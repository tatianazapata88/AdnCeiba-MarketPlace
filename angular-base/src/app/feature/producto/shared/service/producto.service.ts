import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Producto } from '../model/producto';


@Injectable()
export class ProductoService {

  constructor(protected http: HttpService) {}

  public consultar() {
    return this.http.doGet<Producto[]>(`${environment.endpoint}/scotters`, this.http.optsName('Listar scotters'));
  }

  public consultarPorPrecio(precio: any) {
    return this.http.doGet<Producto[]>(`${environment.endpoint}/scotters/precio/${precio}`, this.http.optsName('Listar scotters por precio'));
  }

  public consultarPorId(id: any) {
    return this.http.doGet<Producto>(`${environment.endpoint}/scotters/id/${id}`, this.http.optsName('Listar scotters por id'));
  }

  public consultarPorCiudad(ciudad: any) {
    return this.http.doGet<Producto[]>(`${environment.endpoint}/scotters/ciudad/${ciudad}`, this.http.optsName('Listar scotters por ciudad'));
  }

  public consultarPorIdVendedor(vendedor: any) {
    return this.http.doGet<Producto>(`${environment.endpoint}/scotters/vendedor/${vendedor}`, this.http.optsName('Listar scotters por Id Vendedor'));
  }

  public guardar(producto: Producto) {
    return this.http.doPost<Producto, boolean>(`${environment.endpoint}/scotters`, producto,
                                                this.http.optsName('Crear Scotter'));
  }

  public eliminar(producto: Producto) {
    return this.http.doDelete<boolean>(`${environment.endpoint}/productos/${producto.id}`,
                                                 this.http.optsName('eliminar productos'));
  }
}
