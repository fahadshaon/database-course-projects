# Tasks - JDBC

A project containing basic examples using Java Database Connectivity [JDBC](http://en.wikipedia.org/wiki/Java_Database_Connectivity).
These are just examples for understanding JDBC workflow and basic API and should NOT be used in any production application.
As some critical accepts of production environment, like connection pool, proper exception handling, etc. are not handled.

## Run

To build

    gradle build

To clean and compile

    gradle clean build

To execute -

    gradle run -DmainClass="class-path-to-main"

Here, `class-path-to-main` is fully qualified class path to a class containing to `public static void main(String []args)` method.
For example -

    gradle run -DmainClass="edu.utd.dspl.InitialExample"
    gradle -q --console plain run -DmainClass="edu.utd.dspl.tasks.PreparedStatementExample"
    gradle -q --console plain run -DmainClass="edu.utd.dspl.tasks.TransactionExample"

Here, `-q` sets the logging level of gradle to `QUITE`
and `--console plain` sets the console level to plain console.
Combination of these two sets stops gradle related information in between user input.
More at <https://docs.gradle.org/current/userguide/gradle_command_line.html>

## Reference

- Official JDBC tutorial <http://docs.oracle.com/javase/tutorial/jdbc/basics/index.html>
- Official JDBC example <http://docs.oracle.com/javase/tutorial/jdbc/basics/examples/zipfiles/JDBCTutorial.zip>
