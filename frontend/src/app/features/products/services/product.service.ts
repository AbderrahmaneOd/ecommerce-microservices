import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { CreateProductRequest, Product, UpdateProductRequest } from '../../../core/models/product.model';
import { map } from 'rxjs/operators';
import { environment } from '../../../../environments/environment';

export interface PagedResponse<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  pageNumber: number;
  pageSize: number;
}


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // private apiUrl = 'http://localhost:8081/api/products';

  private apiUrl = environment.productApiUrl;

  constructor(private http: HttpClient) { }

  // Get all product
  getProducts(name: string = '', pageNumber: number = 0, pageSize: number = 5): Observable<PagedResponse<Product>> {
    const params = new HttpParams()
      .set('name', name)
      .set('page', pageNumber.toString())
      .set('size', pageSize.toString());

    return this.http.get<any>(this.apiUrl, { params }).pipe(
      map(response => this.transformHateoasResponse(response))
    );
  }

  // Transform HATEOAS response into the expected format
  private transformHateoasResponse(response: any): PagedResponse<Product> {
    return {
      content: response._embedded?.productResponseList || [],
      totalElements: response.page?.totalElements || 0,
      totalPages: response.page?.totalPages || 0,
      pageNumber: response.page?.number || 0,
      pageSize: response.page?.size || 0
    };
  }


  // Get product by ID
  getProductById(id: string): Observable<Product> {
    return this.http.get<Product>(`${this.apiUrl}/${id}`);
  }

  // Add new product
  addProduct(product: CreateProductRequest): Observable<Product> {
    return this.http.post<Product>(this.apiUrl, product);
  }

  // Update existing product
  updateProduct(id: string, product: UpdateProductRequest): Observable<Product> {
    // console.log('updateUser', product);
    // console.log('updateUser id', id);
    return this.http.put<Product>(`${this.apiUrl}/${id}`, product);
  }

  // Delete product
  deleteProduct(id: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}