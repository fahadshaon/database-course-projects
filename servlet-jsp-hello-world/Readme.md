# Servlet JSP Hello World

An example java web application containing example Servlet and JSP.

## Deploy

To clean and compile

    gradle clean build

Run the web application with Jetty server

    gradle appRun

To access the running application visit <http://localhost:8001/servlet-jsp-hello-world>.
To run the application on a different port, e.g. `8080`.

    gradle appRun -Dport=8080
