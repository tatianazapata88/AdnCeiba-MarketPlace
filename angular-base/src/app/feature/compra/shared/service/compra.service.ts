import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { environment } from 'src/environments/environment';
import { Compra } from '../model/compra';

@Injectable({
  providedIn: 'root'
})
export class CompraService {

  constructor(protected http: HttpService) { }

  public guardar(compra: Compra) {
    return this.http.doPost<Compra, boolean>(`${environment.endpoint}/compras`, compra,
                                                this.http.optsName('Crear Compra'));
  }

  public consultarPorId(id: any) {
    return this.http.doGet<Compra>(`${environment.endpoint}/compras/id/${id}`, this.http.optsName('Controlador consulta compras'));
  }

  public eliminar(compra: Compra) {
    return this.http.doDelete<boolean>(`${environment.endpoint}/compras/${compra.id}`,
                                                 this.http.optsName('eliminar productos'));
  }
}
