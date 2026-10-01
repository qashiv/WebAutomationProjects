# Lizt Appium Mobile Automation Assessment

Automation project for the supplied `rodrigo2392/lizt-app` Android application.

## Stack

- Java 17
- Appium 2/3 server
- Appium Java Client 9.4.0
- Selenium Java 4.27.0 APIs
- TestNG 7.10.2
- Maven
- ExtentReports 5.1.2
- Android UiAutomator2

The Appium Java client is built on Selenium, so Selenium `WebDriver`, `WebElement`, `By`-style locators, and `WebDriverWait` are used directly in the framework.

## Application under test

- Package: `com.indexceed.lizt`
- Main activity: `.MainActivity`
- Source framework: React Native 0.79.2
- Source language: TypeScript

## Framework design

```text
src/test/java/com/lizt/automation/
├── base/
│   └── BaseTest.java
├── pages/
│   ├── BasePage.java
│   ├── HomePage.java
│   ├── AddListPage.java
│   └── DetailsPage.java
├── tests/
│   └── LiztMobileTests.java
└── utils/
    ├── Config.java
    ├── ScreenshotUtil.java
    └── TestListener.java
```

## Prerequisites

1. JDK 17.
2. Node.js/npm for Appium.
3. Android Studio with Android SDK and Platform-Tools.
4. An Android emulator (or USB-debugging-enabled device).
5. Maven.

Appium's Android UiAutomator2 documentation requires the Android SDK/platform-tools, `ANDROID_HOME`/`ANDROID_SDK_ROOT`, Java JDK, and an emulator/device visible through `adb devices`.

## Install Appium

```bash
npm install -g appium
appium driver install uiautomator2
appium driver doctor uiautomator2
```

Start the server:

```bash
appium
```

Default server URL used by this project:

```text
http://127.0.0.1:4723
```

Verify the emulator:

```bash
adb devices
```

## APK location

The supplied ZIP does **not** contain a prebuilt APK.

For a debug build, the expected output is:

```text
lizt-app\android\app\build\outputs\apk\debug\app-debug.apk
```

For a release build, the expected output is:

```text
lizt-app\android\app\build\outputs\apk\release\app-release.apk
```

The source project's release task is `gradlew assembleRelease`. Its current release signing configuration references a keystore that is not present in the supplied source archive, so use the debug APK for this assessment unless the release keystore is supplied.

### Current Gradle download issue

The supplied app's Gradle wrapper uses Gradle 8.10.2. If the wrapper cannot download it, first obtain Gradle successfully or use Android Studio/Gradle's normal wrapper cache. Do not substitute an unrelated Gradle version.

## Build debug APK

From the Lizt application repository:

```cmd
cd C:\path\to\lizt-app
npm install
cd android
gradlew assembleDebug
```

Expected APK:

```text
android\app\build\outputs\apk\debug\app-debug.apk
```

Install manually if desired:

```cmd
adb install -r android\app\build\outputs\apk\debug\app-debug.apk
```

## Run automation

From this automation project:

```cmd
mvn clean test -Dapp="C:\path\to\lizt-app\android\app\build\outputs\apk\debug\app-debug.apk" -DdeviceName=emulator-5554
```

If your emulator name is different:

```cmd
adb devices
```

then pass that value with `-DdeviceName`.

The default relative path in `src/test/resources/config.properties` assumes this project is located beside the Lizt source repository. Override it with `-Dapp=...` whenever needed.

## Reports

After execution:

```text
reports/extent-report.html
```

Failed-test screenshots:

```text
screenshots/
```

Surefire results:

```text
target/surefire-reports/
```

## Assessment deliverables

- `test-cases.md` – 20 test cases and coverage mapping.
- `src/test/java/...` – Appium/Selenium Java automation source.
- `test-report.md` – execution instructions and reporting approach.
- `bug-report.md` – reproducible product bug.
- `README.md` – setup/run instructions.
- `reflection.md` – short QA reflection.

## Important product gap

The current Lizt UI has no edit action for an existing item. The requested item-edit scenario is therefore documented as BUG-001 and TC20 is intentionally skipped. The automation does not claim functionality that the product does not expose.
