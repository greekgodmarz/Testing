# Installations
## OpenJDK
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


