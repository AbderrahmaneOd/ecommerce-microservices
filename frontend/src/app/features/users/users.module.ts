import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersRoutingModule } from './users-routing.module';
import { UserListComponent } from './pages/user-list/user-list.component';
import { UserDetailsComponent } from './pages/user-details/user-details.component';

@NgModule({
  declarations: [

  ],
  imports: [
    CommonModule,
    UserListComponent,
    UserDetailsComponent,
    UsersRoutingModule,
  ]
})
export class UsersModule { }
