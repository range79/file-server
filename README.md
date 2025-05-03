# 📁 Kotlin File Upload Server (Android + Desktop Compatible)

This is a lightweight **file upload server** built with **Kotlin** and **Spring Boot**, designed to run on Linux, Windows, and Android devices via [Termux](https://f-droid.org/packages/com.termux/). It's a simple yet practical project for uploading, downloading, and managing files from a minimal web interface — entirely offline and portable.

---

## 🚀 Features

- 📤 Upload files
- 📥 Download files by ID
- 🗑️ Delete individual or all files
- 🌐 Responsive web UI (Thymeleaf + Bootstrap)
- 📱 Runs on Android (via Termux)
- 🪟 Compatible with Windows, macOS, and Linux
- 💾 Embedded H2 database (no external setup)
- ⚙️ Auto-launch scripts for Android and Windows

---

## ⚙️ Tech Stack

- Kotlin (JVM 17+)
- Spring Boot 3.4.5
- Spring Web + Spring Data JPA
- H2 Database
- Thymeleaf (for UI)
- JUnit 5 + Kotlin Test
- Gradle (Kotlin DSL)
- SLF4J (Logging)

---

## 🖼️ Screenshot

![screenshot](images/project.png)

---

## 📦 Java Requirement

> **Java 21+ is required** to run this application on any platform.

Check your installed version:
```bash
java -version
```
If it’s below 21, install it from:
👉 https://adoptium.net/en-GB/temurin/releases/?version=21

---

## 📱 Android Setup (via Termux)

1. Install Termux from [F-Droid](https://f-droid.org/packages/com.termux/)
2. Install Git and clone the project:
   ```bash
   pkg install git
   git clone https://github.com/range79/file-server.git
   cd file-server
   ```
3. Run the setup script:
   ```bash
   chmod +x android.sh
   ./android.sh
   ```
4. Access from your browser:
   ```
   http://localhost:8080
   ```

💡 `android.sh` can also be used on **Linux/macOS/Windows (via WSL)** if Java is installed.

---

## 🪟 Windows Setup

1. Open CMD or PowerShell
2. Run the Gradle-based launcher:
   ```bash
   windows-gradle.bat
   ```

> If it doesn’t work, feel free to **fork and improve the script** — contributions are welcome!

---

## 🧪 Running Tests

```bash
./gradlew test
```

---

## 🛠️ Building the Project

```bash
./gradlew build
```

The final JAR will be located at:
```
build/libs/FIle-Upload-1.0.0-STABLE.jar
```

---

## 🧾 Project Structure

```
.
├── android.sh            # Auto-setup for Termux/Android/Linux
├── windows-gradle.bat    # Windows launcher (Gradle based)
├── build.gradle.kts      # Gradle config (Kotlin DSL)
├── src/                  # Source code
├── build/libs/           # JAR file lives here
├── images/               # Screenshots/assets
└── README.md
```

---

## 📜 License

MIT — use freely, improve openly.

---

## 🙋‍♂️ Author & Contact

Built with love and Kotlin by **range79**.

📧 Contact: [darkrange006@gmail.com](mailto:darkrange006@gmail.com)  
🌐 GitHub: [github.com/range79](https://github.com/range79)

> ⭐ Star the repo if you find it useful!