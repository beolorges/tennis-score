package com.ufmg.tennisscore.repositories;

import com.ufmg.tennisscore.model.entity.Contest;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ContestRepository extends CrudRepository<Contest, UUID> {
}
