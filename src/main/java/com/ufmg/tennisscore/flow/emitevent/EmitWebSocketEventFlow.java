package com.ufmg.tennisscore.flow.emitevent;

import com.ufmg.tennisscore.config.CustomStompSessionHandler;
import com.ufmg.tennisscore.model.listenerevent.GameEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Component
@RequiredArgsConstructor
public class EmitWebSocketEventFlow {
    private final WebSocketStompClient webSocketStompClient;

    public void emit(String connectUrl, String destinationUrl, GameEvent gameEvent) {
        StompSessionHandler sessionHandler = new CustomStompSessionHandler();
        StompSession stompSession = null;
        try {
            stompSession = webSocketStompClient.connect(connectUrl, sessionHandler).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        stompSession.send(destinationUrl, gameEvent);
    }
}
