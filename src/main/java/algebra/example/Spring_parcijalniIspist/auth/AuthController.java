package algebra.example.Spring_parcijalniIspist.auth;


import algebra.example.Spring_parcijalniIspist.User.User;
import algebra.example.Spring_parcijalniIspist.User.UserService;
import algebra.example.Spring_parcijalniIspist.auth.dto.GenerateAccessTokenFromRefreshTokenDto;
import algebra.example.Spring_parcijalniIspist.auth.dto.LoginDto;
import algebra.example.Spring_parcijalniIspist.auth.dto.LoginResponseDto;
import algebra.example.Spring_parcijalniIspist.auth.dto.RefreshTokenResponseDto;
import algebra.example.Spring_parcijalniIspist.security.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth/api/v1")

public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto dto){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword()));
        if(!authentication.isAuthenticated()){
            throw  new UsernameNotFoundException("Wrong credentials.");
        }
        String accessToken=jwtService.generateAccessToken(dto.getUsername());

        User user =userService.findByUsername(dto.getUsername());
        RefreshToken refreshToken=refreshTokenService.generateRefreshToken(user.getId());
        LoginResponseDto loginResponseDto =new LoginResponseDto(accessToken,refreshToken.getRefreshToken());
        return ResponseEntity.ok(loginResponseDto);



    }
    @PostMapping("/refreshToken")
    public ResponseEntity<RefreshTokenResponseDto> generateRefreshToken(@Valid @RequestBody GenerateAccessTokenFromRefreshTokenDto dto){
        RefreshToken refreshToken=refreshTokenService.findByToken(dto.getRefreshToken());
        Date expireDate=jwtService.extractExpirationDate(refreshToken.getRefreshToken());
        if(expireDate.before(new Date())){
            throw new RuntimeException("Refresh token expired.");
        }
        User user=userService.findById(refreshToken.getUserId());
        String accessToken=jwtService.generateAccessToken(user.getUsername());
        RefreshTokenResponseDto responseDto=new RefreshTokenResponseDto(accessToken);
        return ResponseEntity.ok(responseDto);


    }
}
