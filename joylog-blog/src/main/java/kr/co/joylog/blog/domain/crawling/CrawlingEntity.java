package kr.co.joylog.blog.domain.crawling;

import javax.persistence.*;

import lombok.Getter;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "crawling")
@Getter
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
