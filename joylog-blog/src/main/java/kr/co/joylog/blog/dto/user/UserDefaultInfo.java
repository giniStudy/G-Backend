package kr.co.joylog.blog.dto.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.joylog.blog.domain.user.AdminRoleType;
import kr.co.joylog.blog.domain.user.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class UserDefaultInfo {
    int seq;
    String email;
    AdminRoleType role;

    public static UserDefaultInfo from(UserEntity userEntity) {
        return UserDefaultInfo.builder()
                .seq(userEntity.getSeq())
                .email(userEntity.getEmail())
                .role(userEntity.getLevel())
                .build();
    }

    public Map<String, Object> toMap() {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.convertValue(this, Map.class);
        for(String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        return map;
    }
}
