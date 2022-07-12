package kr.co.joylog.blog.controller;


import java.util.List;

import kr.co.joylog.blog.dto.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.joylog.blog.domain.post.PostEntity;
import kr.co.joylog.blog.domain.post.PostRepository;
import kr.co.joylog.blog.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;
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
	public List<Post> getPostList(@RequestParam int page, @RequestParam int size)
	{
		return postService.getPostList(page, size);
	}

}
