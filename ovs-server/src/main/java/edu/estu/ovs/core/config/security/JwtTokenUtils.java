package edu.estu.ovs.core.config.security;

import edu.estu.ovs.service.abstracts.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtTokenUtils implements Serializable {

    @Serial
    private static final long serialVersionUID = -2550185165626007488L;
    @Value("${jwt.secret}")
    private String secret;
    private final UserService userService;

    @SneakyThrows
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parseClaimsJws(token).getBody();
            return claimsResolver.apply(claims);
        } catch (ExpiredJwtException ignored) {
            return null;
        }
    }

    public String generateToken(User user) {
        final int JWT_EXPIRATION_HOUR = 48;
        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_HOUR * 60 * 60 * 1000)) // 48 hours
                .setIssuer("online-voting-system")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .claim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();
        String scheme = "Bearer";
        return String.format("%s %s", scheme, token);
    }

    public Boolean valid(String token) {
        final String userName = getClaim(token, Claims::getSubject);
        final Date expiration = getClaim(token, Claims::getExpiration);
        final edu.estu.ovs.models.entities.User tokenUser = userService.findByUserName(userName).orElse(null);
        return userName != null && expiration.after(new Date()) && tokenUser != null;
    }

}
