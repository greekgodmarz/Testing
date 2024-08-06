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

### 1.1.3 Checking In Files
If you do changes to your files you may want to verioning them.

The first step is to figure out what changes were made:
```
git status
```
will tell you what files have changed, which are new and which are deleted.
If files are already "staged" for a commit Git will show them in green. These ones will be commit. All red files are not yet staged.For instance, it could be you wanted to delete a file and you already did it locally. This file will be shown red.
To add it to the commit (stage) you run
```
git add MY_DELETED_FILE
```
If you now type 
```
git status
```
it should show up in green, meaning it's ready to be committed.
Now you can commit it, adding a comment why you made such changes as well:
```
git commit -m "deleted the file, it's no longer needed"
```
If you now check again with 
```
git status
```
the files should have disappeared. This means that the commited changes are not in your local git repository.
If you want the changes also remotely, on the Github server for instance, you need to push the changes in your local repository:
```
git push
````
Not Git will inform you about the changes pushed to the remote server.

 
