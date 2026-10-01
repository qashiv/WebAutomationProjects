import { defineConfig, devices } from '@playwright/test';

export default defineConfig({

  // Folder where tests are located
  testDir: './tests',

  // Timeout for each test
  timeout: 180 * 1000, // 180 seconds - 3 mins

  // Timeout for expect assertions
  expect: {
    timeout: 30000,
  },

  // Run tests in parallel
  fullyParallel: false,

  // Retry failed tests
  retries: 1,

  // Number of workers
  workers: 1,

  // Reporter
  reporter: [
    ['html'],
    ['list']
  ],

  // Shared settings for all projects
  use: {
    // Base URL
    baseURL: 'http://localhost:8888',

    // Browser options
    browserName: 'chromium',

    // Headless mode
    headless: false,

    // Take screenshot on failure
    screenshot: 'only-on-failure',

    // Record video on failure
    video: 'retain-on-failure',

    // Save trace on retry
    trace: 'on-first-retry',

    // Ignore HTTPS certificate errors
    ignoreHTTPSErrors: true,

    // Browser viewport
    viewport: {
      width: 1280,
      height: 720,
    },

    // Maximum action timeout
    actionTimeout: 60000,

    // Maximum navigation timeout
    navigationTimeout: 60000,
  },

  // Multiple browser projects
  projects: [
    {
      name: 'Chromium',
      use: {
        ...devices['Desktop Chrome'],
      },
    }
    //,
    // {
    //   name: 'Firefox',
    //   use: {
    //     ...devices['Desktop Firefox'],
    //   },
    // },
    // {
    //   name: 'WebKit',
    //   use: {
    //     ...devices['Desktop Safari'],
    //   },
    // },
  ],

  // Start local server before tests (optional)
  /*
  webServer: {
    command: 'npm run start',
    url: 'http://localhost:3000',
    reuseExistingServer: !process.env.CI,
  },
  */

  // Folder for test results
  outputDir: 'test-results',
});