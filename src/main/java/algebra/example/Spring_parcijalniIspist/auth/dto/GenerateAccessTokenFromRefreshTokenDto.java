package algebra.example.Spring_parcijalniIspist.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateAccessTokenFromRefreshTokenDto {
    private  String refreshToken;
}
