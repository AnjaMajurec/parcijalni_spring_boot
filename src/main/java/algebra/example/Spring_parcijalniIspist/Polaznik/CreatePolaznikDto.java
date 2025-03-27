package algebra.example.Spring_parcijalniIspist.Polaznik;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePolaznikDto {

    @NotBlank
    private String ime;

    @NotBlank
    private String prezime;

}
