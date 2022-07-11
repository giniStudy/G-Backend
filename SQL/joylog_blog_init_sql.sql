CREATE SCHEMA `joylog_blog` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `joylog_blog`.`crawling` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `user_seq` int NOT NULL COMMENT '생성 유저 seq',
  `path` varchar(400) NOT NULL COMMENT '타겟을 조사할 url',
  `next_start_datetime` datetime DEFAULT NULL COMMENT '다음 조회 시간',
  `last_crawling_datetime` datetime DEFAULT NULL COMMENT '마지막 조회 시간',
  `kind` varchar(30) DEFAULT NULL COMMENT '크롤링 종류 ',
  `interval` int DEFAULT NULL COMMENT '실행 간격',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='news_target 테이블을 기준으로 크롤링 하기위한 테이블';

CREATE TABLE `joylog_blog`.`news` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `crawling_seq` int NOT NULL COMMENT '생성한 크롤러 seq',
  `target_seq` int DEFAULT NULL COMMENT '어떤 타겟 키워드로 생성되었는지를 알기위한 target seq',
  `title` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '제목',
  `content` varchar(20000) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '내용',
  `state` varchar(30) DEFAULT NULL COMMENT '상태',
  `path` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '원본 주소',
  `last_update_datetime` datetime DEFAULT NULL COMMENT '마지막 업데이트 일시',
  `create_datetime` datetime DEFAULT NULL COMMENT '생성 일시',
  `level` varchar(30) DEFAULT NULL COMMENT '접근 권한 레벨',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='크롤링으로 얻은 it 정보 테이블';

CREATE TABLE `joylog_blog`.`target` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `keyword` varchar(400) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '크롤링할 대상의 키워드',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='크롤링할 대상 테이블';

CREATE TABLE `joylog_blog`.`post` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `user_seq` int NOT NULL COMMENT 'user table PK - 작성자',
  `title` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '제목',
  `content` varchar(20000) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '본 문',
  `state` varchar(30) DEFAULT NULL COMMENT '게시글 상태 값',
  `last_update_datetime` datetime DEFAULT NULL COMMENT '마지막 업데이트 일시',
  `create_datetime` datetime DEFAULT NULL COMMENT '생성일시',
  `level` varchar(30) DEFAULT NULL COMMENT '접근 권한 레벨',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='게시글 테이블';

CREATE TABLE `joylog_blog`.`post_tags_relation` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `post_seq` int NOT NULL COMMENT 'post 테이블의 seq',
  `tag_seq` int NOT NULL COMMENT 'tag 테이블의 seq',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='post 테이블과 tags 테이블의 관계 테이블';

CREATE TABLE `joylog_blog`.`tags` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `tag` varchar(500) NOT NULL COMMENT '태그 이름',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='태그 테이블';

CREATE TABLE `joylog_blog`.`user` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `id` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '아이디',
  `pw` varchar(400) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '비밀번호',
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '이름',
  `nick_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '별칭',
  `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '이메일',
  `phon` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '전화번호',
  `level` varchar(30) DEFAULT NULL COMMENT '권한',
  `repository` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '여러개의 깃 레파지토리 이름들을 String 형태로 나열 (구분자 ,)',
  `login_state` varchar(30) DEFAULT NULL COMMENT '로그인 상태 값',
  `github_name` varchar(200) DEFAULT NULL COMMENT '깃 허브 이름',
  `image_path` varchar(500) DEFAULT NULL COMMENT '프로필 이미지 주소',
  `create_datetime` datetime DEFAULT NULL COMMENT '생성일시',
  PRIMARY KEY (`seq`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='회원 테이블';
