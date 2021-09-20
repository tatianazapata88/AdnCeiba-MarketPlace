import { browser, logging } from 'protractor';
//import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { ProductoPage } from '../page/producto/producto.po';

describe('workspace-project Producto', () => {
    let page: AppPage;
  //  let navBar: NavbarPage;
    let producto: ProductoPage;

    beforeEach(() => {
        page = new AppPage();
        //navBar = new NavbarPage();
        producto = new ProductoPage();
        page.navigateTo('/producto/listar');
    });

  
    it('Deberia listar todas las scooters disponibles', async () => {
        expect(9713).toBe(producto.contarScooters());
    });

    it('Deberia listar scooters por precio', async () => {
        await producto.ingresaPrecio('4000000')
        await producto.clickBotonBuscarScooters();
       
        expect(1).toBe(producto.contarScooters());
    });

    it('Deberia listar scooters por ciudad', async () => {
       await producto.ingresarCiudad('cali')
       await producto.clickBotonBuscarScooters();
       
        expect(1).toBe(producto.contarScooters());
    });

    it('Deberia mostrar mensaje de bienvenida a la busqueda', () => {
        expect(page.getTitleTextbyId('h3listar')).toEqual('Encuentra tu proxima Scooter');
      });
    
     
      afterEach(async () => {
        // Assert that there are no errors emitted from the browser
        const logs = await browser.manage().logs().get(logging.Type.BROWSER);
        expect(logs).not.toContain(jasmine.objectContaining({
          level: logging.Level.SEVERE,
        } as logging.Entry));
      });
   
     
});
