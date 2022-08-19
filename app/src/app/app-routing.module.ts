import { NgModule } from '@angular/core';
import { RouterModule, Routes  } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register-component/register.component';
import { PagesRoutingModule } from './pages/pages.routing';

const ROUTES : Routes = [  
  { path: 'login' , component: LoginComponent},
  { path: 'register' , component: RegisterComponent},
  { path: '' , redirectTo: '/login', pathMatch:'full'} ,
]

@NgModule({
  imports: [RouterModule.forRoot(ROUTES) , PagesRoutingModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
