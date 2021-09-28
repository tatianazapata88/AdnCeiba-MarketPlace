import { browser} from 'protractor';
import { AppPage } from '../app.po';
import { CrearProductoPage } from '../page/crearProducto/crear-producto.po';


describe('workspace-project Crear Scooter', () => {
    let page: AppPage;
    let crearProducto: CrearProductoPage;

    beforeEach(() => {
        page = new AppPage();
        crearProducto = new CrearProductoPage();
        page.navigateTo('producto/crear');
    });

    it('Deberia mostrar mensaje de bienvenida a la publicacion de scooter', () => {
      expect(page.getTitleTextbyId('h3Publicar')).toEqual('Scooter');
      });

      it('Deberia publicar scooter y direccionar al ingreso', () => {
         crearProducto.ingresarMarca(Math.random().toString(10).slice(-5));
      crearProducto.ingresarModelo(Math.random().toString(10).slice(-5));
     crearProducto.ingresarPrecio(Math.random().toString(10).slice(-5));
      crearProducto.ingresarCiudad(Math.random().toString(15).slice(-5));
      crearProducto.ingresarFoto(Math.random().toString(15).slice(-5));
       crearProducto.clickBotonPublicarScooter();

        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'producto/crear');
        
    });

    it('Deberia direccionar al usuario al ingreso despues de dar click cancelar', async() => {
        await crearProducto.clickBotonCancelar();
        
             expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'home');
         
     });
    
     

  
     
});
