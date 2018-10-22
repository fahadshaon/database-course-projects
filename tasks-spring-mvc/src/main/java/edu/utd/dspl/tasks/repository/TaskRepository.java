package edu.utd.dspl.tasks.repository;

import edu.utd.dspl.tasks.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
