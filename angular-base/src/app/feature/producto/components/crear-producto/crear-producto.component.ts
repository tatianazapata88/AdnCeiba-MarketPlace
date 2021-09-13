import { Component, OnInit } from '@angular/core';
import { ProductoService } from '../../shared/service/producto.service';
import Swal from 'sweetalert2'
import {Router} from '@angular/router';
import {Producto} from '../../shared/model/producto';
import { UsuarioService } from '@usuario/shared/service/usuario.service';
import { Usuario } from '@usuario/shared/model/usuario';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-crear-producto',
  templateUrl: './crear-producto.component.html',
  styleUrls: ['./crear-producto.component.scss']
})
export class CrearProductoComponent implements OnInit {
 
  public vendedor: Usuario;
  public scooter: Producto = new Producto();
  public datosScooter: Observable<Producto>;

  constructor(protected productoServices: ProductoService, protected router: Router, protected usuarioServices: UsuarioService ) { }

 ngOnInit() {
  let recuperarStorage = JSON.parse( localStorage.getItem("datosSesion"));
  this.vendedor=recuperarStorage;
  this.productoServices.consultarPorIdVendedor(this.vendedor.id).subscribe()
  console.log(this.datosScooter)
 
  }

  cerar() {
    this.scooter.vendedor=this.vendedor;
    this.productoServices.guardar(this.scooter).subscribe(() => {
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: `¡La scooter fue publicada correctamente!`,
        showConfirmButton: false,
        timer: 4000
      })
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
