CREATE SCHEMA `joylog_blog` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `joylog_blog`.`user` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(200) CHARACTER SET 'utf8' NOT NULL COMMENT '아이디',
  `pw` VARCHAR(400) CHARACTER SET 'utf8' NOT NULL COMMENT '비밀번호',
  `name` VARCHAR(20) CHARACTER SET 'utf8' NOT NULL COMMENT '이름',
  `nick_name` VARCHAR(100) CHARACTER SET 'utf8' NULL COMMENT '별칭',
  `email` VARCHAR(100) CHARACTER SET 'utf8' NULL COMMENT '이메일',
  `phon` VARCHAR(30) CHARACTER SET 'utf8' NULL COMMENT '전화번호',
  `level` INT NULL COMMENT '권한 (level_lang 테이블에서 용어 정의)',
  `repository` VARCHAR(200) CHARACTER SET 'utf8' NULL COMMENT '여러개의 깃 레파지토리 이름들을 String 형태로 나열 (구분자 ,)',
  `login_state` INT NULL COMMENT '로그인 상태 값 (state_lang 테이블에서 용어 정의)',
  `github_name` VARCHAR(200) NULL COMMENT '깃 허브 이름',
  `image_path` VARCHAR(500) NULL COMMENT '프로필 이미지 주소',
  `create_datetime` DATETIME NULL COMMENT '생성일시',
  PRIMARY KEY (`seq`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '회원 테이블';

CREATE TABLE `joylog_blog`.`post` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `user_seq` INT NOT NULL COMMENT 'user table PK - 작성자',
  `title` VARCHAR(100) CHARACTER SET 'utf8' NULL COMMENT '제목',
  `content` VARCHAR(20000) CHARACTER SET 'utf8' NULL COMMENT '본 문',
  `state` INT NULL COMMENT '게시글 상태 값 (state_lang 테이블에서 용어 정의)',
  `last_update_datetime` DATETIME NULL COMMENT '마지막 업데이트 일시',
  `create_datetime` DATETIME NULL COMMENT '생성일시',
  `level` INT NULL COMMENT '접근 권한 레벨 (level_lang 테이블에서 용어 정의)',
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '게시글 테이블';

CREATE TABLE `joylog_blog`.`tags` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `tag` VARCHAR(500) NOT NULL COMMENT '태그 이름',
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '태그 테이블';

CREATE TABLE `joylog_blog`.`post_tags_ relation` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `post_seq` int NOT NULL COMMENT 'post 테이블의 seq',
  `tag_seq` int NOT NULL COMMENT 'tag 테이블의 seq',
  PRIMARY KEY (`seq`),
  UNIQUE KEY `post_seq_UNIQUE` (`post_seq`),
  UNIQUE KEY `tag_seq_UNIQUE` (`tag_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='post 테이블과 tags 테이블의 관계 테이블';

CREATE TABLE `joylog_blog`.`news` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `crawling_seq` INT NOT NULL COMMENT '생성한 크롤러 seq',
  `target_seq` INT NULL COMMENT '어떤 타겟 키워드로 생성되었는지를 알기위한 target seq',
  `title` VARCHAR(500) CHARACTER SET 'utf8' NULL COMMENT '제목',
  `content` VARCHAR(20000) CHARACTER SET 'utf8' NULL COMMENT '내용',
  `state` INT NULL COMMENT '상태 (state_lang 테이블에서 용어 정의)',
  `path` VARCHAR(500) CHARACTER SET 'utf8' NULL COMMENT '원본 주소',
  `last_update_datetime` DATETIME NULL COMMENT '마지막 업데이트 일시',
  `create_datetime` DATETIME NULL COMMENT '생성 일시',
  `level` INT NULL COMMENT '접근 권한 레벨(level_lang 테이블에서 용어 정의)',
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '크롤링으로 얻은 it 정보 테이블';

CREATE TABLE `joylog_blog`.`news_target` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `keyword` VARCHAR(400) CHARACTER SET 'utf8' NOT NULL COMMENT '크롤링할 대상의 키워드',
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '크롤링할 대상 테이블';

CREATE TABLE `joylog_blog`.`crawling` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `user_seq` int NOT NULL COMMENT '생성 유저 seq',
  `path` varchar(400) NOT NULL COMMENT '타겟을 조사할 url',
  `next_start_datetime` datetime DEFAULT NULL COMMENT '다음 조회 시간',
  `last_crawling_datetime` datetime DEFAULT NULL COMMENT '마지막 조회 시간',
  `kind` int NULL COMMENT '크롤링 종류 (kind_lang 테이블에서 용어 정리)',
  `interval` int NULL COMMENT '실행 간격',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='news_target 테이블을 기준으로 크롤링 하기위한 테이블';

CREATE TABLE `joylog_blog`.`level_lang` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `korean` VARCHAR(100) NULL,
  `english` VARCHAR(100) NULL,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'level 값에 따른 용어 테이블 (user, post, news)';

CREATE TABLE `joylog_blog`.`kind_lang` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `korean` VARCHAR(100) NULL,
  `english` VARCHAR(100) NULL,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'kind 값에 따른 용어 테이블';

CREATE TABLE `joylog_blog`.`state_lang` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `korean` VARCHAR(100) NULL,
  `english` VARCHAR(100) NULL,
  PRIMARY KEY (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'state 값에 따른 용어 테이블 (login, 게시글)';
