package algebra.example.Spring_parcijalniIspist.ProgramObrazovanja;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProgramObrazovanjaServiceImpl implements ProgramObrazovanjaService{
    private final ProgramObrazovanjaRepository programObrazovanjaRepository;

    @Override
    public List<ProgramObrazovanja> fetchAll(){
        return programObrazovanjaRepository.findAll();
    }

    @Override
    public Optional<ProgramObrazovanja> findById(Integer id){
        return programObrazovanjaRepository.findById(id);
    }



}
