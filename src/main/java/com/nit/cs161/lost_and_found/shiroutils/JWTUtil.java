package com.nit.cs161.lost_and_found.shiroutils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nit.cs161.lost_and_found.constant.general.ProjectConstants;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by NR on 2018/4/1.
 */

public class JWTUtil {

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     *
     * @param username 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String sign(String username, String secret) {
        try {
            Date date = new Date(System.currentTimeMillis() + ProjectConstants.EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private static final String CLAIM_NAME = "username";

    /**
     * 生成签名,5min后过期
     *
     * @param claimName  用户claim信息
     * @param secret 用户的密码
     * @return 加密的token
     */
    public static String signature(String claimName, String secret) {
        try {
            Date date = new Date(System.currentTimeMillis() + ProjectConstants.EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带phone信息
            return JWT.create()
                    .withClaim(CLAIM_NAME, claimName)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * Descriptions: 获取token中包涵的用户名(无需secret解密)<p>
     *
     * @return token中包含的用户名
     * @author SailHe
     * @date 2018/10/1 17:33
     */
    public static String getUsernameInToken(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(CLAIM_NAME).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
