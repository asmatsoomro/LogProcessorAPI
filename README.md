## Synopsis
The project takes the log file as input, processes it and returns the useful statistics about a log file e.g. number of warnings, errors, info and debugs
It also provides the list of warning logs and the list of error logs

## Installation
Please import the project as a Maven project and it is compatible with Java 1.8
To run the API, create your client that makes an instance of LogProcessor (located in com.processor package) and provide it a logfile located of specified location. 

The API will throw an NoInputProvidedException if empty or null value is provided and FileNotFoundException if the file is not located is specified location.

To merely test the API, run a main method located in com.main.LogStatisticsAnalyzer that takes the log file located in resources folder as an input and return the number of warnings, errors, info and debugs in a log file.
Main method inside com.main.LogWarningsFetcher would extract all the warning logs from a log file and display it on console
Main method inside com.main.LogErrorsFetcher would extract all the error logs from a log file and display it on console


## Tests
The test cases are located under com.test package and tests the relevant test case scenarios for logProcessor. The test file also use log file located in resources folder to test as an input.

Maven is used to import the dependency for JUnit

## Author
This API is authored by Asmat Soomro (soomro.asmat@gmail.com)