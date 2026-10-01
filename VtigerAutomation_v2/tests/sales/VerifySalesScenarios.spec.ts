import {expect} from "@playwright/test";
import commondata from "../../testdata/commondata.json" with {type: 'json'};
import testdata from "../../testdata/testdata.json" with {type: 'json'};
import {test} from "../../fixtures/BaseFixtures";

test('TC001 - Verify Sales Accounts', async ({ page, loginPage, homePage, salesAccounts }) => {
    await loginPage.goToURL(commondata.url);
    await loginPage.login(commondata.username, commondata.password);
    await homePage.goToSalesAccounts();
    
    await salesAccounts.clickCreateNewAccounts();
    let accountNo : string = await salesAccounts.fillAccountsFormAndReturnAccountsNo(testdata.salesAccounts.accountName, testdata.salesAccounts.website, testdata.salesAccounts.address);
    console.log(accountNo);
    let act_AccNo = await salesAccounts.searchAccoutsByAccNo(accountNo);
    expect(act_AccNo).toBe(accountNo);
});

