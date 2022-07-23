package kr.co.joylog.blog.config.auth;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public enum OAuthAttributes {
    GIT("gitub", (map) -> UserProfile.builder()
            .build()),
    GOOGLE("google", (map) -> UserProfile.builder()
            .build())
    ;

    String registrationId;
    Function<Map<String, Object>, UserProfile> from;

    public static UserProfile extract(String registrationId, Map<String, Object> attributes) {
        return Arrays.stream(values())
                .filter(provider -> registrationId.equals(provider.registrationId))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .from.apply(attributes);
    }
}
