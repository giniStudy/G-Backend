package kr.co.joylog.blog.controller;

import kr.co.joylog.blog.config.auth.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class LoginController {

    @GetMapping("/token")
    public Token loginTokenProvider(HttpSession session) {
        session.getAttribute("token");
        Token token = (Token) session.getAttribute("token");
        session.invalidate();
        return token;
    }
}
