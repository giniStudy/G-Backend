package kr.co.joylog.blog.domain.post;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "post")
@Getter
@Setter
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    private Integer userSeq;
    private String  title;
    private String  content;
    private String  state;
    private String  lastUpdateDatetime;
    private String  createDatetime;
    private String  level;
    
    
    
    
    
    
    
    
    
    

	
    
}
