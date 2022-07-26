package kr.co.joylog.blog.controller;

import kr.co.joylog.blog.domain.tag.TagEntity;
import kr.co.joylog.blog.dto.tag.ReqestTag;
import kr.co.joylog.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping("tag")
    public void postTag(@RequestBody ReqestTag reqestTag)
    {
        tagService.postTag(reqestTag);
    }

    // 매개 변수 List<ReqestTag>로 변경 필요.
    @PostMapping("taglist")
    public void postTagList(@RequestBody List<String> reqestTag)
    {
        tagService.postTagList(reqestTag);
    }
}
