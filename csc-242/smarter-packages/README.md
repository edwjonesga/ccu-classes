# Assignment Tasks
# 📦  **Smarter Packages, Smarter Homes** 🧠🏡

## 🧠 What Are Java Packages?

In Java, **packages** are used to organize classes and interfaces into namespaces — much like folders on your computer. They help:

- Avoid name conflicts
- Group related classes
- Improve readability and maintainability

Each package maps to a folder structure in your file system. For example:

```java
package edu.ccu.students.jdoe22.smarthome.devices;
```

must be saved in:

```
edu/ccu/students/jdoe22/smarthome/devices/
```

---

## 📋 Your Instructions

You're working on the **Smarter Packages, Smarter Homes** project, and your task now is to:

1. **Organize your code using Java packages**.

2. Use the correct package prefix:\
   `edu.ccu.students.<your_username>.smarthome`

3. Break your classes into the appropriate sub-packages:

```
edu.ccu.students.<your_username>.smarthome
├── core           // Shared interfaces like SmartDevice, Powerable
├── controller     // Singleton HomeController
├── repository     // SmartHomeRepository and its Builder
├── factory        // SmartDeviceFactory
├── observer       // Event manager and observer interfaces
├── decorator      // Power usage tracking decorators
├── devices        // SmartLight, SmartLock, etc.
```

> ⚠️ The **directory structure must match** the package name exactly. This means your `.java` files need to be in the matching folder hierarchy.

For example, if you're working on `SmartLight.java`, it should begin with:

```java
package edu.ccu.students.jdoe22.smarthome.devices;
```

and be located in:

```
edu/ccu/students/jdoe22/smarthome/devices/SmartLight.java
```

---

## 🧪 What About Tests?

There are **no tests provided** for this portion of the assignment.

The **primary challenge** is getting your **project to compile successfully** with the correct package structure.
Once your code compiles, you can go back and update your existing test code (like `MainTest.java`) to reflect your new package layout.

---





## Downloading, Unzipping, and Running the Assignment
### Step 1: Download the assignment ZIP file from your course portal.
### Step 2: Unzip the file into a directory of your choice.
You can use the following command in the terminal to unzip the file:
```sh
unzip the-assignment.zip
```

### Step 3: Open a terminal (Command Prompt on Windows, Terminal on Mac/Linux) and navigate to the unzipped directory using the `cd` command.

### Step 4: Build the Docker image using the following command:
#### Windows only (Ensure Docker Desktop is running)
```sh
docker build -t smarter-packages .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace smarter-packages
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace smarter-packages
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: smarter-packages
```sh
refresh-assignment-files.sh
```

## Using the Installed Scripts
After running the Docker container, you will have access to three scripts that are included in the Docker image:

1. **compile.sh:** This script compiles all code including `Main.java` and `MainTest.java` files.
    ```sh
    compile.sh
    ```
    It will compile the source files and ensure that your code is ready for testing.

2. **run-tests.sh:** This script runs the JUnit tests in the `MainTest.java` file.
    ```sh
    run-tests.sh
    ```
    The results will be saved to a file named `test-results.txt`.

3. **prepare_to_submit.sh:** This script prepares your assignment for submission by running all tests and creating a ZIP file containing your work.
    ```sh
    prepare_to_submit.sh
    ```
    If all tests pass, it will create a file named `Assignment.zip` in the `/workspace` directory, ready for submission.

4. **update-docker.sh:** This script downloads a new Dockerfile to your workspace. This is sometimes necessary if updates are required.
    ```sh
    update-docker.sh
    ```
    You will need to exit, rebuild, and restart your Docker container after running this command.

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named smarter-packages.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the smarter-packages directory.


# Getting Started with Docker for Your Assignment
This assignment will guide you through creating a Docker-based environment. Follow the instructions below to set up Docker on your system and complete the tasks.

## Setting Up Docker
### Windows
1. Download Docker Desktop from [Docker’s official website](https://www.docker.com/products/docker-desktop/).
2. Run the installer and follow the prompts.
3. After installation, launch Docker Desktop and ensure it is running.

### Mac
1. Open Terminal.
2. Install Homebrew if it is not already installed by running the following command:
    ```sh
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    ```
3. Run the following command to install Docker using Homebrew:
    ```sh
    brew install --cask docker
    ```
4. Start Docker from the command line:
    ```sh
    open /Applications/Docker.app
    ```
5. Verify Docker installation by running:
    ```sh
    docker --version
    ```

### Linux
1. Open a terminal.
2. Run the following commands:
    ```sh
    sudo apt-get update
    sudo apt-get install docker.io
    ```
3. Verify Docker installation with:
    ```sh
    docker --version
    ```

