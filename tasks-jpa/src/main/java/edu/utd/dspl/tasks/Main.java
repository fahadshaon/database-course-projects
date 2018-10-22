package edu.utd.dspl.tasks;

import edu.utd.dspl.tasks.domain.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("edu.utd.dspl.tasks");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        try {
            List<Task> tasks = entityManager.createQuery("from Task", Task.class).getResultList();

            // We use HibernateQL (HQL) to query in Hibernate,
            // SQL Like syntax has some extra features relating Hibernate

            System.out.println("-------------");

            for (Task task : tasks) {
                System.out.println("Task: " + task.getTitle() + ", Items" + task.getItems().size());
            }

            System.out.println("-------------");

            entityManager.getTransaction().commit();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
