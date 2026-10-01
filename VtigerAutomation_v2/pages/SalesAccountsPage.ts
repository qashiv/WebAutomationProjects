import { expect, Locator, Page } from "@playwright/test";
import { HomePage } from "./HomePage";
import { BasePage } from "./BasePage";

export class SalesAccountsPage extends BasePage{

    page : Page; // Instance Variable
    readonly linkCreateNewAccounts : Locator;
    readonly labelCreatingNewAccount : Locator;
    readonly inputAccountName : Locator;
    readonly inputWebsite : Locator;
    readonly inputAddress : Locator;
    readonly btnSave : Locator;
    readonly txtAccountNo : Locator;
    readonly linkMyHomePage : Locator;
    readonly inputSearchAccountNo : Locator;
    readonly dropdownAccountNo : Locator;
    readonly btnSubmit : Locator;
    readonly columnLead : Locator;

    constructor(page : Page){
        super(page);
        this.page = page;
        this.linkCreateNewAccounts = page.locator('//img[@title="Create Account..."]');
        this.labelCreatingNewAccount = page.locator("//span[text()= 'Creating New Account']");
        this.inputAccountName = page.locator('input[name="accountname"]');
        this.inputWebsite = page.locator("input[name='website']");
        this.inputAddress = page.locator("textarea.detailedViewTextBox").first();
        this.btnSave = page.locator("input[title='Save [Alt+S]']").nth(1);
        this.txtAccountNo = page.locator("//td[text()='Account No']//following-sibling::td");
        this.linkMyHomePage = page.locator("//a[text()='My Home Page']");
        this.inputSearchAccountNo = page.locator("//input[@name='search_text']");
        this.dropdownAccountNo = page.locator("select#bas_searchfield");
        this.btnSubmit = page.locator("input[name='submit']");
        this.columnLead = page.locator("//table[@class = 'lvt small']//tr[2]//td[2]");
    }
    
    async clickCreateNewAccounts(){
        await this.click(this.linkCreateNewAccounts);
        await this.waitForLoadState();
    }

    async fillAccountsFormAndReturnAccountsNo(accountName: string, website: string, address: string) : Promise<string>{
        await this.verifyVisible(this.labelCreatingNewAccount);
        await this.setValue(this.inputAccountName, accountName);
        await this.setValue(this.inputWebsite, website);
        await this.setValue(this.inputAddress, address);
        await this.click(this.btnSave);
        await this.wait(5000);
        let accountsNo : string = await this.getVisibleText(this.txtAccountNo);
        expect(accountsNo).not.toBe('');
        return accountsNo;
    }

    async searchAccoutsByAccNo(accontsNo: string) : Promise<string>{
        await this.click(this.linkMyHomePage);
        await this.waitForLoadState();

        let homePage : HomePage = new HomePage(this.page);
        await homePage.goToSalesAccounts();
        await this.wait(2000);
        await this.setValue(this.inputSearchAccountNo, accontsNo);
        //await this.selectOptionByValue(this.dropdownAccountNo, "accounts_no");
        await this.click(this.btnSubmit);
        await this.wait(2000);
        let act_accontsNo = await this.getVisibleText(this.columnLead);
        return act_accontsNo;
    }
}

