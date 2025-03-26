package algebra.example.Spring_parcijalniIspist.Polaznik;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolaznikServiceImpl implements PolaznikService{
    private final PolaznikRepository polaznikRepository;

    public PolaznikServiceImpl(PolaznikRepository polaznikRepository){
        this.polaznikRepository=polaznikRepository;
    }
    @Override
    public List<Polaznik> fetchAll(){
        return polaznikRepository.findAll();
    }

    @Override
    public Optional<Polaznik> findById(Integer id){
        return polaznikRepository.findById(id);
    }

    @Override
    public Polaznik create(CreatePolaznikDto dto){
        Polaznik polaznik=new Polaznik(dto.getIme(),dto.getPrezime());
        return polaznikRepository.save(polaznik);
    }

}
