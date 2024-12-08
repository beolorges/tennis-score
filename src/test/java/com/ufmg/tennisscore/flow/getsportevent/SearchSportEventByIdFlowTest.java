package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.exceptions.SportEventNotFoundException;
import com.ufmg.tennisscore.model.entity.Contender;
import com.ufmg.tennisscore.model.entity.Contest;
import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.model.entity.Stadium;
import com.ufmg.tennisscore.model.enums.EventPhase;
import com.ufmg.tennisscore.model.response.ContenderResponse;
import com.ufmg.tennisscore.model.response.ContestResponse;
import com.ufmg.tennisscore.model.response.SportEventResponse;
import com.ufmg.tennisscore.model.response.StadiumResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchSportEventByIdFlowTest {
    @InjectMocks
    private SearchSportEventByIdFlow searchSportEventByIdFlow;

    @Mock
    private SearchSportEventByIdFlowItem searchSportEventByIdFlowItem;
    @Mock
    private EnhanceSportEventFlow enhanceSportEventFlow;

    @Test
    void shouldReturnValidSportEventWhenItExists(){
        int id = 10;

        Contender contenderOne = Contender.builder().name("Contender One").build();
        Contender contenderTwo = Contender.builder().name("Contender Two").build();

        Contest contest = Contest.builder()
                .name("US Open")
                .build();

        LocalDateTime now = LocalDateTime.now();
        Stadium stadium = Stadium.builder().name("Hard Court").build();
        SportEvent sportEventFounded = SportEvent.builder()
                .eventPhase(EventPhase.FINAL)
                .contenders(List.of(contenderOne, contenderTwo))
                .contest(contest)
                .stadium(stadium)
                .dateTime(now)
                .build();

        Optional<SportEvent> optionSportEvent = Optional.of(sportEventFounded);

        ContenderResponse contenderResponseOne = ContenderResponse.builder().name("Contender One").build();
        ContenderResponse contenderResponseTwo = ContenderResponse.builder().name("Contender Two").build();

        ContestResponse contestResponse = ContestResponse.builder().name("US Open").build();
        StadiumResponse stadiumResponse = StadiumResponse.builder().name("Hard Court").build();

        SportEventResponse sportEventResponse = SportEventResponse.builder()
                .eventPhase(EventPhase.FINAL)
                .contenders(List.of(contenderResponseOne, contenderResponseTwo))
                .contest(contestResponse)
                .dateTime(now)
                .stadium(stadiumResponse)
                .timeToEvent(Duration.ofDays(1))
                .build();

        when(searchSportEventByIdFlowItem.search(id)).thenReturn(optionSportEvent);
        when(enhanceSportEventFlow.enhance(sportEventFounded)).thenReturn(sportEventResponse);

        // Execute the method and assert that no exception is thrown.
        SportEventResponse response = assertDoesNotThrow(() -> searchSportEventByIdFlow.search(id));

        // Assert that the event phase is the same as the one in the original SportEvent.
        assertEquals(response.getEventPhase(), sportEventFounded.getEventPhase(), "The event phase should match.");

        // Assert that the first contender's name matches the original SportEvent's contender's name.
        assertEquals(response.getContenders().get(0).getName(), sportEventFounded.getContenders().get(0).getName(),
                "The name of the first contender should match the original.");

        // Assert that the stadium name matches the original SportEvent's stadium name.
        assertEquals(response.getStadium().getName(), sportEventFounded.getStadium().getName(),
                "The stadium name should match the original.");
    }

    @Test
    void shouldThrowNotFoundException(){
        int id = 101;

        when(searchSportEventByIdFlowItem.search(id)).thenReturn(Optional.empty());

        // Assert that the exception is thrown when the event is not found.
        SportEventNotFoundException exception = assertThrows(
                SportEventNotFoundException.class,
                () -> searchSportEventByIdFlow.search(id)
        );

        // Assert that the exception message is correct.
        assertEquals("Não foi possível localizar o evento 101", exception.getMessage(), "The exception message should match.");

        // Assert that the status code is 404.
        assertEquals(404, exception.getStatus(), "The status code should be 404 for 'Not Found'.");
    }
}
