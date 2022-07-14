package kr.co.joylog.blog.dto.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class PageResponse <T>{
    private List<T> list;
    private int maxPage;
    private long totalCount;
    private int viewSize;
}
