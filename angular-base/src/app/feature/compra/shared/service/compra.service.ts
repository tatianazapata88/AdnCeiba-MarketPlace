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
}
