package kr.co.joylog.blog.domain.postTagRelation;

import javax.persistence.*;

import kr.co.joylog.blog.domain.post.PostEntity;
import kr.co.joylog.blog.domain.tag.TagEntity;
import kr.co.joylog.blog.domain.tag.TagRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Table(name = "post_tag_relation")
@Getter
@Setter
public class PostTagRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @ManyToOne
    @JoinColumn(name = "post_seq")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "tag_seq")
    private TagEntity tag;
    
    
    
    
    
    
    
    
    
    
    

	
    
}
