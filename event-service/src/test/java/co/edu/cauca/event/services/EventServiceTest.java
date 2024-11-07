package co.edu.cauca.event.services;

import co.edu.cauca.event.access.IEventRepository;
import co.edu.cauca.event.domain.Event;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

/**
 * Pruebas unitarias para la clase EventService.
 * 
 * @author earea
 */
public class EventServiceTest {

    @Mock
    private IEventRepository eventRepository; // Mock del repositorio

    @InjectMocks
    private EventService eventService; // El servicio que vamos a probar

    private Event mockEvent1;
    private Event mockEvent2;

    @Before
    public void setUp() {
        // Inicializa los mocks
        MockitoAnnotations.openMocks(this);

        // Crear algunos eventos simulados para las pruebas
        mockEvent1 = new Event();
        mockEvent1.setName("Conferencia de Tecnología");
        mockEvent1.setId(1L);

        mockEvent2 = new Event();
        mockEvent2.setName("Feria de Ciencia");
        mockEvent2.setId(2L);
    }

    /**
     * Test del método findAll de la clase EventService.
     */
    @Test
    public void testFindAll() {
        // Simulamos la respuesta del repositorio
        when(eventRepository.findAll()).thenReturn(Arrays.asList(mockEvent1, mockEvent2));

        // Llamamos al método del servicio
        List<Event> result = eventService.findAll();

        // Verificamos el resultado
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Conferencia de Tecnología", result.get(0).getName());
        assertEquals("Feria de Ciencia", result.get(1).getName());
    }

    /**
     * Test del método findById de la clase EventService.
     */
    @Test
    public void testFindById() {
        // Simulamos la respuesta del repositorio cuando se busca por ID
        when(eventRepository.findById(1L)).thenReturn(Optional.of(mockEvent1));

        // Llamamos al método del servicio
        Event result = eventService.findById(1L);

        // Verificamos el resultado
        assertNotNull(result);
        assertEquals("Conferencia de Tecnología", result.getName());
        assertEquals(Long.valueOf(1L), result.getId());
    }

    /**
     * Test del método create de la clase EventService.
     */
    @Test
    public void testCreate() {
        // Simulamos la creación de un nuevo evento
        when(eventRepository.save(mockEvent1)).thenReturn(mockEvent1);

        // Llamamos al método de crear
        Event result = eventService.create(mockEvent1);

        // Verificamos que el evento se haya creado correctamente
        assertNotNull(result);
        assertEquals("Conferencia de Tecnología", result.getName());
    }

    /**
     * Test del método update de la clase EventService.
     */
    @Test
    public void testUpdate() {
        // Simulamos la actualización de un evento
        when(eventRepository.findById(1L)).thenReturn(Optional.of(mockEvent1));
        when(eventRepository.save(mockEvent1)).thenReturn(mockEvent1);

        // Modificamos el nombre del evento
        mockEvent1.setName("Conferencia Actualizada");

        // Llamamos al método de actualización
        Event result = eventService.update(1L, mockEvent1);

        // Verificamos que se haya actualizado correctamente
        assertNotNull(result);
        assertEquals("Conferencia Actualizada", result.getName());
    }

    /**
     * Test del método deleteById de la clase EventService.
     */
    @Test
    public void testDeleteById() {
        // No necesitamos simular mucho aquí, solo verificamos que se llama al método correcto
        doNothing().when(eventRepository).deleteById(1L);

        // Llamamos al método de eliminación
        eventService.deleteById(1L);

        // Verificamos que el método deleteById del repositorio haya sido llamado con el ID correcto
        verify(eventRepository, times(1)).deleteById(1L);
    }
}
