import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Producto } from '@producto/shared/model/producto';
import { ProductoService } from '@producto/shared/service/producto.service';
import { Usuario } from '@usuario/shared/model/usuario';
import { Observable } from 'rxjs';
import Swal from 'sweetalert2';
import { Compra } from './shared/model/compra';
import { CompraService } from './shared/service/compra.service';



@Component({
  selector: 'app-compra',
  templateUrl: './compra.component.html',
  styleUrls: ['./compra.component.scss']
})
export class CompraComponent implements OnInit {
  public compra: Compra = new Compra();
  public comprador: Usuario= new Usuario();
  public scooter: Producto = new Producto();
  public datosScooter: Observable<Producto>;
  ciudadDestinoEnvioScotter: any;
  fecha1 = Date.now;
  fecha: Date =new Date();
  
  

  //constructor(private productoService: ProductoService,  private activatedRoute: ActivatedRoute) { }
  constructor(protected router: Router,private productoService: ProductoService,private compraService: CompraService, private activatedRoute: ActivatedRoute){}
  ngOnInit(): void {
    let recuperarStorage = JSON.parse( localStorage.getItem("datosSesion"));
    this.comprador=recuperarStorage;
    this.cargarScooter();
  }

  cargarScooter(): void{
    this.activatedRoute.params.subscribe(params =>{
      let idScooter = params['id']
      if(idScooter){
         this.productoService.consultarPorId(idScooter).subscribe((data)=> this.scooter =data);
      }
    })
  }

  comprar(){
  this.compra.fecha=this.fecha
  this.compra.scotterId=this.scooter.id;
  this.compra.compradorId=this.comprador.id;
  this.compra.ciudadDestinoEnvioScotter=this.ciudadDestinoEnvioScotter;
  console.log(this.compra)

  this.compraService.guardar(this.compra).subscribe(() => {
    Swal.fire({
      position: 'center',
      icon: 'success',
      title: `¡Orden de compra generada!`,
      showConfirmButton: false,
      timer: 4000
    })
    this.router.navigate([`/producto/listar`]);
    
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
