package com.web.store_auth_api.store_auth_api.infra.security;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.web.store_auth_api.store_auth_api.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.web.store_auth_api.store_auth_api.exception.TokenCreationOrValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("store-auth-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(this.generateExpirationMomentToken())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new TokenCreationOrValidationException("Failed to create token for user: " + user.getEmail(), exception);
        }
    }

    public String validateToken(String token, User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("store-auth-api")
                    .build()
                    .verify(token)
                    .getSubject();

        }catch (JWTVerificationException exception){
            throw new TokenCreationOrValidationException("Failed to verify token for user: " + user.getName(), exception);
        }

    }

    public Instant generateExpirationMomentToken(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
