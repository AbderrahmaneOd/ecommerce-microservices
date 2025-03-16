import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { User } from '../../../../core/models/user.model';
import { UserService } from '../../services/user.service';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatRadioModule } from '@angular/material/radio';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-user-details',
  standalone: true,
  imports: [
    CommonModule,
    HttpClientModule,
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
  templateUrl: './user-details.component.html',
})
export class UserDetailsComponent implements OnInit {
  user$!: Observable<User | undefined>;
  isNew = false;
  userForm!: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.initForm();
    
    this.user$ = this.route.paramMap.pipe(
      switchMap(params => {
        const id = params.get('id');
        if (id === 'add' || id === null) {
          this.isNew = true;
          return of({
            id: '',
            username: '',
            email: ''
          } as User);
        } else if (id) {
          return this.userService.getUserById(id);
        }
        return of(undefined);
      })
    );
    
    this.user$.subscribe(user => {
      if (user) {
        this.userForm.patchValue({
          id: user.id,
          username: user.username,
          email: user.email
        });
      }
    });
  }

  initForm(): void {
    this.userForm = this.fb.group({
      id: [''],
      username: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', this.isNew ? [Validators.required] : []]
    });
  }

  saveUser(): void {
    if (this.userForm.valid) {
      const userData = this.userForm.value;
      
      if (this.isNew) {
        this.userService.addUser({
          username: userData.username,
          email: userData.email,
          password: userData.password
        }).subscribe(() => {
          this.router.navigate(['/users']);
        });
      } else {
        this.userService.updateUser(userData.id, {
          username: userData.username,
          email: userData.email,
          password: userData.password || undefined
        }).subscribe(() => {
          this.router.navigate(['/users']);
        });
      }
    } else {
      // Mark all fields as touched to trigger validation messages
      Object.keys(this.userForm.controls).forEach(key => {
        this.userForm.get(key)?.markAsTouched();
      });
    }
  }

  cancel(): void {
    this.router.navigate(['/users']);
  }
}