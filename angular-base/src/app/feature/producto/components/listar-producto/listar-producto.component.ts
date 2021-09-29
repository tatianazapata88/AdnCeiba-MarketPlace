import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductoService } from '@producto/shared/service/producto.service';
import { Producto } from '@producto/shared/model/producto';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-producto',
  templateUrl: './listar-producto.component.html',
  styleUrls: ['./listar-producto.component.scss']
})
export class ListarProductoComponent implements OnInit {
  public listaProductos: Observable<Producto[]>;
  precio: any;
  ciudad: any;
  idCompra: any;

  constructor(protected productoService: ProductoService, protected router: Router) { }

  ngOnInit() {
    this.listaProductos = this.productoService.consultar();
  }

  searchdis(){
    if(this.ciudad==undefined){
     this.listaProductos=this.productoService.consultarPorPrecio(this.precio);
    }
    else if (this.precio==undefined){
     this.listaProductos=this.productoService.consultarPorCiudad(this.ciudad);
    }
    else{
      Swal.fire('Por favor buscar por precio o ciudad, intentalo de nuevo')
      location.reload();
    }
    this.precio = ""; 
    this.ciudad = "";
   }

   boleto(){
    this.router.navigate([`/boleto/${this.idCompra}`]);
   }

}


