package application.utils.authsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by mj on 1/6/16.
 */

@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class AuthenticationSecurity
        extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(domainUsernamePasswordAuthenticationProvider()).
//                authenticationProvider(backendAdminUsernamePasswordAuthenticationProvider()).
//        auth.authenticationProvider(tokenAuthenticationProvider());
        auth.userDetailsService(userDetailsService);
//        auth.inMemoryAuthentication().withUser("admin").password("admin")
//                .roles("ADMIN", "USER").and().withUser("user").password("user")
//                .roles("USER");
    }


}
