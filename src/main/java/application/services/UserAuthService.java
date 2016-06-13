package application.services;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by mj on 8/6/16.
 */
public interface UserAuthService {
    UserDetails loadUserByUsernameAndPassword(String userName, String password);
}
