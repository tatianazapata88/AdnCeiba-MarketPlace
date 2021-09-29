import { by, element } from 'protractor';

export class CrearCompraPage {
    private linkCancelar = element(by.id('btnCancelar'));
    private linkComprarScooter = element(by.id('btnComprar'));
    private inputCiudadDestino = element(by.id('ciudadDestinoEnvioScotter'));
    private inputFecha = element(by.id('fecha'));

    ;

    async clickBotonComprarScooter() {
        await this.linkComprarScooter.click();
    }

    async clickBotonCancelar() {
        await this.linkCancelar.click();
    }

    async ingresarCiudadDEstino(ciudad) {
        await this.inputCiudadDestino.sendKeys(ciudad);
    }

     async ingresarFecha(fecha) {
        await this.inputFecha.sendKeys(fecha);
    }

 }