package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Wykladowcy;
import com.zawisza.planZajec.model.Zajecia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ZajeciaRepository extends CrudRepository<Zajecia, Integer> {

    @Query("Select p From Zajecia p where p.nazwa LIKE :nazwa")
    Zajecia findZajeciaByNazwa(@Param("nazwa") String nazwa);

}
