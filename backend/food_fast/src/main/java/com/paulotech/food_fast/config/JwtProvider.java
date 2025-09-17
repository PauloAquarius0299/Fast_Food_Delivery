package com.paulotech.food_fast.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.*;

@Service
public class JwtProvider {
    private SecretKey key = Keys.hmacShaKeyFor(JwtConstante.SECRET_KEY.getBytes());

    public String generateToken(Authentication auth){
        Collection<? extends GrantedAuthority>authorities=auth.getAuthorities();
        String roles = populateAutherities(authorities);

        String jwt = Jwts.builder().setIssuedAt(new Date())
                .setIssuer("FoodFast")
                .setExpiration(new Date((new Date()).getTime()+864000000))
                .setSubject(auth.getName())
                .claim("authorities",roles)
                .signWith(key)
                .compact();

        return jwt;
    }

    public String getEmailFromToken(String jwt){
        jwt = jwt.substring(7);
        Claims clamis = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

        String email = String.valueOf(clamis.get("Email"));
        return email;
    }

    private String populateAutherities(Collection<? extends GrantedAuthority> authorities) {
        Set<String> auths = new HashSet<>();

        for(GrantedAuthority authority:authorities){
            auths.add(authority.getAuthority());
        }
        return null;
    }
}
