package algebra.example.Spring_parcijalniIspist.auth;

public interface RefreshTokenService {
    RefreshToken findByUserId(Long userId);
    RefreshToken generateRefreshToken(Long userId);
    RefreshToken findByToken(String token);
}

