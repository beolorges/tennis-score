package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.model.response.SportEventResponse;

public interface EnhanceSportEventFlowItem {
    void enhance(SportEventResponse sportEventResponse);

    default boolean isApplicable() {
        return true;
    }
}
