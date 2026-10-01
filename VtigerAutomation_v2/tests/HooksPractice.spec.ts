import test from "@playwright/test";

test.beforeAll('BeforeAll', async () => {
    console.log("Before All - Run once before all tests")
});

test.beforeEach('BeforeEach', async () => {
    console.log("Before Each");
});

test.describe('Group 1', async () => {
    test('Test 1', async () => {
        console.log("This is Test 1");
    });

    test('Test 2', async () => {
        console.log("This is Test 2");
    });
});

test.describe('Group 2', async () => {
    test('Test 3', async () => {
        console.log("This is Test 3");
    });

    test('Test 4', async () => {
        console.log("This is Test 4");
    });
});

test.afterEach('AfterEach', async () => {
    console.log("After Each");
});

test.afterAll('AfterAll', async () => {
    console.log("After All - Run once after all tests");
});