package kr.co.joylog.blog.config.auth;

import kr.co.joylog.blog.dto.user.UserDefaultInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthFilter extends GenericFilterBean {

    private final TokenService tokenService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = ((HttpServletRequest)request).getHeader("Auth-Token");
        log.info("token info : {}", token);
        if (token != null && tokenService.verifyToken(token)) {
            UserDefaultInfo userDefaultInfo = tokenService.getBody(token);
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(userDefaultInfo));
            log.info("authtication : {}", token);
        } else if(token != null) {
            // TODO 토큰 만료 처리

            return ;
        }
        chain.doFilter(request, response);
    }

    public Authentication getAuthentication(UserDefaultInfo user) {
        return new UsernamePasswordAuthenticationToken(user, "",
                user.getRole().getAuthorities());
    }
}
