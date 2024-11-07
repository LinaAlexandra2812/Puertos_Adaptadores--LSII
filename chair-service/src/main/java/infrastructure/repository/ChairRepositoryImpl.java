
package infrastructure.repository;

import domain.model.Chair;
import domain.ports.output.IChairRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class ChairRepositoryImpl implements IChairRepository {

    @Autowired
    IChairRepository chairRepository;

    @Override
    public <S extends Chair> S save(S entity) {        
        return chairRepository.save(entity);
    }

    @Override
    @Transactional
    public <S extends Chair> Iterable<S> saveAll(Iterable<S> entities) {
        return chairRepository.saveAll(entities);
    }

    @Override
    public Optional<Chair> findById(Long id) {
        return chairRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return chairRepository.existsById(id);
    }

    @Override
    public Iterable<Chair> findAll() {
        return chairRepository.findAll();
    }

    @Override
    public Iterable<Chair> findAllById(Iterable<Long> ids) {
        return chairRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return chairRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        chairRepository.deleteById(id);
    }

    @Override
    public void delete(Chair entity) {
        chairRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends Chair> entities) {
        chairRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        chairRepository.deleteAll();
    }
}

