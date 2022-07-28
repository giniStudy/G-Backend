package kr.co.joylog.blog.service;

import kr.co.joylog.blog.dto.user.UserDefaultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class LoginUtil {

    public static UserDefaultInfo getLoginUser() {
        log.info("login User : {}", SecurityContextHolder.getContext().getAuthentication());
        return (UserDefaultInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
