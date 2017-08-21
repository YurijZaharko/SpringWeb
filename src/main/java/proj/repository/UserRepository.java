package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import proj.entity.User;

/**
 * Created by SCIP on 20.09.2016.
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    User findByLogin(String login);

    User findByPhoneNumber(String phoneNumber);
}
