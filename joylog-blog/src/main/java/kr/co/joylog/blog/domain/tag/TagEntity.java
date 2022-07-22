package kr.co.joylog.blog.domain.tag;

import javax.persistence.*;

import kr.co.joylog.blog.dto.tag.ReqestTag;
import lombok.*;

@Entity
@Table(name = "tag")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TagEntity {
    public static TagEntity from(ReqestTag reqestTag){
        return TagEntity.builder()
                .tag(reqestTag.getTag())
                .build();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    private String  tag;

}
