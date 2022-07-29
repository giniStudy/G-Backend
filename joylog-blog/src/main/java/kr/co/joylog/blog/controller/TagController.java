package kr.co.joylog.blog.controller;

import kr.co.joylog.blog.domain.postTagRelation.PostTagRelationEntity;
import kr.co.joylog.blog.domain.tag.TagEntity;
import kr.co.joylog.blog.dto.tag.ReqestTag;
import kr.co.joylog.blog.service.PostTagRelationService;
import kr.co.joylog.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TagController {

    @Autowired
    TagService tagService;
    
    @Autowired
    PostTagRelationService postTagRelationService;

    @PostMapping("/tag")
    public void postTag(@RequestBody ReqestTag reqestTag)
    {
        tagService.postTag(reqestTag);
    }

    // 매개 변수 List<ReqestTag>로 변경 필요.
    @PostMapping("/taglist")
    public void postTagList(@RequestBody List<String> reqestTag)
    {
        tagService.postTagList(reqestTag);
    }
    
    @GetMapping("/preview/tag")
    public List<String> getPreviewTag()
    {
    	List<PostTagRelationEntity> postTagRelationEntitieList = postTagRelationService.getAllPostTagRelationEntityList();
    	List<String> allTagList = new ArrayList<String>();
    	for(PostTagRelationEntity tag : postTagRelationEntitieList)
    		allTagList.add(tag.getTag().getTag());
    	
    	return allTagList.stream().distinct().collect(Collectors.toList());
    }
}
