import { Locator, Page } from "@playwright/test";
import { BasePage } from "./BasePage";

export class MarketingCampaignsPage extends BasePage{

    page: Page;
    readonly createCampaignBtn : Locator;
    readonly inputCampaignsName : Locator;
    readonly selectCampaignType : Locator;
    readonly inputTargetAudience : Locator;
    readonly inputBudgetCost : Locator;
    readonly selectExpectedResponse : Locator;
    readonly inputExpectedSalesCount : Locator;
    readonly inputActualCost : Locator;
    readonly inputExpectedRevenue : Locator;
    readonly inputActualSalesCount : Locator;
    readonly inputDescription : Locator;
    readonly saveButton : Locator;

    constructor(page: Page){
        super(page);
        this.page = page;
        this.createCampaignBtn = page.getByRole('link', { name: 'Create Campaign...' });
        this.inputCampaignsName = page.locator('input[name="campaignname"]');
        this.selectCampaignType = page.locator('select[name="campaigntype"]');
        this.inputTargetAudience = page.locator('#targetaudience');
        this.inputBudgetCost = page.locator('#budgetcost');
        this.selectExpectedResponse = page.locator('select[name="expectedresponse"]');
        this.inputExpectedSalesCount = page.locator('#expectedsalescount');
        this.inputActualCost = page.locator('#actualcost');
        this.inputExpectedRevenue = page.locator('#expectedrevenue');
        this.inputActualSalesCount = page.locator('#actualsalescount');
        this.inputDescription = page.locator('textarea[name="description"]');
        this.saveButton = page.getByRole('button', { name: 'Save' }).nth(1);


    }

    async createNewCampaigns(campaignName: string, campaignType: string, targetAudience: string, budgetCost:string, expectedResponse: string, 
        expectedSalesCount: string, actualCost: string, expectedRevenue: string, actualSalesCount: string, description:string
    ){
        await this.click(this.createCampaignBtn);
        await this.setValue(this.inputCampaignsName, campaignName);
        await this.selectOptionByLabel(this.selectCampaignType, campaignType);
        await this.setValue(this.inputTargetAudience, targetAudience);
        await this.setValue(this.inputBudgetCost, budgetCost);
        await this.selectOptionByLabel(this.selectExpectedResponse, expectedResponse);
        await this.setValue(this.inputExpectedSalesCount, expectedSalesCount);
        await this.setValue(this.inputActualCost, actualCost);
        await this.setValue(this.inputExpectedRevenue, expectedRevenue);
        await this.setValue(this.inputActualSalesCount, actualSalesCount);
        await this.setValue(this.inputDescription, description);
        await this.click(this.saveButton);
    }

}