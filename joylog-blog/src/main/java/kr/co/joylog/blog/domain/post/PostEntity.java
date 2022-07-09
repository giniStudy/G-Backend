package kr.co.joylog.blog.domain.post;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer seq;

    String title;
}
