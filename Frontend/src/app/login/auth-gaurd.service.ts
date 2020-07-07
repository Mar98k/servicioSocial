import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {

  constructor(private router: Router,
              private loginService: LoginService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    if (this.loginService.usuarioEstaLogeado()) {

      const perfilRequerido = route.data.perfilRequerido;

      if (perfilRequerido) {
        const perfilActual = sessionStorage.getItem('perfil');
        return perfilActual == perfilRequerido;
      } else {
        return true;
      }
    } else {
      this.router.navigate(['login']);
      return false;
    }
  }

}
