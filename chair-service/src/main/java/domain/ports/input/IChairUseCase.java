
package domain.ports.input;

import domain.model.Chair;
import java.util.List;

public interface IChairUseCase {
    List<Chair> findAllChairs();
    
    Chair findChairById(Long id);
    
    Chair createChair(Chair chair);
    
    Chair updateChair(Long id, Chair chair);
    
    void deleteById(Long id);
}
