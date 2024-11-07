
package domain.services;

import domain.ports.output.IChairRepository;
import domain.model.Chair;
import co.edu.cauca.chair_service.services.IChairService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChairService implements IChairService{
    @Autowired
    IChairRepository chairRepository;
    
    public ChairService(IChairRepository chairRepository){
        this.chairRepository = chairRepository;
    }
    
    @Override
    @Transactional
    public List<Chair> findAll() {
        return (List<Chair>) chairRepository.findAll();
    }

    @Override
    @Transactional
    public Chair findById(Long id) {
        Chair c = chairRepository.findById(id).orElse(null);
       return c;
    }

    @Override
    @Transactional
    public Chair create(Chair chair) {
        return chairRepository.save(chair); 
    }

    @Override
    @Transactional
    public Chair update(Long id, Chair chair) {
       Chair c = findById(id);
        c.setName(chair.getName());
        return chairRepository.save(c);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
          chairRepository.deleteById(id);
    }
    
}
