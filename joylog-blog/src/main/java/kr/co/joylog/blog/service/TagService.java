package kr.co.joylog.blog.service;

import kr.co.joylog.blog.domain.post.PostRepository;
import kr.co.joylog.blog.domain.tag.TagEntity;
import kr.co.joylog.blog.domain.tag.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TagService {

    private final TagRepository tagRepository;
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagEntity postTag(TagEntity tagEntity)
    {
        return tagRepository.save(tagEntity);
    }
}
