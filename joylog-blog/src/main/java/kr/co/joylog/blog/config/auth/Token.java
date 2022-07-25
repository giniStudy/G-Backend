package kr.co.joylog.blog.config.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
public class Token {
    private String token;
    private String refreshToken;

    public Token(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public String toJson() {
        return "{"
                + "t\"token\":" + token
                + ",\"refreshToken\":" + refreshToken
                + "}";
    }
}