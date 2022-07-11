package kr.co.joylog.blog.domain.postTagsRelation;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "post_tags_relation")
@Getter
@Setter
public class PostTagsRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    private Integer postSeq;
    private Integer tagSeq;
    
    
    
    
    
    
    
    
    
    
    

	
    
}
