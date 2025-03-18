import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatRadioModule } from '@angular/material/radio';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { skip, switchMap } from 'rxjs/operators';
import { Product } from '../../../../core/models/product.model';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-details',
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
    MatRadioModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatCheckboxModule,
  ],
  templateUrl: './product-details.component.html',
})
export class ProductDetailsComponent implements OnInit {
  product$!: Observable<Product | undefined>;
  isNew = false;
  productForm!: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.initForm();

    this.product$ = this.route.paramMap.pipe(
      switchMap(params => {
        const id = params.get('id');
        if (id === 'add' || id === null) {
          this.isNew = true;
          return of({
            id: '',
            name: '',
            description: '',
            price: 0,
          } as Product);
        } else if (id) {
          return this.productService.getProductById(id);
        }
        return of(undefined);
      })
    );

    this.product$.subscribe(product => {
      // console.log('Product Data:', product); // Debugging
      if (product) {
        this.productForm.patchValue({
          id: product.id,
          sku: product.skuCode,
          name: product.name,
          description: product.description,
          price: product.price,
        });
      }
    });
  }

  initForm(): void {
    this.productForm = this.fb.group({
      id: [''],
      name: ['', [Validators.required]],
      description: ['', [Validators.required]],
      price: [0, [Validators.required]],
      sku: [''],
    });
  }

  saveProduct(): void {
    // console.log('saveProduct(): is form valide', this.productForm.valid); // Debugging
    if (this.productForm.valid) {
      const productData = this.productForm.value;
      if (this.isNew) {
        this.productService.addProduct({
          name: productData.name,
          description: productData.description,
          price: productData.price,
        }).subscribe(() => {
          this.router.navigate(['/products']);
        });
      } else {
        this.productService.updateProduct(productData.id, {
          name: productData.name,
          description: productData.description,
          price: productData.price,
        }).subscribe(() => {
          this.router.navigate(['/products']);
        });
      }
    } else {
      // Mark all fields as touched to trigger validation messages
      Object.keys(this.productForm.controls).forEach(key => {
        this.productForm.get(key)?.markAsTouched();
      });
    }
  }

  cancel(): void {
    this.router.navigate(['/products']);
  }
}
