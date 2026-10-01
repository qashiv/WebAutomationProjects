import {expect, test} from "@playwright/test";
import logindata from "../testdata/logindata.json" with {type : 'json'};
import commondata from "../testdata/commondata.json" with {type : 'json'};
import { LoginPage } from "../pages/LoginPage";

logindata.forEach((data) => {
    test(`Verify Login - ${data.label}`, async ({page}) => {
        let loginPage : LoginPage = new LoginPage(page);
        await loginPage.goToURL(commondata.url);
        await loginPage.login(data.username, data.password);
        if(data.status == "valid"){
            await expect(page).toHaveTitle(/vtiger CRM 5 - Commercial Open Source CRM/i);
        }else{
            await expect(loginPage.loginErrorMsg).toBeVisible();
        }
    });
});