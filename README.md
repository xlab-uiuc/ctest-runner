# Configuration Test (CTest) Runner

## What is CTest Runner?

CTest Runner is a specialized JUnit test runner designed to simplify the process of writing and executing configuration tests (ctests). 
It offers a range of annotations for defining a ctest and its expected outcomes, similar to parameterized tests. 
The runner executes ctests concurrently using configurations set by the user, ensuring the accuracy of these configurations. 
Additionally, CTest Runner features a ctest selection option, which enables the execution of only those ctests that utilize the specific configuration being tested to speed up the testing process.

## Download CTest Runner
### Build from source
```bash
$ git clone https://github.com/xlab-uiuc/ctest-runner.git && cd ctest-runner
$ mvn clean install
```

### Maven Central
Include the following dependency in your `pom.xml`:
For JUnit4:
```xml
<dependency>
    <groupId>edu.illinois</groupId>
    <artifactId>ctest-runner-junit4</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
For JUnit5:
```xml
<dependency>
    <groupId>edu.illinois</groupId>
    <artifactId>ctest-runner-junit5</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Quick Start
Please follow the [Guide to Get Started](example_with_hcommon.md) to run a simple example with CTest Runner.

Read the [Features & Options](Options.md) to learn more about all the features that CTest Runner supports.

## Supported Framework:
- [JUnit4](JUnit4.md): [Write and run ctest with JUnit4](write_and_run_ctest.md)
- [JUnit5](JUnit5.md) 
