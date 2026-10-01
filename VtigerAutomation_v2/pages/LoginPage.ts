import { Locator, Page } from "@playwright/test";
import { BasePage } from "./BasePage";

export class LoginPage extends BasePage{

  page : Page;
  readonly inputUserName : Locator;
  readonly inputPassword : Locator;
  readonly btnLogin : Locator;
  readonly loginErrorMsg : Locator;

  constructor(page : Page){
    super(page);
    this.page = page;
    this.inputUserName = page.locator('input[name="user_name"]');
    this.inputPassword = page.locator('input[name="user_password"]');
    this.btnLogin = page.getByRole('button', { name: 'Login [Alt+L]' });
    this.loginErrorMsg = page.locator("//font[contains(text(), 'You must specify a valid username and password.')]");
  }
  
  async login(userName : string, password : string){
    await this.setValue(this.inputUserName, userName);
    await this.setValue(this.inputPassword, password);
    await this.click(this.btnLogin);
  }
}