# CO3326 Computer security assignment

This description contains the requirements for the _code submission_, to be read in conjunction with the actual assignment with which you are already familiar. You must follow these instructions carefully, as your code submission will be processed automatically and will receive a mark of 0 if it does not pass all the test cases detailed below.

Make sure you study and understand the examples of inputs and outputs which follow the general and technical guidelines. These extend on the descriptions given in the original coursework assignment document.

## General guidelines

* You will submit a _single JAR file_ for each coursework following a _specific naming scheme_.
* Your code must compile and run against _Java 8_.
* The entry point in your code will have a main method, which receives one command-line argument, the absolute path to an _input file_. 
* Your programme will read the input file and treats each line as a separate _test case_ / separate instance of the problem. 
* Each line in the test file is a JSON object.
* Your programme will print a single line of text, containing one JSON object, for every single input line. Therefore the number of input lines will match the number of output lines.
* The JSON objects, both input and output, have a _strict format_ you __must__ conform to; details are provided below, with examples.

## Prerequisites

* Make sure you have _Java 8 Development Kit_ installed. 

```
    $ java -version
```

```
    java version "1.8.0_66"
    Java(TM) SE Runtime Environment (build 1.8.0_66-b17)
    Java HotSpot(TM) 64-Bit Server VM (build 25.66-b17, mixed mode)
```

* The minor version (in this case 66) is unimportant. If you don't have Java 8 Development Kit installed, install it: http://www.oracle.com/technetwork/java/javase/downloads/index.html (available for all platforms).
  
* Set up the _Maven_ build system. Instructions are available here: https://maven.apache.org/install.html (for all platforms).
* Double-check that you have at least Maven 3.3.3:

```
    $ mvn -v
```

```
    Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T12:57:37+01:00)
    Maven home: /usr/local/Cellar/maven/3.3.3/libexec
    Java version: 1.8.0_66, vendor: Oracle Corporation
    Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre
    Default locale: en_US, platform encoding: UTF-8
    OS name: "mac os x", version: "10.11.2", arch: "x86_64", family: "mac"
```

## Setup

* Extract the provided ZIP file and you will have a __co3326__ folder, which will be referred to as your _project folder_; navigate to it using a command-line prompt.
* Double-check that you have the following folder structure:

```
    /co3326/
        |-- README.md
        |-- pom.xml
        |-- test-cw1.txt
        |-- test-cw2.txt
        |-- /src/
            |-- /main/
                |-- /java/
                    |-- /co3326/
                        |-- App.java
                        |-- Cw1.java                    
                        |-- Cw2.java                    
                        |-- Message.java                    
                        |-- User.java                    
                |-- /resources/
                    |-- config.properties
```

* Edit the ```pom.xml``` file
* Look for the following lines:

```xml
    <student.name>FamilyName</student.name>
    <student.srn>27644437</student.srn>
    <coursework.number>2</coursework.number>        
```
* Replace ```FamilyName``` with your family name using a CamelCase syntax, _without_ blanks or dashes or underscores. Ex. if your family name is Zuckerberg, use _Zuckerberg_. 
* Replace ```27644437``` with your SRN.
* Set the ```coursework.number``` accordingly, i.e. _1_ for CW1 and _2_ for CW2.  
* Save the ```pom.xml``` file.

## Build

* Open a command-line prompt and navigate to your project folder (```co3326```).
* Build the project with the following command:

```
    $ mvn clean package
```

* This should have an output ending with:

```
    ...
     
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 3.114 s
    [INFO] Finished at: 2016-01-06T00:28:35+00:00
    [INFO] Final Memory: 20M/171M
    [INFO] ------------------------------------------------------------------------
```

* A new __target__ folder should have appeared in your project folder (```co3326/target/```), which should contain - among others - a ```FamilyName_27644437_CO3326CW2-jar-with-dependencies.jar``` file. Obviously, the file name will have your family name, SRN and the actual course work number; for example, if your family name is  _Zuckerberg_, your SRN is 27644437 and you are submitting CW2, the file will be ```Zuckerberg_27644437_CO3326CW2-jar-with-dependencies.jar```.

## Test

* The JAR file obtained with the build process is executable and contains both the Java byte code and the source code.
* There are two _test files_, in your project folder ```test-cw1.txt``` (for CW1) and ```test-cw2.txt``` (for CW2), which are valid test files and similar to those that will be used by the automatic testing process when your submissions will be evaluated, so these are the test files you will have to make sure that your code runs against successfully.
* For CW1, in a command-line prompt issue the following command:
   
```
    $ java -jar target/FamilyName_27644437_CO3326CW1-jar-with-dependencies.jar test-cw1.txt
```

* The output should be similar to this (with your family name and SRN):

```
    FamilyName
    27644437
    {"communication":[{"text":"University of London"}]}
    {"alice":{},"communication":[{"text":"Hi Bob!"}]}
    {"alice":{},"bob":{},"charlie":{},"communication":[{"text":"Hello World!"}]}
```

* For CW2, in a command-line prompt issue the following command:
   
```
    $ java -jar target/FamilyName_27644437_CO3326CW2-jar-with-dependencies.jar test-cw2.txt
```

* The output should be similar to this (with your family name and SRN):

```
FamilyName
27644437
{}
{"A":{}}
{"A":{},"B":{},"S":{}}
```

## Develop

The source folder, where your code will have to go is ```src/main/java/``` within yout project folder. You have a __co3326__ the top level package (```src/main/java/co3326```). Look at the ```App.java```, ```Cw1.java``` (for CW1) / ```Cw2.java``` (for CW2), ```Message.java``` and ```User.java``` files which are already in there. These provide a starting point for your code and help you with the reading of the input file, parsing of the input lines and creation of JSON representations of the test cases as well as printing the JSON results. You can place your code next to these files. The _main_ method is in the ```co3326.App``` class.

