import { Component, OnInit } from '@angular/core';
import { PerfilService } from './perfil.service';
import { Usuario } from '../modelos/usuario';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss']
})
export class PerfilComponent implements OnInit {

  public usuario = new Usuario();
  constructor(private perfilService: PerfilService) { }

  ngOnInit(): void {
    this.consultarPerfil();
  }

  consultarPerfil() {
    this.perfilService.consultarUsuarioEnSesion()
        .subscribe((usuario: Usuario) => {
          console.log(usuario);
          this.usuario = usuario;
        }, (error) => {
          console.log(error);
        });
  }

}
