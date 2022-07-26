package kr.co.joylog.blog.service;

import kr.co.joylog.blog.domain.post.PostRepository;
import kr.co.joylog.blog.domain.tag.TagEntity;
import kr.co.joylog.blog.domain.tag.TagRepository;
import kr.co.joylog.blog.dto.tag.ReqestTag;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class TagService {

    private final TagRepository tagRepository;
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagEntity postTag(ReqestTag reqestTag)
    {
        Optional<TagEntity> optionalTagEntity = tagRepository.findAllByTag(reqestTag.getTag());

        return optionalTagEntity.orElseGet(()->tagRepository.save(TagEntity.from(reqestTag)));
    }


    public List<TagEntity> postTagList(List<String> reqestTagList)
    {
        List<TagEntity> ifPresentTagEntity = tagRepository.findAllByTagIn(reqestTagList);

        List<TagEntity> saveTagEntity = new ArrayList<TagEntity>();
        for(String reqestTag : reqestTagList)
        {
            int i = 0;
            for(; i < ifPresentTagEntity.size(); i++)
            {
                if (ifPresentTagEntity.get(i).getTag().equals(reqestTag)) break;
            }
            if(i == ifPresentTagEntity.size()) saveTagEntity.add(TagEntity.from(ReqestTag.builder().tag(reqestTag).build()));
        }

        return tagRepository.saveAll(saveTagEntity);
    }

    public List<TagEntity> getTagList(List<String> tagList)
    {
        return tagRepository.findAllByTagIn(tagList);
    }
}
