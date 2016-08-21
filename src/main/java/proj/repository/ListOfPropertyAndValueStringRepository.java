package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.ListOfPropertyAndValueString;

/**
 * Created by SC on 10.08.2016.
 */
public interface ListOfPropertyAndValueStringRepository extends JpaRepository<ListOfPropertyAndValueString, Integer> {
}
