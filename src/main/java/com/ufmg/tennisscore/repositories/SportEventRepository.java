package com.ufmg.tennisscore.repositories;

import com.ufmg.tennisscore.model.entity.SportEvent;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SportEventRepository extends CrudRepository<SportEvent, UUID> {
}
