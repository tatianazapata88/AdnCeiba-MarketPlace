import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Usuario } from '../model/usuario';


@Injectable()
export class UsuarioService {

  constructor(protected http: HttpService) {}

   public guardar(usuario: Usuario) {
    return this.http.doPost<Usuario, boolean>(`${environment.endpoint}/personas`, usuario,
                                                this.http.optsName('Crear Persona'));
  }

  public consultar(id: number) {
    return this.http.doGet<Usuario>(`${environment.endpoint}/personas/id/${id}`, this.http.optsName('Listar Personas por id'));
  }

  public consultarUsername(username: string) {
    return this.http.doGet<Usuario>(`${environment.endpoint}/personas/username/${username}`, this.http.optsName('Listar Personas por username'));
  }

  
  public actualizar(usuario: Usuario) {
    return this.http.doPut<Usuario, boolean>(`${environment.endpoint}/personas/${usuario.username}`, usuario,
                                                this.http.optsName('Actualizar Persona'));
  }

}
