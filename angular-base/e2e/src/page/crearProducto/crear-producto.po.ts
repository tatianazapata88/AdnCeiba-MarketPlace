import { by, element } from 'protractor';

export class CrearProductoPage {
    private linkPublicarScooter = element(by.id('btnPublicar'));
    private linkCancelar = element(by.id('btnCancelar'));
    private inputMarca = element(by.id('marca'));
    private inputModelo = element(by.id('modelo'));
    private inputPrecio = element(by.id('precio'));
    private inputCiudad = element(by.id('ciudad'));
    private inputFoto = element(by.id('foto'));

    ;

    async clickBotonPublicarScooter() {
        await this.linkPublicarScooter.click();
    }

    async clickBotonCancelar() {
        await this.linkCancelar.click();
    }

    async ingresarMarca(marca) {
        await this.inputMarca.sendKeys(marca);
    }

    async ingresarModelo(modelo) {
        await this.inputModelo.sendKeys(modelo);
    }

    async ingresarPrecio(precio) {
        await this.inputPrecio.sendKeys(precio);
    }

    async ingresarCiudad(ciudad) {
        await this.inputCiudad.sendKeys(ciudad);
    }
    async ingresarFoto(foto) {
        await this.inputFoto.sendKeys(foto);
    }

 }