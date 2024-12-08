package com.ufmg.tennisscore.flow.gameeventnotification;

import com.ufmg.tennisscore.model.listenerevent.GameEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetEndpointsToEmitFlowItem {
    public List<String> get(GameEvent gameEvent){
        return List.of(
                "/" + gameEvent.getContest().toLowerCase().replace(" ", "_")
        );
    }
}
