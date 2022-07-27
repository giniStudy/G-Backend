package kr.co.joylog.blog.config.auth;

import kr.co.joylog.blog.domain.user.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserProfile {
    int seq;
    String loginType;
    String id;
    String name;
    String email;

    public static UserProfile from(UserEntity userEntity) {
        return UserProfile.builder()
                .seq(userEntity.getSeq())
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .build();
    }


    public Map<String, Object> convertToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("seq", seq);
        map.put("id", id);
        map.put("loginType", loginType);
        map.put("name", name);
        map.put("email", email);
        return map;
    }

    public static UserProfile from(Map<String, Object> map) {
        return UserProfile.builder()
                .id((String)map.get("id"))
                .name((String)map.get("name"))
                .email((String)map.get("email"))
                .loginType((String)map.get("loginType"))
                .build();
    }
}
