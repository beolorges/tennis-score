package com.ufmg.tennisscore.repositories;

import com.ufmg.tennisscore.model.entity.Stadium;
import org.springframework.data.repository.CrudRepository;

public interface StadiumRepository extends CrudRepository<Stadium, Integer> {
}
