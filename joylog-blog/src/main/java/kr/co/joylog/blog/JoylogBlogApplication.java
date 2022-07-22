package kr.co.joylog.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // create dateTime 문제 해결.
public class JoylogBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoylogBlogApplication.class, args);
	}

}
