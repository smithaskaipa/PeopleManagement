import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonComponent } from '../components/person/person.component';
import { LoginComponent } from '../components/login/login.component';
import { MyInfoComponent } from '../components/myinfo/myinfo.component';


export const routes: Routes = [
 {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },

  { path: 'person', component: PersonComponent },

  { path: 'login', component: LoginComponent },

  { path: 'myinfo', component: MyInfoComponent },


];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);