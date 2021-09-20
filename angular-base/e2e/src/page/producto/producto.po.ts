import { by, element } from 'protractor';

export class ProductoPage {
    private linkCrearProducto = element(by.id('linkCrearProducto'));
    private linkBuscarScooters = element(by.id('buscar'));
    private inputPrecioScooter = element(by.id('precio'));
    private inputCiudadScooter = element(by.id('ciudad'));
    private listaProductos = element.all(by.id('idScooter'));

    ;

    async clickBotonCrearProductos() {
        await this.linkCrearProducto.click();
    }

    async clickBotonBuscarScooters() {
        await this.linkBuscarScooters.click();
    }

    async ingresaPrecio(precio) {
        await this.inputPrecioScooter.sendKeys(precio);
    }

    async ingresarCiudad(ciudad) {
        await this.inputCiudadScooter.sendKeys(ciudad);
    }

    async contarScooters() {
        return this.listaProductos.count();
    }
}
