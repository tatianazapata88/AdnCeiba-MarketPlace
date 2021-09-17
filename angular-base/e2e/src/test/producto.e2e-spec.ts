//import { browser, logging } from 'protractor';
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

  
    it('Deberia listar todas las scooters disponibles', () => {
        expect(9713).toBe(producto.contarScooters());
    });

    it('Deberia listar scooters por precio', () => {
        producto.ingresaPrecio('4000000')
        producto.clickBotonListarProductos();
       
        expect(1).toBe(producto.contarScooters());
    });

    it('Deberia listar scooters por ciudad', () => {
        producto.ingresarCiudad('cali')
        producto.clickBotonListarProductos();
       
        expect(1).toBe(producto.contarScooters());
    });

    it('Deberia mostrar mensaje de bienvenida a la busqueda', () => {
        expect(page.getTitleTextbyId('h3listar')).toEqual('Encuentra tu proxima Scooter');
      });
    
});
