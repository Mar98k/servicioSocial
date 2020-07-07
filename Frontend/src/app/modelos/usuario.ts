import { Estatus } from './estatus';

export class Usuario {
  public nombre: string;
  public usuario: string;
  public estatus: Estatus;

  constructor() {
    this.nombre = '';
    this.usuario = '';
    this.estatus = new Estatus();
    this.estatus.nombre = '';
  }
}
