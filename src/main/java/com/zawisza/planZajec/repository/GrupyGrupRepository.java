package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Grupy;
import com.zawisza.planZajec.model.GrupyGrup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupyGrupRepository extends CrudRepository<GrupyGrup, Integer> {
}
