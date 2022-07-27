package kr.co.joylog.blog.config.auth;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import kr.co.joylog.blog.dto.user.UserDefaultInfo;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

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
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return claims.getBody()
                    .getExpiration()
                    .after(new Date());
        } catch (Exception e) {
            return false;
        }
    }


    public String getUid(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
