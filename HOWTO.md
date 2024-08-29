# 1. Useful Commands
 
The Windows Git SCM installation also installs a tool named "Git Bash".
Git Bash offers a variety of Linux tools on Windows that are very useful for software development, testing, deployment, configuration and many other tasks.

## 1.1 Git
For all the commands below you need to open the Git Bash application. It provides you with a resizable text console and plenty of tools.

### 1.1.1 Cloning A Repo
This implies that there's alread a remote repository that you can clone.
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


### 1.1.3 Checking Out A Repository
For this you need the remote URL. On Github it's shown when pressing the code button of a repository.  
Use the SSH URL. For this you must have an SSH key deployed in your Github account. See [INSTALLATIONS.md](INSTALLATIONS.md) for more information on this topic.
Assuming the URL is "git@github.com:greekgodmarz/Testing.git", type
```
git clone git@github.com:greekgodmarz/Testing.git
```
Now Git should clone this remote repository locally into the directory Testing.
If you want to clone it at a different location or under a different name then change into the desired directory first or type the name of the desired local directory, for instance:
```
git clone git@github.com:greekgodmarz/Testing.git first_test
```

Now change the working directory to the cloned directory and check what branch you're on and maybe switch to the branch you want to work with:
```
cd first_test
git branch -a
git checkout devel
```
In case that the *devel* branch doesn't exist yet you'll get an error message. You can create that branch as described before.

### 1.1.4 Checking In Files
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

The whole process may look like this [example]:
```
repos/Testing> git status
On branch main
Your branch is up to date with 'origin/main'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   HOWTO.md

no changes added to commit (use "git add" and/or "git commit -a")
repos/Testing> git add HOWTO.md 
repos/Testing> git commit -m "git push added to the HOWTO's"
[main ae79072] git push added to the HOWTO's
 1 file changed, 33 insertions(+)
repos/Testing> git push
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 16 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 986 bytes | 986.00 KiB/s, done.
Total 3 (delta 1), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
To github.com:greekgodmarz/Testing.git
   6c587ce..ae79072  main -> main
```


