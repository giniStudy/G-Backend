package kr.co.joylog.blog.domain.target;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "target")
@Getter
@Setter
public class TargetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    private String  keyword;
    
    
    
    
    
    
    
    
    

	
    
}
