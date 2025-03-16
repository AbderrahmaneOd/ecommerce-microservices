import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersRoutingModule } from './users-routing.module';
import { UserListComponent } from './pages/user-list/user-list.component';
import { UserDetailsComponent } from './pages/user-details/user-details.component';
import { UserFormComponent } from './components/user-form/user-form.component';

@NgModule({
  declarations: [

  ],
  imports: [
    CommonModule,
    UserListComponent,
    UserDetailsComponent,
    UserFormComponent,
    UsersRoutingModule
  ]
})
export class UsersModule { }
