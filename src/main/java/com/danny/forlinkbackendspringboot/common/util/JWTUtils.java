package com.danny.forlinkbackendspringboot.common.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JWTUtils {

    private static final String SECRET_KEY = "forlink"; // 반드시 환경변수로 관리할 것
    private static final long EXPIRATION_TIME = 86400000; // 1일 (밀리초 단위)

    public static String generateToken(String loginId, String role) {
        return Jwts.builder()
                .setSubject(loginId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
