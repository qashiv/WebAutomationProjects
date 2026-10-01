import test from "@playwright/test";

test('Valid Login @smoke', async () => {
    console.log('Valid Login - Smoke');
});

test('Invalid Login @regression', async () => {
    console.log("Invalid Login - Regression");
});

test('Logout @sanity', async () => {
    console.log("Logout - Sanity");
});
