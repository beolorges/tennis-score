package com.ufmg.tennisscore.flow.gameeventnotification;

import com.ufmg.tennisscore.flow.emitevent.EmitWebSocketEventFlow;
import com.ufmg.tennisscore.model.enums.GameEventType;
import com.ufmg.tennisscore.model.listenerevent.GameEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmitGameEventFlowTest {

    @InjectMocks
    private EmitGameEventFlow emitGameEventFlow;

    @Mock
    private EmitWebSocketEventFlow emitWebSocketEventFlow;

    @Mock
    private GetEndpointsToEmitFlowItem getEndpointsToEmitFlowItem;

    private static final String URL = "ws://localhost:8080/ws";

    @Test
    void shouldEmitGameEventToAllEndpoints() {
        // Given
        GameEvent gameEvent = GameEvent.builder()
                .type(GameEventType.WIN)
                .description("Someone scores")
                .contest("US Open")
                .dateTime(LocalDateTime.now())
                .build();

        List<String> endpointsToEmit = List.of("/game/event1", "/game/event2");

        when(getEndpointsToEmitFlowItem.get(gameEvent)).thenReturn(endpointsToEmit);

        // Execute the method and assert no exception is thrown
        assertDoesNotThrow(() -> emitGameEventFlow.emit(gameEvent));

        // Verify that getEndpointsToEmitFlowItem.get() is called once
        verify(getEndpointsToEmitFlowItem, times(1)).get(gameEvent);

        // Verify that emitWebSocketEventFlow.emit() is called for each endpoint
        for (String endpoint : endpointsToEmit) {
            verify(emitWebSocketEventFlow).emit(URL, endpoint, gameEvent);
        }
    }

    @Test
    void shouldNotEmitWhenNoEndpointsAvailable() {
        // Given
        GameEvent gameEvent = GameEvent.builder()
                .type(GameEventType.WIN)
                .description("Someone scores")
                .contest("US Open")
                .dateTime(LocalDateTime.now())
                .build();
        List<String> endpointsToEmit = List.of();

        when(getEndpointsToEmitFlowItem.get(gameEvent)).thenReturn(endpointsToEmit);

        // Execute the method and assert no exception is thrown
        assertDoesNotThrow(() -> emitGameEventFlow.emit(gameEvent));

        // Verify that getEndpointsToEmitFlowItem.get() is called once
        verify(getEndpointsToEmitFlowItem, times(1)).get(gameEvent);

        // Verify that emitWebSocketEventFlow.emit() is not called
        verify(emitWebSocketEventFlow, never()).emit(anyString(), anyString(), any(GameEvent.class));
    }
}
