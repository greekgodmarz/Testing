# Installations
## 1. OpenJDK
Go to the [OpenJDK](http://jdk.java.net/22), download the Windows JDK and unpack the archive to
```
C:\Program Files (x86)\
```

Then open **System Properties => Advanced => Environment Variables**.
Look for the Path variable under **System variables**.  
**DO NOT CHANGE ITS VALUES! ONLY APPEND THE PATH TO YOUR JDK's bin directory**, e.g.
```
Path=...previous values...**;C:\Program Files (x86)\jdk-21.0.3+9\bin**
```

After that add a User environment variable named JAVA_HOME:
```
JAVA_HOME=C:\Program Files (x86)\jdk-21.0.3+9
```

After this open/execute cmd.exe and enter **java -version**  
You should get a message like
```
openjdk version "21.0.3" 2024-04-16 LTS
OpenJDK Runtime Environment Microsoft-9388422 (build 21.0.3+9-LTS)
OpenJDK 64-Bit Server VM Microsoft-9388422 (build 21.0.3+9-LTS, mixed mode, sharing)
```

## 2. IDE
Pick the IDE of your choice (here Netbeans).

### 2.1 Netbeans IDE
Download the [Netbeans IDE](https://apache.org/dyn/closer.lua/netbeans/22/netbeans-22-bin.zip)
Unpack the archive to
```
C:\Program Files (x86)\
```
Drag netbeans64.exe from the netbeans/bin folder to your desktop.
Start Netbeans. If Netbeans complains about a missing JDK open the netbeans.conf file from your netbeans/etc directory in a text editor (e.g. Notepad++). Go to the end of the file and add a new line:
```
netbeans_jdkhome="C:\Program Files (x86)\jdk-21.0.3+9"
```
Important: **DO NOT CHANGE ANY OTHER LINES**
After this Netbeans should find the JDK and start.

## 3. Git SCM
This is needed to organize and versioning code and helps to collaborate on projects.  
Download the standalone versions for your system [here](https://git-scm.com/download/win) and execute the installation binary (e.g. Git-2.46.0-64-bit.exe)
Watch out that you pick your preferred editor (e.g. Notepad, Wordpad, Notpad++, whatever ...)
Here are some recommendations for the setup process:
- Select Components: **Additional icons - On the Desktop**
- Select Start Menu Folder: **Git**
- Editor: **notepad.exe**
- Adjusting the name of the initial branch in new repositories: **Override the default branch name for new repositories ==> main**
- Adjusting your PATH environment: **GIT from the commandline and also from 3rd-party software (recommended)**
- Choosing HTTP transport backend: **Use the OpenSSL library**
- Configuring the line ending conversions: **Checkout Windows-style, commit Unix-style line endings**
- Configuring the terminal emulator to use with Git Bash: **Use MinTTY (the default terminal of MSYS2)**
- Chose the default behavior of 'git pull': **Fast-forward or merge**
- Chose the credential helper: **None**
- Configuring extra options: **Enable file system caching**
- Configuring experimental options: **none**

**Setup Github SSH key**  
Start the Git Bash that was installed with the Git SCM. Then run this command with your email address to generate an SSH key:
```
ssh-keygen.exe -t ed25519 -C "your_email@domain.tld"
```
The output may look somehow like this:

***
