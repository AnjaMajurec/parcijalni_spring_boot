package algebra.example.Spring_parcijalniIspist.Upisi;

import algebra.example.Spring_parcijalniIspist.Polaznik.Polaznik;
import algebra.example.Spring_parcijalniIspist.ProgramObrazovanja.ProgramObrazovanja;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Upis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PROGRAM_OBRAZOVANJA_ID")
    @JsonManagedReference
    private ProgramObrazovanja programObrazovanja;

    @ManyToOne
    @JoinColumn(name = "POLAZNIK_ID")
    @JsonManagedReference
    private Polaznik polaznik;
}
