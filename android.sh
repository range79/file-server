#!/data/data/com.termux/files/usr/bin/bash

echo "📦 Checking for Java installation..."
sleep 3
# Check if Java is installed
if command -v java &> /dev/null; then
    echo "✅ Java is already installed: $(java -version 2>&1 | head -n 1)"
  sleep 2
else
    echo "☕ Java not found. Installing..."
sleep 2
    pkg update && pkg upgrade -y
    pkg install openjdk -y

    if command -v java &> /dev/null; then
        echo "✅ Java successfully installed: $(java -version 2>&1 | head -n 1)"
    else
        echo "❌ Java installation failed."
        exit 1
    fi
fi

# Look for a JAR file in build/libs/
JAR_FILE=$(find ./build/libs -name "*.jar" | head -n 1)

if [ -f "$JAR_FILE" ]; then
    echo "🚀 Launching: $JAR_FILE"
    sleep 2
    java -jar "$JAR_FILE"
else
    echo "❌ No .jar file found in build/libs/"
fi
