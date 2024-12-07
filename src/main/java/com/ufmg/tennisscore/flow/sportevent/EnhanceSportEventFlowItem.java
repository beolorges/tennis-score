package com.ufmg.tennisscore.flow.sportevent;

import com.ufmg.tennisscore.model.response.SportEventResponse;

public interface EnhanceSportEventFlowItem {
    void enhance(SportEventResponse sportEventResponse);

    default boolean isApplicable() {
        return true;
    }
}
