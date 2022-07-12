package kr.co.joylog.blog.dto.tags;

import kr.co.joylog.blog.domain.tag.TagEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Tag {

    public static Tag of(TagEntity tagsEntity){
        return Tag.builder()
                .seq(tagsEntity.getSeq())
                .tag(tagsEntity.getTag())
                .build();
    }

    private Integer seq;
    private String tag;
}
