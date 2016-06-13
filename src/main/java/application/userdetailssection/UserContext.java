package application.userdetailssection;

/**
 * Created by mj on 9/6/16.
 */


import application.enums.UserAuthoritiesEnum;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * This object wraps {link User} and makes it {@link UserDetails} so that Spring Security can use it.
 */
public class UserContext implements UserDetails {
    private Logger logger = LoggerFactory.getLogger(UserContext.class);

    private UserDomain user;

    public UserContext(UserDomain user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Integer> roles = new ArrayList<>();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            roles = objectMapper.readValue(user.getRoles(), new TypeReference<List<Integer>>() {
            });
        } catch (IOException e) {
            logger.debug("COuld not parse json : " + roles + "to list<int>");
        }
        roles.forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(UserAuthoritiesEnum.valueOf(role).description())));//TODO can have multiple authorities
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        return this == o
                || o != null && o instanceof UserContext
                && Objects.equals(user, ((UserContext) o).user);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(user);
    }

    @Override
    public String toString() {
        return "UserContext{" +
                "user=" + user +
                '}';
    }
}