package kr.co.joylog.blog.domain.target;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "target")

public class TargetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    private String  keyword;
    
    
    
    
    
    
    
    
    

	
    
}
