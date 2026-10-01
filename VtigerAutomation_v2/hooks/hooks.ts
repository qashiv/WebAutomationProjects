import {test} from "../fixtures/BaseFixtures";
import commondata from "../testdata/commondata.json" with {type: 'json'};

test.beforeAll(async () => {
    console.log("Test case execution is started...");

});

test.beforeEach(async ({loginPage}) => {
    console.log("BeforeEach - Test execution is started");
    await loginPage.goToURL(commondata.url);
});

test.afterEach(async ( {}, testInfo) => {
    console.log(`AfterEach - Test execution is completed: ${testInfo.title}`);
});

test.afterAll(async ({basePage}) => {
    console.log("AfterAll - Test execution has been completed");
    await basePage.closeBrowser();
});