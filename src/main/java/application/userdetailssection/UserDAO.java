package application.userdetailssection;

import java.util.List;

/**
 * Created by mj on 10/6/16.
 */
public interface UserDAO {
    UserDomain getUser(String username);

    UserDomain save(UserDomain user);

    UserDomain update(UserDomain user);

    UserDomain get(Long id);

    List<UserDomain> findAll();

    long count();
}
