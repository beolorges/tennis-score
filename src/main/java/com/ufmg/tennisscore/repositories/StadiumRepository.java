package com.ufmg.tennisscore.repositories;

import com.ufmg.tennisscore.model.entity.Stadium;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StadiumRepository extends CrudRepository<Stadium, UUID> {
}
