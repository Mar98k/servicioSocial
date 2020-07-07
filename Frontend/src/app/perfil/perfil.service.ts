import { Injectable } from '@angular/core';
import { SERVER_HOST } from '../util/constant';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PerfilService {

  constructor(private httpClient: HttpClient) { }

  consultarUsuarioEnSesion() {
    return this.httpClient.get(`${SERVER_HOST}/usuario/consultarPerfil`);
  }
}
