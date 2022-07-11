package kr.co.joylog.blog.domain.news;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsEntity, Integer> {

}
