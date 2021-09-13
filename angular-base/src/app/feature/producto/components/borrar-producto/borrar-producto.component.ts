import { Component, OnInit } from '@angular/core';
import { Producto } from '@producto/shared/model/producto';
import { ProductoService } from '@producto/shared/service/producto.service';
import { Usuario } from '@usuario/shared/model/usuario';

@Component({
  selector: 'app-borrar-producto',
  templateUrl: './borrar-producto.component.html',
  styleUrls: ['./borrar-producto.component.scss']
})
export class BorrarProductoComponent implements OnInit {
  public scotter =new Producto();
  public  user: Usuario = new Usuario()
  constructor(protected productoService: ProductoService) { }

 

  ngOnInit() {
    let recuperarStorage = JSON.parse( localStorage.getItem("datosSesion"));
    this.user=recuperarStorage;
        this.productoService.consultarPorIdVendedor(this.user.id).subscribe(data => {
        this.scotter=data; 
        
         
        })
  }

  eliminar(){
    /* Swal.fire({
       title: '¿Estás seguro de eliminar la reserva?',
       text: "Es posible que no encuentras disponibilidad en las mismas fechas",
       icon: 'warning',
       showCancelButton: true,
       confirmButtonColor: '#3085d6',
       cancelButtonColor: '#d33',
       confirmButtonText: 'Si, deseo eliminarla!'
     }).then((result) => {
       this.service.eliminarReserva(idReserve1).subscribe()
       if (result.isConfirmed) {
         Swal.fire(
           'Reserva Eliminada!',
           '',
           'success'
         )
       }
     })*/
       
   }

}
