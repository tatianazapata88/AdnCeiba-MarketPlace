import { browser, logging } from 'protractor';
import { AppPage } from '../app.po';
import { CrearUsuarioPage } from '../page/crearUsuario/crear-usuario.po';



describe('workspace-project Crear Usuario', () => {
    let page: AppPage;
    let crearUsuario: CrearUsuarioPage;

    beforeEach(() => {
        page = new AppPage();
        crearUsuario = new CrearUsuarioPage();
        page.navigateTo('/usuario/crear');
    });

  
    it('Deberia crear usuario y direccionar al ingreso', async () => {
        await crearUsuario.ingresarUsername(Math.random().toString(10).slice(-5));
        await crearUsuario.ingresarNombres(Math.random().toString(10).slice(-5));
        await crearUsuario.ingresarCelular(Math.random().toString(10).slice(-5));
        await crearUsuario.ingresarEmail(Math.random().toString(15).slice(-5));
        await crearUsuario.clickBotonCrearUsuario();

        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'home');
        
    });
/*
    it('Deberia ingresar a crear usuario', async () => {
        await home.ingresaUsername('');
        await home.clickBotonCrearUsuario();

        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'usuario/crear');
        
    });

    it('No Deberia ingresar si el username no existe', async () => {
        await home.ingresaUsername('otro');
        await home.clickBotonIngresar();
       
    });
*/

    it('Deberia mostrar mensaje de bienvenida a creacion Usuario', async () => {
       await expect(page.getTitleTextbyId('h3')).toEqual('Registrar Usuario');
      });
    
     
      afterEach(async () => {
        // Assert that there are no errors emitted from the browser
        const logs = await browser.manage().logs().get(logging.Type.BROWSER);
        expect(logs).not.toContain(jasmine.objectContaining({
          level: logging.Level.SEVERE,
        } as logging.Entry));
      });
   
     
});
