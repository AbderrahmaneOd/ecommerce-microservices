import { Routes } from '@angular/router';
import { StarterComponent } from './starter/starter.component';

export const DashboardRoutes: Routes = [
  {
    path: '',
    component: StarterComponent,
    data: {
      title: 'Starter Page',
      urls: [
        { title: 'Dashboard', url: '/dashboard' },
        { title: 'Starter Page' },
      ],
    },
  },
];
