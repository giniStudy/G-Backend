package kr.co.joylog.blog.domain.postTagsRelation;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "post_tags_relation")

public class PostTagsRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    private Integer postSeq;
    private Integer tagSeq;
    
    
    
    
    
    
    
    
    
    
    

	
    
}
