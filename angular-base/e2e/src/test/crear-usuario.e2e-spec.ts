import { browser} from 'protractor';
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

  
    it('Deberia crear usuario y direccionar al ingreso',  () => {
         crearUsuario.ingresarUsername(Math.random().toString(10).slice(-5));
         crearUsuario.ingresarNombres(Math.random().toString(10).slice(-5));
         crearUsuario.ingresarCelular(Math.random().toString(10).slice(-5));
         crearUsuario.ingresarEmail(Math.random().toString(15).slice(-5));
         crearUsuario.clickBotonCrearUsuario();

        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'home');
        
    });

    it('Deberia direccionar al usuario al ingreso despues de dar click cancelar', () => {
       crearUsuario.clickBotonCancelar();
       
            expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'home');
        
    });

    it('Deberia salir mensaje de validacion error campo vacio username', async () => {
       try {
        await crearUsuario.ingresarUsername('');
        await crearUsuario.ingresarNombres(Math.random().toString(10).slice(-5));
        await crearUsuario.ingresarCelular(Math.random().toString(10).slice(-5));
        await crearUsuario.ingresarEmail(Math.random().toString(15).slice(-5));
        await crearUsuario.clickBotonCrearUsuario();
        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'usuario/crear');
       } catch (error) {
        expect(browser.console.error().error.mensaje).toEqual(error.error.mensaje);
       }
       
    });
    it('Deberia salir mensaje de validacion error campo vacionombre', async () => {
      try {
       await crearUsuario.ingresarUsername(Math.random().toString(10).slice(-5));
       await crearUsuario.ingresarNombres('');
       await crearUsuario.ingresarCelular(Math.random().toString(10).slice(-5));
       await crearUsuario.ingresarEmail(Math.random().toString(15).slice(-5));
       await crearUsuario.clickBotonCrearUsuario();
       expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'usuario/crear');
      } catch (error) {
       expect(browser.console.error().error.mensaje).toEqual(error.error.mensaje);
      }
      
   });

    it('Deberia salir mensaje de validacion error todos los campos vacios ', async () => {
      try {
       await crearUsuario.ingresarUsername('');
       await crearUsuario.ingresarNombres('');
       await crearUsuario.ingresarCelular('');
       await crearUsuario.ingresarEmail('');
       await crearUsuario.clickBotonCrearUsuario();
       expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'usuario/crear');
      } catch (error) {
       expect(browser.console.error().error.mensaje).toEqual(error.error.mensaje);
      }
      
   });

    it('Deberia mostrar mensaje de bienvenida a creacion Usuario',  () => {
       expect(page.getTitleTextbyId('h3')).toEqual('Registrar Usuario');
      });
    
  
   
     
});
