package algebra.example.Spring_parcijalniIspist.Upisi;

import java.util.List;
import java.util.Optional;

public interface UpisService {
    List<Upis> fetchAll();
    Optional<Upis> findById(Integer id);

}
