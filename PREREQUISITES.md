# 1. Needed application for development and collaboration
The following apps must be installed for the following purposes:

## 1.1 GIT (source code revision system, collaboration)
Git is needed to store and version all project files.  
To work with Git the git binaries to work with Git repositories must be installed.  
The Windows versions are availabe for download [here](https://git-scm.com/download/win)

## 1.2 OpenJDK (Java Development Kit)
This is needed to develop application in the Java programming language.

## 1.3 Netbeans IDE (Integrated Development Environment)
This is an OSS (Open Source Software) IDE.  
Just like other IDE's (IntelliJ/IDEA, VSCode, Android Studio...) it makes software development a lot easier.  
Netbeans is a pretty straight forward and easy-to-handle IDE. It may not offer the latest features or a plugin market place like IntelliJ/IDEA for instance, but it also has less quirks.

## 1.4 Build system (Maven, Gradle)
This is needed to run the toolchain building libraries and apps or also to run tests.
Mostly these build system are already integrated in IDE's like Netbeans, IntelliJ/IDEA, and others and mostly also available as command line tools.

## 1.5 Docker, Docker-Compose
This is a container system that allows deployment without the need of an installation of app on the host system. It also allows to run multiple instances. This is perfect for testing, deployment and also handling of network configuration.
