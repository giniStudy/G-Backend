package kr.co.joylog.blog.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.joylog.blog.dto.user.UserDefaultInfo;
import kr.co.joylog.blog.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final TokenService tokenService;
    private final UserLoginService userLoginService;
    private final HttpSession session;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();

        log.info("Principal에서 꺼낸 OAuth2User = {}", oAuth2User);
        String loginType = (String)oAuth2User.getAttributes().get("loginType");
        UserProfile userProfile = UserProfile.from(oAuth2User.getAttributes());

        // 최초 로그인이라면 회원가입 처리를 한다.
        UserDefaultInfo userDefaultInfo = userLoginService.loginOrCreateUser(userProfile);
        Token token = tokenService.generateToken(userDefaultInfo);

        log.info("token : {}", token);

        String targetUrl = UriComponentsBuilder.fromUriString("/token")
                .build().toUriString();

        session.setAttribute("token", token);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
