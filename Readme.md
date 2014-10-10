Code examples for CS6360 Database Design course. It contains following projects 

1. **tasks-jdbc** 
    - Implements interaction with database using JDBC
2. **tasks-spring** 
    - Implements interaction with database using JdbcTemplate and usages DAO and Domain objects.
3. **servlet-jsp-hello-world** 
    - Simple servlet and jsp project, demonstrating how to create web application
4. **tasks-spring-mvc**
    - Fully functional Spring MVC application for managing tasks and task-items.  
    
## Requirements 

- [Apache Maven](http://maven.apache.org/), project management and build tool
- [Apache Tomcat](http://tomcat.apache.org/), servlet container for deploying web application

## Installing Maven 
    
Refer to <http://maven.apache.org/download.cgi#Installation>. 
Generally the process is simply extract the compressed binary file and setup few environment variables.   

## Installing Tomcat 

Refer to <http://tomcat.apache.org/tomcat-7.0-doc/setup.html#Introduction>.
Generally the process is simply extract the compressed binary file, setup few environment variables, 
assign ports those are not used, and run the startup script.

### Configuring Tomcat

As we are going to deploy our web applications via maven, we need to change few configurations. For `tomcat`
version `7.x`, add the following in `$TOMCAT_HOME/conf/tomcat-users.xml` in `<tomcat-users>` tag.

    <role rolename="manager-gui"/>
    <role rolename="manager-script"/>
    <user username="tomcat" password="tomcat" roles="manager-gui, manager-script"/>

This will create a manager user with name `tomcat` and password `tomcat`. 

### Pre processing for building code  
 
- For database interacting projects like `tasks-jdbc`, `tasks-spring`, and `tasks-spring-mvc`, 
    copy `src/main/resources/jdbc-sample.properties` to `src/main/resources/jdbc.properties` 
    and fill up four attributes. 
    
- For web applications like `tasks-spring-mvc` and `servlet-jsp-hello-world` 
     copy `tomcat-sample.properties` to `tomcat.properties` and fill up all the variables. For example  
      
        tomcat.username=tomcat
        tomcat.password=tomcat
        tomcat.manager_url=http://localhost:8080/manager/text

## Build and Run 

Project `tasks-jdbc` and `tasks-spring` are terminal based application. For these two 

To compile 

    mvn compile 

To clean and compile 

    mvn clean compile

To execute - 

    mvn exec:java -Dexec.mainClass="class-path-to-main"  -Dexec.args="arg0 arg1 arg2"
 
Here, `class-path-to-main` is fully qualified class path to a class containing to `public static void main(String []args)` method.
and `arg0 arg1 arg2` are arguments passed to main method. 

For example executing `PreparedStatementExample` in `tasks-jdbc` project -  

    $ cd tasks-jdbc
    $ mvn exec:java -Dexec.mainClass="edu.utd.dspl.tasks.PreparedStatementExample" 


Project `servlet-jsp-hello-world` and `tasks-spring-mvc` are web application.
 
To clean and compile 

    mvn clean compile

To build `war` file 

    mvn package 
    
To deploy, (assuming tomcat is configured properly)  

    mvn tomcat:deploy 

To undeploy, (assuming tomcat is configured properly)

    mvn tomcat:undeploy
    

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
