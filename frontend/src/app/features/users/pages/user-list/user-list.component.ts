import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MaterialModule } from 'src/app/material.module';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../../../../core/models/user.model';
import { UserService } from '../../services/user.service';


const USER_DATA: User[] = [
  {
    id: 1,
    username: 'John Doe',
    email: 'john.doe@gmail.com',
    active: true,
  },

];
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
  ],
  templateUrl: './user-list.component.html',
})
export class UserListComponent {
  displayedColumns1: string[] = ['username', 'email', 'priority', 'action'];
  // dataSource1 = USER_DATA;
  users$!: Observable<User[]>;

  constructor(
    private userService: UserService,
    private router: Router) {
  }

  ngOnInit(): void {
    this.loadUsers()
  }

  loadUsers(): void {
    this.users$ = this.userService.getUsers();
  }

  viewUser(id: number): void {
    this.router.navigate(['/users', id]);
  }

  addUser(): void {
    this.router.navigate(['/users/new']);
  }

  deleteUser(id: number): void {
    if (confirm('Are you sure you want to delete this user?')) {
      this.userService.deleteUser(id).subscribe(() => {
        this.loadUsers();
      });
    }
  }

}