package algebra.example.Spring_parcijalniIspist;

import algebra.example.Spring_parcijalniIspist.User.UserService;
import algebra.example.Spring_parcijalniIspist.auth.AuthController;
import algebra.example.Spring_parcijalniIspist.auth.dto.LoginDto;
import algebra.example.Spring_parcijalniIspist.security.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;

class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @Mock
    private UserService userService;

    @InjectMocks
    private AuthController authController;

    private LoginDto loginDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        loginDto = new LoginDto();
        loginDto.setUsername("user");
        loginDto.setPassword("password");
    }
}