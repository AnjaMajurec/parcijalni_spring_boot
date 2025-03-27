package algebra.example.Spring_parcijalniIspist;

import algebra.example.Spring_parcijalniIspist.Polaznik.*;
import algebra.example.Spring_parcijalniIspist.auth.AuthController;
import algebra.example.Spring_parcijalniIspist.auth.dto.LoginDto;
import algebra.example.Spring_parcijalniIspist.auth.dto.LoginResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PolaznikControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PolaznikController polaznikController;

    @Autowired
    private PolaznikService polaznikService;

    @Autowired
    private AuthController authController;

    @Autowired
    private PolaznikRepository polaznikRepository;



    private String accessToken;
    private CreatePolaznikDto createPolaznikDto = new CreatePolaznikDto("Marko",  "Markić");

    @BeforeEach
    void setUp() throws Exception {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername("admin");
        loginDto.setPassword("password");

        LoginResponseDto jwtResponse = authController.login(loginDto).getBody();
        accessToken = jwtResponse.getAccessToken();
    }

    @Test
    void CreatePolaznikDto() throws Exception {
        mockMvc.perform(post("/polaznici")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPolaznikDto))
                )
                .andExpect(status().isCreated());
    }

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get("/polaznici")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(4))));
    }


    @Test
    void testFindById_Found() throws Exception {
        Polaznik polaznik = new Polaznik("Melita", "Majic");
        when(polaznikService.findById(1)).thenReturn(Optional.of(polaznik));

        mockMvc.perform(get("/polaznici/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ime").value("Melita"))
                .andExpect(jsonPath("$.prezime").value("Majic"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(polaznikService.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(get("/polaznici/{id}", 1))
                .andExpect(status().isNotFound());
    }
}
