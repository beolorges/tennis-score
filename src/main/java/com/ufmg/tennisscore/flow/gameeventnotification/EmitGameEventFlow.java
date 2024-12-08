package com.ufmg.tennisscore.flow.gameeventnotification;

import com.ufmg.tennisscore.flow.emitevent.EmitWebSocketEventFlow;
import com.ufmg.tennisscore.model.listenerevent.GameEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmitGameEventFlow {
    private final EmitWebSocketEventFlow emitWebSocketEventFlow;
    private final GetEndpointsToEmitFlowItem getEndpointsToEmitFlowItem;

    private static final String URL = "ws://localhost:8080/ws";

    public void emit(GameEvent gameEvent) {
        List<String> endpointsToEmit = getEndpointsToEmitFlowItem.get(gameEvent);
        endpointsToEmit.forEach(
                endpoint -> emitWebSocketEventFlow.emit(URL, endpoint, gameEvent)
        );
    }
}
