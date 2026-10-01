@echo off
:loop
set timeHrs=%time:~0,2%
set timeMin=%time:~3,2%


if "%timeHrs%"=="10" if "%timeMin%"=="35" (
    REM Call your backup batch file here
    call ".\Execute.bat"
)

if "%timeHrs%"=="17" if "%timeMin%"=="15" (
    call ".\Execute.bat"
)

timeout /t 60 >NUL
goto loop