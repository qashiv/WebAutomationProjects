# Android Calculator Mobile Automation Framework

Appium + Java + TestNG framework for automating the Android Calculator application.

## Tech Stack

- Java 17
- Appium Java Client 9.4.0
- Selenium 4.33.0
- TestNG 7.8.0
- Maven
- Android Emulator / Android Device
- UiAutomator2

## Framework Architecture

```text
calculator-appium-framework
│
├── pom.xml
├── testng.xml
├── README.md
│
├── src/main/java
│   ├── config
│   │   └── ConfigReader.java
│   ├── driver
│   │   └── DriverFactory.java
│   ├── pages
│   │   └── CalculatorPage.java
│   └── util
│       └── ElementActions.java
│
└── src/test/java
    ├── base
    │   └── BaseTest.java
    ├── tests
    │   └── CalculatorTests.java
    └── utils
        └── ScreenshotUtil.java
```

## Prerequisites

1. JDK 17 installed.
2. Maven installed.
3. Android Studio / Android SDK installed.
4. An Android emulator or physical Android device.
5. Appium 2 installed.
6. UiAutomator2 Appium driver installed.

Check:

```bash
java --version
mvn -version
adb devices
appium --version
appium driver list
```

Install UiAutomator2 if required:

```bash
appium driver install uiautomator2
```

## Start Appium

```bash
appium
```

Default server:

```text
http://127.0.0.1:4723
```

## Check the Calculator Package

Calculator package/activity can differ by Android image.

Run:

```bash
adb shell pm list packages | findstr calculator
```

You can inspect the current foreground application with:

```bash
adb shell dumpsys window | findstr mCurrentFocus
```

If your emulator does not use:

```text
com.android.calculator2
```

update:

```text
src/test/resources/config.properties
```

For example:

```properties
appPackage=<your-calculator-package>
appActivity=<your-calculator-activity>
```

## Execute Tests

From the project root:

```bash
mvn clean test
```

Or run:

```bash
mvn -Dtest=CalculatorTests test
```

## Scenarios Covered

| Test | Scenario | Expected |
|---|---|---|
| basicAdditionTest | 10 + 20 | 30 |
| subtractionTest | 100 - 25 | 75 |
| multiplicationTest | 5 × 6 | 30 |
| divisionTest | 100 ÷ 4 | 25 |
| divisionByZeroTest | 10 ÷ 0 | Error/Infinity-style handling |
| clearFunctionalityTest | Enter calculation → Clear | Reset/cleared display |

## Screenshots

Failed tests automatically capture screenshots under:

```text
test-output/screenshots/
```

## Design Explanation

### DriverFactory
Creates and manages the Appium AndroidDriver using UiAutomator2.

### ConfigReader
Reads device/server/application configuration from `config.properties`.

### BaseTest
Handles driver setup and teardown for each test.

### CalculatorPage
Implements Page Object Model (POM). Calculator operations are exposed as reusable methods.

### CalculatorTests
Contains TestNG test cases and assertions.

### ScreenshotUtil
Captures screenshots when a test fails.

## GitHub

Create a repository and push:

```bash
git init
git add .
git commit -m "Initial mobile automation framework"
git branch -M main
git remote add origin <YOUR_GITHUB_REPOSITORY_URL>
git push -u origin main
```

## Notes on Calculator Variants

Android calculator UI, package names, activity names, button labels, and result resource IDs can vary across emulator images and Android versions.

The framework therefore uses text-based button lookup where practical. If a specific emulator uses different labels/resource IDs, update `CalculatorPage.java` and `config.properties`.

## Candidate Deliverables Checklist

- [x] Appium + Java + TestNG framework
- [x] Basic calculation
- [x] Multiple operations
- [x] Negative division-by-zero scenario
- [x] Clear functionality
- [x] POM architecture
- [x] Configuration management
- [x] TestNG suite
- [x] Maven execution
- [x] Failure screenshots
- [x] README/setup instructions
- [ ] GitHub repository URL — create using your GitHub account
- [ ] Execution report — generated after running tests
- [ ] Execution video — record emulator while tests execute
