import { ProductService } from '../../services/product.service';
import { Observable, of, catchError, EMPTY, BehaviorSubject } from 'rxjs';
import { CommonModule } from '@angular/common';
import { Component, ViewChild, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MaterialModule } from 'src/app/material.module';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatPaginatorModule, MatPaginator, PageEvent } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { map, finalize } from 'rxjs/operators';
import { FormsModule } from '@angular/forms';
import { Product } from 'src/app/core/models/product.model';


export interface PagedResponse<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  pageNumber: number;
  pageSize: number;
}

@Component({
  selector: 'app-product-list',
  imports: [
    MatTableModule,
    CommonModule,
    MatCardModule,
    MaterialModule,
    MatIconModule,
    MatMenuModule,
    MatButtonModule,
    RouterModule,
    FormsModule,
  ],
  templateUrl: './product-list.component.html',
})
export class ProductListComponent {
  displayedColumns: string[] = ["sku", 'name', 'price', 'action'];

  // Change to BehaviorSubject for better error handling
  private productsSubject = new BehaviorSubject<Product[]>([]);
  products$ = this.productsSubject.asObservable();

  // Pagination properties
  totalProducts = 0;
  pageSize = 5;
  currentPage = 0;

  // Error handling
  hasError = false;
  errorMessage = 'Unable to connect to the server. Please try again later.';
  loading = false;

  // Add filters object
  filters = {
    name: ''
  };

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private productService: ProductService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    // Reset error state
    this.hasError = false;
    this.loading = true;

    // Fetch products using pagination parameters
    this.productService.getProducts(this.filters.name, this.currentPage, this.pageSize)
      .pipe(
        map((response: PagedResponse<Product>) => {
          this.totalProducts = response.totalElements;
          return response.content; // Extract only the 'content' (the list of product)
        }),
        catchError(error => {
          console.error('Error fetching products:', error);
          this.hasError = true;
          return of([]);  // Return empty array on error
        }),
        finalize(() => {
          this.loading = false;
        })
      )
      .subscribe({
        next: (products) => {
          this.productsSubject.next(products);
          console.log('Products loaded:', products);
        },
        error: (err) => {
          // This shouldn't be reached due to catchError above, but as a safety
          console.error('Uncaught error in subscription:', err);
          this.hasError = true;
          this.productsSubject.next([]);
        }
      });
  }

  // Called when pagination changes
  onPageChange(event: PageEvent): void {
    this.currentPage = event.pageIndex;
    this.pageSize = event.pageSize;
    this.loadProducts();
  }

  viewProduct(id: string): void {
    this.router.navigate(['/products', id]);
  }

  deleteProduct(id: string): void {
    if (confirm('Are you sure you want to delete this product?')) {
      this.productService.deleteProduct(id)
        .pipe(
          catchError(error => {
            console.error('Error deleting product:', error);
            this.hasError = true;
            alert('Failed to delete product. Please try again later.');
            return EMPTY;
          })
        )
        .subscribe(() => {
          this.loadProducts();
        });
    }
  }

  applyFilters() {
    this.currentPage = 0; // Reset to first page when applying filters
    this.loadProducts();
  }

  resetFilters() {
    this.filters = {
      name: '',
    };
    this.currentPage = 0;
    this.loadProducts();
  }

  retryConnection(): void {
    this.loadProducts();
  }
}
