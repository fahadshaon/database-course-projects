# Servlet JSP Hello World 

An example java web application containing example Servlet and JSP.

## Deploy


To clean and compile 

    mvn clean compile 
    
To deploy the web application in Tomcat-7.x. Setup and run the tomcat as described in
top level readme file and run

    mvn tomcat7:deploy
 
After a successful deploy you should be able to view the web application at 
<http://localhost:8080/servlet-jsp-hello-world/>.
(Assuming tomcat is running in `localhost` at `8080` port.
Change host and port as necessary.)

