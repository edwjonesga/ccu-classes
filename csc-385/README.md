# CSC-385 Assignment Setup

Welcome to CSC-385! This guide will walk you through setting up your development environment using a two-stage Docker process.

## Stage 1: Initialization

This first stage will set up your GitHub repository and clone it to your local machine.

### Step 1: Download the Initial Dockerfile

First, you need to download the `Dockerfile` for the initialization process.

[Download the Dockerfile here](https://raw.githubusercontent.com/edwjonesga/edwjones-ccu/main/classes/csc-385/Dockerfile)

Save this file in a new, empty directory on your computer. Make sure the file is named `Dockerfile` with no extension.

### Step 2: Install Docker

Please follow the instructions below to install Docker on your operating system if you haven't already.

#### Windows
1. Download Docker Desktop from [Docker’s official website](https://www.docker.com/products/docker-desktop/).
2. Run the installer and follow the prompts.
3. After installation, launch Docker Desktop and ensure it is running.

#### Mac
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

#### Linux
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

### Step 3: Run the Initialization Script

This step will create your personal GitHub repository for this class and clone it to your machine.

1.  Open a terminal (Command Prompt on Windows, Terminal on Mac/Linux).
2.  Navigate to the directory where you saved the `Dockerfile`.
3.  Build the initializer Docker image:

    ```sh
    docker build -t csc-385-init-env .
    ```

4.  Run the initializer container, mounting your current directory into the container's `/workspace`:

    ```sh
    docker run -it --rm -v "$(pwd)":/workspace csc-385-init-env
    ```

5.  The container will run the `init.sh` script, which will guide you through the GitHub setup process. At the end, it will clone your new repository into the directory you are in and then exit.

## Stage 2: Development Environment

After the initialization is complete, you will have a new directory containing your assignment repository. You will use this for your development work.

1.  In your local terminal, change into your new repository directory. The name will be what you chose during the initialization script.
    ```sh
    cd <your-repo-name>
    ```

2.  Build your development Docker image using the provided script:
    ```sh
    ./buildContainer.sh
    ```

3.  Start your development container using the provided script:
    ```sh
    ./startContainer.sh
    ```

You will now be inside your development container, with all the necessary tools and your repository files mounted in the `/workspace` directory.

### Included Development Tools

Your development environment comes pre-installed with the following tools:

*   **Java Development Kit (OpenJDK 16):** The standard Java compiler (`javac`) and runtime (`java`).
*   **JUnit 5:** A widely-used testing framework for Java. You can run tests using the `run-tests.sh` script.
*   **JavaCC (Java Compiler Compiler):** A parser generator for Java.
*   **ASM:** A Java bytecode manipulation and analysis framework.

All necessary JAR files are included in the `CLASSPATH`, so you can use these tools directly.

### Available Helper Scripts

A set of scripts is available in the `/bin` directory of the container to help you with common tasks. Since `/bin` is in your `PATH`, you can run them from anywhere in the workspace.

*   `compile.sh`: Compiles all `.java` files found in the `src` and `test` directories of your current location.
*   `run-tests.sh`: Executes all JUnit tests in the current directory and saves the results to `test-results.txt`.
*   `run-all-tests.sh`: A powerful script that iterates through all assignment directories in your workspace, compiles the code, and runs the tests for each one.
*   `prepare_to_submit.sh`: Runs the tests and, if they pass, creates a `Assignment.zip` file ready for submission.
*   `refresh-assignment-files.sh`: Refreshes an assignment directory with the original files from the class repository.
*   `pull-updates.sh`: Fetches updates from the main class repository and merges them into your current branch. This is useful for getting updates from your instructor.
*   `update-docker.sh`: Downloads the latest version of the development `Dockerfile`. After running this, you will need to exit the container and run `./buildContainer.sh` again to apply the changes.

### Importing Existing Work

If you have already started working on an assignment on your local machine (outside of this Docker environment), you can easily import your work.

For example, let's say you have an assignment in a local directory named `~/projects/tokenizers-assemble` and your new repository from Stage 1 is at `~/csc385/my-csc385-repo`. The `tokenizers-assemble` assignment folder should already exist inside your repository.

1.  **Navigate to your repository on your local machine:**
    ```sh
    cd ~/csc385/my-csc385-repo
    ```
2.  **Copy your existing work into the corresponding assignment directory.** Make sure you copy the contents, not the folder itself.
    ```sh
    # Example for Linux/macOS
    cp -r ~/projects/tokenizers-assemble/* ./tokenizers-assemble/

    # Example for Windows (in PowerShell)
    Copy-Item -Recurse -Path ~/projects/tokenizers-assemble/* -Destination ./tokenizers-assemble/
    ```
3.  **Start the container** (`./startContainer.sh`) and your files will be there, ready to be compiled and tested.

If an assignment directory does not exist in your repository, you can use the `refresh-assignment-files.sh` script inside the container to download it first.

---

Happy coding!
