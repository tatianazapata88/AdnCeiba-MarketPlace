import { NgModule } from '@angular/core';
import { UsuarioRoutingModule } from './usuario-routing.module';
import { UsuarioComponent } from 'src/app/feature/usuario/components/usuario/usuario.component';
import { CrearUsuarioComponent } from './components/crear-usuario/crear-usuario.component';
import { SharedModule } from '@shared/shared.module';
import { UsuarioService } from './shared/service/usuario.service';
import { FormsModule } from '@angular/forms';
import { ActualizarUsuarioComponent } from './components/actualizar-usuario/actualizar-usuario.component';

@NgModule({
  declarations: [
  CrearUsuarioComponent,
  ActualizarUsuarioComponent,
  UsuarioComponent
  ],
  imports: [
  UsuarioRoutingModule,
  SharedModule,
  FormsModule,
    ],
    providers: [UsuarioService]
  })
export class UsuarioModule { }
