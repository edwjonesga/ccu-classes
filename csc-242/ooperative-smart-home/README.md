# Assignment Tasks
# The OOPerative Smart Home

## Objective
In this assignment, you will implement a **Smart Home Automation System** that follows **Object-Oriented Programming (OOP) principles**. You will design a **HomeController** class that manages various smart devices, ensuring encapsulation, abstraction, inheritance, and polymorphism are correctly applied.

## Requirements
### **1. HomeController Class**
- Create a `HomeController` class.
- It **must** have a **no-argument constructor**.
- It **must** contain a method `getSmartDeviceTypes()` that returns a **list of classes** implementing the `SmartDevice` interface.

### **2. SmartDevice Interface & Device Types**
- Define a `SmartDevice` interface that all smart devices must implement.
- Implement at least **three smart device types**:
  - **Smart Light** (Class name must contain "Light")
  - **Smart Lock** (Class name must contain "Lock")
  - **Security Device**

### **3. Device Methods**
- Each device must implement the following methods:
  - `turnOn()` - Turns the device on.
  - `turnOff()` - Turns the device off.
  - `isOn()` - Returns whether the device is on or off.
  - `getName()` - Returns the name of the device.
  - **Security Devices Only:** `operate()` - Executes security-specific functionality.

### **4. HomeController Methods for Devices**
For **each device type** returned in `getSmartDeviceTypes()`, `HomeController` must provide:
- `getXyzList()` - Returns a **list** of all instances of `Xyz` devices.
- `getXyz(String name)` - Returns a **single instance** of `Xyz` device based on its name.

### **5. Main Class Implementation**
Implement a `Main.java` class that includes methods:
- `getHomeControllerType()` - Returns the `HomeController` class.
- `getSmartDeviceType()`, `getSmartLightType()`, `getSmartLockType()`, `getSecurityDeviceType()` - Returns the respective class types.

## Evaluation Criteria
Your implementation will be validated using **JUnit tests** to ensure compliance with the requirements.
- ✅ **HomeController Structure** (20%)
- ✅ **Correct Implementation of SmartDevice and Inheritance** (30%)
- ✅ **Polymorphism & Encapsulation in Device Methods** (20%)
- ✅ **Correct Functionality of HomeController Methods** (20%)
- ✅ **Code Readability & Documentation** (10%)

## Submission Instructions
- Submit your `HomeController.java`, `SmartDevice.java`, all device classes, and `Main.java`.
- Ensure that your code **compiles** and passes all provided unit tests.

---
### 🚀 **Bonus Challenge**
Extend your system to include a `SmartThermostat` that implements additional behavior such as adjusting temperature settings.

Good luck! 🎯


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
docker build -t ooperative-smart-home .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace ooperative-smart-home
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace ooperative-smart-home
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: ooperative-smart-home
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named ooperative-smart-home.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the ooperative-smart-home directory.


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

