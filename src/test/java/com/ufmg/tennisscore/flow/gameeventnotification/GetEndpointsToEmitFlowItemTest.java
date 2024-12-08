package com.ufmg.tennisscore.flow.gameeventnotification;

import com.ufmg.tennisscore.model.enums.GameEventType;
import com.ufmg.tennisscore.model.listenerevent.GameEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GetEndpointsToEmitFlowItemTest {

    @InjectMocks
    private GetEndpointsToEmitFlowItem getEndpointsToEmitFlowItem;

    @Test
    void shouldReturnEndpointWithFormattedContestName() {
        // Given
        GameEvent gameEvent = GameEvent.builder()
                .type(GameEventType.WIN)
                .description("Someone scores")
                .contest("US Open")
                .dateTime(LocalDateTime.now())
                .build();
        gameEvent.setContest("US Open");

        // When
        List<String> endpoints = getEndpointsToEmitFlowItem.get(gameEvent);

        // Then
        assertNotNull(endpoints, "Endpoints list should not be null.");
        assertEquals(1, endpoints.size(), "There should be exactly one endpoint.");
        assertEquals("/us_open", endpoints.get(0), "The endpoint should match the expected formatted contest name.");
    }

    @Test
    void shouldHandleContestWithSpacesAndUpperCase() {
        // Given
        GameEvent gameEvent = GameEvent.builder()
                .type(GameEventType.WIN)
                .description("Someone scores")
                .contest("US Open")
                .dateTime(LocalDateTime.now())
                .build();
        gameEvent.setContest("Wimbledon Championship");

        // When
        List<String> endpoints = getEndpointsToEmitFlowItem.get(gameEvent);

        // Then
        assertNotNull(endpoints, "Endpoints list should not be null.");
        assertEquals(1, endpoints.size(), "There should be exactly one endpoint.");
        assertEquals("/wimbledon_championship", endpoints.get(0),
                "The endpoint should be correctly formatted with underscores and lowercase.");
    }

    @Test
    void shouldReturnEmptyEndpointForEmptyContestName() {
        // Given
        GameEvent gameEvent = GameEvent.builder()
                .type(GameEventType.WIN)
                .description("Someone scores")
                .contest("")
                .dateTime(LocalDateTime.now())
                .build();

        // When
        List<String> endpoints = getEndpointsToEmitFlowItem.get(gameEvent);

        // Then
        assertNotNull(endpoints, "Endpoints list should not be null.");
        assertEquals(1, endpoints.size(), "There should be exactly one endpoint.");
        assertEquals("/", endpoints.get(0), "The endpoint should be the root '/' when the contest name is empty.");
    }
}
