import { AppPage } from './app.po';
import { browser} from 'protractor';
import { NavbarPage } from './page/navbar/navbar.po';


describe('workspace-project App', () => {
  let page: AppPage;
  let navBar: NavbarPage;

  beforeEach(() => {
    page = new AppPage();
    navBar = new NavbarPage();
 
  });

  it('Deberia mostrar mensaje de bienvenida a la app', () => {
    page.navigateTo('/');
    expect(page.getTitleTextbyCss('app-root h1')).toEqual('Scooter Planet');
  });

  it('Deberia enviar al ingreso de la app al dar click navbar salir' , async () => {
    await page.navigateTo('/');
    await navBar.clickLinkSalir();

    expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'home');

  });

  it('Deberia enviar al ingreso de la app al dar click navbar comprar' , async () => {
    await page.navigateTo('/');
    await navBar.clickLinkComprar();

    expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'producto/listar');

  });

  it('Deberia enviar al ingreso de la app al dar click navbar vender' , async () => {
    await page.navigateTo('/');
    await navBar.clickLinkVender();

    expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'producto/crear');

  });

  it('Deberia enviar al ingreso de la app al dar click navbar perfil' , async () => {
    await page.navigateTo('/');
    await navBar.clickLinkPerfil();

    expect(browser.getCurrentUrl()).toEqual(browser.baseUrl + 'usuario/actualizar');

  });

 
});
