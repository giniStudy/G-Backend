package kr.co.joylog.blog.domain.tags;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "tags")

public class TagsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    private String  tag;
    
    
    
    
    
    
    
    
    

	
    
}
