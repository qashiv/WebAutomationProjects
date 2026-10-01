import { expect} from '@playwright/test';
import commondata from "../../testdata/commondata.json" with {type: 'json'};
import testdata from "../../testdata/testdata.json" with {type: 'json'}
import {test} from "../../fixtures/BaseFixtures";
import "../../hooks/hooks";

test('TC001 - Verify Marketing Lead Creation', async ({ page, loginPage, homePage, marketingLeadsPage }) => {
  await loginPage.login(commondata.username, commondata.password);
  await homePage.goToLeadsPage();
  await homePage.clickCreateLead();
  let leadNumber : string = await marketingLeadsPage.fillLeadsFormAndReturnLeadNo(testdata.marketingLeads.salutation, testdata.marketingLeads.firstName, testdata.marketingLeads.lastName, testdata.marketingLeads.company, testdata.marketingLeads.leadSource, testdata.marketingLeads.leadStatus, testdata.marketingLeads.assignedUserId, testdata.marketingLeads.lane, testdata.marketingLeads.description);
  expect(leadNumber).not.toBeNull();
  expect(marketingLeadsPage.txtLeadNo).toHaveText(leadNumber);
  expect(marketingLeadsPage.txtFirstName).toContainText(testdata.marketingLeads.firstName);
  expect(marketingLeadsPage.txtLastName).toContainText(testdata.marketingLeads.lastName);
  expect(page).toHaveTitle(testdata.marketingLeads.title);
});

test('TC002 - Search and Verify Marketing Lead by Lead Number', async ({loginPage, homePage, marketingLeadsPage }) => {
  await loginPage.login(commondata.username, commondata.password);
  await homePage.goToLeadsPage();
  await homePage.clickCreateLead();
  let leadNumber : string = await marketingLeadsPage.fillLeadsFormAndReturnLeadNo(testdata.marketingLeads.salutation, testdata.marketingLeads.firstName, testdata.marketingLeads.lastName, testdata.marketingLeads.company, testdata.marketingLeads.leadSource, testdata.marketingLeads.leadStatus, testdata.marketingLeads.assignedUserId, testdata.marketingLeads.lane, testdata.marketingLeads.description);
  console.log(leadNumber);
  let act_LeadNo : string = await marketingLeadsPage.searchLeadByLeadNo(leadNumber);
  expect(act_LeadNo).toBe(leadNumber);
});