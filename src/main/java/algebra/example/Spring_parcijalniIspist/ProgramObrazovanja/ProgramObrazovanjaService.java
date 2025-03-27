package algebra.example.Spring_parcijalniIspist.ProgramObrazovanja;

import java.util.List;
import java.util.Optional;

public interface ProgramObrazovanjaService {
    List<ProgramObrazovanja> fetchAll();
    Optional<ProgramObrazovanja> findById(Integer id);
}
