import { CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MaterialModule } from 'src/app/material.module';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatPaginatorModule, MatPaginator, PageEvent } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../../../../core/models/user.model';
import { UserService } from '../../services/user.service';
import { map } from 'rxjs/operators';

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
export class UserListComponent {
  displayedColumns: string[] = ['username', 'email', 'status', 'action'];
  users$!: Observable<User[]>;

  // Pagination properties
  totalUsers = 0;
  pageSize = 5;
  currentPage = 0;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private userService: UserService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.loadUsers()
  }

  loadUsers(): void {
    // Fetch users using pagination parameters
    this.users$ = this.userService.getUsers(this.currentPage, this.pageSize).pipe(
      map((response: PagedResponse<User>) => {
        this.totalUsers = response.totalElements; // Set the total number of users for pagination
        return response.content;  // Return only the list of users
      })
    );
  }


  // Called when pagination changes
  onPageChange(event: PageEvent): void {
    this.currentPage = event.pageIndex;  // Update the current page based on the event
    this.pageSize = event.pageSize;  // Update page size if changed
    this.loadUsers();  // Reload users with the new page settings
  }


  viewUser(id: string): void {
    this.router.navigate(['/users', id]);
  }

  addUser(): void {
    this.router.navigate(['/users/new']);
  }

  deleteUser(id: string): void {
    if (confirm('Are you sure you want to delete this user?')) {
      this.userService.deleteUser(id).subscribe(() => {
        this.loadUsers();
      });
    }
  }

}