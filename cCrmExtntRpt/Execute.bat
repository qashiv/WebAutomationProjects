@echo off
start chrome.exe --remote-debugging-port=1111 --user-data-dir="D:\AutomationProfile"

set ProjectPath=%~dp0
echo %ProjectPath%
CD /D %ProjectPath%
mvn test -DsuiteXmlFile=src\test\resources\testng_suites\web.xml