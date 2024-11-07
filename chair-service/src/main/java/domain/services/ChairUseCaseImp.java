package domain.services;

import domain.model.Chair;
import domain.ports.input.IChairUseCase;
import domain.ports.output.IChairRepository;
import java.util.List;

public class ChairUseCaseImp implements IChairUseCase {
    
    private final IChairRepository chairRepository;

    // Constructor que inyecta el repositorio
    public ChairUseCaseImp(IChairRepository chairRepository) {
        this.chairRepository = chairRepository;
    }

    @Override
    public List<Chair> findAllChairs() {
        return (List<Chair>) chairRepository.findAll();  // Devuelve todas las sillas
    }

    @Override
    public Chair createChair(Chair chair) {
        return chairRepository.save(chair);  // Crea una nueva silla
    }

    @Override
    public Chair findChairById(Long id) {
        return chairRepository.findById(id).orElse(null);  // Encuentra una silla por ID
    }

    @Override
    public Chair updateChair(Long id, Chair chair) {
        Chair existingChair = findChairById(id);
        if (existingChair != null) {
            existingChair.setName(chair.getName());
            existingChair.setLastName(chair.getLastName());
            existingChair.setEmail(chair.getEmail());
            return chairRepository.save(existingChair);  // Actualiza la silla
        }
        return null;  // O puedes lanzar una excepción si no se encuentra la silla
    }

    @Override
    public void deleteById(Long id) {
        chairRepository.deleteById(id);  // Elimina la silla por ID
    }
}
