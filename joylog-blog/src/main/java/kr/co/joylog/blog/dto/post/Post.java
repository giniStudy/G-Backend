package kr.co.joylog.blog.dto.post;

import io.micrometer.core.instrument.Tags;
import kr.co.joylog.blog.domain.post.PostEntity;
import kr.co.joylog.blog.domain.tags.TagsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Post {

    public static Post of(PostEntity postEntity){
        return Post.builder()
                .seq(postEntity.getSeq())
                .userSeq(postEntity.getUserSeq())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .state(postEntity.getState())
                .lastUpdateDatetime(postEntity.getLastUpdateDatetime())
                .createDatetime(postEntity.getCreateDatetime())
                .tags(postEntity.getPostTagsRelation().stream().map(r -> r.getTag().getTag()).collect(Collectors.toList()))
                .build();
    }

    private Integer seq;
    private Integer userSeq;
    private String title;
    private String content;
    private String state;
    private LocalDateTime lastUpdateDatetime;
    private LocalDateTime createDatetime;

    private List<String> tags;
}
