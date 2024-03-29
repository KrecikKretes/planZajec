package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Zajecia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ZajeciaRepository extends CrudRepository<Zajecia, Integer> {

    @Query("select count(*) from Zajecia ")
    int countAll();

    @Query("Select p From Zajecia p")
    List<Zajecia> findAllZajecia();

    @Query("Select p From Zajecia p where p.nazwa LIKE :nazwa")
    Zajecia findZajeciaByNazwa(@Param("nazwa") String nazwa);

    @Query("Select p From Zajecia p where p.id LIKE :id")
    Zajecia findZajeciaById(@Param("id") int id);

}
