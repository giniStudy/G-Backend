package kr.co.joylog.blog.domain.post;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

import kr.co.joylog.blog.domain.postTagRelation.PostTagRelationEntity;
import kr.co.joylog.blog.domain.tag.TagEntity;
import kr.co.joylog.blog.dto.post.Post;
import kr.co.joylog.blog.dto.post.ReqestPost;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "post")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class) // create dateTime 문제 해결.
public class PostEntity {
    public static PostEntity from(ReqestPost reqestPost){
        LocalDateTime nowDateTime = LocalDateTime.now();
        return PostEntity.builder()
                .userSeq(reqestPost.getUserSeq())
                .title(reqestPost.getTitle())
                .content(reqestPost.getContent())
                .state("일반")
                .level("일반")
                .build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    private Integer userSeq;
    private String  title;
    private String  content;
    private String  state;
    private String  level;

    @LastModifiedDate
    private LocalDateTime lastUpdateDatetime; // 마지막 수정 시간
    @CreatedDate
    private LocalDateTime createDatetime;     // 생성 시간

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private List<PostTagRelationEntity> postTagsRelation;
}
