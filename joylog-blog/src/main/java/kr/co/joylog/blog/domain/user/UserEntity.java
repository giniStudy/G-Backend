package kr.co.joylog.blog.domain.user;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "user")
@Getter
@Setter
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
    private String createDatetime;

    
    
    
    
    
    
    
    
    

	
    
}
