import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '@usuario/shared/model/usuario';
import { UsuarioService } from '@usuario/shared/service/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-actualizar-usuario',
  templateUrl: './actualizar-usuario.component.html',
  styleUrls: ['./actualizar-usuario.component.scss']
})
export class ActualizarUsuarioComponent implements OnInit {
  public user: Usuario= new Usuario();
  constructor(protected usuarioServices: UsuarioService, protected router: Router) { }

  ngOnInit(): void {
    let recuperarStorage = JSON.parse( localStorage.getItem("datosSesion"));
    this.user=recuperarStorage;
    }

    cerar() {
      console.log(this.user)
      this.usuarioServices.actualizar(this.user).subscribe(() => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: `¡El usuario fue actualizado correctamente!`,
          showConfirmButton: false,
          timer: 4000
        })
        let recuperarStorage = JSON.parse( localStorage.getItem("datosSesion"));
        recuperarStorage=this.user;
        localStorage.setItem("datosSesion", JSON.stringify(recuperarStorage));
        location.reload;
 
      },
      (error) =>{
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: error.error.mensaje,
        })}
     
     
        
        );

      }

    
   
  }


