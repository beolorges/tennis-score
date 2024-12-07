package com.ufmg.tennisscore.repositories;

import com.ufmg.tennisscore.model.entity.Contender;
import org.springframework.data.repository.CrudRepository;

public interface ContenderRepository extends CrudRepository<Contender, Integer> {
}
