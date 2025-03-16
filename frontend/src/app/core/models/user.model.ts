// src/app/core/models/user.model.ts
export interface User {
    id: string;
    username: string;
    email: string;
    password?: string;
    active?: boolean | 'true';
  }
  
  export interface CreateUserRequest {
    username: string;
    email: string;
    password: string;
  }
  
  export interface UpdateUserRequest {
    username?: string;
    email?: string;
    password?: string;
  }