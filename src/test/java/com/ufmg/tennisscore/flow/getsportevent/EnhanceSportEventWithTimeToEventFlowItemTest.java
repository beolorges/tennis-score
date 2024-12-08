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
        LocalDateTime eventDateTime = LocalDateTime.now().plusHours(2); // Event is in 2 hours
        Duration expectedTimeToEvent = Duration.between(LocalDateTime.now(), eventDateTime);

        SportEventResponse sportEventResponse = SportEventResponse.builder()
                .dateTime(eventDateTime)
                .build();

        // When
        enhanceSportEventWithTimeToEventFlowItem.enhance(sportEventResponse);

        // Assert that the timeToEvent in the response is set correctly.
        assertNotNull(sportEventResponse.getTimeToEvent(), "Time to event should not be null.");

        // Assert that the timeToEvent is correctly calculated.
        assertEquals(expectedTimeToEvent, sportEventResponse.getTimeToEvent(), "Time to event should be correctly calculated.");
    }
}

