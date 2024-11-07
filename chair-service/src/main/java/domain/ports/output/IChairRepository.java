
package domain.ports.output;

import domain.model.Chair;
import org.springframework.data.repository.CrudRepository;

public interface IChairRepository extends CrudRepository <Chair, Long> {
    
}
