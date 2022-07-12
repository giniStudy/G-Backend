package kr.co.joylog.blog.domain.post;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

import kr.co.joylog.blog.domain.postTagsRelation.PostTagsRelationEntity;
import kr.co.joylog.blog.domain.tags.TagsEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Setter
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    private Integer userSeq;
    private String  title;
    private String  content;
    private String  state;
    private LocalDateTime lastUpdateDatetime;
    private LocalDateTime createDatetime;
    private String  level;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private List<PostTagsRelationEntity> postTagsRelation;
}
