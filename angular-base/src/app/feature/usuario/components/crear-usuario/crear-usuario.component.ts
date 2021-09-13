import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../shared/service/usuario.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
//import {Usuario} from '../../shared/model/usuario';
import Swal from 'sweetalert2'
import {Router} from '@angular/router';



@Component({
  selector: 'app-crear-usuario',
  templateUrl: './crear-usuario.component.html',
  styleUrls: ['./crear-usuario.component.scss']
})
export class CrearUsuarioComponent implements OnInit {
   UsuarioForm: FormGroup;
  //public  user: Usuario = new Usuario()
  constructor(protected usuarioServices: UsuarioService, protected router: Router) { }

  ngOnInit(): void {
  this.construirFormularioUsuario();
  }

  cerar() {
      console.log(this.UsuarioForm.value)
      this.usuarioServices.guardar(this.UsuarioForm.value).subscribe(() => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: `¡El usuario fue registrado correctamente!`,
          showConfirmButton: false,
          timer: 4000
        })
        this.router.navigate(['/home']);
      },
      (error) =>{
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: error.error.mensaje,
        })}
     
     
        
        );

      }
      
        
  



  private construirFormularioUsuario() {
      this.UsuarioForm = new FormGroup({
        username: new FormControl('', [Validators.required]),
        nombre: new FormControl('', [Validators.required]),
        celular: new FormControl('', [Validators.required]),
        email: new FormControl('', [Validators.required]),
      });
    }

}
