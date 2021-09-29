import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Compra } from '../compra/shared/model/compra';
import { CompraService } from '../compra/shared/service/compra.service';

@Component({
  selector: 'app-boleto-compra',
  templateUrl: './boleto-compra.component.html',
  styleUrls: ['./boleto-compra.component.scss']
})
export class BoletoCompraComponent implements OnInit {
  public compra: Compra = new Compra();
  constructor(protected router: Router,private compraService: CompraService,private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.cargarCompra();
  }

  cargarCompra(){
    this.activatedRoute.params.subscribe(params =>{
      let idCompra = params['id']
      if(idCompra){
         this.compraService.consultarPorId(idCompra).subscribe((data)=> this.compra =data);
      }
    })
  }
  pagar(){
    Swal.fire('Dirigite a realizar el pago')
  }

  eliminar(compra){
    Swal.fire({
      title: 'Estas seguro de eliminar esta orden de compra?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.compraService.eliminar(compra).subscribe();
        Swal.fire(
          'Eliminado!',
          'Tu boleto de compra ha sido eliminado.',
          
        )
        location.reload;
        this.router.navigate(['/producto/listar']);
      }
      
    })
    
  }
}
