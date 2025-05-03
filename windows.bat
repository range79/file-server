@echo off
chcp 65001 >nul
title 📁 File Upload Server - Windows Starter
echo ===============================
echo  📦 Checking for Java...
echo ===============================
timeout /t 2 >nul

java -version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ❌ Java is not installed or not in PATH.
    echo 🔗 Please install Java 17+ from:
    echo     https://adoptium.net/
    pause
    exit /b 1
)

echo ✅ Java found!
timeout /t 1 >nul

:: Find the JAR
for /f "delims=" %%f in ('dir /b /s "build\libs\*.jar" 2^>nul') do (
    set "JAR_PATH=%%f"
    goto :runjar
)

echo ❌ No JAR file found in build\libs\ directory!
pause
exit /b 1

:runjar
echo 🚀 Launching: %JAR_PATH%
timeout /t 2 >nul
java -jar "%JAR_PATH%"
pause
