package co.edu.cauca.chair_service.services;

import domain.services.ChairService;
import domain.ports.output.IChairRepository;
import domain.model.Chair;
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

class ChairServiceTest {

    @Mock
    private IChairRepository chairRepository;

    @InjectMocks
    private ChairService chairService;

    private Chair chair1;
    private Chair chair2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Crear objetos Chair simulados
        chair1 = new Chair("John", "Doe", "jhon.doe@example.com");

        chair2 = new Chair("Jane", "Smith", "jane.smith@example.com");
    }

    @Test
    void testFindAll() {
        // Simular la respuesta del repositorio
        when(chairRepository.findAll()).thenReturn(Arrays.asList(chair1, chair2));

        // Ejecutar el método findAll()
        List<Chair> result = chairService.findAll();

        // Verificar que el resultado contiene las dos sillas
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Jane", result.get(1).getName());

        // Verificar que el método findAll fue llamado una vez
        verify(chairRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Simular la respuesta del repositorio
        when(chairRepository.findById(1L)).thenReturn(Optional.of(chair1));

        // Ejecutar el método findById()
        Chair result = chairService.findById(1L);

        // Verificar que el resultado es la silla correcta
        assertNotNull(result);
        assertEquals("John", result.getName());
        assertEquals("Doe", result.getLastName());

        // Verificar que el método findById fue llamado una vez con el ID correcto
        verify(chairRepository, times(1)).findById(1L);
    }

    @Test
    void testCreate() {
        // Simular la respuesta del repositorio
        when(chairRepository.save(chair1)).thenReturn(chair1);

        // Ejecutar el método create()
        Chair result = chairService.create(chair1);

        // Verificar que el resultado es la silla creada
        assertNotNull(result);
        assertEquals("John", result.getName());

        // Verificar que el método save fue llamado una vez
        verify(chairRepository, times(1)).save(chair1);
    }

    @Test
    void testUpdate() {
        // Simular la respuesta del repositorio
        when(chairRepository.findById(1L)).thenReturn(Optional.of(chair1));
        when(chairRepository.save(chair1)).thenReturn(chair1);

        // Actualizar algunos valores
        chair2.setName("Updated Name");

        // Ejecutar el método update()
        Chair result = chairService.update(1L, chair2);

        // Verificar que el nombre fue actualizado correctamente
        assertNotNull(result);
        assertEquals("Updated Name", result.getName());

        // Verificar que el método findById fue llamado una vez y save fue llamado para actualizar
        verify(chairRepository, times(1)).findById(1L);
        verify(chairRepository, times(1)).save(chair1);
    }

    @Test
    void testDeleteById() {
        // Ejecutar el método deleteById()
        chairService.deleteById(1L);

        // Verificar que el método deleteById fue llamado una vez con el ID correcto
        verify(chairRepository, times(1)).deleteById(1L);
    }
}
