# APK build helper

From the Lizt application source repository:

```cmd
npm install
cd android
gradlew assembleDebug
```

APK:

```text
android\app\build\outputs\apk\debug\app-debug.apk
```

The automation project should receive that APK with `-Dapp="..."`.
