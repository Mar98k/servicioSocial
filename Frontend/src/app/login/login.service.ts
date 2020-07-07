import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { SERVER_HOST } from '../util/constant';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient,
              private router: Router) {}

  acceder(usuario, contrasena) {
    return this.httpClient.post<any>(`${SERVER_HOST}/sistema/login`, {usuario, contrasena}).pipe(
     map(
       userData => {
        sessionStorage.setItem('username', usuario);
        const tokenStr = 'Bearer ' + userData.token;
        sessionStorage.setItem('token', tokenStr);
        sessionStorage.setItem('perfil', userData.perfil.toString());
        return userData;
       }
     )
    );
  }

  usuarioEstaLogeado() {
    const user = sessionStorage.getItem('username');
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('perfil');
    this.router.navigateByUrl('/login');
  }

}
