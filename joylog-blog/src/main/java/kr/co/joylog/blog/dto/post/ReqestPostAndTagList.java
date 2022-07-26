package kr.co.joylog.blog.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ReqestPostAndTagList {

    private Integer userSeq;
    private String title;
    private String content;

    private List<String> tag;
}
