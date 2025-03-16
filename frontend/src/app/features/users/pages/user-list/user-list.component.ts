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
import { Observable, of, catchError, EMPTY, BehaviorSubject } from 'rxjs';
import { User } from '../../../../core/models/user.model';
import { UserService } from '../../services/user.service';
import { map, finalize } from 'rxjs/operators';

export interface PagedResponse<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  pageNumber: number;
  pageSize: number;
}

@Component({
  selector: 'app-user-list',
  imports: [
    MatTableModule,
    CommonModule,
    MatCardModule,
    MaterialModule,
    MatIconModule,
    MatMenuModule,
    MatButtonModule,
    RouterModule,
  ],
  templateUrl: './user-list.component.html',
})
export class UserListComponent implements OnInit {
  displayedColumns: string[] = ['username', 'email', 'status', 'action'];
  
  // Change to BehaviorSubject for better error handling
  private usersSubject = new BehaviorSubject<User[]>([]);
  users$ = this.usersSubject.asObservable();
  
  // Pagination properties
  totalUsers = 0;
  pageSize = 5;
  currentPage = 0;
  
  // Error handling
  hasError = false;
  errorMessage = 'Unable to connect to the server. Please try again later.';
  loading = false;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private userService: UserService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(): void {
    // Reset error state
    this.hasError = false;
    this.loading = true;
    
    // Fetch users using pagination parameters
    this.userService.getUsers(this.currentPage, this.pageSize)
      .pipe(
        map((response: PagedResponse<User>) => {
          this.totalUsers = response.totalElements;
          return response.content;
        }),
        catchError(error => {
          console.error('Error fetching users:', error);
          this.hasError = true;
          return of([]);  // Return empty array on error
        }),
        finalize(() => {
          this.loading = false;
        })
      )
      .subscribe({
        next: (users) => {
          this.usersSubject.next(users);
        },
        error: (err) => {
          // This shouldn't be reached due to catchError above, but as a safety
          console.error('Uncaught error in subscription:', err);
          this.hasError = true;
          this.usersSubject.next([]);
        }
      });
  }

  // Called when pagination changes
  onPageChange(event: PageEvent): void {
    this.currentPage = event.pageIndex;
    this.pageSize = event.pageSize;
    this.loadUsers();
  }

  viewUser(id: string): void {
    this.router.navigate(['/users', id]);
  }

  deleteUser(id: string): void {
    if (confirm('Are you sure you want to delete this user?')) {
      this.userService.deleteUser(id)
        .pipe(
          catchError(error => {
            console.error('Error deleting user:', error);
            this.hasError = true;
            alert('Failed to delete user. Please try again later.');
            return EMPTY;
          })
        )
        .subscribe(() => {
          this.loadUsers();
        });
    }
  }

  retryConnection(): void {
    this.loadUsers();
  }
}