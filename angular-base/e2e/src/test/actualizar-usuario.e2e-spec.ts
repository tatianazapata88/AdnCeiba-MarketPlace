import { browser } from 'protractor';
import { AppPage } from '../app.po';
import { ActualizarUsuarioPage } from '../page/actuUsuario/actualizar-usuario.po';


//import Swal from 'sweetalert2';



describe('workspace-project Actualizar Usuario', () => {
    let page: AppPage;
    let actualizarUsuario: ActualizarUsuarioPage;
    
    beforeEach(() => {
        page = new AppPage();
        actualizarUsuario = new ActualizarUsuarioPage();
        page.navigateTo('/usuario/actualizar/');
      //  browser.executeScript("window.localStorage.setItem('datosSesion', JSON.stringify({'id': 1,'username': 'taty','nombre': 'Luz Tatiana Zapata','celular': '3135151616','email': 'taty@gmail.com'}));");
        
    });

  
    it('Deberia actualizar  usuario y direccionar al ingreso', async () => {
      //  await browser.executeScript("window.localStorage.getItem('datosSesion')");
        await actualizarUsuario.actualizarNombres(Math.random().toString(10).slice(-5));
        await actualizarUsuario.actualizarCelular(Math.random().toString(10).slice(-5));
        await actualizarUsuario.actualizarEmail(Math.random().toString(15).slice(-5));
        await actualizarUsuario.clickBotonActualizarUsuario();

        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'usuario/actualizar');
        
    });


    it('Deberia mostrar mensaje de bienvenida a Actualizar Usuario', async () => {
      await  expect(page.getTitleTextbyId('h3')).toEqual('Actualizar Datos');
      });
    
     
     
   
     
});
