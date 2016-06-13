package application.dto;

import org.springframework.stereotype.Component;

/**
 * Created by mj on 2/6/16.
 */
@Component
public class UserDto {
    private Long id;
    private String authToken;
    private Integer authority;

    public UserDto() {
    }

    public UserDto(Long id, String authToken, Integer authority) {
        this.id = id;
        this.authToken = authToken;
        this.authority = authority;

    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
