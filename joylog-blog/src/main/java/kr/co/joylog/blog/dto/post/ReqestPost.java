package kr.co.joylog.blog.dto.post;

import kr.co.joylog.blog.domain.post.PostEntity;
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
public class ReqestPost {

    private Integer userSeq;
    private String title;
    private String content;
}
