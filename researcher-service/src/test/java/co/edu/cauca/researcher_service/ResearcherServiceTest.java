package co.edu.cauca.researcher_service;

import co.edu.cauca.researcher_service.access.IResearcherRepository;
import co.edu.cauca.researcher_service.domain.Researcher;
import co.edu.cauca.researcher_service.services.ResearcherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ResearcherServiceTest {

    @Mock
    private IResearcherRepository researcherRepository;

    @InjectMocks
    private ResearcherService researcherService;

    private Researcher researcher1;
    private Researcher researcher2;

    @BeforeEach
    void setUp() {
        // Inicializar Mockito
        MockitoAnnotations.openMocks(this);

        // Crear dos investigadores simulados
        researcher1 = new Researcher();
        researcher1.setName("John");
        researcher1.setLastName("Doe");
        researcher1.setEmail("john.doe@example.com");
        researcher1.setResearchField("Computer Science");

        researcher2 = new Researcher();
        researcher2.setName("Jane");
        researcher2.setLastName("Smith");
        researcher2.setEmail("jane.smith@example.com");
        researcher2.setResearchField("Mathematics");
    }

    @Test
    void testFindAll() {
        // Simular la respuesta del repositorio
        when(researcherRepository.findAll()).thenReturn(Arrays.asList(researcher1, researcher2));

        // Ejecutar el método findAll()
        List<Researcher> result = researcherService.findAll();

        // Verificar que el resultado contiene los dos investigadores
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Jane", result.get(1).getName());

        // Verificar que el método findAll fue llamado una vez
        verify(researcherRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Simular la respuesta del repositorio
        when(researcherRepository.findById(1L)).thenReturn(Optional.of(researcher1));

        // Ejecutar el método findById()
        Researcher result = researcherService.findById(1L);

        // Verificar que el resultado es el investigador correcto
        assertNotNull(result);
        assertEquals("John", result.getName());
        assertEquals("Doe", result.getLastName());

        // Verificar que el método findById fue llamado una vez con el ID correcto
        verify(researcherRepository, times(1)).findById(1L);
    }

    @Test
    void testCreate() {
        // Simular la respuesta del repositorio
        when(researcherRepository.save(researcher1)).thenReturn(researcher1);

        // Ejecutar el método create()
        Researcher result = researcherService.create(researcher1);

        // Verificar que el resultado es el investigador creado
        assertNotNull(result);
        assertEquals("John", result.getName());

        // Verificar que el método save fue llamado una vez
        verify(researcherRepository, times(1)).save(researcher1);
    }

    @Test
    void testUpdate() {
        // Simular la respuesta del repositorio
        when(researcherRepository.findById(1L)).thenReturn(Optional.of(researcher1));
        when(researcherRepository.save(researcher1)).thenReturn(researcher1);

        // Actualizar algunos valores
        researcher2.setName("Updated Name");

        // Ejecutar el método update()
        Researcher result = researcherService.update(1L, researcher2);

        // Verificar que el nombre fue actualizado correctamente
        assertNotNull(result);
        assertEquals("Updated Name", result.getName());

        // Verificar que el método findById fue llamado una vez y save fue llamado para actualizar
        verify(researcherRepository, times(1)).findById(1L);
        verify(researcherRepository, times(1)).save(researcher1);
    }

    @Test
    void testDeleteById() {
        // Ejecutar el método deleteById()
        researcherService.deleteById(1L);

        // Verificar que el método deleteById fue llamado una vez con el ID correcto
        verify(researcherRepository, times(1)).deleteById(1L);
    }
}
