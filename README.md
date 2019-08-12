Getting Started
===============

* Install JDK 1.8 and set up with environment variable 
* Set up Maven 3 and set up with environment variable
* Download latest (Tested with chrome 2.29. Safari. Firefox- Gecodriver
  fail for some reason) drivers to below path
  ${project.base.dir}\src\test\resources\config\drivers_exe

 
 1. We no need to download safaridriver as it available at "/usr/bin/safaridriver"
 2. chromedriver.exe
 3. geckodriver.exe

How Run Tests
=============
Unzip the file and do a ``` mvn clean install -DSkipTests``` to
download/update all the dependencies

How Run Tests
=============
Tests can be run with Maven or with Intellij

  
  1.Run tests with intellij
  ---------------
The IntelliJ Cucumber Java runner works better than its JUnit runner for running Gherkin features.
We can jump between the test runner pane and the Gherkin definitions & can run individual scenarios
rather the entire feature file.

To set this up, open the Edit Run Configurations dialog.

Add the following to the defaults for **Cucumber** Java tests:

    a. Main Class: cucumber.api.cli.Main b. Glue: cucumber.api.spring
com.disc


Now We can run feature file or just a scenario from the right-button
popup menu.

2.Run tests with maven ( THIS IS CURRENTLY THROWING ERROR AND HAS TO BE FIXED)
---------------
 Go to project directory where pom.xml located, open command prompt
 
 a. Then run below maven command (This is default command and kicks off Chromedriver)
 ```
 mvn clean install
 ```
 b. 2 tests fail and marked as bugs. To exclude those test and get 100% success, use
```
 mvn clean test -Dcucumber.options="--tags @hotelbooking --tags ~@bug"
```


 To Run with safari
 ```
  mvn clean install -Dbrowser.name=safari
  ```

Run with Firefox
 ```
  mvn clean install -Dbrowser.name=firefox
  ```
  
Run with Internet explorer
  ```
   mvn clean install -Dbrowser.name=ie
   ```

Bugs found while testing
==================
1.  Intermittent issue - When the player starts playing, both play and
    pause buttons are overlapped and hence sikuli struggles to identify
    the pattern.
2.  Cookie Violation - After signin, go to player page, watch video, go
    to homepage, signout. Go to the player page and the user is still
    signed in and unable to sign out after many tries
3.   'Champions league' link under suggested Favourites is broken.
     Acutal URL is :
     https://video.eurosport.co.uk/football/champions-league/sport-event.shtml
     Expected URL is : https://video.eurosport.co.uk/football/champions-league/
4.  Tennis video has got page title & item title starting with
        Football : https://video.eurosport.co.uk/tennis/football-video-rafael-nadal-i-played-a-great-final_vid1228913/video.shtml
        
