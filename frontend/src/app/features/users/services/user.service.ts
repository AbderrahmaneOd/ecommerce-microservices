import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';
import { User } from '../../../core/models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private users: User[] = [
    {
      id: 1,
      username: 'John Doe',
      email: 'john@example.com',
      active: true
    },
    {
      id: 2,
      username: 'Jane Smith',
      email: 'jane@example.com',
      active: true
    },
    {
      id: 3,
      username: 'Bob Johnson',
      email: 'bob@example.com',
      active: false
    }
  ];

  constructor() { }

  // Simulate API call to get all users
  getUsers(): Observable<User[]> {
    return of(this.users).pipe(delay(500)); // Simulate network delay
  }

  // Get user by ID
  getUserById(id: number): Observable<User | undefined> {
    const user = this.users.find(u => u.id === id);
    return of(user).pipe(delay(500));
  }

  // Add new user
  addUser(user: Omit<User, 'id' | 'createdAt'>): Observable<User> {
    const newUser: User = {
      ...user,
      id: this.getNextId(),
    };
    this.users.push(newUser);
    return of(newUser).pipe(delay(500));
  }

  // Update existing user
  updateUser(user: User): Observable<User> {
    const index = this.users.findIndex(u => u.id === user.id);
    if (index !== -1) {
      this.users[index] = user;
    }
    return of(user).pipe(delay(500));
  }

  // Delete user
  deleteUser(id: number): Observable<boolean> {
    const initialLength = this.users.length;
    this.users = this.users.filter(u => u.id !== id);
    return of(this.users.length !== initialLength).pipe(delay(500));
  }

  private getNextId(): number {
    return Math.max(...this.users.map(u => u.id)) + 1;
  }
}