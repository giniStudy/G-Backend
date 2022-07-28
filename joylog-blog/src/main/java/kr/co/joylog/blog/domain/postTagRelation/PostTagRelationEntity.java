package kr.co.joylog.blog.domain.postTagRelation;

import javax.persistence.*;

import kr.co.joylog.blog.domain.post.PostEntity;
import kr.co.joylog.blog.domain.tag.TagEntity;
import kr.co.joylog.blog.domain.tag.TagRepository;
import kr.co.joylog.blog.dto.tag.ReqestTag;
import kr.co.joylog.blog.service.PostTagRelationService;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post_tag_relation")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostTagRelationEntity {
    public static List<PostTagRelationEntity> from(PostEntity pPost, List<TagEntity> pTag){
        List<PostTagRelationEntity> postTagRelationEntityList = new ArrayList<PostTagRelationEntity>();

        for(int i = 0; i < pTag.size(); i++)
        {
            postTagRelationEntityList.add(PostTagRelationEntity.from(pPost, pTag.get(i)));
         }

        return postTagRelationEntityList;
    }
    
    public static PostTagRelationEntity from(PostEntity pPost, TagEntity pTag){
        return PostTagRelationEntity
        		.builder()
        		.post(pPost)
        		.tag(pTag)
        		.build();
    }
    
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
