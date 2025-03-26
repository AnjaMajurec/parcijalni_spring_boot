package algebra.example.Spring_parcijalniIspist.Polaznik;

import java.util.List;
import java.util.Optional;

public interface PolaznikService {
    List<Polaznik> fetchAll();
    Optional<Polaznik> findById(Integer id);
    Polaznik create(CreatePolaznikDto dto);
}
