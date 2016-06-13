package application.utils.authsecurity.token;

import java.util.Collection;
import java.util.Map;
/**
 * Created by mj on 9/6/16.
 */


import org.springframework.security.core.userdetails.UserDetails;

public interface TokenManager {

    TokenInfo createNewToken(UserDetails userDetails);

    /**
     * Removes all tokens for user.
     */
    void removeUserDetails(UserDetails userDetails);

    /**
     * Removes a single token.
     */
    UserDetails removeToken(String token);

    /**
     * Returns user details for a token.
     */
    UserDetails getUserDetails(String token);

    /**
     * Returns a collection with token information for a particular user.
     */
    Collection<TokenInfo> getUserTokens(UserDetails userDetails);

    /**
     * Returns a map from valid tokens to users.
     */
    Map<String, UserDetails> getValidUsers();
}
