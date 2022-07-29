package kr.co.joylog.blog.service;

import kr.co.joylog.blog.domain.post.PostEntity;
import kr.co.joylog.blog.domain.postTagRelation.PostTagRelationEntity;
import kr.co.joylog.blog.domain.postTagRelation.PostTagRelationRepository;
import kr.co.joylog.blog.domain.tag.TagEntity;
import kr.co.joylog.blog.domain.tag.TagRepository;
import kr.co.joylog.blog.dto.tag.ReqestTag;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PostTagRelationService {

    private final PostTagRelationRepository postTagRelationRepository;
    public PostTagRelationService(PostTagRelationRepository postTagRelationRepository) {
        this.postTagRelationRepository = postTagRelationRepository;
    }

    public List<PostTagRelationEntity> postPostTagRelation(List<PostTagRelationEntity> postTagRelationEntityList)
    {
        return postTagRelationRepository.saveAll(postTagRelationEntityList);
    }
    
    public List<PostTagRelationEntity> getPostTagRelationEntityList(PostEntity post)
    {
    	return postTagRelationRepository.findAllByPost(post);
    }
    
    public List<PostTagRelationEntity> getAllPostTagRelationEntityList()
    {
    	return postTagRelationRepository.findAll();
    }
}
