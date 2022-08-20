package kr.co.joylog.blog.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public enum AdminRoleType {
    DEFAULT("기본 권한", new String[]{"ROLE_USER"}),
    WRITER("관리자 권한", new String[]{"ROLE_USER, ROLE_WRITE"});

    String description;
    String[] adminRole;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(adminRole)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
