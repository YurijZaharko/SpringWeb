package proj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.entity.User;
import proj.form.Filter.UserFilterForm;

/**
 * Created by SCIP on 20.09.2016.
 */
public interface UserService {
    User findByLogin(String login);

    User findById(int id);

    Page<User> findAll(Pageable pageable, UserFilterForm userFilterForm);

    void save(User user);
}
