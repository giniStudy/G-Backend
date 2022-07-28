package kr.co.joylog.blog.controller;


import java.util.List;

import kr.co.joylog.blog.domain.postTagRelation.PostTagRelationEntity;
import kr.co.joylog.blog.domain.tag.TagEntity;
import kr.co.joylog.blog.dto.post.Post;
import kr.co.joylog.blog.dto.post.ReqestPost;
import kr.co.joylog.blog.dto.post.ReqestPostAndTagList;
import kr.co.joylog.blog.dto.util.PageResponse;
import kr.co.joylog.blog.service.PostTagRelationService;
import kr.co.joylog.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import kr.co.joylog.blog.domain.post.PostEntity;
import kr.co.joylog.blog.domain.post.PostRepository;
import kr.co.joylog.blog.service.PostService;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    TagService tagService;

    @Autowired
    PostTagRelationService postTagRelationService;

    /*
    @GetMapping("")
    public PostEntity test() {
        return postService.createPost("test!!!");
    }
    */
    @GetMapping("/all")
    public List<PostEntity> findAll() {
        return postService.findAll();
    }


    @GetMapping("/post")
    public PageResponse<Post> getPostList(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size) {
        return postService.getPostList(page, size);
    }

    @GetMapping("/postdetail")
    public Post getPostDetail(
            @RequestParam(defaultValue = "0", required = false) int seq) {

        return postService.getPostDetail(seq);
    }

    @PostMapping("/post")
    public void postPost(@RequestBody ReqestPost reqestPost)
    {
        postService.postPost(PostEntity.from(reqestPost));
    }

    @PostMapping("postandtag")
    public void postPostAndTag(@RequestBody ReqestPostAndTagList reqestPostAndTagList)
    {
        PostEntity postEntity = postService.postPost(PostEntity.from(reqestPostAndTagList));
        List<TagEntity> tagEntityList = tagService.postTagList(reqestPostAndTagList.getTag());
        List<TagEntity> saveTagEntityList = tagService.getTagList(reqestPostAndTagList.getTag());

        List<PostTagRelationEntity> postTagRelationEntityList = PostTagRelationEntity.from(postEntity, saveTagEntityList);

        postTagRelationService.postPostTagRelation(postTagRelationEntityList);

    }

}
