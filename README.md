# CO3326 Computer security assignment 2016

This description contains the requirements for the __code submission__, which has to be read in conjunction with the actual assignment you are already familiar with. It is important that you follow these instructions carefully, as your code submission will be processed automatically and will not be seen by the marker unless it passes all test cases that are detailed below. 

## General guidelines

* You will submit a _single JAR file_ for each coursework following a _specific naming scheme_.
* Your code must compile and run against _Java 8_.
* The entry point in your code will have a main method, which receives one command-line argument, the absolute path to an _input file_. 
* Your programme will read the input file and treats each line as a separate _test case_ / separate instance of the problem. 
* Each line in the test file is a JSON object.
* Your programme will print a single line of text, containing one JSON object, for every single input line. Therefore the number of input lines will match the number of output lines.
* The JSON objects, both input and output, have a _strict format_ you will have to conform to and there are details provided below with examples.

## Prerequisites

* Make sure you have __Java 8 Development Kit__ installed:

```$ java -version```

should have a similar output:

```
java version "1.8.0_66"
Java(TM) SE Runtime Environment (build 1.8.0_66-b17)
Java HotSpot(TM) 64-Bit Server VM (build 25.66-b17, mixed mode)
```

The minor version (in this case 66) is unimportant. If you don't have Java 8 Development Kit installed, install it: http://www.oracle.com/technetwork/java/javase/downloads/index.html (available for all platforms).
  
* Set up the __Maven__ build system. Instructions are available here: https://maven.apache.org/install.html (for all platforms). Double-check that you have at least Maven 3.3.3:

```$ mvn -v```

should have a similar output:

```
Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T12:57:37+01:00)
Maven home: /usr/local/Cellar/maven/3.3.3/libexec
Java version: 1.8.0_66, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.11.2", arch: "x86_64", family: "mac"
```

## Setup

* Download the skeleton project by clicking the __Download ZIP__ button above.
* Extract the ZIP file and you will have a __co3326-master__ folder; navigate to this folder using a command-line prompt.
* Double-check that you have the following folder structure:

```
/co3326-master/
	|-- README.md
	|-- pom.xml
	|-- test.txt
	|-- /src/
		|-- /main/
			|-- /java/
				|-- /co3326/
					|-- App.java
					|-- Cw1.java					
                    |-- Message.java                    
                    |-- User.java                    
			|-- /resources/
				|-- config.properties
```

* Edit the ```pom.xml``` file; look for the following lines:

```xml
<student.name>FirstnameLastname</student.name>
<student.srn>27644437</student.srn>
```
* Replace ```FirstnameLastname``` with your name using a _CamelCase_ syntax, __without__ blanks or dashes or underscores. Ex. if your name is Jane Smith, use _JaneSmith_. 
* Replace ```27644437``` with your SRN.
* Save the ```pom.xml``` file.

## <a name="build"></a>Build

* Open a command-line prompt and navigate to the __co3326-master__ folder.
* Build the project with the following command:

``` $ mvn clean package ```

* It should have an output ending with:

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

* A new __target__ folder should have appeared in your project folder (co3326-master), which should contain - among others - a ```FirstnameLastname-jar-with-dependencies.jar``` file. Obviously, the file name will have your name in it, ex. if you're _Jane Smith_, the file will be ```JaneSmith-jar-with-dependencies.jar```.

## <a name="test"></a>Test

* The JAR file obtained with the build process is executable and contains both the Java byte code and the source code.
* There is a _test file_ in your project folder (```test.txt```), which is a valid test file and similar to the one that will be used by the automatic testing process when your submission will be evaluated, so this is the test file you will have to make sure that your code runs against successfully.
* In a command-line prompt issue the following cmmand:
   
``` $ java -jar target/FirstnameLastname-jar-with-dependencies.jar test.txt```

obviously, using the correct file name. The output should be:

```
FirstnameLastname
27644437
{"communication":[{"text":"University of London"}]}
Unable to invoke no-args constructor for interface co3326.User. Register an InstanceCreator with Gson for this type may fix this problem.
Unable to invoke no-args constructor for interface co3326.User. Register an InstanceCreator with Gson for this type may fix this problem.

```

