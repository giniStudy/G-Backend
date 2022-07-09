package kr.co.joylog.blog.domain.user;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "user")

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    
    private String id;
    private String pw;
    private String name;
    private String nick_name;
    private String email;
    private String phon;
    private String level;
    private String repository;
    private String login_state;
    private String github_name;
    private String image_path;
    private String create_datetime;

    
    
    
    
    
    
    
    
    

	
    
}
