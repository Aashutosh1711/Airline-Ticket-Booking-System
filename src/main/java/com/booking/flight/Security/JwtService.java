package com.booking.flight.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private static final long EXPIRATION_TIME=15*60*1000;
    private static final String SECRETE="ajnfgnsorjbgronsrjnvg";


    public String generateToken(String username){
        String token = Jwts.builder().subject(username).issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(Keys.hmacShaKeyFor(SECRETE.getBytes())).
                compact();
        return token;
    }

    public String Username(String token){
        String subject = Jwts.parser().setSigningKey(SECRETE.getBytes()).build()
                .parseClaimsJws(token).getPayload().getSubject();
        return subject;
    }

    public boolean isValid(String token){
        try {
            Jwts.parser().setSigningKey(SECRETE.getBytes()).build().parseClaimsJws(token);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
