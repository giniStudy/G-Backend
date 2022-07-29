package kr.co.joylog.blog.domain.postTagRelation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.joylog.blog.domain.post.PostEntity;

public interface PostTagRelationRepository extends JpaRepository<PostTagRelationEntity, Integer> {
	public List<PostTagRelationEntity> findAllByPost(PostEntity post);
}
