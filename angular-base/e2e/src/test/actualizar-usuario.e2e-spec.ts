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
        page.navigateTo('/usuario/actualizar');
    });

  
    it('Deberia actualizar  usuario y direccionar al ingreso', async () => {
        await actualizarUsuario.actualizarNombres(Math.random().toString(10).slice(-5));
        await actualizarUsuario.actualizarCelular(Math.random().toString(10).slice(-5));
        await actualizarUsuario.actualizarEmail(Math.random().toString(15).slice(-5));
        await actualizarUsuario.clickBotonActualizarUsuario();

        expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'usuario/actualizar');
        
    });

 /*  it('Deberia direccionar al usuario al ingreso despues de dar click cancelar', async () => {
       await actualizarUsuario.clickBotonCancelar();
       
            expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'producto/listar');
        
    });*/
/*
    it('Deberia salir mensaje de validacion campos vacios', async () => {
        await crearUsuario.ingresarUsername('');
        await crearUsuario.ingresarNombres('');
        await crearUsuario.ingresarCelular('');
        await crearUsuario.ingresarEmail('');
        await crearUsuario.clickBotonCrearUsuario();

        expect(Swal.isVisible()).toBeTruthy()
       
    });*/

    it('Deberia mostrar mensaje de bienvenida a Actualizar Usuario', async () => {
      await  expect(page.getTitleTextbyId('h3')).toEqual('Actualizar Datos');
      });
    
     
     
   
     
});
