# Task Spring MVC

An example spring mvc application managing tasks done for CS6360: Database Design class.

## Deploy

To clean and compile

    gradle clean build

Run the web application with Jetty server

    gradle appRun

To access the running application visit <http://localhost:8002/tasks-spring-mvc>.
To run the application on a different port, e.g. `8080`.

    gradle appRun -Dport=8080


## Possible improvements

- Include a way to insert multiple items simultaneously
- Use AJAX for inserting and changing state of items
- Drag and drop for changing state of items
- Re-Ordering items in a task
