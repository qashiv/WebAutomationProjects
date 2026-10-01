@echo off
setlocal
if "%APP_PATH%"=="" set APP_PATH=..\lizt-app\android\app\build\outputs\apk\debug\app-debug.apk
if "%DEVICE_NAME%"=="" set DEVICE_NAME=emulator-5554
call mvn clean test -Dapp="%APP_PATH%" -DdeviceName="%DEVICE_NAME%"
endlocal
