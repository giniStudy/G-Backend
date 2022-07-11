package kr.co.joylog.blog.domain.postTagsRelation;

import javax.persistence.*;

import kr.co.joylog.blog.domain.post.PostEntity;
import kr.co.joylog.blog.domain.tags.TagsEntity;
import kr.co.joylog.blog.domain.tags.TagsRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Table(name = "post_tags_relation")
@Getter
@Setter
public class PostTagsRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @ManyToOne
    @JoinColumn(name = "post_seq")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "tag_seq")
    private TagsEntity tag;
    
    
    
    
    
    
    
    
    
    
    

	
    
}
