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

- [Apache Maven](http://maven.apache.org/), project management and build tool
- [Apache Tomcat](http://tomcat.apache.org/), servlet container for deploying web application

## Installing Maven 

There are several ways to install maven in an operating system. 
In general the process is *download*, *extract* and *setup environment variable*.

- Download tar/zip file from <http://maven.apache.org/download.cgi>
- Extract the tar/zip file 
- Add the `bin` directory to environment variable. 
    Refer to <http://maven.apache.org/install.html> for further detail.    

## Installing Tomcat 


- Download Apache Tomcat 7.x.x from <https://tomcat.apache.org/download-70.cgi>.
    **For this tutorial please use Tomcat 7.x.x. Other versions of tomcat are not supported 
    by the tomcat deploy plugin yet!**
    
- Extract the tar/zip file. (This extracted folder is referred as `$TOMCAT_HOME` later on) 
- To run the server simply start `$TOMCAT_HOME/bin/startup.sh` script (in Linux or Mac OS X) or start 
    `$TOMCAT_HOME/bin/startup.bat` script (in windows).

- To shutdown run `$TOMCAT_HOME/bin/shutdown.sh` script (in Linux or Mac OS X) or start 
    `$TOMCAT_HOME/bin/shutdown.bat` script (in windows).
    
- Server logs are generated in `$TOMCAT_HOME/logs/catalina.out` file.
 
Refer to <http://tomcat.apache.org/tomcat-7.0-doc/setup.html#Introduction>.


### Configuring Tomcat

As we are going to deploy our web applications via maven, we need to change few configurations. 
Add the following in `$TOMCAT_HOME/conf/tomcat-users.xml` in `<tomcat-users>` tag.

    <role rolename="manager-gui"/>
    <role rolename="manager-script"/>
    <user username="tomcat" password="tomcat" roles="manager-gui, manager-script"/>

This will create a manager user with name `tomcat` and password `tomcat`.
Now stop and start the Tomcat server again. 

### Maven settings for tomcat server
 
Save the following into `$HOME/.m2/settings.xml`, where `$HOME` stands for the user home in operating system.
  
    <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                  http://maven.apache.org/xsd/settings-1.0.0.xsd">
        <servers>
            <server>
                <id>tomcat-localhost</id>
                <username>tomcat</username>
                <password>tomcat</password>
            </server>
        </servers>
    
        <profiles>
            <profile>
                <id>local-tomcat</id>
                <activation>
                    <activeByDefault>true</activeByDefault>
                </activation>
                <properties>
                    <tomcat.deploy.url>http://localhost:8080/manager/text</tomcat.deploy.url>
                </properties>
            </profile>
        </profiles>
    </settings>
 

If system's `settings.xml` already has other contents, please adjust accordingly.

## Database settings   
 
- For database interacting projects like `tasks-jdbc`, `tasks-spring`, and `tasks-spring-mvc`, 
    copy `src/main/resources/jdbc-sample.properties` to `src/main/resources/jdbc.properties` 
    and fill up four attributes. 

## Build and Run
 
Project `tasks-jdbc` and `tasks-spring` are terminal based application. For these two 

To compile 

    mvn compile 

To clean and compile 

    mvn clean compile

To execute - 

    mvn exec:java -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="class-path-to-main"  -Dexec.args="arg0 arg1 arg2"
 
Here, `class-path-to-main` is fully qualified class path to a class containing to `public static void main(String []args)` method.
and `arg0 arg1 arg2` are arguments passed to main method. 

For example executing `PreparedStatementExample` in `tasks-jdbc` project -  

    $ cd tasks-jdbc
    $ mvn exec:java -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="edu.utd.dspl.tasks.PreparedStatementExample" 


Project `servlet-jsp-hello-world` and `tasks-spring-mvc` are web application.
 
To clean and compile 

    mvn clean compile

To build `war` file, which can be deployed in any servlet container like Tomcat to 
server the page.

    mvn package 
    
To deploy, (assuming tomcat is configured properly)  

    mvn tomcat7:deploy 


In addition, this project can be directly executed from any modern IDE like Intellij IDEA, Eclipse, Netbeans, etc.
    
## Ideas that these examples don't cover

- Session 
- Spring Security 
- Property editor 
- Logging 
- Exception handling

## Common problems with spring and tomcat
 
*Problem:* Ran out of permgen space, getting exception.

`org.springframework.web.util.NestedServletException: Handler processing failed; nested exception is java.lang.OutOfMemoryError: PermGen space`

*Solution:*

Increase permgen space of tomcat. Add the following system variable or add the following line in `catalina.sh` of Apache Tomcat. 

    CATALINA_OPTS="-Xmx1024m -XX:MaxPermSize=512m"



## Versions 
 
Following are the versions of different systems, which are used to build, deploy, and run these projects.   

- Java - 1.7.0_71
- Apache Maven - 3.3.3
- Apache Tomcat - 7.0.65
