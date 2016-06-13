package application.userdetailssection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by mj on 10/6/16.
 */
@Component
public class UserDAOImpl implements UserDAO {
    @Autowired
    FrontUserRepository frontUserRepository;

    @Override
    public UserDomain getUser(String username) {
        return frontUserRepository.findByUsername(username);
    }

    @Override
    public UserDomain save(UserDomain user) {
        return frontUserRepository.save(user);
    }

    @Override
    public UserDomain update(UserDomain user) {
        return save(user);
    }

    @Override
    public UserDomain get(Long id) {
        return frontUserRepository.findOne(id);
    }

    @Override
    public List<UserDomain> findAll() {
        return frontUserRepository.findAll();
    }

    @Override
    public long count() {
        return frontUserRepository.count();
    }
}
