import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonComponent } from '../components/person/person.component';

export const routes: Routes = [
 {
    path: '',
    redirectTo: '/person',
    pathMatch: 'full'
  },

  { path: 'person', component: PersonComponent }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);