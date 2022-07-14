package kr.co.joylog.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import kr.co.joylog.blog.dto.post.Post;
import kr.co.joylog.blog.dto.util.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.joylog.blog.domain.post.PostEntity;
import kr.co.joylog.blog.domain.post.PostRepository;

@Transactional
@Service
public class PostService {
	
	private final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	/*
	public PostEntity createPost(String title) {
		PostEntity newPost = new PostEntity();
		newPost.setTitle("test1");
		newPost.setUserSeq(1);
		postRepository.save(newPost);
		System.out.println(newPost.getSeq());
		System.out.println(newPost.getUserSeq());
		return newPost;
	}*/

	public List<PostEntity> findAll() {
		return postRepository.findAll();
	}

	public PageResponse<Post> getPostList(int page, int size)
	{
		Page<PostEntity> pagePost =postRepository.findAll(PageRequest.of(page, size));

		return PageResponse.<Post>builder()
				.list(pagePost.get().map(Post::of).collect(Collectors.toList()))
				.maxPage(pagePost.getTotalPages())
				.viewSize(size)
				.totalCount(pagePost.getTotalElements())
				.build();
	}

}
