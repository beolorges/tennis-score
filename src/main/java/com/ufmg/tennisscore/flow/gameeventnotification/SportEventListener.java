package com.ufmg.tennisscore.flow.gameeventnotification;

import com.ufmg.tennisscore.model.listenerevent.GameEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
public class SportEventListener {
    private final EmitGameEventFlow emitGameEventFlow;

    @RabbitListener(queues = "game-event-queue")
    public void listener(GameEvent gameEvent) throws ExecutionException, InterruptedException {
        emitGameEventFlow.emit(gameEvent);
    }


}
