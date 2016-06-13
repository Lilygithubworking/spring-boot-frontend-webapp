package application.services;

/**
 * Created by mj on 2/6/16.
 */

import application.constants.UrlConstants;
import application.enums.UserAuthoritiesEnum;
import application.userdetailssection.FrontUserRepository;
import application.userdetailssection.UserDomain;
import application.utils.JacksonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@Repository
public class UserDetailsServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private UrlConstants urlConstants;

    @Autowired
    JacksonUtils jacksonUtils;
    @Autowired
    private FrontUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserDomain user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
//        RequestResponseDTO requestResponseDTO = HttpUtils.postData(urlConstants.getAuthenticationUrl(),
//                username, "", "", RequestMethod.POST.toString());
//        UserDto userDto = (UserDto) requestResponseDTO.getData();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Integer> roles = new ArrayList<>();
        try {
            roles = objectMapper.readValue(user.getRoles(), new TypeReference<List<Integer>>() {
            });
        } catch (IOException e) {
            logger.debug("COuld not parse json : " + roles + "to list<int>");
        }

        roles.forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(UserAuthoritiesEnum.valueOf(role).description())));//TODO can have multiple authorities
        UserDetails userDetails = new User(String.valueOf(user.getUsername()),
                user.getPassword(), true, true, true, true, grantedAuthorities);
        return userDetails;
    }


}
