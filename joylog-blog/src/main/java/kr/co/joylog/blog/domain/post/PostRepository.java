package kr.co.joylog.blog.domain.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    public Page<PostEntity> findAll(Pageable pageable);
    PostEntity getById(int seq);
}