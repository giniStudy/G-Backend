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
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthFilter extends GenericFilterBean {

    private final TokenService tokenService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = ((HttpServletRequest)request).getHeader("Authorization");

        log.info("token info : {}", token);
        Optional.ofNullable(token)
                .map(t -> t.substring(7))
                .filter(tokenService::verifyToken)
                .ifPresent( t -> {
                    UserDefaultInfo userDefaultInfo = tokenService.getBody(t);
                    SecurityContextHolder.getContext().setAuthentication(getAuthentication(userDefaultInfo));
                });
        chain.doFilter(request, response);
    }

    public Authentication getAuthentication(UserDefaultInfo user) {
        log.debug("user authrities : {}", user.getRole().getAuthorities());
        return new UsernamePasswordAuthenticationToken(user, "",
                user.getRole().getAuthorities());
    }
}
