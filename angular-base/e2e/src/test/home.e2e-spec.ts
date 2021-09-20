import { browser, logging } from 'protractor';
import { AppPage } from '../app.po';
import { HomePage } from '../page/home/home.po';


describe('workspace-project Ingreso', () => {
    let page: AppPage;
    let home: HomePage;

    beforeEach(() => {
        page = new AppPage();
        home = new HomePage();
        page.navigateTo('');
    });

  
    it('Deberia ingresar si el username existe', async () => {
        await home.ingresaUsername('taty');
        await home.clickBotonIngresar();

        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'producto/listar');
        
    });

    it('Deberia ingresar a crear usuario', async () => {
        await home.ingresaUsername('');
        await home.clickBotonCrearUsuario();

        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'usuario/crear');
        
    });
/*
    it('No Deberia ingresar si el username no existe', async () => {
        await home.ingresaUsername('otro');
        await home.clickBotonIngresar();
       
    });
*/

    it('Deberia mostrar mensaje de bienvenida al ingreso', async () => {
       await expect(page.getTitleTextbyId('h3')).toEqual('Bienvenido a Scooter Planet');
      });
    
     
      afterEach(async () => {
        // Assert that there are no errors emitted from the browser
        const logs = await browser.manage().logs().get(logging.Type.BROWSER);
        expect(logs).not.toContain(jasmine.objectContaining({
          level: logging.Level.SEVERE,
        } as logging.Entry));
      });
   
     
});
