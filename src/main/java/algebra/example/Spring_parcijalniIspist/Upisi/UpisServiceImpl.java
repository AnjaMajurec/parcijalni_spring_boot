package algebra.example.Spring_parcijalniIspist.Upisi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpisServiceImpl implements UpisService{
    private final UpisRepository upisRepository;

    @Override
    public List<Upis> fetchAll(){
        return upisRepository.findAll();
    }

    @Override
    public Optional<Upis> findById(Integer id){
        return upisRepository.findById(id);
    }
}
