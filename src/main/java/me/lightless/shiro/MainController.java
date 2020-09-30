package me.lightless.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    // 登录用户才能看的接口
    @GetMapping("/account/index")
    public String accountIndex() {
        return "Login Success.";
    }

    // 无需登录就能看的接口
    @GetMapping("/index")
    public String index() {
        return "Hello World!";
    }

    // 登录接口
    @GetMapping("/login")
    public String login(String username, String password) {
        if (username == null || password == null) {
            return "use username and password to login!";
        } else {
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(new UsernamePasswordToken(username, password));
                System.out.println("Login success!");
            } catch (AuthenticationException e) {
                System.out.println("login failed!");
            }
        }

        return "1";
    }


}
