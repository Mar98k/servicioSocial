import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { LoginService } from './login.service';
import { MyErrorStateMatcher, caracteresEspecialesValidator } from '../util/util';
import { Router } from '@angular/router';
import { PERFIL_ADMINISTRADOR, PERFIL_ALUMNO, PERFIL_MAESTRO } from '../util/constant';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public formulario: FormGroup;
  public ocultarContrasena = true;
  public errorLogin = false;
  public errorMatcher = new MyErrorStateMatcher();

  public listaTipoLogin = [
    {nombre: 'Administrador', valor: PERFIL_ADMINISTRADOR},
    {nombre: 'Alumno', valor: PERFIL_ALUMNO},
    {nombre: 'Maestro', valor: PERFIL_MAESTRO}
  ];

  constructor(private fb: FormBuilder,
              private loginService: LoginService,
              private router: Router) {
    if (this.loginService.usuarioEstaLogeado()) {
      this.router.navigateByUrl('inicio/perfil');
    }
    this.formulario = this.fb.group({
      usuario: new FormControl('', [Validators.required, caracteresEspecialesValidator]),
      contrasena: new FormControl('', [Validators.required, caracteresEspecialesValidator]),
    });
  }

  ngOnInit(): void {
  }

  acceder() {
    if (this.formulario.valid) {
      const usuario = this.formulario.controls['usuario'].value;
      const contrasena = this.formulario.controls['contrasena'].value;

      this.loginService.acceder(usuario, contrasena)
          .subscribe(() => {
            console.log(1);
            this.router.navigateByUrl('inicio');
          }, (error) => {
            this.errorLogin = true;
          });
    }
  }

}
