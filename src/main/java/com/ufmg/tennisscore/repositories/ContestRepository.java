package com.ufmg.tennisscore.repositories;

import com.ufmg.tennisscore.model.entity.Contest;
import org.springframework.data.repository.CrudRepository;

public interface ContestRepository extends CrudRepository<Contest, Integer> {
}
