import {test} from "../../fixtures/BaseFixtures";
import testdata from "../../testdata/testdata.json" with {type : 'json'};
import commondata from "../../testdata/commondata.json" with {type : 'json'}; 
import "../../hooks/hooks";

test('TC001- Verify Campaign', async ({page, loginPage, homePage, marketingCampaignsPage}) => {
    await loginPage.login(commondata.username, commondata.password);
    await homePage.goToMarketingCampaigns();
    await marketingCampaignsPage.createNewCampaigns(testdata.marketingCampaigns.CampaignName, testdata.marketingCampaigns.CampaignType, testdata.marketingCampaigns.TargetAudience, testdata.marketingCampaigns.BudgetCost, testdata.marketingCampaigns.ExpectedResponce, testdata.marketingCampaigns.ExpectedSalesCount, testdata.marketingCampaigns.ActualCost, testdata.marketingCampaigns.ExpectedRevenue, testdata.marketingCampaigns.ActualSalesCount, testdata.marketingCampaigns.Description);


//       await expect(page.getByText('[ CAM62 ] TTest - Campaign')).toBeVisible();
//   page.once('dialog', dialog => {
//     console.log(`Dialog message: ${dialog.message()}`);
//     dialog.dismiss().catch(() => {});
//   });
//   await page.getByRole('button', { name: 'Delete' }).first().click();
});