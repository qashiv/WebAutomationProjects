import { Locator, Page } from "@playwright/test";
import { BasePage } from "./BasePage";

export class HomePage extends BasePage {

    page : Page;
    readonly linkMarketing : Locator;
    readonly linkMarketingLeads : Locator;
    readonly linkCreateLead : Locator;
    readonly linkSales : Locator;
    readonly linkSalesAccounts : Locator;
    readonly linkMarketingCampaigns : Locator;

    constructor(page: Page) {
        super(page);
        this.page = page;
        this.linkMarketing = page.locator("//a[text()='Marketing']");
        this.linkMarketingLeads = page.locator("//div[@id='Marketing_sub']//a[text() = 'Leads']");
        this.linkCreateLead = page.getByRole('link', { name: 'Create Lead...' });
        this.linkSales = page.locator("//a[text()='Sales']");
        this.linkSalesAccounts = page.locator('//div[@id="Sales_sub"]//a[text()="Accounts"]');
        this.linkMarketingCampaigns = page.getByRole('link', { name: 'Campaigns' });
    }

    async goToMarketingLeadsPage(): Promise<void>{
        await this.waitForLoadState();
        await this.mouseHover(this.linkMarketing);
        await this.wait(2000);
        await this.click(this.linkMarketingLeads);
        await this.waitForLoadState();
    }

    async clickCreateLead() : Promise<void>{
        await this.click(this.linkCreateLead);
        await this.wait(5000);
    }

    async goToSalesAccounts(): Promise<void>{
        await this.mouseHover(this.linkSales);
        await this.wait(2000);
        await this.click(this.linkSalesAccounts);
        await this.waitForLoadState();
    }

    async goToMarketingCampaigns(): Promise<void>{
        await this.mouseHover(this.linkMarketing);
        await this.wait(2000);
        await this.click(this.linkMarketingCampaigns);
        await this.waitForLoadState();
    }

}