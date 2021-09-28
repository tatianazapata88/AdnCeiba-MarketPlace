import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '@usuario/shared/model/usuario';
import { UsuarioService } from '@usuario/shared/service/usuario.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
username: any;
public user: Usuario= new Usuario();



  constructor(protected usuarioServices: UsuarioService, protected router: Router) { }

  ngOnInit() {
  }


  login(){
   this.usuarioServices.consultarUsername(this.username).subscribe(data => {
    this.user=data;
    console.log(data)
    
    localStorage.setItem("datosSesion", JSON.stringify(data));
    this.router.navigate(['/producto/listar']);

  }, () => 
      
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Usuario no existe, crear cuenta',
       }));
  
    
  }
}

