# Tasks - JPA

Sample project to read and write data using Java Persistence API (JPA) and Hibernate Object Relational Mapping (ORM).
We use this approach because it makes our life easier. We don't need to explicitly handle column to class attribute mapping.

## Run

First make a copy of `src/main/resources/META-INF/persistence.xml-sample` to `src/main/resources/META-INF/persistence.xml`
and fill up the four attributes. Then,

To build

    gradle build

To clean and compile

    gradle clean build

To execute -

    gradle run 
    
## Reference

- Hibernate Tutorial <https://docs.jboss.org/hibernate/orm/current/quickstart/html_single/>
- Official JPA docs <https://docs.oracle.com/javaee/6/tutorial/doc/bnbqa.html>
