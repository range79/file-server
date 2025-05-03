#!/data/data/com.termux/files/usr/bin/bash

echo "📦 Checking for Java & Gradle..."
sleep 2

if command -v java &> /dev/null; then
    echo "✅ Java installed: $(java -version 2>&1 | head -n 1)"
else
    echo "☕ Installing Java..."
    pkg update && pkg upgrade -y
    pkg install openjdk -y
fi

if command -v ./gradlew &> /dev/null; then
    echo "✅ Gradle wrapper found."
else
    echo "❌ Gradle wrapper not found. Make sure 'gradlew' exists and is executable."
    exit 1
fi

echo "🚀 Running Spring Boot application with bootRun..."
sleep 2
chmod +x ./gradlew
./gradlew bootRun
