import { by, element } from 'protractor';

export class CrearUsuarioPage {
    private linkCrearUsuario = element(by.id('btnCrear'));
    private linkCancelar = element(by.id('btnCancelar'));
    private inputUsername = element(by.id('username'));
    private inputNombre = element(by.id('nombre'));
    private inputCelular = element(by.id('celular'));
    private inputEmail = element(by.id('email'));
    

    ;

    async clickBotonCrearUsuario() {
        await this.linkCrearUsuario.click();
    }

    async clickBotonCancelar() {
        await this.linkCancelar.click();
    }

    async ingresarUsername(username) {
        await this.inputUsername.sendKeys(username);
    }

    async ingresarNombres(nombre) {
        await this.inputNombre.sendKeys(nombre);
    }

    async ingresarCelular(celular) {
        await this.inputCelular.sendKeys(celular);
    }

    async ingresarEmail(email) {
        await this.inputEmail.sendKeys(email);
    }
 }