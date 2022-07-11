package kr.co.joylog.blog.domain.tags;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "tags")
@Getter
@Setter
public class TagsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    private String  tag;
    
    
    
    
    
    
    
    
    

	
    
}
