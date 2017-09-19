Code examples for CS6360 Database Design course. It contains following projects

1. **tasks-jdbc**
    - Implements interaction with database using JDBC
2. **tasks-spring**
    - Implements interaction with database using JdbcTemplate and usages DAO and Domain objects.
3. **servlet-jsp-hello-world**
    - Simple servlet and jsp project, demonstrating how to create web application
4. **tasks-spring-mvc**
    - Fully functional Spring MVC application for managing tasks and task-items.

Relevant presentation at <http://www.shaon.org/slides/mvc-and-spring.html>

## Requirements

- [Gradle](https://gradle.org/), project management and build tool

## Installing Gradle

There are several ways to install gradle in an operating system.
In general the process is *download*, *extract* and *setup environment variable*.

- Download tar/zip file from <https://gradle.org/releases/>
- Extract the tar/zip file
- Add the `bin` directory to environment variable.

More at - <https://gradle.org/install/>

## Database settings

- For database interacting projects like `tasks-jdbc`, `tasks-spring`, and `tasks-spring-mvc`,
    copy `src/main/resources/jdbc-sample.properties` to `src/main/resources/jdbc.properties`
    and fill up the four attributes.

## Build and Run

Project `tasks-jdbc` and `tasks-spring` are terminal based application. For these two

To build

    gradle build

To clean and build

    gradle clean build

To execute -

    gradle -q --console plain run -DmainClass="class-path-to-main"

Here, `class-path-to-main` is fully qualified class path to a class containing to `public static void main(String []args)` method.

For example executing `PreparedStatementExample` in `tasks-jdbc` project -

    $ cd tasks-jdbc
    $ gradle -q --console plain run -DmainClass="edu.utd.dspl.tasks.PreparedStatementExample"

Project `servlet-jsp-hello-world` and `tasks-spring-mvc` are web application.

To build `war` file, which can be deployed in any servlet container like Jetty to server the page.

    gradle clean build

To deploy

    gradle appRun

In addition, these projects can be directly executed from any modern IDE like Intellij IDEA, Eclipse, Netbeans, etc.

## Ideas that these examples don't cover

- Session
- Spring Security
- Property editor
- Logging
- Exception handling

## Versions

Following are the versions of different systems, which are used to build, deploy, and run these projects.

- Java - 1.8
- Gradle - 2.4.11
