package org.example.server.common.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * token
 */
@Service
public class TokenServiceImpl {

    //缓存中的key前缀
    private static String WEB_CACHE_KEY = "TOKEN_USER_";

    @Value("${config.jwt.expire}")
    private long expire;
    @Value("${config.jwt.secret}")
    private String secret;

    public long getExpire() {
        return expire;
    }

    public String getSecret() {
        return secret;
    }

    /**
     * 生成token（签名）
     *
     * @param userId
     * @return
     */
    public String createSign(Long userId) {
        Date expiresAt = new Date(System.currentTimeMillis() + this.getExpire());
        Algorithm algorithm = Algorithm.HMAC256(this.getSecret());
        String token = JWT.create()
                .withIssuer("auth0")    // 发布者
                .withIssuedAt(new Date())   // 生成签名的时间
                .withExpiresAt(expiresAt)   // 生成签名的有效期
                .withClaim("user_id", userId) // 插入数据
                .sign(algorithm);
        return token;
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public Long verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.getSecret());
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0") //匹配指定的token发布者 auth0
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            Long userId = jwt.getClaim("user_id").asLong();
            return userId;
        } catch (Exception e) {
            return 0l;
        }
    }
}
