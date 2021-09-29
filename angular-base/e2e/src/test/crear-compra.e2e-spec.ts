import { browser} from 'protractor';
import { AppPage } from '../app.po';
import { CrearCompraPage } from '../page/compra/crearCompra.po';



describe('workspace-project Crear Scooter', () => {
    let page: AppPage;
    let crearCompra: CrearCompraPage;

    beforeEach(() => {
        page = new AppPage();
        crearCompra = new CrearCompraPage();
        page.navigateTo('compra/1');
    });

    it('Deberia mostrar mensaje de bienvenida a la vista generar compra', () => {
      expect(page.getTitleTextbyId('h4')).toEqual('Gestionar Compra Scooter');
      });

      it('Deberia publicar scooter y direccionar al ingreso', async() => {
       await crearCompra.ingresarCiudadDEstino('Medellin');
       await crearCompra.ingresarFecha();
       crearCompra.clickBotonComprarScooter();

        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'compra/1');
        
    });

    it('Deberia direccionar al usuario al ingreso despues de dar click cancelar', async() => {
        await crearCompra.clickBotonCancelar();
        
             expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'producto/listar');
         
     });
    
     

  
     
});
