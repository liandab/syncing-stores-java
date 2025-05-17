# Syncing Stores Java Setup Guide

This document provides a guide to setting up the "syncing-stores-java" application.

## Installations

### 1. Install OpenJDK 17

   First, update the system's package list:

   ```bash
   sudo apt update
```

Then, install OpenJDK 17:
```
sudo apt install -y openjdk-17-jdk
```

2. Verify Java Installation
Check the installed Java version:
```
java -version
```

If multiple Java versions are installed, configure the default:
```
sudo update-alternatives --config java
```

3. Set Environment Variables
To make the Java environment variables persistent, add the following lines to your ~/.bashrc or ~/.zshrc file:
```
echo "export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64" >> ~/.bashrc
echo "export PATH=$JAVA_HOME/bin:$PATH" >> ~/.bashrc
```

Apply the changes by sourcing the configuration file:
```
source ~/.bashrc
```

4. Verify Gradle Configuration
Verify that Gradle is correctly configured and can detect the Java installation:
```
./gradlew -version
```

Running the Application
1. Enable Continuous Build
For development, use continuous build with bootRun:
```
./gradlew bootRun --continuous
```

or single build and single run

2. Build the Application
To build the application:
```
./gradlew build
```

3. Run the Application
To run the built application:
```
./gradlew bootRun
```

