import { by, element } from 'protractor';

export class ProductoPage {
    private linkBuscarScooters = element(by.id('buscar'));
    private inputPrecioScooter = element(by.id('precio'));
    private inputCiudadScooter = element(by.id('ciudad'));
   // private linkVerScootter= element(by.xpath('/html/body/app-root/app-producto/app-listar-producto/div.container.align-center/div.card.mb-3/div.row.no-gutters/div.col.md-4/div.card-body/button.btn.btn-info.btn-fill-pull-right[0]'));
    private listaProductos = element.all(by.id('idScooter'));

    
    async clickBotonBuscarScooter() {
        await this.linkBuscarScooters.click();
    }

  /*  async clickBotonVerScotter() {
        await this.linkVerScootter.click();
    }*/
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
