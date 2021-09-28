import { by, element } from 'protractor';

export class ActualizarUsuarioPage {
    private linkActualizarUsuario = element(by.id('btnActUser'));
    private linkCancelar = element(by.id('btnCancelar'));
    private inputNombre = element(by.id('nombre'));
    private inputCelular = element(by.id('celular'));
    private inputEmail = element(by.id('email'));
    
   ;

    async clickBotonActualizarUsuario() {
        await this.linkActualizarUsuario.click();
    }

    async clickBotonCancelar() {
        await this.linkCancelar.click();
    }

    async actualizarNombres(nombre) {
        await this.inputNombre.sendKeys(nombre);
    }

    async actualizarCelular(celular) {
        await this.inputCelular.sendKeys(celular);
    }

    async actualizarEmail(email) {
        await this.inputEmail.sendKeys(email);
    }

 }