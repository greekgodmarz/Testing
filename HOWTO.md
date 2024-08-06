# 1. Useful Commands

The Windows Git SCM installation also installs a tool named "Git Bash".
Git Bash offers a variety of Linux tools on Windows that are very useful for software development, testing, deployment, configuration and many other tasks.

## 1.1 Git

### 1.1.1 Cloning A Repo
Cloning a repository to the local file system:
```
git clone git@github.com:greekgodmarz/Testing.git [directory]
```
Here "directory" is optional. If provided the git command will clone the remote repository into this directory. Otherwise it will clone into a directory with the same name as the repository.

### 1.1.2 Handling Branches
Usually the **main** branch is used for working versions of your app(s) that is well tested and functional.  
For development and hence potentially unstable versions of your app the **devel** branch (sometimes also trunk) is used.

To see what branches are available use 
```
git branch -a
```
It will show what branches are available and what branch is active, meaning what branch are you currently working on.

To create a branch use
```
git branch devel
```

To switch to the new branch use
```
git checkout devel
```

To push this new branch to the remote repository use 
```
git push
```

If you push this new branch the very first time Git may want to know where to push it. In this case Git gives you a hint in its response how the address the upstream to your remote repository that you want to use.
In this case just type the command Git suggested to you. After doing this once your new branch is on the remote repository and you don't need to do this again.

 
