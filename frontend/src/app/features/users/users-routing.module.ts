import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './pages/user-list/user-list.component';
import { UserDetailsComponent } from './pages/user-details/user-details.component';

const routes: Routes = [
  { path: '', component: UserListComponent }, // /users
  { path: 'new', component: UserDetailsComponent }, // /users/new
  { path: ':id', component: UserDetailsComponent } // /users/:id
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsersRoutingModule {}
