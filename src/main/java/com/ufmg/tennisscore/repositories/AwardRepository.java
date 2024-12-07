package com.ufmg.tennisscore.repositories;

import com.ufmg.tennisscore.model.entity.Award;
import org.springframework.data.repository.CrudRepository;

public interface AwardRepository extends CrudRepository<Award, Integer> {
}
