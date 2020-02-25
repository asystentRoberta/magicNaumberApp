Status after last push (github actions):

[![Actions Status](https://github.com/asystentRoberta/magicNaumberApp/workflows/gradleBuildTest/badge.svg)](https://github.com/asystentRoberta/magicNumberApp/actions)

## Magic numbers

----

### Console application. 

The application checks the correctness of the file extension. 
At the moment it supports:
* txt files
* jpg files 
* gif files 

If you want to use the application, follow these steps:

```batch
git clone https://github.com/asystentRoberta/magicNumberApp
cd magicNumberApp
./build gradle

cd build/libs
```
and then execute:
```batch
java -jar magicNumberApp-0.1.jar fileToTest
```
where  _**fileToTest**_  is the file you want to test (file has to be in _/build/libs/_  folder) or path to file (for
 example _/home/user/text.txt_  or _C:\Users\\%USERNAME%\Documents\text.txt_)
 
 
 ---
 
 ### Update-1 New functionality:
 You can use "magic" argument "sourceFolder" when you call magicNumberApp.
 Then my application scan folder _files_ **(it has to exist)** in _/src/main/resources_ and print info about each
  file in this folder.
  
  Just copy files to test int _src/main/resources/files/_ and then:
  
```batch
java -jar magicNumberApp-0.1.jar sourceFolder
```

It is a result of using "magic" switch argument:

```batch
java -jar appName.jar sourceFolder

Ok - lets see at a.txt :
First six bytes of this file:
61 62 63 64 65 66 
Extension is txt, while actually it's a txt.
==============
Ok - lets see at gif.txt :
First six bytes of this file:
47 49 46 38 39 61 
Extension is txt, while actually it's a gif.
==============
Ok - lets see at jpg.txt :
First six bytes of this file:
ff d8 ff e0 00 10 
Extension is txt, while actually it's a jpg.
==============
Ok - lets see at notText.txt :
First six bytes of this file:
ff d8 ff e0 00 10 
Extension is txt, while actually it's a jpg.
==============
Ok - lets see at test.gif :
First six bytes of this file:
47 49 46 38 39 61 
Extension is gif, while actually it's a gif.
```  
 
 
 #### This is a test of my skills. I only have two hours to write the program..
 
 **_The clock has started ticking..._**
 
 and it ticking fast.
 
  <img src="http://bohdziewicz.com.pl/images_share/tickingClock.gif" width="100" height="100" />

#### Update-2 info: 
I have 15 minutes left - not enough to write the tests...