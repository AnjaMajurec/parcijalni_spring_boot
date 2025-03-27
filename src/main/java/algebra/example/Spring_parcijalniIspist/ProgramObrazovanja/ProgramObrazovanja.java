package algebra.example.Spring_parcijalniIspist.ProgramObrazovanja;

import algebra.example.Spring_parcijalniIspist.Upisi.Upis;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProgramObrazovanja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String naziv;
    private Integer csvet;

    @OneToMany(mappedBy = "programObrazovanja")
    @JsonBackReference
    private List<Upis> upisi;
}
