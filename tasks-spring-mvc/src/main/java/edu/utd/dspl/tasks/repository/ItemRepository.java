package edu.utd.dspl.tasks.repository;

import edu.utd.dspl.tasks.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
