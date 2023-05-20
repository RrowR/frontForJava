package com.study.elementadmin.background.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.elementadmin.background.dto.User;
import com.study.elementadmin.background.mapper.UserMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public String login(String username, String password) {
        if (!userMapper.login(username, password)) {
            throw new Exception401("登录失败");
        }
        SecretKey secretKey = getKeyByUsername(username);
        return Jwts.builder().signWith(secretKey).setSubject(username).compact();
    }

    public String loginFromOAuth(String username, String avatar, String introduction) {
        userMapper.insert(username, username, avatar, introduction, newKey());
        SecretKey secretKey = getKeyByUsername(username);
        return Jwts.builder().signWith(secretKey).setSubject(username).compact();
    }

    public User info(String token) {
        String username = getUsernameFromToken(token, "sub").toString();
        User user = userMapper.info(username);
        String[] roles = userMapper.roles(username);
        // 如果是通过 oauth 登录，本地没有角色，给一个默认值
        user.setRoles(roles.length > 0 ? roles : new String[]{"user"});
        return user;
    }

    private final ConcurrentHashMap<String, SecretKey> keyMap = new ConcurrentHashMap<>();

    private SecretKey getKeyByUsername(String username) {
        return keyMap.computeIfAbsent(username, n -> {
            String key = userMapper.getKey(n);
//            System.out.println(key);
            if (key == null) {
                throw new JwtException("未找到用户[" + n + "]的令牌");
            }
            return Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
        });
    }

    public void logout(String token) {
        String username = getUsernameFromToken(token, "sub").toString();
        userMapper.updateKey(username, newKey());
        keyMap.remove(username);
    }

    private static final String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int n = 36;

    private static String newKey() {
        int length = chars.length();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < 36; i++) {
            int idx = ThreadLocalRandom.current().nextInt(length);
            sb.append(chars.charAt(idx));
        }
        return sb.toString();
    }

    @SuppressWarnings("all")
    private static Object getUsernameFromToken(String token, String key) {
        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new JwtException("令牌格式不正确");
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map map = mapper.readValue(Base64.getDecoder().decode(parts[1]), Map.class);
            return map.get(key);
        } catch (IOException e) {
            throw new JwtException("令牌格式不正确", e);
        }
    }

    public void verify(String token) {
        try {
            String username = getUsernameFromToken(token, "sub").toString();
            SecretKey secretKey = getKeyByUsername(username);
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException |
                 IllegalArgumentException e) {
            throw new Exception401("校验 token 失败");
        }
    }
}
