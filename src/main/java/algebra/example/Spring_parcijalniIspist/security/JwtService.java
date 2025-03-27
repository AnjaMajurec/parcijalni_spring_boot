package algebra.example.Spring_parcijalniIspist.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtService {
    private final String SECRET_KEY="YR6NKUdqjvelpRGGQs91jFBEPnhCVo0Irsx1uHCn4eNYbaMPpuMEs4M832bYVKc7";

    public boolean validateToken(String token, UserDetails userDetails){
        String username = extractUsername(token);
        boolean isUsernameValid = username.equals(userDetails.getUsername());

        if (!isUsernameValid){
            return false;
        }

        boolean isTokenExpired = checkIsTokenExpired(token);

        if (isTokenExpired) {
            return false;
        }

        return true;
    }
    private boolean checkIsTokenExpired(String token){
        Date expirationDate = extractExpirationDate(token);
        boolean isExpired = expirationDate.before(new Date());
        return isExpired;
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }
    public Date extractExpirationDate(String token){
        Claims allClaims=extractAllClaims(token);
        return allClaims.getExpiration();
    }
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws((token))
                .getBody();
    }
    public String generateAccessToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String generateRefreshToken(String userId){
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*100))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

}


