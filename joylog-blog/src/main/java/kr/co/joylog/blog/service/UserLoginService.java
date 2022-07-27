package kr.co.joylog.blog.service;

import kr.co.joylog.blog.config.auth.UserProfile;
import kr.co.joylog.blog.domain.user.UserEntity;
import kr.co.joylog.blog.domain.user.UserRepository;
import kr.co.joylog.blog.dto.user.UserDefaultInfo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@RequiredArgsConstructor
@Service
public class UserLoginService {
    UserRepository userRepository;


    public UserDefaultInfo loginOrCreateUser(UserProfile userProfile) {
        UserEntity userEntity = userRepository.findByEmail(userProfile.getEmail())
                .orElseGet(() -> userRepository.save(UserEntity.createUser(userProfile)));
        return UserDefaultInfo.from(userEntity);
    }

}
