package kr.co.joylog.blog.service;

import kr.co.joylog.blog.config.auth.UserProfile;
import kr.co.joylog.blog.domain.user.UserEntity;
import kr.co.joylog.blog.domain.user.UserRepository;
import kr.co.joylog.blog.dto.user.UserDefaultInfo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class UserLoginService {
    UserRepository userRepository;


    public UserDefaultInfo loginOrCreateUser(UserProfile userProfile) {
        log.debug("userProfile : {}", userProfile.getEmail());
        UserEntity userEntity = userRepository.findByEmail(userProfile.getEmail())
                .orElseGet(() -> userRepository.save(UserEntity.createUser(userProfile)));
        log.debug("UserDefaultInfo : {}", UserDefaultInfo.from(userEntity));
        return UserDefaultInfo.from(userEntity);
    }

}
