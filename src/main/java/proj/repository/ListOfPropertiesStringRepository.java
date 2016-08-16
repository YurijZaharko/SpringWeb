package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.ListOfPropertiesString;

/**
 * Created by SC on 10.08.2016.
 */
public interface ListOfPropertiesStringRepository extends JpaRepository<ListOfPropertiesString, Integer> {
}
