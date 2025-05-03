@echo off
chcp 65001 >nul
title 🚀 File Server - Gradle BootRun

echo ===============================
echo  📦 Checking for Java...
echo ===============================
timeout /t 1 >nul

java -version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ❌ Java is not installed or not in PATH.
    echo 🔗 Please install Java 17+ from:
    echo     https://adoptium.net/
    pause
    exit /b 1
)

echo ✅ Java found!

echo ===============================
echo  🛠️  Starting server via Gradle...
echo ===============================
timeout /t 1 >nul

if exist gradlew (
    call gradlew bootRun
) else (
    echo ❌ gradlew not found. Make sure you're in the project root.
    pause
    exit /b 1
)

pause
