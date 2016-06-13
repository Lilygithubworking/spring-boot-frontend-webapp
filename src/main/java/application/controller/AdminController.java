package application.controller;

import application.constants.UrlConstants;
import application.dto.RequestResponseDTO;
import application.exceptions.NoSuchUserException;
import application.utils.HttpUtils;
import application.utils.TestClass;
import application.utils.authsecurity.token.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by mj on 31/5/16.
 */
@Controller
public class AdminController {
    @Autowired
    private UrlConstants urlConstants;
    @Autowired
    private TokenUtils tokenUtils;

    @RequestMapping("/admin")
    @Secured("ROLE_ADMIN")
    public String home(Map<String, Object> model) throws NoSuchUserException, IOException {
        String tokenTOBeSent = tokenUtils.getTokenToBeSent();
        RequestResponseDTO response = HttpUtils.postData(urlConstants.getAuthenticationUrl(), tokenTOBeSent, RequestMethod.POST.toString(), new TestClass(1));
        System.out.println("response = " + response);
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());
        model.put("responseTxt", response);
        return "home";
    }

}
