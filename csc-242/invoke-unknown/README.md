# Assignment Tasks
# 🧠 Assignment: Reflective Smart Device Adapters

## 🔍 Overview

In this assignment, you'll work with a Smart Home system where all interactions with devices are handled **dynamically** using **reflection**. Your goal is to create **adapter classes** that implement interfaces like `SmartDevice`, `Powerable`, and `SecureDevice`, but operate on an instance of a class provided **only by name** at runtime.

You'll complete and test your code using the provided `CustomSmartDevice` class, which mixes standard and custom method names.

---

## 🎯 Objectives

- Practice using Java Reflection (`Class.forName`, `Method.invoke`)
- Learn how to decouple system logic using adapters
- Implement dynamic method invocation
- Handle runtime class and method resolution with flexibility and fallbacks

---

## 📦 Provided Code

You are provided with:

- `SmartDeviceAdapter.java`, `PowerableAdapter.java`, `SecureDeviceAdapter.java`  
  → These contain reflection stubs and TODOs.
- `CustomSmartDevice.java`  
  → A sample smart device implementation with a mix of standard and non-standard method names.
- `Main.java` (in `Adapter Test Main`)  
  → A working test driver that demonstrates how to use the adapters and set custom method names.

---

## 📝 Tasks

1. **Complete each adapter class** by using reflection to invoke the correct method:
   - If no `setXYZMethodName` is called, use the default method name from the interface.
   - Otherwise, use the custom name specified by the setter.
   - Handle any reflection exceptions gracefully with meaningful error messages.

2. **Methods to implement (reflectively)**:
   - `SmartDevice`: `getName()`, `setName(String name)`
   - `Powerable`: `turnOn()`, `turnOff()`, `isOn()`
   - `SecureDevice`: `operate()`

3. **Test your solution using the provided `Main.java`.**
   - Make sure it prints all expected messages from `CustomSmartDevice`.

---

## 🤓 Hints

- Use `clazz.getMethod(methodName, paramTypes...)` to retrieve method references.
- Use `method.invoke(instance, args...)` to execute.
- If you're calling a method with a `String` parameter, your parameter type array will look like: `new Class<?>[] { String.class }`.

---

## ✅ Example Output

```
[CustomSmartDevice] Name set to: Microwave
Name: Microwave
[CustomSmartDevice] Device is now ON
[CustomSmartDevice] Checking if device is on...
Power status: true
[CustomSmartDevice] Device has been turned OFF
[CustomSmartDevice] Security system engaged
```

---

## 🧪 Submission

Submit the following:
- Your completed `SmartDeviceAdapter`, `PowerableAdapter`, and `SecureDeviceAdapter`
- Your working `Main.java`
- Optional: Add your own device class and test it with different method names!

---

Let me know if you want this bundled into an HTML version for LMS or into a JSON `AssignmentSpec`.

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
docker build -t invoke-unknown .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace invoke-unknown
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace invoke-unknown
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: invoke-unknown
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named invoke-unknown.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the invoke-unknown directory.


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

