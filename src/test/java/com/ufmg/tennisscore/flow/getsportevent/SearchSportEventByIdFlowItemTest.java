package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.repositories.SportEventRepository;
import org.junit.jupiter.api.Test;
import com.ufmg.tennisscore.model.entity.Contender;
import com.ufmg.tennisscore.model.entity.Contest;
import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.model.entity.Stadium;
import com.ufmg.tennisscore.model.enums.EventPhase;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchSportEventByIdFlowItemTest {

    @InjectMocks
    private SearchSportEventByIdFlowItem searchSportEventByIdFlowItem;

    @Mock
    private SportEventRepository sportEventRepository;

    @Test
    void shouldReturnSportEventWhenItExists() {
        int id = 10;

        Contender contenderOne = Contender.builder().name("Contender One").build();
        Contender contenderTwo = Contender.builder().name("Contender Two").build();
        Contest contest = Contest.builder().name("US Open").build();
        LocalDateTime now = LocalDateTime.now();
        Stadium stadium = Stadium.builder().name("Hard Court").build();

        SportEvent sportEvent = SportEvent.builder()
                .eventPhase(EventPhase.FINAL)
                .contenders(List.of(contenderOne, contenderTwo))
                .contest(contest)
                .stadium(stadium)
                .dateTime(now)
                .build();

        when(sportEventRepository.findById(id)).thenReturn(Optional.of(sportEvent));

        Optional<SportEvent> result = searchSportEventByIdFlowItem.search(id);

        // Assert that the result is present (not empty).
        assertTrue(result.isPresent(), "The result should contain a SportEvent when the ID exists.");

        // Assert that the returned SportEvent matches the mocked SportEvent.
        assertEquals(sportEvent, result.get(), "The returned SportEvent should match the expected SportEvent.");

        // Assert that the contest name matches the expected name.
        assertEquals("US Open", result.get().getContest().getName(), "The contest name should be 'US Open'.");
    }

    @Test
    void shouldReturnEmptyWhenSportEventDoesNotExist() {
        int id = 101;

        when(sportEventRepository.findById(id)).thenReturn(Optional.empty());

        Optional<SportEvent> result = searchSportEventByIdFlowItem.search(id);

        // Assert that the result is empty (no SportEvent found).
        assertFalse(result.isPresent(), "The result should be empty when the ID does not exist.");
    }
}

