package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Grupy;
import com.zawisza.planZajec.model.Wykladowcy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupyRepository extends CrudRepository<Grupy, Integer> {

    @Query("select count(*) from Grupy ")
    int countAll();

    @Query("Select p from Grupy p WHERE p.grupa = :nazwa")
    Grupy getGrupyByGrupa(@Param("nazwa") String nazwa);

    @Query("Select p from Grupy p")
    List<Grupy> getGrupies();
}

