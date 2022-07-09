package kr.co.joylog.blog.domain.news;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "news")

public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    private Integer crawlingSeq;
    private Integer targetSeq;
    private String title;
    private String content;
    private String state;
    private String path;
    private String lastUpdateDatetime;
    private String createDatetime;
    private String level;
    
    
    
    
    
    
    
    
    

	
    
}
