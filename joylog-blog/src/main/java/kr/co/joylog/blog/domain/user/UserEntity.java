package kr.co.joylog.blog.domain.user;

import javax.persistence.*;

import kr.co.joylog.blog.config.auth.UserProfile;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    
    private String id;
    private String pw;
    private String name;
    private String nickName;
    private String email;
    private String phon;
    @Enumerated(EnumType.STRING)
    private AdminRoleType level;
    private String repository;
    private String loginState;
    private String githubName;
    private String imagePath;

    @CreatedDate
    private LocalDateTime createDatetime;

    public static UserEntity createUser(UserProfile userProfile) {
        return UserEntity.builder()
                .id(userProfile.getId())
                .email(userProfile.getEmail())
                .pw("lsadflksdajf")
                .name(userProfile.getName())
                .loginState(userProfile.getLoginType())
                .level(AdminRoleType.DEFAULT)
                .build();
    }
}
