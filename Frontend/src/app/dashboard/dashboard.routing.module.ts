import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { AlumnosComponent } from '../alumnos/alumnos.component';
import { AuthGaurdService } from '../login/auth-gaurd.service';
import { MaestrosComponent } from '../maestros/maestros.component';
import { PerfilComponent } from '../perfil/perfil.component';
import { MateriasComponent } from '../materias/materias.component';
import { GruposComponent } from '../grupos/grupos.component';
import { InscripcionComponent } from '../inscripcion/inscripcion.component';
import { PERFIL_ADMINISTRADOR, PERFIL_MAESTRO, PERFIL_ALUMNO } from '../util/constant';

const routes: Routes = [
  {path: 'inicio',
   component: DashboardComponent,
   children: [
     {path: '', pathMatch: 'full', redirectTo: 'perfil'},
     {path: 'perfil', component: PerfilComponent, canActivate: [AuthGaurdService]},
     {path: 'alumnos', component: AlumnosComponent, canActivate: [AuthGaurdService], data: {perfilRequerido: PERFIL_ADMINISTRADOR}},
     {path: 'maestros', component: MaestrosComponent, canActivate: [AuthGaurdService], data: {perfilRequerido: PERFIL_ADMINISTRADOR}},
     {path: 'materias', component: MateriasComponent, canActivate: [AuthGaurdService], data: {perfilRequerido: PERFIL_MAESTRO}},
     {path: 'grupos', component: GruposComponent, canActivate: [AuthGaurdService], data: {perfilRequerido: PERFIL_MAESTRO}},
     {path: 'inscripcion', component: InscripcionComponent, canActivate: [AuthGaurdService], data: {perfilRequerido: PERFIL_ALUMNO}}
   ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
