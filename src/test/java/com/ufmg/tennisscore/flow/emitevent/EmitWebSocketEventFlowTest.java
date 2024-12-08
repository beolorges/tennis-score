package com.ufmg.tennisscore.flow.emitevent;

import com.ufmg.tennisscore.config.CustomStompSessionHandler;
import com.ufmg.tennisscore.model.enums.GameEventType;
import com.ufmg.tennisscore.model.listenerevent.GameEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.util.concurrent.CompletableToListenableFutureAdapter;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmitWebSocketEventFlowTest {

    @InjectMocks
    private EmitWebSocketEventFlow emitWebSocketEventFlow;

    @Mock
    private WebSocketStompClient webSocketStompClient;
    @Mock
    private StompSession stompSession;

    @Test
    void shouldEmitWebSocketEventSuccessfully() {
        // Given
        String connectUrl = "ws://localhost:8080";
        String destinationUrl = "/game/event";
        GameEvent gameEvent = GameEvent.builder()
                .type(GameEventType.WIN)
                .description("Someone scores")
                .contest("US Open")
                .dateTime(LocalDateTime.now())
                .build();

        ListenableFuture<StompSession> stompSessionListenableFuture = new CompletableToListenableFutureAdapter(CompletableFuture.completedFuture(stompSession));


        when(webSocketStompClient.connect(eq(connectUrl), any(CustomStompSessionHandler.class))).thenReturn(stompSessionListenableFuture);

        // Execute the method and assert no exception is thrown
        assertDoesNotThrow(() -> emitWebSocketEventFlow.emit(connectUrl, destinationUrl, gameEvent));

        // Verify that the connect method was called
        verify(webSocketStompClient).connect(eq(connectUrl), any(CustomStompSessionHandler.class));

        // Verify that the send method was called with the correct parameters
        verify(stompSession).send(destinationUrl, gameEvent);
    }

    @Test
    void shouldThrowRuntimeExceptionWhenConnectFails() {
        // Given
        String connectUrl = "ws://localhost:8080";
        String destinationUrl = "/game/event";
        GameEvent gameEvent = GameEvent.builder()
                .type(GameEventType.WIN)
                .description("Someone scores")
                .contest("US Open")
                .dateTime(LocalDateTime.now())
                .build();

        ListenableFuture<StompSession> stompSessionListenableFuture = new CompletableToListenableFutureAdapter(CompletableFuture.completedFuture(stompSession));

        when(webSocketStompClient.connect(eq(connectUrl), any(CustomStompSessionHandler.class))).thenThrow(new RuntimeException("Connection failed"));

        // Execute the method and assert the exception is thrown
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> emitWebSocketEventFlow.emit(connectUrl, destinationUrl, gameEvent)
        );

        // Verify that the exception message is correct
        assertEquals("java.lang.RuntimeException: Connection failed", exception.getMessage());
    }

    @Test
    void shouldThrowRuntimeExceptionWhenSendFails() throws Exception {
        // Given
        String connectUrl = "ws://localhost:8080";
        String destinationUrl = "/game/event";
        GameEvent gameEvent = GameEvent.builder()
                .type(GameEventType.WIN)
                .description("Someone scores")
                .contest("US Open")
                .dateTime(LocalDateTime.now())
                .build();

        ListenableFuture<StompSession> stompSessionListenableFuture = new CompletableToListenableFutureAdapter(CompletableFuture.completedFuture(stompSession));

        when(webSocketStompClient.connect(eq(connectUrl), any(CustomStompSessionHandler.class))).thenReturn(stompSessionListenableFuture);
        doThrow(new RuntimeException("Send failed")).when(stompSession).send(destinationUrl, gameEvent);

        // Execute the method and assert the exception is thrown
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> emitWebSocketEventFlow.emit(connectUrl, destinationUrl, gameEvent)
        );

        // Verify that the exception message is correct
        assertEquals("Send failed", exception.getMessage());
    }
}

