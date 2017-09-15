# Tasks Spring

An example spring application managing tasks done for CS6360: Database Design class.

## Run

First make a copy of `src/main/resources/jdbc-sample.properties` to `src/main/resources/jdbc.properties`
and fill up the four attributes. Then,

To build

    gradle build

To clean and build

    gradle clean build

To execute

    gradle run -q --console plain
