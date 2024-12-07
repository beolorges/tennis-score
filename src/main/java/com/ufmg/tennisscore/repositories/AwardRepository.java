package com.ufmg.tennisscore.repositories;

import com.ufmg.tennisscore.model.entity.Award;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AwardRepository extends CrudRepository<Award, UUID> {
}
