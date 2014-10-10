# Tasks - JDBC 

A project containing basic examples using Java Database Connectivity [JDBC](http://en.wikipedia.org/wiki/Java_Database_Connectivity). 
These are just examples for understanding JDBC workflow and basic API and should NOT be used in any production application. 
As some critical accepts of production environment, like connection pool, proper exception handling, etc. are not handled.

## Run

This project is managed with [Apache Maven](http://maven.apache.org/). 

To compile 

    mvn compile 

To clean and compile 

    mvn clean compile

To execute - 

    mvn exec:java -Dexec.mainClass="class-path-to-main"

Here, `class-path-to-main` is fully qualified class path to a class containing to `public static void main(String []args)` method.
For example, `edu.utd.dspl.InitialExample`, `edu.utd.dspl.tasks.PreparedStatementExample`, `edu.utd.dspl.tasks.TransactionExample`. 

In addition, this project can be directly executed from any modern IDE like Intellij IDEA, Eclipse, Netbeans, etc.   

## Reference 

- Official JDBC tutorial <http://docs.oracle.com/javase/tutorial/jdbc/basics/index.html>
- Official JDBC example <http://docs.oracle.com/javase/tutorial/jdbc/basics/examples/zipfiles/JDBCTutorial.zip>
