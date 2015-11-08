# Tasks Spring 

An example spring application managing tasks done for CS6360: Database Design class.
 
## Run

First make a copy of `src/main/resources/jdbc-sample.properties` to `src/main/resources/jdbc.properties`
and fill up four attributes. Then, 

To compile 

    mvn compile 

To clean and compile 

    mvn clean compile

To execute - 

    mvn exec:java -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="edu.utd.dspl.tasks.Main"

