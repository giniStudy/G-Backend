package kr.co.joylog.blog.domain.crawling;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "crawling")
@Getter
@Setter
public class CrawlingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    
    private Integer userSeq;
    private String  path;
    private String  nextStartDatetime;
    private String  lastCrawlingDatetime;
    private String  kind;
    
    
    
    
    
    
    
    
    
    

	
    
}
