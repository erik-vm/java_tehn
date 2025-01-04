package controller;

import com.nimbusds.oauth2.sdk.http.HTTPResponse;
import dao.UserDao;
import jakarta.servlet.http.HttpSession;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/version")
    public int version() {
        return HTTPResponse.SC_OK;
    }



    @GetMapping("/users/{username}")
    public User getUserByName(@PathVariable("username") String username) {
        return new UserDao().getUserByUserName(username);
    }
}