package com.nit.cs161.lost_and_found.shiroutils;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by NR on 2018/4/1.
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
