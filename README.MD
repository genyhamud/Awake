# Awake #

:sleeping: Awake is a alternative to Caffeine or NoSleep to prevent your PC from sleeping.

[![Apache License](http://img.shields.io/badge/license-ASL-blue.svg)](https://github.com/genyherrera/Awake/blob/master/LICENSE)
[![Build Status](https://travis-ci.org/genyherrera/Awake.svg)](https://travis-ci.org/genyherrera/Awake)

![Screenshots](scr1.png)

## Why I should use Awake? ##

Since I started using Caffeine on Windows, which by the way is not nearly as good as the Mac version, I noticed some strange characters appears when I was at command line.

At first didn't care to much, but if you have to work remotely in a mobile connection and is typing at command line (with delay) and suddenly you realize that in the middle of your typing shows a lot of "~ 8", that's exaclty what Caffeine does.

Every 30 seconds, it simulates the action of the F15 key. As there is no keyboard with this specific key they believe that the SO didn't care about it, but Windows translates the command of the F15 key to "~ 8".

Other software that I used was NoSleep. To keep your machine up NoSleep simulate the mouse movement 1 px to left and then 1 px to right.
Maybe you don't care about your mouse been moving, but if you are drawing something, you will notice for sure.

## Running ##

### Method 1: ###
Download the file [Awake-1.0-SNAPSHOT.jar](https://github.com/genyherrera/Awake/blob/master/Awake-1.0-SNAPSHOT.jar) and run on terminal: 

````
java -jar Awake-1.0-SNAPSHOT.jar
````

### Method 2: ###
Download the file [Awake-1.0-SNAPSHOT.jar](https://github.com/genyherrera/Awake/blob/master/Awake-1.0-SNAPSHOT.jar) and copy to your Startup folder, usually in: 

````
C:\Users\[user]\AppData\Roaming\Microsoft\Windows\Start Menu\Programs.
````

This will make the application available every time that you turn your computer on. 

## Copyright and License ##

Copyright 2016 Geny Isam Hamud Herrera (geny.herrera@gmail.com)

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
