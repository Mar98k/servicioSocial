import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardRoutingModule } from './dashboard/dashboard.routing.module';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '**', redirectTo: 'inicio'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {useHash: true}),
    DashboardRoutingModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
