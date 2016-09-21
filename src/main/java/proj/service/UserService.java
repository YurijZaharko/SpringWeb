package proj.service;

import proj.entity.User;

/**
 * Created by SCIP on 20.09.2016.
 */
public interface UserService {
    User findByLogin(String login);

    User findById(int id);

    void save(User user);
}
