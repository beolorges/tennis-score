package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.mapper.ResponseMapper;
import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.model.enums.EventPhase;
import com.ufmg.tennisscore.model.response.SportEventResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EnhanceSportEventFlowTest {

    @InjectMocks
    private EnhanceSportEventFlow enhanceSportEventFlow;

    @Mock
    private List<EnhanceSportEventFlowItem> enhanceSportEventFlowItems;

    @Mock
    private ResponseMapper responseMapper;

    @Mock
    private EnhanceSportEventFlowItem enhanceSportEventFlowItem;

    @Test
    void shouldEnhanceSportEventResponseWhenApplicable() {
        // Given
        SportEvent sportEvent = SportEvent.builder()
                .eventPhase(EventPhase.FINAL)
                .build();

        SportEventResponse sportEventResponse = SportEventResponse.builder()
                .eventPhase(EventPhase.FINAL)
                .build();

        // When
        when(responseMapper.toResponse(sportEvent)).thenReturn(sportEventResponse);
        when(enhanceSportEventFlowItem.isApplicable()).thenReturn(true);
        doNothing().when(enhanceSportEventFlowItem).enhance(sportEventResponse);
        when(enhanceSportEventFlowItems.stream()).thenReturn(Stream.of(enhanceSportEventFlowItem));

        SportEventResponse response = enhanceSportEventFlow.enhance(sportEvent);

        // Assert that the response is not null.
        assertNotNull(response, "The response should not be null.");

        // Assert that the enhance method was called on the applicable EnhanceSportEventFlowItem.
        verify(enhanceSportEventFlowItem, times(1)).enhance(sportEventResponse);

        // Assert that the event phase of the response matches the original sport event phase.
        assertEquals(sportEvent.getEventPhase(), response.getEventPhase(), "The event phase should match.");

        // Assert that the response is enhanced only if the EnhanceSportEventFlowItem is applicable.
        assertTrue(response.getEventPhase() == sportEvent.getEventPhase(), "The event phase should be correctly mapped.");
    }

    @Test
    void shouldNotEnhanceSportEventResponseWhenNotApplicable() {
        // Given
        SportEvent sportEvent = SportEvent.builder()
                .eventPhase(EventPhase.FINAL)
                .build();

        SportEventResponse sportEventResponse = SportEventResponse.builder()
                .eventPhase(EventPhase.FINAL)
                .build();

        // When
        when(responseMapper.toResponse(sportEvent)).thenReturn(sportEventResponse);
        when(enhanceSportEventFlowItem.isApplicable()).thenReturn(false);
        when(enhanceSportEventFlowItems.stream()).thenReturn(Stream.of(enhanceSportEventFlowItem));

        SportEventResponse response = enhanceSportEventFlow.enhance(sportEvent);

        // Assert that the response is not null.
        assertNotNull(response, "The response should not be null.");

        // Assert that the enhance method was not called on the EnhanceSportEventFlowItem.
        verify(enhanceSportEventFlowItem, times(0)).enhance(sportEventResponse);

        // Assert that the event phase in the response matches the original event phase.
        assertEquals(sportEvent.getEventPhase(), response.getEventPhase(), "The event phase should remain unchanged.");
    }
}
