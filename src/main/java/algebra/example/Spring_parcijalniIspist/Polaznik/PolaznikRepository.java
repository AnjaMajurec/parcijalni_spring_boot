package algebra.example.Spring_parcijalniIspist.Polaznik;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolaznikRepository extends JpaRepository<Polaznik,Integer> {

}
