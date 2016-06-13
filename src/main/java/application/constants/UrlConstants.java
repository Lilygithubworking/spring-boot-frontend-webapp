package application.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by mj on 31/5/16.
 */
@Component
public class UrlConstants {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    private String TEST_BACKEND_URL;
    private String AUTHENTICATION_URL;
    private String ADMIN_DETAILS_URL;

    public String getAuthenticationUrl() {
        return AUTHENTICATION_URL;
    }

    public String getTestBackendUrl() {
        return TEST_BACKEND_URL;
    }


    @PostConstruct
    public void init() {
        TEST_BACKEND_URL = backendServerUrl + "/user/dummy/url/test";
        AUTHENTICATION_URL = backendServerUrl + "/user/authenticate";
        ADMIN_DETAILS_URL = backendServerUrl + "/user/adminDetails";
    }

}