## Develop

The source folder, where your code will have to go is ```src/main/java/```. You have a __co3326__ the top level package. Look at the ```App.java```, ```Cw1.java```, ```Message.java``` and ```User.java``` files which are already in there. These provide a starting point for your code and help you with the reading of the input file, parsing of the input lines and creation of JSON representations of the test cases as well as printing the JSON results.

For serializing / de-serializing JSON objects, Google’s Gson library is used (https://github.com/google/gson). The build system (i.e. Maven) sorts out the dependency for you and bundles the library in your JAR file when you build the project.

You may use an IDE of your choice. Eclipse, IntelliJ IDEA and NetBeans are popular choices and available for all platforms. Most IDEs, including the ones mentioned, have support for Maven and will recognise your project when you import it.

## Required output: _Coursework 1_

Inspect the ```test.txt``` in your project folder:

```json
{ "communication" : [ { "text" : "University of London" } ] }
{ "alice" : { "rsa" : { "p" : 313, "q" : 787 } }, "communication" : [ { "text" : "Hi Bob!" } ] }
{ "alice" : { "rsa" : { "p" : 313, "q" : 787 } }, "bob": { "rsa" : { "p" : 157, "q" : 641, "e" : 29203 } }, "charlie" : { "rsa" : { "p" : 373, "q" : 977, "e" : 258845 } }, "communication" : [ { "text" : "Hello World!" } ] }
```

The following output is correct for this test file, both in terms of _format_ and _content_:

```json
FirstnameLastname
27644437
{"alice":{"rsa":{"p":313,"q":577,"e":93563,"n":180601,"r":179712,"d":117683}},"bob":{"rsa":{"p":17,"q":863,"e":103,"n":14671,"r":13792,"d":4151}},"charlie":{"rsa":{"p":79,"q":929,"e":60373,"n":73391,"r":72384,"d":13885}},"communication":[{"text":"University of London","encoded":[85,110,105,118,101,114,115,105,116,121,32,111,102,32,76,111,110,100,111,110]},{"encoded":[107065,52809,88507,154319,128497,125540,60910,88507,174328,53386,139715,2154,174967,139715,109212,2154,52809,168467,2154,52809]},{"text":"University of London :: intercepted","encoded":[85,110,105,118,101,114,115,105,116,121,32,111,102,32,76,111,110,100,111,110,32,58,58,32,105,110,116,101,114,99,101,112,116,101,100]},{"encoded":[70570,25473,24366,43521,60324,62759,2298,24366,9499,68636,51783,72628,69542,51783,243,72628,25473,37725,72628,25473,51783,20860,20860,51783,24366,25473,9499,60324,62759,33447,60324,42119,9499,60324,37725]},{"text":"University of London :: intercepted :: received"}]}
{"alice":{"rsa":{"p":313,"q":787,"e":33877,"n":246331,"r":245232,"d":59149}},"bob":{"rsa":{"p":73,"q":677,"e":43219,"n":49421,"r":48672,"d":45307}},"charlie":{"rsa":{"p":199,"q":461,"e":1601,"n":91739,"r":91080,"d":11321}},"communication":[{"text":"Hi Bob!","encoded":[72,105,32,66,111,98,33]},{"encoded":[229279,201403,88012,212789,165051,117839,160611]},{"text":"Hi Bob! :: intercepted","encoded":[72,105,32,66,111,98,33,32,58,58,32,105,110,116,101,114,99,101,112,116,101,100]},{"encoded":[15978,60926,18315,22440,8940,7688,18848,18315,50400,50400,18315,60926,78841,17711,14406,78215,70754,14406,58153,17711,14406,77814]},{"text":"Hi Bob! :: intercepted :: received"}]}
{"alice":{"rsa":{"p":313,"q":787,"e":103087,"n":246331,"r":245232,"d":126559}},"bob":{"rsa":{"p":157,"q":641,"e":29203,"n":100637,"r":99840,"d":48667}},"charlie":{"rsa":{"p":373,"q":977,"e":258845,"n":364421,"r":363072,"d":74933}},"communication":[{"text":"Hello World!","encoded":[72,101,108,108,111,32,87,111,114,108,100,33]},{"encoded":[48213,311218,150906,150906,187364,343442,170986,187364,166325,150906,245842,337141]},{"text":"Hello World! :: intercepted","encoded":[72,101,108,108,111,32,87,111,114,108,100,33,32,58,58,32,105,110,116,101,114,99,101,112,116,101,100]},{"encoded":[294580,181265,149385,149385,283553,136995,216187,283553,197484,149385,200153,290070,136995,251883,251883,136995,353286,60176,103884,181265,197484,143653,181265,251364,103884,181265,200153]},{"text":"Hello World! :: intercepted :: received"}]}
```

The first two lines are your name (in CamelCase) and your SRN. The following 3 lines are the outputs corresponding to the 3 input lines. To explain the output we'll look at the first two input-output pair in turn.

### First example

#### Input

This is the simplest input:

```json
{ "communication" : [ { "text" : "University of London" } ] }
```

Only the initial plain text is given: _University of London_. Nothing is given about  __Alice__, __Bob__ and __Charlie__, therefore _all_ their key-pairs have to be generated by you.

#### Possile output

Outputs will vary depending on what _p_, _q_ and _e_ values you have generated for __Alice__, __Bob__ and __Charlie__, but the correct format of the output is the following:    

```json
{
    "alice": {
        "rsa": { "p": 157, "q": 773, "e": 54703, "n": 121361, "r": 120432, "d": 87151 }
    },
    "bob": {
        "rsa": { "p": 59, "q": 941, "e": 12303, "n": 55519, "r": 54520, "d": 32447 }
    },
    "charlie": {
        "rsa": { "p": 223, "q": 941, "e": 138137, "n": 209843, "r": 208680, "d": 148673 }
    },
    "communication": [
        { "text": "University of London", "encoded": [85, 110, 105, 118, 101, 114, 115, 105, 116, 121, 32, 111, 102, 32, 76, 111, 110, 100, 111, 110] }, 
        { "encoded": [151949, 97345, 92116, 100345, 87441, 177085, 116675, 92116, 50469, 89969, 9459, 148491, 152971, 9459, 13937, 148491, 97345, 89405, 148491, 97345] },
        { "text": "University of London :: intercepted", "encoded": [85, 110, 105, 118, 101, 114, 115, 105, 116, 121, 32, 111, 102, 32, 76, 111, 110, 100, 111, 110, 32, 58, 58, 32, 105, 110, 116, 101, 114, 99, 101, 112, 116, 101, 100] },
        { "encoded": [172769, 123251, 52491, 2295, 160592, 157810, 56443, 52491, 161029, 131962, 199946, 141598, 192674, 199946, 122683, 141598, 123251, 7267, 141598, 123251, 199946, 115298, 115298, 199946, 52491, 123251, 161029, 160592, 157810, 197006, 160592, 206468, 161029, 160592, 7267] },
        { "text": "University of London :: intercepted :: received" }
    ]
}
```

__Important__: the actual output will be a single line, but a pretty-print is used in this description such that you can better understand what is expected.

* The ```rsa``` field will be generated / computed entirely by you.
* You will extract the initial message, encode it, push it back to the ```communication``` list and push all subsequent messages as the initial message gets sent, intercepted and received between __Alice__, __Bob__ and __Charlie__.
* For plain texts (non-encrypted), include the encoding; i.e. the message will have both the ```text``` and the ```encoded``` fields set.
* For encrypted texts, the encoded text suffices; i.e. the message will only have the ```encoded``` field set.
* The ```communication``` list will have to contain the trail of messages as the initial message travels from _Alice_ to _Bob_ and is intercepted by _Charlie_.
* _Alice_ thinks she is communicating with _Bob_, but is in fact communicating with __Charlie__, who decodes __Alice__'s message, slightly alters it (appends ' :: intercepted', for example) and sends it to __Bob__. __Bob__ will finally decode the message and marks it with ' :: received' before sending it back to _Alice_.
* Each message is doubly-encrypted: when __A__ sends a message to __B__, the message will be encrypted with __A__'s private key and __B__'s public key.
* Subsequently, the __B__ receives the message, it will have to be doubly-decrypted: with __B__'s private key and with __A__'s public key.
* You may have to pay attention to the ordering of the double encryption and the double decryption.

### Second example

#### Input

```json
{ "alice" : { "rsa" : { "p" : 313, "q" : 787 } }, "communication" : [ { "text" : "Hi Bob!" } ] }
```

The initial plain text is given: _Hi Bob!_. In addition __Alice__'s _p_ and _q_ pair is also given; _e_ will be generated by you. Nothing is said about __Bob__ and __Charlie__, therefore _all_ their key-pairs have to be generated by you.

#### Possile output

Outputs will vary depending on what _p_, _q_ and _e_ values you have generated for __Bob__ and __Charlie__ and what value have you picked for __Alice__'s _e_, but the correct format of the output is the following:    

```json
{
    "alice": { "rsa": { "p": 313, "q": 787, "e": 33877, "n": 246331, "r": 245232, "d": 59149 } },
    "bob": { "rsa": { "p": 73, "q": 677, "e": 43219, "n": 49421, "r": 48672, "d": 45307 } },
    "charlie": { "rsa": { "p": 199, "q": 461, "e": 1601, "n": 91739, "r": 91080, "d": 11321 } },
    "communication": [
        { "text": "Hi Bob!", "encoded": [72, 105, 32, 66, 111, 98, 33] },
        { "encoded": [229279, 201403, 88012, 212789, 165051, 117839, 160611] },
        {
            "text": "Hi Bob! :: intercepted",
            "encoded": [72, 105, 32, 66, 111, 98, 33, 32, 58, 58, 32, 105, 110, 116, 101, 114, 99, 101, 112, 116, 101, 100]
        },
        {
            "encoded": [15978, 60926, 18315, 22440, 8940, 7688, 18848, 18315, 50400, 50400, 18315, 60926, 78841, 17711, 14406, 78215, 70754, 14406, 58153, 17711, 14406, 77814]
        },
        { "text": "Hi Bob! :: intercepted :: received" }
    ]
}
```

__Important__: the actual output will be a single line, but a pretty-print is used in this description such that you can better understand what is expected.

### Help

* You may restrict _p_ and _q_ to be primes in the __(8, 1024)__ interval.
* Pick _e_ randomly such that it is co-prime with _r_ and compute _d_ accordingly.
* You can assume that the ```communication``` array initially always contains the plain text of the message that __Alice__ is to send to __Bob__ that will be intercepted by __Charlie__.
* To _encode_ plain texts (i.e. strings) to an array of integers that can be encrypted / decrypted, you may use the following functions (_Java 8_):

```java
public static int[] encode(String message) {
    ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
    return IntStream.generate(buffer::get).limit(buffer.remaining()).toArray();
}

public static String decode(int[] message) {
    return Arrays.stream(message).mapToObj(i -> (char) i).reduce(new StringBuilder(), (sb, c) -> sb.append(c), StringBuilder::append).toString();       
}
```      

* This splits the string to characters and uses their ASCII values.


## Submission

* Once you're happy with your code
  * rebuild your project, following the instructions in the [build](#build) section,
  * re-test your project, following the instructions in the [test](#test) section,
  * double-check that the output in the required format,
  * submit the ```target/FirstnameLastname-jar-with-dependencies.jar``` JAR file (which will obviously have your name in it, ex. if you're Jane Smith, the file will be ``JaneSmith-jar-with-dependencies.jar```).
  
### Important

__Only__ a JAR file, which uses the correct naming scheme and produces output in the described format will be looked at, and __only__ if it passes the automatic tests. A ZIPed project folder or individual Java or Class files will __not__ be looked at, and will be awarded a _0_ mark. If you correctly follow the description above, the JAR file you submit will contain the source code that you worked on and will give the marker the opportunity to check it, once your byte code passes the automatic execution phase.          