For serializing / de-serializing JSON objects, Google’s Gson library is used (https://github.com/google/gson). The build system (i.e. Maven) sorts out the dependency for you and bundles the library in your JAR file when you build the project.

You may use an IDE of your choice. Eclipse, IntelliJ IDEA and NetBeans are popular choices and available for all platforms. Most IDEs, including the ones mentioned, have support for Maven and will recognise your project when you import it.

## Required output: _Coursework 1_

Inspect the ```test-cw1.txt``` in your project folder:

```json
{ "communication" : [ { "text" : "University of London" } ] }
{ "alice" : { "rsa" : { "p" : 313, "q" : 787 } }, "communication" : [ { "text" : "Hi Bob!" } ] }
{ "alice" : { "rsa" : { "p" : 313, "q" : 787 } }, "bob": { "rsa" : { "p" : 157, "q" : 641, "e" : 29203 } }, "charlie" : { "rsa" : { "p" : 373, "q" : 977, "e" : 258845 } }, "communication" : [ { "text" : "Hello World!" } ] }
```

The following output is correct for this test file, both in terms of _format_ and _content_:

```json
FamilyName
27644437
{"alice":{"rsa":{"p":353,"q":739,"e":74609,"n":260867,"r":259776,"d":250577}},"bob":{"rsa":{"p":37,"q":733,"e":17359,"n":27121,"r":26352,"d":1471}},"charlie":{"rsa":{"p":313,"q":1009,"e":224249,"n":315817,"r":314496,"d":305993}},"communication":[{"text":"University of London","encoded":[85,110,105,118,101,114,115,105,116,121,32,111,102,32,76,111,110,100,111,110]},{"encoded":[51695,7876,216371,187465,245967,86567,170449,216371,84549,65399,158992,138625,51377,158992,272409,138625,7876,101075,138625,7876]},{"text":"University of London :: intercepted","encoded":[85,110,105,118,101,114,115,105,116,121,32,111,102,32,76,111,110,100,111,110,32,58,58,32,105,110,116,101,114,99,101,112,116,101,100]},{"encoded":[180276,96682,290466,200611,288925,151909,239338,290466,167979,71118,48758,12480,246717,48758,44604,12480,96682,278234,12480,96682,48758,49069,49069,48758,290466,96682,167979,288925,151909,186226,288925,70993,167979,288925,278234]},{"text":"University of London :: intercepted :: received","encoded":[85,110,105,118,101,114,115,105,116,121,32,111,102,32,76,111,110,100,111,110,32,58,58,32,105,110,116,101,114,99,101,112,116,101,100,32,58,58,32,114,101,99,101,105,118,101,100]}]}
{"alice":{"rsa":{"p":313,"q":787,"e":44429,"n":246331,"r":245232,"d":136037}},"bob":{"rsa":{"p":103,"q":521,"e":23657,"n":53663,"r":53040,"d":16553}},"charlie":{"rsa":{"p":439,"q":857,"e":341965,"n":376223,"r":374928,"d":95077}},"communication":[{"text":"Hi Bob!","encoded":[72,105,32,66,111,98,33]},{"encoded":[353251,34421,150268,286700,56706,306602,212817]},{"text":"Hi Bob! :: intercepted","encoded":[72,105,32,66,111,98,33,32,58,58,32,105,110,116,101,114,99,101,112,116,101,100]},{"encoded":[194469,350993,125350,116698,175587,292246,102367,125350,130545,130545,125350,350993,59464,136675,36166,298197,247651,36166,71422,136675,36166,265525]},{"text":"Hi Bob! :: intercepted :: received","encoded":[72,105,32,66,111,98,33,32,58,58,32,105,110,116,101,114,99,101,112,116,101,100,32,58,58,32,114,101,99,101,105,118,101,100]}]}
{"alice":{"rsa":{"p":313,"q":787,"e":118865,"n":246331,"r":245232,"d":243761}},"bob":{"rsa":{"p":157,"q":641,"e":29203,"n":100637,"r":99840,"d":48667}},"charlie":{"rsa":{"p":373,"q":977,"e":258845,"n":364421,"r":363072,"d":74933}},"communication":[{"text":"Hello World!","encoded":[72,101,108,108,111,32,87,111,114,108,100,33]},{"encoded":[291497,323875,261384,261384,322480,279160,194042,322480,327447,261384,353896,336665]},{"text":"Hello World! :: intercepted","encoded":[72,101,108,108,111,32,87,111,114,108,100,33,32,58,58,32,105,110,116,101,114,99,101,112,116,101,100]},{"encoded":[294580,181265,149385,149385,283553,136995,216187,283553,197484,149385,200153,290070,136995,251883,251883,136995,353286,60176,103884,181265,197484,143653,181265,251364,103884,181265,200153]},{"text":"Hello World! :: intercepted :: received","encoded":[72,101,108,108,111,32,87,111,114,108,100,33,32,58,58,32,105,110,116,101,114,99,101,112,116,101,100,32,58,58,32,114,101,99,101,105,118,101,100]}]}
```

The first two lines are _your name_ (in CamelCase) and _your SRN_. The following 3 lines are the outputs corresponding to the 3 input lines. To explain the output, we'll look at the first two input-output pairs in turn.

### First example

#### Input

This is the simplest input:

```json
{ "communication" : [ { "text" : "University of London" } ] }
```

Only the initial plain text is given: _University of London_. Nothing is given about  __Alice__, __Bob__ and __Charlie__, therefore _all_ their key-pairs have to be generated by you.

#### Possible output

Outputs will vary depending on what _p_, _q_ and _e_ values you have generated for __Alice__, __Bob__ and __Charlie__, but the correct format of the output is the following:    

```json
{
    "alice": { "rsa": { "p": 353, "q": 739, "e": 74609, "n": 260867, "r": 259776, "d": 250577 } },
    "bob": { "rsa": { "p": 37, "q": 733, "e": 17359, "n": 27121, "r": 26352, "d": 1471 } },
    "charlie": { "rsa": { "p": 313, "q": 1009, "e": 224249, "n": 315817, "r": 314496, "d": 305993 } },
    "communication": [
        { "text": "University of London", "encoded": [85, 110, 105, 118, 101, 114, 115, 105, 116, 121, 32, 111, 102, 32, 76, 111, 110, 100, 111, 110] }, 
        { "encoded": [51695, 7876, 216371, 187465, 245967, 86567, 170449, 216371, 84549, 65399, 158992, 138625, 51377, 158992, 272409, 138625, 7876, 101075, 138625, 7876] },
        { "text": "University of London :: intercepted", "encoded": [85, 110, 105, 118, 101, 114, 115, 105, 116, 121, 32, 111, 102, 32, 76, 111, 110, 100, 111, 110, 32, 58, 58, 32, 105, 110, 116, 101, 114, 99, 101, 112, 116, 101, 100] }, 
        { "encoded": [180276, 96682, 290466, 200611, 288925, 151909, 239338, 290466, 167979, 71118, 48758, 12480, 246717, 48758, 44604, 12480, 96682, 278234, 12480, 96682, 48758, 49069, 49069, 48758, 290466, 96682, 167979, 288925, 151909, 186226, 288925, 70993, 167979, 288925, 278234] },
        { "text": "University of London :: intercepted :: received", "encoded": [85, 110, 105, 118, 101, 114, 115, 105, 116, 121, 32, 111, 102, 32, 76, 111, 110, 100, 111, 110, 32, 58, 58, 32, 105, 110, 116, 101, 114, 99, 101, 112, 116, 101, 100, 32, 58, 58, 32, 114, 101, 99, 101, 105, 118, 101, 100] }
    ]
}
```

__Important__: the actual output will be a single line, but a pretty-print is used in this description so that you can better understand what is expected.

* The ```rsa``` field will be generated / computed entirely by you for __Alice__, __Bob__ and __Charlie__.
* You will extract the initial message, encode it, push it back to the ```communication``` list and push all subsequent messages as the initial message gets sent, intercepted and received between __Alice__, __Charlie__ and __Bob__.
* For plain texts (non-encrypted), include the encoding; i.e. the message will have both the ```text``` and the ```encoded``` fields set.
* For encrypted texts, the encoded text suffices; i.e. the message will only have the ```encoded``` field set.
* The ```communication``` list will have to contain the trail of messages as the initial message travels from __Alice__ to __Bob__ and is intercepted by __Charlie__.
* __Alice__ thinks she is communicating with __Bob__, but is in fact communicating with __Charlie__, who decodes __Alice__'s message, slightly alters it (appends _:: intercepted_ to the original message, for example) and sends it to __Bob__. __Bob__ will finally decode the message and mark it with _:: received_ before sending it back to __Alice__.
* Each message is doubly-encrypted, when __A__ sends a message to __B__, the message will be encrypted with __A__'s private key and __B__'s public key.
* Subsequently, when __B__ receives the message, it will have to be doubly-decrypted, with __B__'s private key and with __A__'s public key.
* You may have to pay attention to the ordering of the double encryption and the double decryption.
* You may continue to simulate a message travelling back from __Bob__ to __Alice__ but only the first 5 messages will be checked by the automatic tester. 
* More precisely, the ```encoded``` field of the 2nd message will be checked against the ```encoded``` field of the 1st message, using the _p_, _q_ and _e_ values you generated.
* Subsequently, it will be checked whether the decrypted 2nd message is a subset of the 3rd message, whether the 4th message is correctly generated from the 3rd and whether the decrypted 4th message is a subset of the 5th message. 

### Second example

#### Input

```json
{ "alice" : { "rsa" : { "p" : 313, "q" : 787 } }, "communication" : [ { "text" : "Hi Bob!" } ] }
```

The initial plain text is given: _"Hi Bob!"_. In addition, __Alice__'s _p_ and _q_ pair is also given; _e_ will be generated by you. Nothing is said about __Bob__ and __Charlie__, therefore _all_ their key-pairs and have to be generated by you.

#### Possible output

Outputs will vary depending on what _p_, _q_ and _e_ values you have generated for __Bob__ and __Charlie__ and what value have you picked for __Alice__'s _e_, but the correct format of the output is the following:    

```json
{
    "alice": { "rsa": { "p": 313, "q": 787, "e": 44429, "n": 246331, "r": 245232, "d": 136037 } },
    "bob": { "rsa": { "p": 103, "q": 521, "e": 23657, "n": 53663, "r": 53040, "d": 16553 } },
    "charlie": { "rsa": { "p": 439, "q": 857, "e": 341965, "n": 376223, "r": 374928, "d": 95077 } },
    "communication": [
        { "text": "Hi Bob!", "encoded": [72, 105, 32, 66, 111, 98, 33] }, 
        { "encoded": [353251, 34421, 150268, 286700, 56706, 306602, 212817] }, 
        { "text": "Hi Bob! :: intercepted", "encoded": [72, 105, 32, 66, 111, 98, 33, 32, 58, 58, 32, 105, 110, 116, 101, 114, 99, 101, 112, 116, 101, 100] }, 
        { "encoded": [194469, 350993, 125350, 116698, 175587, 292246, 102367, 125350, 130545, 130545, 125350, 350993, 59464, 136675, 36166, 298197, 247651, 36166, 71422, 136675, 36166, 265525] },
        { "text": "Hi Bob! :: intercepted :: received", "encoded": [72, 105, 32, 66, 111, 98, 33, 32, 58, 58, 32, 105, 110, 116, 101, 114, 99, 101, 112, 116, 101, 100, 32, 58, 58, 32, 114, 101, 99, 101, 105, 118, 101, 100] }
    ]
}
```

__Important__: the actual output will be a single line, but a pretty-print is used in this description so that you can better understand what is expected.

* Again, you may continue to simulate a message travelling back from __Bob__ to __Alice__ but only the first 5 messages will be checked by the automatic tester, as explained above. 

### Assumptions

* You may restrict _p_ and _q_ to be primes in the __(8, 1024)__ interval.
* Pick _e_ randomly such that it is co-prime with _r_ and compute _d_ accordingly.
* You can assume that the ```communication``` array initially always contains the plain text of the message that __Alice__ is to send to __Bob__ that will be intercepted by __Charlie__.
 

## Required output: _Coursework 2_

Inspect the ```test-cw2.txt``` in your project folder:

```json
{  }
{ "A" : { "rsa" : { "p" : 313, "q" : 787 }, "nonce" : 1066 } }
{ "A" : { "rsa" : { "p" : 313, "q" : 787 }, "nonce" : 1812 }, "B": { "rsa" : { "p" : 157, "q" : 641, "e" : 29203 }, "nonce" : 1989 }, "S" : { "rsa" : { "p" : 373, "q" : 977, "e" : 258845 } } }
```

The following output is correct for this test file, both in terms of _format_ and _content_:

```json
FirstnameLastname
27644437
{"A":{"rsa":{"p":139,"q":647,"e":38795,"n":89933,"r":89148,"d":12071},"nonce":844043615},"B":{"rsa":{"p":19,"q":751,"e":8047,"n":14269,"r":13500,"d":9883},"nonce":1382041814},"S":{"rsa":{"p":127,"q":821,"e":63209,"n":104267,"r":103320,"d":38849}},"communication":[{"text":"Dear S, This is A and I would like to get B-s public key. Yours sincerely, A.","encoded":[68,101,97,114,32,83,44,32,84,104,105,115,32,105,115,32,65,32,97,110,100,32,73,32,119,111,117,108,100,32,108,105,107,101,32,116,111,32,103,101,116,32,66,45,115,32,112,117,98,108,105,99,32,107,101,121,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,65,46]},{"text":"Dear A, Here is B-s public key [8047] signed by me. Yours sincerely, S.","encoded":[68,101,97,114,32,65,44,32,72,101,114,101,32,105,115,32,66,45,115,32,112,117,98,108,105,99,32,107,101,121,32,91,56,48,52,55,93,32,115,105,103,110,101,100,32,98,121,32,109,101,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,83,46],"encrypted":[21566,44822,90721,22969,44200,102772,7733,44200,12889,44822,22969,44822,44200,42954,81324,44200,10770,1547,81324,44200,12151,69634,81818,87269,42954,20865,44200,59709,44822,3898,44200,55502,47797,73141,50614,12892,11859,44200,81324,42954,82699,95854,44822,85645,44200,81818,3898,44200,42170,44822,48751,44200,80020,71493,69634,22969,81324,44200,81324,42954,95854,20865,44822,22969,44822,87269,3898,7733,44200,34177,48751]},{"text":"Dear B, This is A and I have sent you a nonce [844043615] only you can read. Yours sincerely, A.","encoded":[68,101,97,114,32,66,44,32,84,104,105,115,32,105,115,32,65,32,97,110,100,32,73,32,104,97,118,101,32,115,101,110,116,32,121,111,117,32,97,32,110,111,110,99,101,32,91,56,52,52,48,52,51,54,49,53,93,32,111,110,108,121,32,121,111,117,32,99,97,110,32,114,101,97,100,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,65,46],"encrypted":[10898,5820,9331,4199,13712,6222,9544,13712,6506,8388,1644,1445,13712,1644,1445,13712,2117,13712,9331,12175,7814,13712,73,13712,8388,9331,1011,5820,13712,1445,5820,12175,1465,13712,7398,9725,13569,13712,9331,13712,12175,9725,12175,4146,5820,13712,11605,5737,6208,6208,5064,6208,450,2619,7364,5582,9441,13712,9725,12175,11565,7398,13712,7398,9725,13569,13712,4146,9331,12175,13712,4199,5820,9331,7814,787,13712,8677,9725,13569,4199,1445,13712,1445,1644,12175,4146,5820,4199,5820,11565,7398,9544,13712,2117,787]},{"text":"Dear S, This is B and I would like to get A-s public key. Yours sincerely, B.","encoded":[68,101,97,114,32,83,44,32,84,104,105,115,32,105,115,32,66,32,97,110,100,32,73,32,119,111,117,108,100,32,108,105,107,101,32,116,111,32,103,101,116,32,65,45,115,32,112,117,98,108,105,99,32,107,101,121,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,66,46]},{"text":"Dear B, Here is A-s public key [38795] signed by me. Yours sincerely, S.","encoded":[68,101,97,114,32,66,44,32,72,101,114,101,32,105,115,32,65,45,115,32,112,117,98,108,105,99,32,107,101,121,32,91,51,56,55,57,53,93,32,115,105,103,110,101,100,32,98,121,32,109,101,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,83,46],"encrypted":[21566,44822,90721,22969,44200,10770,7733,44200,12889,44822,22969,44822,44200,42954,81324,44200,102772,1547,81324,44200,12151,69634,81818,87269,42954,20865,44200,59709,44822,3898,44200,55502,63378,47797,12892,3520,39090,11859,44200,81324,42954,82699,95854,44822,85645,44200,81818,3898,44200,42170,44822,48751,44200,80020,71493,69634,22969,81324,44200,81324,42954,95854,20865,44822,22969,44822,87269,3898,7733,44200,34177,48751]},{"text":"Dear A, Here is my nonce [1382041814] and yours [844043615], proving I decrypted it. Yours sincerely, B.","encoded":[68,101,97,114,32,65,44,32,72,101,114,101,32,105,115,32,109,121,32,110,111,110,99,101,32,91,49,51,56,50,48,52,49,56,49,52,93,32,97,110,100,32,121,111,117,114,115,32,91,56,52,52,48,52,51,54,49,53,93,44,32,112,114,111,118,105,110,103,32,73,32,100,101,99,114,121,112,116,101,100,32,105,116,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,66,46],"encrypted":[14092,11352,53419,72832,72214,85287,25216,72214,3924,11352,72832,11352,72214,10300,78764,72214,54556,32535,72214,59926,37739,59926,56002,11352,72214,11236,57667,3244,29316,43472,23097,34537,57667,29316,57667,34537,34808,72214,53419,59926,27446,72214,32535,37739,60404,72832,78764,72214,11236,29316,34537,34537,23097,34537,3244,12263,57667,10405,34808,25216,72214,26072,72832,37739,76874,10300,59926,37625,72214,76552,72214,27446,11352,56002,72832,32535,26072,26872,11352,27446,72214,10300,26872,84732,72214,87883,37739,60404,72832,78764,72214,78764,10300,59926,56002,11352,72832,11352,39448,32535,25216,72214,36594,84732]},{"text":"Dear B, Here is your nonce [1382041814] proving I decrypted it. Yours sincerely, A.","encoded":[68,101,97,114,32,66,44,32,72,101,114,101,32,105,115,32,121,111,117,114,32,110,111,110,99,101,32,91,49,51,56,50,48,52,49,56,49,52,93,32,112,114,111,118,105,110,103,32,73,32,100,101,99,114,121,112,116,101,100,32,105,116,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,65,46],"encrypted":[10898,5820,9331,4199,13712,6222,9544,13712,72,5820,4199,5820,13712,1644,1445,13712,7398,9725,13569,4199,13712,12175,9725,12175,4146,5820,13712,11605,7364,450,5737,10975,5064,6208,7364,5737,7364,6208,9441,13712,13222,4199,9725,1011,1644,12175,11864,13712,73,13712,7814,5820,4146,4199,7398,13222,1465,5820,7814,13712,1644,1465,787,13712,8677,9725,13569,4199,1445,13712,1445,1644,12175,4146,5820,4199,5820,11565,7398,9544,13712,2117,787]}]}
{"A":{"rsa":{"p":313,"q":787,"e":226321,"n":246331,"r":245232,"d":89905},"nonce":1066},"B":{"rsa":{"p":359,"q":769,"e":258659,"n":276071,"r":274944,"d":156491},"nonce":173535442},"S":{"rsa":{"p":103,"q":461,"e":10027,"n":47483,"r":46920,"d":22723}},"communication":[{"text":"Dear S, This is A and I would like to get B-s public key. Yours sincerely, A.","encoded":[68,101,97,114,32,83,44,32,84,104,105,115,32,105,115,32,65,32,97,110,100,32,73,32,119,111,117,108,100,32,108,105,107,101,32,116,111,32,103,101,116,32,66,45,115,32,112,117,98,108,105,99,32,107,101,121,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,65,46]},{"text":"Dear A, Here is B-s public key [258659] signed by me. Yours sincerely, S.","encoded":[68,101,97,114,32,65,44,32,72,101,114,101,32,105,115,32,66,45,115,32,112,117,98,108,105,99,32,107,101,121,32,91,50,53,56,54,53,57,93,32,115,105,103,110,101,100,32,98,121,32,109,101,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,83,46],"encrypted":[30365,1393,20207,5883,12375,39236,28297,12375,46529,1393,5883,1393,12375,7671,1953,12375,35307,39226,1953,12375,26640,23975,2118,6740,7671,1410,12375,30108,1393,7251,12375,38629,551,46211,25600,41697,46211,21481,29416,12375,1953,7671,22145,9774,1393,425,12375,2118,7251,12375,5440,1393,11994,12375,31233,14340,23975,5883,1953,12375,1953,7671,9774,1410,1393,5883,1393,6740,7251,28297,12375,36670,11994]},{"text":"Dear B, This is A and I have sent you a nonce [1066] only you can read. Yours sincerely, A.","encoded":[68,101,97,114,32,66,44,32,84,104,105,115,32,105,115,32,65,32,97,110,100,32,73,32,104,97,118,101,32,115,101,110,116,32,121,111,117,32,97,32,110,111,110,99,101,32,91,49,48,54,54,93,32,111,110,108,121,32,121,111,117,32,99,97,110,32,114,101,97,100,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,65,46],"encrypted":[65632,226002,147211,202097,152419,255812,232948,152419,154942,193922,167573,238177,152419,167573,238177,152419,167559,152419,147211,226680,113504,152419,176884,152419,193922,147211,180754,226002,152419,238177,226002,226680,100562,152419,76853,142763,234379,152419,147211,152419,226680,142763,226680,140019,226002,152419,247504,108879,142136,117461,117461,169084,152419,142763,226680,169170,76853,152419,76853,142763,234379,152419,140019,147211,226680,152419,202097,226002,147211,113504,65592,152419,142390,142763,234379,202097,238177,152419,238177,167573,226680,140019,226002,202097,226002,169170,76853,232948,152419,167559,65592]},{"text":"Dear S, This is B and I would like to get A-s public key. Yours sincerely, B.","encoded":[68,101,97,114,32,83,44,32,84,104,105,115,32,105,115,32,66,32,97,110,100,32,73,32,119,111,117,108,100,32,108,105,107,101,32,116,111,32,103,101,116,32,65,45,115,32,112,117,98,108,105,99,32,107,101,121,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,66,46]},{"text":"Dear B, Here is A-s public key [226321] signed by me. Yours sincerely, S.","encoded":[68,101,97,114,32,66,44,32,72,101,114,101,32,105,115,32,65,45,115,32,112,117,98,108,105,99,32,107,101,121,32,91,50,50,54,51,50,49,93,32,115,105,103,110,101,100,32,98,121,32,109,101,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,83,46],"encrypted":[30365,1393,20207,5883,12375,35307,28297,12375,46529,1393,5883,1393,12375,7671,1953,12375,39236,39226,1953,12375,26640,23975,2118,6740,7671,1410,12375,30108,1393,7251,12375,38629,551,551,41697,5480,551,31124,29416,12375,1953,7671,22145,9774,1393,425,12375,2118,7251,12375,5440,1393,11994,12375,31233,14340,23975,5883,1953,12375,1953,7671,9774,1410,1393,5883,1393,6740,7251,28297,12375,36670,11994]},{"text":"Dear A, Here is my nonce [173535442] and yours [1066], proving I decrypted it. Yours sincerely, B.","encoded":[68,101,97,114,32,65,44,32,72,101,114,101,32,105,115,32,109,121,32,110,111,110,99,101,32,91,49,55,51,53,51,53,52,52,50,93,32,97,110,100,32,121,111,117,114,115,32,91,49,48,54,54,93,44,32,112,114,111,118,105,110,103,32,73,32,100,101,99,114,121,112,116,101,100,32,105,116,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,66,46],"encrypted":[71637,17125,68386,231043,9533,206453,192332,9533,112380,17125,231043,17125,9533,172794,112954,9533,87389,202648,9533,121831,157759,121831,69272,17125,9533,37709,117070,93197,164520,122211,164520,122211,119976,119976,25581,244016,9533,68386,121831,179325,9533,202648,157759,240592,231043,112954,9533,37709,117070,75041,232300,232300,244016,192332,9533,106001,231043,157759,21653,172794,121831,168956,9533,119648,9533,179325,17125,69272,231043,202648,106001,112552,17125,179325,9533,172794,112552,179050,9533,57169,157759,240592,231043,112954,9533,112954,172794,121831,69272,17125,231043,17125,156379,202648,192332,9533,187391,179050]},{"text":"Dear B, Here is your nonce [173535442] proving I decrypted it. Yours sincerely, A.","encoded":[68,101,97,114,32,66,44,32,72,101,114,101,32,105,115,32,121,111,117,114,32,110,111,110,99,101,32,91,49,55,51,53,51,53,52,52,50,93,32,112,114,111,118,105,110,103,32,73,32,100,101,99,114,121,112,116,101,100,32,105,116,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,65,46],"encrypted":[65632,226002,147211,202097,152419,255812,232948,152419,131076,226002,202097,226002,152419,167573,238177,152419,76853,142763,234379,202097,152419,226680,142763,226680,140019,226002,152419,247504,108879,51938,161521,275429,161521,275429,196722,196722,184829,169084,152419,215407,202097,142763,180754,167573,226680,101234,152419,176884,152419,113504,226002,140019,202097,76853,215407,100562,226002,113504,152419,167573,100562,65592,152419,142390,142763,234379,202097,238177,152419,238177,167573,226680,140019,226002,202097,226002,169170,76853,232948,152419,167559,65592]}]}
{"A":{"rsa":{"p":313,"q":787,"e":119279,"n":246331,"r":245232,"d":109535},"nonce":1812},"B":{"rsa":{"p":157,"q":641,"e":29203,"n":100637,"r":99840,"d":48667},"nonce":1989},"S":{"rsa":{"p":373,"q":977,"e":258845,"n":364421,"r":363072,"d":74933}},"communication":[{"text":"Dear S, This is A and I would like to get B-s public key. Yours sincerely, A.","encoded":[68,101,97,114,32,83,44,32,84,104,105,115,32,105,115,32,65,32,97,110,100,32,73,32,119,111,117,108,100,32,108,105,107,101,32,116,111,32,103,101,116,32,66,45,115,32,112,117,98,108,105,99,32,107,101,121,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,65,46]},{"text":"Dear A, Here is B-s public key [29203] signed by me. Yours sincerely, S.","encoded":[68,101,97,114,32,65,44,32,72,101,114,101,32,105,115,32,66,45,115,32,112,117,98,108,105,99,32,107,101,121,32,91,50,57,50,48,51,93,32,115,105,103,110,101,100,32,98,121,32,109,101,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,83,46],"encrypted":[118729,40313,161154,53846,184591,39926,183659,184591,138538,40313,53846,40313,184591,151404,359645,184591,230781,346794,359645,184591,638,267401,228780,67179,151404,145992,184591,47308,40313,363125,184591,74612,209108,1042,209108,50072,130951,272757,184591,359645,151404,196392,69537,40313,47323,184591,228780,363125,184591,162611,40313,171648,184591,271083,330341,267401,53846,359645,184591,359645,151404,69537,145992,40313,53846,40313,67179,363125,183659,184591,246996,171648]},{"text":"Dear B, This is A and I have sent you a nonce [1812] only you can read. Yours sincerely, A.","encoded":[68,101,97,114,32,66,44,32,84,104,105,115,32,105,115,32,65,32,97,110,100,32,73,32,104,97,118,101,32,115,101,110,116,32,121,111,117,32,97,32,110,111,110,99,101,32,91,49,56,49,50,93,32,111,110,108,121,32,121,111,117,32,99,97,110,32,114,101,97,100,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,65,46],"encrypted":[99370,80483,57557,37156,94355,70040,20635,94355,36661,11841,96327,93367,94355,96327,93367,94355,81524,94355,57557,73153,31369,94355,94591,94355,11841,57557,87374,80483,94355,93367,80483,73153,2698,94355,82549,48883,82121,94355,57557,94355,73153,48883,73153,49626,80483,94355,69219,9604,21096,9604,67303,87557,94355,48883,73153,73920,82549,94355,82549,48883,82121,94355,49626,57557,73153,94355,37156,80483,57557,31369,63686,94355,11629,48883,82121,37156,93367,94355,93367,96327,73153,49626,80483,37156,80483,73920,82549,20635,94355,81524,63686]},{"text":"Dear S, This is B and I would like to get A-s public key. Yours sincerely, B.","encoded":[68,101,97,114,32,83,44,32,84,104,105,115,32,105,115,32,66,32,97,110,100,32,73,32,119,111,117,108,100,32,108,105,107,101,32,116,111,32,103,101,116,32,65,45,115,32,112,117,98,108,105,99,32,107,101,121,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,66,46]},{"text":"Dear B, Here is A-s public key [119279] signed by me. Yours sincerely, S.","encoded":[68,101,97,114,32,66,44,32,72,101,114,101,32,105,115,32,65,45,115,32,112,117,98,108,105,99,32,107,101,121,32,91,49,49,57,50,55,57,93,32,115,105,103,110,101,100,32,98,121,32,109,101,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,83,46],"encrypted":[118729,40313,161154,53846,184591,230781,183659,184591,138538,40313,53846,40313,184591,151404,359645,184591,39926,346794,359645,184591,638,267401,228780,67179,151404,145992,184591,47308,40313,363125,184591,74612,312418,312418,1042,209108,227987,1042,272757,184591,359645,151404,196392,69537,40313,47323,184591,228780,363125,184591,162611,40313,171648,184591,271083,330341,267401,53846,359645,184591,359645,151404,69537,145992,40313,53846,40313,67179,363125,183659,184591,246996,171648]},{"text":"Dear A, Here is my nonce [1989] and yours [1812], proving I decrypted it. Yours sincerely, B.","encoded":[68,101,97,114,32,65,44,32,72,101,114,101,32,105,115,32,109,121,32,110,111,110,99,101,32,91,49,57,56,57,93,32,97,110,100,32,121,111,117,114,115,32,91,49,56,49,50,93,44,32,112,114,111,118,105,110,103,32,73,32,100,101,99,114,121,112,116,101,100,32,105,116,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,66,46],"encrypted":[170211,243408,224895,189942,58603,137692,172926,58603,199359,243408,189942,243408,58603,36838,84236,58603,52817,160465,58603,132354,51470,132354,102253,243408,58603,131552,242880,97573,139733,97573,12803,58603,224895,132354,194188,58603,160465,51470,116996,189942,84236,58603,131552,242880,139733,242880,173523,12803,172926,58603,236538,189942,51470,179810,36838,132354,236877,58603,94980,58603,194188,243408,102253,189942,160465,236538,222880,243408,194188,58603,36838,222880,207076,58603,134217,51470,116996,189942,84236,58603,84236,36838,132354,102253,243408,189942,243408,128102,160465,172926,58603,150884,207076]},{"text":"Dear B, Here is your nonce [1989] proving I decrypted it. Yours sincerely, A.","encoded":[68,101,97,114,32,66,44,32,72,101,114,101,32,105,115,32,121,111,117,114,32,110,111,110,99,101,32,91,49,57,56,57,93,32,112,114,111,118,105,110,103,32,73,32,100,101,99,114,121,112,116,101,100,32,105,116,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,65,46],"encrypted":[99370,80483,57557,37156,94355,70040,20635,94355,47469,80483,37156,80483,94355,96327,93367,94355,82549,48883,82121,37156,94355,73153,48883,73153,49626,80483,94355,69219,9604,44933,21096,44933,87557,94355,46935,37156,48883,87374,96327,73153,40428,94355,94591,94355,31369,80483,49626,37156,82549,46935,2698,80483,31369,94355,96327,2698,63686,94355,11629,48883,82121,37156,93367,94355,93367,96327,73153,49626,80483,37156,80483,73920,82549,20635,94355,81524,63686]}]}
```

Similar to the output of CW1, the first two lines are _your name_ (in CamelCase) and _your SRN_. The following 3 lines are the outputs corresponding to the 3 input lines. To explain the output, we'll look at each input-output pairs in turn.

### First example

This is the simplest input:

```json
{  }
```

Nothing is given about  Alice (__A__), Bob (__B__) and the trusted 3rd party (__S__), therefore _all_ their key-pairs have to be generated by you. In addition, you will also have to generate the __nonce__s for Alice and Bob.

#### Possible output

Outputs will vary depending on what _p_, _q_ and _e_ values you have generated for __A__, __B__ and __S__, but the correct format of the output is the following:    

```json
{
    "A" : {
        "rsa" : { "p" : 139, "q" : 647, "e" : 38795, "n" : 89933, "r" : 89148, "d" : 12071 },
        "nonce" : 844043615
    },
    "B" : {
        "rsa" : { "p" : 19, "q" : 751, "e" : 8047, "n" : 14269, "r" : 13500, "d" : 9883 },
        "nonce":1382041814
    },
    "S" : {
        "rsa" : { "p" : 127, "q":821, "e" : 63209, "n" : 104267, "r" : 103320, "d" : 38849 }
    },
    "communication" : [ 
        {
            "text" : "Dear S, This is A and I would like to get B-s public key. Yours sincerely, A.",
            "encoded" : [68,101,97,114,32,83,44,32,84,104,105,115,32,105,115,32,65,32,97,110,100,32,73,32,119,111,117,108,100,32,108,105,107,101,32,116,111,32,103,101,116,32,66,45,115,32,112,117,98,108,105,99,32,107,101,121,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,65,46]
        },
        {
            "text" : "Dear A, Here is B-s public key [8047] signed by me. Yours sincerely, S.",
            "encoded" : [68,101,97,114,32,65,44,32,72,101,114,101,32,105,115,32,66,45,115,32,112,117,98,108,105,99,32,107,101,121,32,91,56,48,52,55,93,32,115,105,103,110,101,100,32,98,121,32,109,101,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,83,46],
            "encrypted" : [21566,44822,90721,22969,44200,102772,7733,44200,12889,44822,22969,44822,44200,42954,81324,44200,10770,1547,81324,44200,12151,69634,81818,87269,42954,20865,44200,59709,44822,3898,44200,55502,47797,73141,50614,12892,11859,44200,81324,42954,82699,95854,44822,85645,44200,81818,3898,44200,42170,44822,48751,44200,80020,71493,69634,22969,81324,44200,81324,42954,95854,20865,44822,22969,44822,87269,3898,7733,44200,34177,48751]
        },
        {
            "text" : "Dear B, This is A and I have sent you a nonce [844043615] only you can read. Yours sincerely, A.",
            "encoded" : [68,101,97,114,32,66,44,32,84,104,105,115,32,105,115,32,65,32,97,110,100,32,73,32,104,97,118,101,32,115,101,110,116,32,121,111,117,32,97,32,110,111,110,99,101,32,91,56,52,52,48,52,51,54,49,53,93,32,111,110,108,121,32,121,111,117,32,99,97,110,32,114,101,97,100,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,65,46],
            "encrypted" : [10898,5820,9331,4199,13712,6222,9544,13712,6506,8388,1644,1445,13712,1644,1445,13712,2117,13712,9331,12175,7814,13712,73,13712,8388,9331,1011,5820,13712,1445,5820,12175,1465,13712,7398,9725,13569,13712,9331,13712,12175,9725,12175,4146,5820,13712,11605,5737,6208,6208,5064,6208,450,2619,7364,5582,9441,13712,9725,12175,11565,7398,13712,7398,9725,13569,13712,4146,9331,12175,13712,4199,5820,9331,7814,787,13712,8677,9725,13569,4199,1445,13712,1445,1644,12175,4146,5820,4199,5820,11565,7398,9544,13712,2117,787]
        },
        {
            "text" : "Dear S, This is B and I would like to get A-s public key. Yours sincerely, B.",
            "encoded" : [68,101,97,114,32,83,44,32,84,104,105,115,32,105,115,32,66,32,97,110,100,32,73,32,119,111,117,108,100,32,108,105,107,101,32,116,111,32,103,101,116,32,65,45,115,32,112,117,98,108,105,99,32,107,101,121,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,66,46]
        },
        {
            "text" : "Dear B, Here is A-s public key [38795] signed by me. Yours sincerely, S.",
            "encoded" : [68,101,97,114,32,66,44,32,72,101,114,101,32,105,115,32,65,45,115,32,112,117,98,108,105,99,32,107,101,121,32,91,51,56,55,57,53,93,32,115,105,103,110,101,100,32,98,121,32,109,101,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,83,46],
            "encrypted" : [21566,44822,90721,22969,44200,10770,7733,44200,12889,44822,22969,44822,44200,42954,81324,44200,102772,1547,81324,44200,12151,69634,81818,87269,42954,20865,44200,59709,44822,3898,44200,55502,63378,47797,12892,3520,39090,11859,44200,81324,42954,82699,95854,44822,85645,44200,81818,3898,44200,42170,44822,48751,44200,80020,71493,69634,22969,81324,44200,81324,42954,95854,20865,44822,22969,44822,87269,3898,7733,44200,34177,48751]
        },
        {
            "text" : "Dear A, Here is my nonce [1382041814] and yours [844043615], proving I decrypted it. Yours sincerely, B.",
            "encoded" : [68,101,97,114,32,65,44,32,72,101,114,101,32,105,115,32,109,121,32,110,111,110,99,101,32,91,49,51,56,50,48,52,49,56,49,52,93,32,97,110,100,32,121,111,117,114,115,32,91,56,52,52,48,52,51,54,49,53,93,44,32,112,114,111,118,105,110,103,32,73,32,100,101,99,114,121,112,116,101,100,32,105,116,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,66,46],
            "encrypted" : [14092,11352,53419,72832,72214,85287,25216,72214,3924,11352,72832,11352,72214,10300,78764,72214,54556,32535,72214,59926,37739,59926,56002,11352,72214,11236,57667,3244,29316,43472,23097,34537,57667,29316,57667,34537,34808,72214,53419,59926,27446,72214,32535,37739,60404,72832,78764,72214,11236,29316,34537,34537,23097,34537,3244,12263,57667,10405,34808,25216,72214,26072,72832,37739,76874,10300,59926,37625,72214,76552,72214,27446,11352,56002,72832,32535,26072,26872,11352,27446,72214,10300,26872,84732,72214,87883,37739,60404,72832,78764,72214,78764,10300,59926,56002,11352,72832,11352,39448,32535,25216,72214,36594,84732]
        },
        {
            "text" : "Dear B, Here is your nonce [1382041814] proving I decrypted it. Yours sincerely, A.",
            "encoded" : [68,101,97,114,32,66,44,32,72,101,114,101,32,105,115,32,121,111,117,114,32,110,111,110,99,101,32,91,49,51,56,50,48,52,49,56,49,52,93,32,112,114,111,118,105,110,103,32,73,32,100,101,99,114,121,112,116,101,100,32,105,116,46,32,89,111,117,114,115,32,115,105,110,99,101,114,101,108,121,44,32,65,46],
            "encrypted" : [10898,5820,9331,4199,13712,6222,9544,13712,72,5820,4199,5820,13712,1644,1445,13712,7398,9725,13569,4199,13712,12175,9725,12175,4146,5820,13712,11605,7364,450,5737,10975,5064,6208,7364,5737,7364,6208,9441,13712,13222,4199,9725,1011,1644,12175,11864,13712,73,13712,7814,5820,4146,4199,7398,13222,1465,5820,7814,13712,1644,1465,787,13712,8677,9725,13569,4199,1445,13712,1445,1644,12175,4146,5820,4199,5820,11565,7398,9544,13712,2117,787]
        }
    ]
}
```

* There must be exactly 4 entries: the details of __A__, __B__ and __S__ (the RSA keys for all 3 parties and nonce values you pick for __A__ and __B__) and the communication between them as specified by the protocol described in the coursework specification.
* The commuinication must be an array of 7 messages

### Second example

### Third example


## Help

To _encode_ plain texts (i.e. strings) to an array of integers that can be encrypted / decrypted, you may use the following functions (_Java 8_):

```java
    public static int[] encode(String message) {
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        return IntStream.generate(buffer::get).limit(buffer.remaining()).toArray();
    }

    public static String decode(int[] message) {
        return Arrays.stream(message)
                .mapToObj(i -> (char) i)
                .reduce(new StringBuilder(), (sb, c) -> sb.append(c), StringBuilder::append)
                .toString();
    }    
```      

* These functions use the ASCII values of the characters that make up the string to convert between string and a list of integers.

## Submission

Once you're happy with your code

* rebuild your project, following the instructions in the [Build](#build) section,
* re-test your project, following the instructions in the [Test](#test) section,
* double-check that the output in the required format,
* submit the ```FamilyName_27644437_CO3326CW1-jar-with-dependencies.jar``` JAR file, which will obviously have your family name, SRN and the actual coursework number; for example, if your family name is Zuckerberg, your SRN is 27644437 and you're submitting CW2, the file would be ```Zuckerberg_27644437_CO3326CW2-jar-with-dependencies.jar```). This file is located in your project's ```target``` folder.
  
### Important

__Only__ a JAR file, which uses the correct naming scheme and produces output in the described format will be looked at, and __only__ if it passes the automatic tests. A ZIPed project folder or individual Java or Class files will __not__ be looked at, and will be awarded a _0_ mark. If you correctly follow the description above, the JAR file you submit will contain the source code that you worked on and will give the marker the opportunity to check it, once your byte code passes the automatic execution phase.
