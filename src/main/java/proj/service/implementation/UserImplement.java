package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import proj.entity.Role;
import proj.entity.User;
import proj.form.Filter.UserFilterForm;
import proj.repository.UserRepository;
import proj.service.UserService;
import proj.service.implementation.specification.UserFilterAdapter;

import javax.annotation.PostConstruct;

/**
 * Created by SCIP on 20.09.2016.
 */
@Service("userDetailsService")
public class UserImplement implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public final User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public final User findById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable, UserFilterForm userFilterForm) {
        return userRepository.findAll(new UserFilterAdapter(userFilterForm), pageable);
    }

    @Override
    public final void save(User user) {
        if (user.getRole() == null){
            user.setRole(Role.ROLE_USER);
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if(user.getRegistrationDate() == null){
            user.createRegistrationDate();
        }
        userRepository.save(user);
    }

    @Override
    public final UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }

    @PostConstruct
    public final void saveAdmin() {
        User user = userRepository.findOne(1);
        if (user == null) {
            user = new User();
            user.setRole(Role.ROLE_ADMIN);
            user.setPassword(bCryptPasswordEncoder.encode("admin"));
            user.setLogin("scipgames@gmail.com");
            user.setId(1);
            user.createRegistrationDate();
            userRepository.save(user);
        }
    }
}
