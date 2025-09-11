# CSC-242 Assignment Setup

Welcome to CSC-242! This guide will walk you through setting up your development environment using a two-stage Docker process.

## Stage 1: Initialization

This first stage will set up your GitHub repository and clone it to your local machine.

### Step 1: Download the Initial Dockerfile

First, you need to download the `Dockerfile` for the initialization process.

[Download the Dockerfile here](https://raw.githubusercontent.com/edwjonesga/ccu-classes/main/csc-242/Dockerfile)

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
    docker build -t csc-242-init-env .
    ```

4.  Run the initializer container, mounting your current directory into the container's `/workspace`:
    - **For Linux and Mac:**
      ```sh
      docker run -it --rm -v "$(pwd)":/workspace csc-242-init-env
      ```
    - **For Windows (using PowerShell):**
      ```sh
      docker run -it --rm -v "${PWD}:/workspace" csc-242-init-env
      ```
    - **For Windows (using Command Prompt):**
      ```sh
      docker run -it --rm -v "%cd%":/workspace csc-242-init-env
      ```
    > **Note for Linux Users:** You may need to run this command with `sudo`.

5.  You will now be inside the initializer container. To begin the setup process, run the initialization script:
    ```sh
    ./init.sh
    ```
6.  The script will guide you through the GitHub setup process. At the end, it will clone your new repository into the directory you are in.
7.  Once the script is finished, the container may not exit automatically. If you are still inside the container, simply type `exit` and press Enter.

**Important Note for Linux/Chromebook Users:**

After exiting the container, the new project files will be owned by the `root` user. You must fix the file ownership by running the following command from your terminal, in the same directory where you ran the `docker` commands:
```sh
sudo chown $USER:$USER -R .
```

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
    > **Note for Windows Users:** `/startContainer.sh` will not work so instead copy the same `docker run` command from step 4

You will now be inside your development container, with all the necessary tools and your repository files mounted in the `/workspace` directory. Happy coding!

## Keeping Your Repository Up-to-Date

Your instructor may push updates to the class repository from time to time. To get these updates into your own repository, you can use the `pull-updates.sh` script.

From within your development container, simply run:
```sh
pull-updates.sh
```
This will pull the latest changes from the class repository. If there are any changes to the `Dockerfile`, you will need to rebuild and restart your development container by running `./buildContainer.sh` and then `./startContainer.sh` again.
