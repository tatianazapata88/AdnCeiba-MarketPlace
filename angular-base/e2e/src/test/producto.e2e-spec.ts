import { AppPage } from '../app.po';
import { ProductoPage } from '../page/producto/producto.po';

describe('workspace-project Producto', () => {
    let page: AppPage;
  // 
    let producto: ProductoPage;

    beforeEach(() => {
        page = new AppPage();
        producto = new ProductoPage();
        page.navigateTo('/producto/listar');
    });

  
    it('Deberia listar todas las scooters disponibles',  () => {
        expect(2).toBe(producto.contarScooters());
    });

    it('Deberia listar scooters por precio', async () => {
        await producto.ingresaPrecio('2300000')
        await producto.clickBotonBuscarScooter();
       
        expect(1).toBe(producto.contarScooters());
    });

    it('Deberia listar scooters por ciudad', async () => {
       await producto.ingresarCiudad('medellin')
       await producto.clickBotonBuscarScooter();
       
        expect(1).toBe(producto.contarScooters());
    });

    it('Deberia mostrar mensaje de bienvenida a la busqueda',() => {
      expect(page.getTitleTextbyId('h3listar')).toEqual('Encuentra tu proxima Scooter');
      });
     
    /*  it('Deberiaingresar a ver la scooter para gestionar la compra',async () => {
        await producto.clickBotonVerScotter();
        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'scooter/compra/1');
        });*/
     
});
