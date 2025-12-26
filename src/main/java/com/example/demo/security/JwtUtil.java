// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;
// import com.example.demo.entity.User;

// import java.security.Key;
// import java.util.Date;

// @Component
// public class JwtUtil {

//     @Value("${jwt.secret}")
//     private String secret;

//     @Value("${jwt.expiration}")
//     private long expiration;

//     private Key getSigningKey() {
//         return Keys.hmacShaKeyFor(secret.getBytes());
//     }

//     // ✅ USED BY CONTROLLER
//     public String createToken(Long userId, String email, String role) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("role", role)
//                 .claim("userId", userId)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                 .signWith(getSigningKey(), SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     // ✅ REQUIRED BY TEST (BACKWARD COMPATIBILITY)
//     public String generateToken(UserDetails userDetails, User user) {
//         return createToken(
//                 user.getId(),
//                 userDetails.getUsername(),
//                 user.getRole()
//         );
//     }

//     // ✅ EXISTING METHOD
//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder()
//                     .setSigningKey(getSigningKey())
//                     .build()
//                     .parseClaimsJws(token);
//             return true;
//         } catch (JwtException | IllegalArgumentException e) {
//             return false;
//         }
//     }

//     // ✅ REQUIRED BY TEST (OVERLOADED METHOD)
//     public boolean validateToken(String token, UserDetails userDetails) {
//         return validateToken(token)
//                 && getEmail(token).equals(userDetails.getUsername());
//     }

//     public String getEmail(String token) {
//         return getClaims(token).getSubject();
//     }

//     public String getRole(String token) {
//         return getClaims(token).get("role", String.class);
//     }

//     private Claims getClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(getSigningKey())
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }
package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET = "secretkey";

    // REQUIRED: Test expects a NO-ARGS constructor
    public JwtUtil() {}

    // REQUIRED: EXACT signature used in tests
    public String generateToken(UserDetails userDetails, User user) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())               // email
                .claim("role", user.getRole())                       // role claim
                .claim("userId", user.getId())                       // id claim
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            return !extractAllClaims(token).getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public Long extractUserId(String token) {
        return extractAllClaims(token).get("userId", Long.class);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
