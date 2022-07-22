package kr.co.joylog.blog.controller;

import kr.co.joylog.blog.domain.tag.TagEntity;
import kr.co.joylog.blog.dto.tag.ReqestTag;
import kr.co.joylog.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping("tag")
    public void postTag(@RequestBody ReqestTag reqestTag)
    {
        tagService.postTag(TagEntity.from(reqestTag));
    }
}
