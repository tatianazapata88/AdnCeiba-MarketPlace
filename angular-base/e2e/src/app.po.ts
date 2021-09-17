import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo(s: string) {
    return browser.get(browser.baseUrl+s) as Promise<any>;
  }

  getTitleTextbyId(s: string) {
    return element(by.id(s)).getText() as Promise<string>;
  }

  getTitleTextbyCss(s: string) {
    return element(by.css(s)).getText() as Promise<string>;
  }
}
