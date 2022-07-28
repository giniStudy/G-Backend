package kr.co.joylog.blog.config.auth;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import kr.co.joylog.blog.domain.user.AdminRoleType;
import kr.co.joylog.blog.dto.user.UserDefaultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

/**
 * TODO 토큰 발급 로직 및 시간 확인 로직 확인 필요
 * */
@Slf4j
@Service
public class TokenService {
    private String secretKey = "token-secret-keyasjoylogkeyasjoylogkeyasjoylogkeyasjoylogkeyasjoylogkeyasjoylog!Q(@(#!";
    private long tokenPeriod = 1000L * 60L * 10L;
    private long refreshPeriod = 1000L * 60L * 60L * 24L * 30L;
    Gson gson = new Gson();


    public Token generateToken(UserDefaultInfo userDefaultInfo) {
        return new Token(
                createAccessToken(userDefaultInfo),
                createRefreshToken(userDefaultInfo));
    }

    private String createAccessToken(UserDefaultInfo userDefaultInfo) {
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + tokenPeriod);
        return Jwts.builder()
                .addClaims(userDefaultInfo.toMap())
                .setAudience(userDefaultInfo.getEmail())
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(key)
                .compact();
    }

    private String createRefreshToken(UserDefaultInfo userDefaultInfo) {
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + refreshPeriod);
        return Jwts.builder()
                .setSubject(gson.toJson(userDefaultInfo))
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(key)
                .compact();
    }


    public boolean verifyToken(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
            JwtParser parser = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build();
            return parser.isSigned(token);
        } catch (Exception e) {
            return false;
        }
    }


    public UserDefaultInfo getBody(String token) {
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        log.info("body: {}", parser.parseClaimsJws(token).getBody() );
        Claims body = parser.parseClaimsJws(token).getBody();

        return UserDefaultInfo.builder()
                .seq((Integer)body.get("seq"))
                .email((String)body.get("email"))
                .role((AdminRoleType.valueOf((String)body.get("role"))))
                .build();
    }
}
