package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.model.response.SportEventResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EnhanceSportEventWithTimeToEventFlowItemTest {

    @InjectMocks
    private EnhanceSportEventWithTimeToEventFlowItem enhanceSportEventWithTimeToEventFlowItem;

    @Test
    void shouldEnhanceSportEventResponseWithTimeToEvent() {
        // Given
        LocalDateTime eventDateTime = LocalDateTime.now().plusHours(2); // Evento em 2 horas
        SportEventResponse sportEventResponse = SportEventResponse.builder()
                .dateTime(eventDateTime)
                .build();

        // When
        enhanceSportEventWithTimeToEventFlowItem.enhance(sportEventResponse);

        // Assert
        assertNotNull(sportEventResponse.getTimeToEvent(), "Time to event should not be null.");

        // Comparação aproximada (granularidade em segundos)
        long expectedSeconds = Duration.between(LocalDateTime.now(), eventDateTime).toSeconds();
        long actualSeconds = sportEventResponse.getTimeToEvent().toSeconds();

        assertEquals(expectedSeconds, actualSeconds, 1, "Time to event should be within a second difference.");
    }
}

