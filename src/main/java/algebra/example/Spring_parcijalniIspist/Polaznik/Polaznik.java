package algebra.example.Spring_parcijalniIspist.Polaznik;

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
public class Polaznik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ime;
    private String prezime;

    @JsonBackReference
    @OneToMany(mappedBy = "polaznik")
    private List<Upis> upisi;

    public Polaznik(String ime, String prezime){
        this.ime=ime;
        this.prezime=prezime;
    }
}
