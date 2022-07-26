package kr.co.joylog.blog.domain.tag;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<TagEntity, Integer> {
    public Optional<TagEntity> findAllByTag(String tag);
    public List<TagEntity> findAllByTagIn(List<String> tag);
    public List<Integer> findSeqByTagIn(List<String> tag);
}
