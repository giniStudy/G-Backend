package kr.co.joylog.blog.controller;

import kr.co.joylog.blog.config.auth.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @GetMapping("/token")
    public Token loginTokenProvider(HttpSession session) {
        log.debug("token: {}", session.getAttribute("token"));
        Token token = (Token) session.getAttribute("token");
        log.debug("token: {}", token);
        session.invalidate();
        return token;
    }

    @GetMapping("/token/expire")
    public ResponseEntity<?> loginTokenProvider() {
        Map<String, String> map = new HashMap<>();
        map.put("error", "not_found_token");
        return new ResponseEntity(map, HttpStatus.UNAUTHORIZED);
    }
}
