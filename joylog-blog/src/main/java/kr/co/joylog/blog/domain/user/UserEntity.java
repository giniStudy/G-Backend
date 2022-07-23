package kr.co.joylog.blog.domain.user;

import javax.persistence.*;

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
@Builder
@AllArgsConstructor
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
    private String level;
    private String repository;
    private String loginState;
    private String githubName;
    private String imagePath;

    @CreatedDate
    private LocalDateTime createDatetime;
}
