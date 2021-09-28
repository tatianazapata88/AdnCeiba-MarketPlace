import { by, element } from 'protractor';

export class NavbarPage {
    linkSalir = element(by.xpath('/html/body/app-root/app-navbar/nav/a[1]'));
    linkComprar = element(by.xpath('/html/body/app-root/app-navbar/nav/a[2]'));
    linkVender = element(by.xpath('/html/body/app-root/app-navbar/nav/a[3]'));
    linkPerfil = element(by.xpath('/html/body/app-root/app-navbar/nav/a[4]'));

    async clickLinkSalir() {
        await this.linkSalir.click();
    }

    async clickLinkComprar(){
        await this.linkComprar.click();
    }

    async clickLinkVender(){
        await this.linkVender.click();
    }

    async clickLinkPerfil(){
        await this.linkPerfil.click();
    }
}
