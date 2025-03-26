package algebra.example.Spring_parcijalniIspist.Polaznik;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Polaznik(String name, String prezime){
        this.ime=ime;
        this.prezime=prezime;
    }
}
