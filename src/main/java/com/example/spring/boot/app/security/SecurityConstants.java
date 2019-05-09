package com.example.spring.boot.app.security;

class SecurityConstants {
    final static String SECRET = "SecretKeyToGenJWT";
    final static long EXPIRATION_TIME = 864_000_000; // 10 days
    final static String TOKEN_PREFIX = "Bearer ";
    final static String HEADER_STRING = "Authorization";
    final static String SING_UP_URL = "/users/sign-up";

}
