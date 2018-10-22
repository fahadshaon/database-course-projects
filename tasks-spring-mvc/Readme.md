# Task Spring MVC

An example spring mvc application managing tasks done for CS6360: Database Design class.
This is a standard [Spring Boot](https://spring.io/projects/spring-boot) application,
which is exactly structured like guides from <https://spring.io/guides>. 
Feel free to experiment with other guides.

## Download JavaScript dependencies 

We use `bower` <https://bower.io> to download dependencies

    cd src/main/resources/static
    bower install

## Deploy

To clean and compile

    gradle clean build

Run the web application 

    gradle bootRun 
    
Or 

    java -jar build/libs/tasks-sring-mvc-0.0.1.jar

The application can be accessed at <http://localhost:8080/> 
Note: in case of servlet deployment we built an war file and deployed with `contextPath`. 
Here spring boot is solo application deployed at ROOT context, so no addition.  

## Possible improvements

- Include a way to insert multiple items simultaneously
- Use AJAX for inserting and changing state of items
- Drag and drop for changing state of items
- Re-Ordering items in a task
