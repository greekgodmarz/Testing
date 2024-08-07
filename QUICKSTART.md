# QUICKSTART

## 1. Clone the project
```
git clone git@github.com:greekgodmarz/Testing.git
cd Testing
```
Leave the console window open for later...

# 2. Open NetBeans IDE
Open the NetBeans IDE and then open the cloned project in 
```
Testing/demos/maven/java_lang
```

# 3. Run the demos
In Netbeans open the folder in 
```
Source Packages
com.marz.lang
```
right-click on Basics.java and select Run File"

# 4. Add a devel branch
A different branch as devel helps to work on sources while leaving your main branch untouched and the sources there intact.
Execute the following statements in the window you left open (from 1. Clone the project)
```
git branch devel
git checkout devel
git merge main
git push
```
These commands
- creates a branch named devel
- you're switching to this branch
- you're merging everything from the main branch into the new devel branch
- you're pushing it back to Github.
The last command will tell you that it doesn't know yet to what origin and suggest a slightly different push command. Execute this one then instead.

