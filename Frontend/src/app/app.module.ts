import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from './material/material.module';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AlumnosComponent } from './alumnos/alumnos.component';
import { MaestrosComponent } from './maestros/maestros.component';
import { AuthGaurdService } from './login/auth-gaurd.service';
import { LoginService } from './login/login.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { HtppInterceptorService } from './login/htpp-interceptor-service.service';
import { PerfilComponent } from './perfil/perfil.component';
import { MateriasComponent } from './materias/materias.component';
import { GruposComponent } from './grupos/grupos.component';
import { InscripcionComponent } from './inscripcion/inscripcion.component';
import { PerfilService } from './perfil/perfil.service';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    AlumnosComponent,
    MaestrosComponent,
    PerfilComponent,
    MateriasComponent,
    GruposComponent,
    InscripcionComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,

    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,

    // MaterialModules
    MaterialModule,

    AppRoutingModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HtppInterceptorService,
      multi: true
    },
    AuthGaurdService,
    LoginService,
    PerfilService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
