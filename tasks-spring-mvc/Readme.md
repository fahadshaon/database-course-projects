#Task Spring MVC

An example spring mvc application managing tasks done for CS6360: Database Design class.

## Deploy

To clean and compile 

    mvn clean compile 
    
To deploy the web application in Tomcat-7.x. Setup and run the tomcat as described in
top level readme file and run

    mvn tomcat7:deploy
 
After a successful deploy you should be able to view the web application at 
<http://localhost:8080/tasks-spring-mvc/>.
(Assuming tomcat is running in `localhost` at `8080` port.
Change host and port as necessary.)


##Possible improvements

- Include a way to insert multiple items simultaneously
- Use AJAX for inserting and changing state of items
- Drag and drop for changing state of items 
- Re-Ordering items in a task 

