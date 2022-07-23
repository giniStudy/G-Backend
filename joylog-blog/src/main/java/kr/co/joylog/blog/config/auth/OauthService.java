package kr.co.joylog.blog.config.auth;

import kr.co.joylog.blog.domain.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Slf4j
@Service
public class OauthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {


    UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService oauthService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oauthService.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration()
                .getRegistrationId(); // OAuth 서비스 이름(ex. github, google);
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName(); // OAuth 로그인 시 키(pk)가 되는 값

        log.info("oauth registrationId : {}", registrationId);
        log.info("oauth userNameAttributeName : {}", userNameAttributeName);
        Map<String, Object> attributes = oAuth2User.getAttributes();

        UserProfile userProfile = OAuthAttributes.extract(registrationId, attributes);

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                userProfile.convertToMap(), "email");
    }

    public UserProfile saveUser(UserProfile profile){
        return UserProfile.from(userRepository.save(profile.toUserEntity()));
    }

}
