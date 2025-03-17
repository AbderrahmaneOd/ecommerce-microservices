import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User, CreateUserRequest, UpdateUserRequest } from '../../../core/models/user.model';
import { map } from 'rxjs/operators';

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
export class UserService {
  private apiUrl = 'http://localhost:8085/api/users';

  constructor(private http: HttpClient) { }

  // Get all users with pagination
  getUsers(username: string = '', email: string = '', pageNumber: number = 0, pageSize: number = 5): Observable<PagedResponse<User>> {
    const params = new HttpParams()
      .set('username', username)
      .set('email', email)
      .set('page', pageNumber.toString())
      .set('size', pageSize.toString());

    //return this.http.get<PagedResponse<User>>(this.apiUrl, { params });
    return this.http.get<any>(this.apiUrl, { params }).pipe(
      map(response => this.transformHateoasResponse(response))
    );
  }

  // Transform HATEOAS response into the expected format
  private transformHateoasResponse(response: any): PagedResponse<User> {
    return {
      content: response._embedded?.userDTOes || [],  // Extract user list from _embedded
      totalElements: response.page?.totalElements || 0,
      totalPages: response.page?.totalPages || 0,
      pageNumber: response.page?.number || 0,
      pageSize: response.page?.size || 0
    };
  }

  // Get the total count of users
  getUserCount(): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/count`);
  }

  // Get user by ID
  getUserById(id: string): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/${id}`);
  }

  // Add new user
  addUser(user: CreateUserRequest): Observable<User> {
    return this.http.post<User>(this.apiUrl, user);
  }

  // Update existing user
  updateUser(id: string, user: UpdateUserRequest): Observable<User> {
    return this.http.put<User>(`${this.apiUrl}/${id}`, user);
  }

  // Delete user
  deleteUser(id: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}