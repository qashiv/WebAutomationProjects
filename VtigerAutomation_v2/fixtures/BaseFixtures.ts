import {test as base} from "@playwright/test"
import { HomePage } from "../pages/HomePage";
import { LoginPage } from "../pages/LoginPage"
import { MarketingLeadsPage } from "../pages/MarketingLeadsPage";
import { BasePage } from "../pages/BasePage";
import { SalesAccountsPage } from "../pages/SalesAccountsPage";
import { MarketingCampaignsPage } from "../pages/MarketingCampaignsPage";

type myFixtures = {
    basePage : BasePage;
    loginPage : LoginPage;
    homePage : HomePage;
    marketingLeadsPage : MarketingLeadsPage;
    marketingCampaignsPage : MarketingCampaignsPage;
    salesAccounts : SalesAccountsPage;
}

export const test = base.extend<myFixtures> ({

    basePage : async ({page}, use) => {
        let basePage : BasePage = new LoginPage(page);
        await use(basePage);
    },

    loginPage : async ({page}, use) => {
        let loginPage : LoginPage = new LoginPage(page);
        await use(loginPage);
    },
    homePage : async ({page}, use) => {
        let homePage : HomePage = new HomePage(page);
        await use(homePage);
    },
    marketingLeadsPage : async ({page}, use) => {
        let marketingLeadsPage : MarketingLeadsPage = new MarketingLeadsPage(page);
        await use(marketingLeadsPage);
    },
    marketingCampaignsPage : async ({page}, use) => {
        let marketingCampaignsPage : MarketingCampaignsPage = new MarketingCampaignsPage(page);
        await use(marketingCampaignsPage);
    },
    salesAccounts : async ({page}, use) => {
        let salesAccounts : SalesAccountsPage = new SalesAccountsPage(page);
        await use(salesAccounts);
    }
    
});
