import { by, element } from 'protractor';

export class HomePage {
    private linkCrearUsuario = element(by.id('btnCrear'));
    private linkIngresar = element(by.id('btnIngresar'));
    private inputUsername = element(by.id('username'));
    
    async clickBotonCrearUsuario() {
        await this.linkCrearUsuario.click();
    }

    async clickBotonIngresar() {
        await this.linkIngresar.click();
    }

    async ingresaUsername(username) {
        await this.inputUsername.sendKeys(username);
    }

}
