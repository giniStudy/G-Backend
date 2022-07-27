package kr.co.joylog.blog.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public enum AdminRoleType {
    DEFAULT("기본 권한", new String[]{"ROLE_USER"}),
    WRITER("관리자 권한", new String[]{"ROLE_USER, ROLE_WRITE_USER"});

    String description;
    String[] adminRole;
}
