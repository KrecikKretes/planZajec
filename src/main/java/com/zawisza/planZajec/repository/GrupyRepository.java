package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Grupy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupyRepository extends CrudRepository<Grupy, Integer> {
}

