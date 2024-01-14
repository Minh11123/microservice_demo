package com.example.gateway_service.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

@Service
public class JwtUtils {

    public static final String SECRET = "verysecretkeyohsosecretdamnhowlongisthispleasedontusethisinproduction";


    public void validateToken(String token) {
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET); // Sử dụng cùng secret key như khi tạo token
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); // Tạo một JWTVerifier

            DecodedJWT jwt = verifier.verify(token); // Xác thực token
            // Tại đây, bạn có thể thêm mã để xử lý thông tin trong token, nếu cần
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            throw new JWTVerificationException("Token không hợp lệ", exception);
        }
    }



    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
