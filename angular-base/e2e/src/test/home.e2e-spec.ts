import { browser } from 'protractor';
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
      
        try {
        await home.ingresaUsername('taty');
        await home.clickBotonIngresar();
        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'producto/listar');  
        } catch (error) {
            expect(browser.console.error().error.mensaje).toEqual(error.error.mensaje)
        }
                
    });

    it('Deberia quedarse en home si el username no existe', async () => {
      
        try {
        await home.ingresaUsername('otro');
        await home.clickBotonIngresar();
        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'home');  
        } catch (error) {
            expect(browser.console.error().error.mensaje).toEqual(error.error.mensaje)
        }
                
    });

    it('Deberia ingresar a crear usuario', async () => {
        await home.ingresaUsername('');
        await home.clickBotonCrearUsuario();

        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'usuario/crear');
        
    });

    it('Deberia mostrar mensaje de bienvenida al ingreso',  () => {
         expect(page.getTitleTextbyId('h3')).toEqual('Bienvenido a Scooter Planet');
      });
          
    
});
