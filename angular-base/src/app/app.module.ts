import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from '@home/home.component';
import { UsuarioModule } from '@usuario/usuario.module';
import { ProductoModule } from '@producto/producto.module';
import { CoreModule } from '@core/core.module';
import { CookieService } from 'ngx-cookie-service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CompraComponent } from './feature/compra/compra.component';
import { BoletoCompraComponent } from './feature/boleto-compra/boleto-compra.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CompraComponent,
    BoletoCompraComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UsuarioModule,
    ProductoModule,
    CoreModule,
    FormsModule,
    NgbModule
  ],
  providers: [CookieService],
    bootstrap: [AppComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
