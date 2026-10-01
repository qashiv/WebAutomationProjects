import { expect, Page, type Locator} from "@playwright/test";
import { HomePage } from "../pages/HomePage";
import { BasePage } from "./BasePage";

export class MarketingLeadsPage extends BasePage{

  page : Page;
  readonly salutationType : Locator;
  readonly inputFirstName : Locator;
  readonly inputLastName : Locator;
  readonly inputCompany : Locator;
  readonly selectLeadSource : Locator;
  readonly selectLeadStatus : Locator;
  readonly selectAssignedUserId : Locator;
  readonly inputLane : Locator;
  readonly inputDescription : Locator;
  readonly btnSave: Locator;
  readonly txtFirstName : Locator;
  readonly txtLastName : Locator;
  readonly txtLeadNo : Locator;
  readonly linkMyHomePage : Locator;
  readonly inputSearchLeadNo : Locator;
  readonly inputSearchLead : Locator;
  readonly btnSubmit : Locator;
  readonly columnLead : Locator;


  constructor(page : Page){
    super(page);
    this.page = page;
    this.salutationType = page.locator('select[name="salutationtype"]');
    this.inputFirstName = page.locator('input[name="firstname"]');
    this.inputLastName = page.locator('input[name="lastname"]');
    this.inputCompany = page.locator('input[name="company"]');
    this.selectLeadSource = page.locator('select[name="leadsource"]');
    this.selectLeadStatus = page.locator('select[name="leadstatus"]');
    this.selectAssignedUserId = page.locator('select[name="assigned_user_id"]');
    this.inputLane = page.locator('textarea[name="lane"]');
    this.inputDescription = page.locator('textarea[name="description"]');
    this.btnSave = page.getByRole('button', { name: 'Save' }).nth(1);
    this.txtFirstName = page.locator("//td[contains(@id, 'First Name')]");
    this.txtLastName = page.locator("//td[contains(@id, 'Last Name')]");
    this.txtLeadNo = page.locator("//td[text()='Lead No']//following-sibling::td");
    this.linkMyHomePage = page.locator("//a[text()='My Home Page']");
    this.inputSearchLeadNo = page.locator("//input[@name='search_text']");
    this.inputSearchLead = page.locator("select#bas_searchfield");
    this.btnSubmit = page.locator("input[name='submit']");
    this.columnLead = page.locator("//table[@class = 'lvt small']//tr[2]//td[2]");

  }

  async fillLeadsFormAndReturnLeadNo(salutation: string, first_Name: string, lastName: string, company: string, leadSource: string, leadStatus: string, assignedUserId: string, lane: string, description: string): Promise<string> {
    await this.verifyVisible(this.salutationType);
    await this.selectOptionByValue(this.salutationType, salutation);
    await this.setValue(this.inputFirstName, first_Name);
    await this.setValue(this.inputLastName, lastName);
    await this.click(this.inputCompany);
    await this.setValue(this.inputCompany, company);
    await this.selectOptionByValue(this.selectLeadSource, leadSource);
    await this.selectOptionByValue(this.selectLeadStatus, leadStatus);
    await this.selectOptionByValue(this.selectAssignedUserId, assignedUserId);
    await this.click(this.inputLane);
    await this.setValue(this.inputLane, lane);
    await this.click(this.inputDescription);
    await this.setValue(this.inputDescription, description);
    await this.click(this.btnSave);
    await this.waitForLoadState();
    await this.wait(5000);
    await this.splitAndMatchText(this.txtFirstName, first_Name);
    let leadNo : string = await this.getVisibleText(this.txtLeadNo);
    return leadNo
  }

  async searchLeadByLeadNo(leadNo: string) : Promise<string>{
    await this.click(this.linkMyHomePage);
    await this.waitForLoadState();
    let homePage : HomePage = new HomePage(this.page);
    await homePage.goToMarketingLeadsPage();
    await this.wait(2000);
    await this.setValue(this.inputSearchLeadNo, leadNo);
    //await this.selectOptionByValue(this.inputSearchLead, "lead_no");
    await this.click(this.btnSubmit);
    await this.wait(2000);
    let act_LeadNo = await this.getVisibleText(this.columnLead);
    return act_LeadNo;
  }
}

