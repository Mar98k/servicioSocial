import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { PERFIL_ADMINISTRADOR, PERFIL_ALUMNO, PERFIL_MAESTRO, MENU_ADMINISTRADOR, MENU_ALUMNO, MENU_MAESTROS } from '../util/constant';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  public opcionesMenu: {nombre, path}[] = [];

  constructor(private loginService: LoginService,
              private router: Router) {
    this.generarMenu();
  }

  ngOnInit(): void {
  }

  generarMenu() {
    const perfil = sessionStorage.getItem('perfil');

    switch (perfil) {
      case PERFIL_ADMINISTRADOR:
        this.opcionesMenu = MENU_ADMINISTRADOR;
        break;
      case PERFIL_ALUMNO:
        this.opcionesMenu = MENU_ALUMNO;
        break;
      case PERFIL_MAESTRO:
        this.opcionesMenu = MENU_MAESTROS;
        break;
    }
  }

  salir() {
    this.loginService.logOut();
  }

  navegar(ruta: string) {
    this.router.navigateByUrl(ruta);
  }

}
