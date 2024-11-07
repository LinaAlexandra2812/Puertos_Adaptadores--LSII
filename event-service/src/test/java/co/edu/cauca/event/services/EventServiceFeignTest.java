package co.edu.cauca.event.services;

import co.edu.cauca.event.access.IEventRepository;
import co.edu.cauca.event.domain.Event;
import co.edu.cauca.event.domain.Researcher;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EventServiceFeignTest {

    @Mock
    private IEventRepository eventRepository;

    @Mock
    private IResearcherClientRest researcherClient;

    @InjectMocks
    private EventServiceFeign eventService;

    private static final Long EVENT_ID = 1L;
    private static final Long RESEARCHER_ID_1 = 1L;
    private static final Long RESEARCHER_ID_2 = 2L;
    private static final Long RESEARCHER_ID_3 = 3L;

    private Researcher researcher1;
    private Researcher researcher2;
    private Researcher researcher3;

    @Before
    public void setUp() {
        
        MockitoAnnotations.openMocks(this);
        // Crear objetos Researcher
        researcher1 = new Researcher();
        researcher1.setName("Juan");

        researcher2 = new Researcher();
        researcher2.setName("Alicia");

        researcher3 = new Researcher();
        researcher3.setName("Vanesa");
    }

    @Test
    public void testFindAllResearcher_Success() throws NoSuchFieldException, IllegalAccessException {
        // Crear un evento simulado
        Event mockEvent = new Event();
        // Usar reflexión para acceder al campo privado comiteDeprograma
        Field field = Event.class.getDeclaredField("comiteDeprograma");
        field.setAccessible(true);
        field.set(mockEvent, Arrays.asList(RESEARCHER_ID_1, RESEARCHER_ID_2, RESEARCHER_ID_3));

        when(eventRepository.findById(EVENT_ID)).thenReturn(Optional.of(mockEvent));
        when(researcherClient.detail(RESEARCHER_ID_1)).thenReturn(researcher1);
        when(researcherClient.detail(RESEARCHER_ID_2)).thenReturn(researcher2);
        when(researcherClient.detail(RESEARCHER_ID_3)).thenReturn(researcher3);

        // Llamar al método que queremos probar
        var result = eventService.findAllResearcher(EVENT_ID);

        // Verificar el resultado
        assertEquals(3, result.size());
        assertEquals("JUan", result.get(0).getName());
        assertEquals("Alicia", result.get(1).getName());
        assertEquals("Vanesa", result.get(2).getName());
    }

    @Test
    public void testFindAllResearcher_EventNotFound() {
        // Simulamos el caso en el que no se encuentra el evento
        when(eventRepository.findById(EVENT_ID)).thenReturn(Optional.empty());

        // Llamar al método y verificar que se devuelve una lista vacía o manejar excepción
        var result = eventService.findAllResearcher(EVENT_ID);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
