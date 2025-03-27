package algebra.example.Spring_parcijalniIspist.ProgramObrazovanja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramObrazovanjaRepository extends JpaRepository<ProgramObrazovanja,Integer> {

}
