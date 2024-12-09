package com.ufmg.tennisscore.repositories;

import com.ufmg.tennisscore.model.entity.SportEvent;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SportEventRepository extends CrudRepository<SportEvent, Integer> {
    List<SportEvent> findAllByDateTimeBetween(LocalDateTime initialDate, LocalDateTime endDate);

    List<SportEvent> findAllByDateTimeGreaterThanEqual(LocalDateTime initialDate);

    List<SportEvent> findAllByDateTimeLessThanEqual(LocalDateTime endDate);

    List<SportEvent> findAllByContest_Name(String contest);

    List<SportEvent> findAllByDateTimeBetweenAndContest_Name(LocalDateTime initialDate, LocalDateTime endDate, String contest);
}
