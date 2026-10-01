# Test Report

## Execution status

**Automation framework:** Appium + Java + Selenium APIs + TestNG  
**Platform:** Android / UiAutomator2  
**Application package:** `com.indexceed.lizt`

### Initial delivery status

The automation suite was created against the supplied Lizt source repository. An Android emulator is required to produce genuine passed/failed execution counts; therefore this repository does **not** claim fabricated results.

Run the suite with:

```bash
mvn clean test -Dapp="C:\path\to\lizt-app\android\app\build\outputs\apk\debug\app-debug.apk" -DdeviceName=emulator-5554
```

The actual HTML report is generated at:

```text
reports/extent-report.html
```

Screenshots for failed tests are generated under:

```text
screenshots/
```

### Expected/known skipped coverage

- TC20 is intentionally disabled because the current application does not expose item editing. See `bug-report.md`.
