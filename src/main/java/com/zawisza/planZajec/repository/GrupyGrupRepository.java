package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.GrupyGrup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupyGrupRepository extends CrudRepository<GrupyGrup, Integer> {

    @Query("Select p From GrupyGrup p where p.idGrupy = :id_grupy")
    List<GrupyGrup> findAllGrupyGrupByIdGrupy(@Param("id_grupy") int id_grupy);

    @Query("Select p From GrupyGrup p where p.idGrupy = :id_grupy and p.grupaGrupy = :nazwa_grupy")
    GrupyGrup findGrupyGrupByIdGrupyAndGrupaGrupy(@Param("id_grupy") int id_grupy, @Param("nazwa_grupy") String nazwa_grupy);


}
