package application.utils.authsecurity.token;

import application.exceptions.NoSuchUserException;
import application.userdetailssection.UserDAO;
import application.userdetailssection.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * Created by mj on 10/6/16.
 */
@Component
public class TokenUtils {
    @Autowired
    private UserDAO userDAO;

    public static String generateToken() {
        byte[] tokenBytes = new byte[32];
        new SecureRandom().nextBytes(tokenBytes);
        return new String(Base64.encode(tokenBytes), StandardCharsets.UTF_8);
    }

    public String getAuthTokenForUser(String userName) throws NoSuchUserException {
        UserDomain user = userDAO.getUser(userName);
        if (user != null) {
            return user.getAuthToken();
        } else {
            throw new NoSuchUserException("No Such user!");
        }
    }


    public String getTokenToBeSent() throws NoSuchUserException {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String authToken = getAuthTokenForUser(userDetails.getUsername());
        String password = userDetails.getPassword();
        return authToken;//TODO will be enhanced later
    }
}
