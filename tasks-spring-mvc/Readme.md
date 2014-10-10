#Task Spring MVC

An example spring mvc application managing tasks done for CS6360: Database Design class.

## Deploy in Tomcat 

    TODO

## Checking the application 

Assuming tomcat is running in `localhost` at `8080` port. Access the application at 
<http://localhost:8080/tasks-spring-mvc/>. 
Change host and port as necessary.


##Possible improvements

- Include a way to insert multiple items simultaneously
- Use AJAX for inserting and changing state of items
- Drag and drop for changing state of items 
- Re-Ordering items in a task 

##Ideas that these tutorials don't cover

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
