package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.GrupyGrup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupyGrupRepository extends CrudRepository<GrupyGrup, Integer> {

    @Query("select count(*) from GrupyGrup ")
    int countAll();

    @Query("select DISTINCT count(*) from GrupyGrup")
    int countAllDistinct();

    @Query("Select p From GrupyGrup p")
    List<GrupyGrup> findAll();

    @Query("Select DISTINCT p.grupaGrupy From GrupyGrup p ORDER BY p.grupaGrupy ASC")
    List<String> findAllGrupyGrup();

    @Query("Select p From GrupyGrup p where p.grupy.id = :id_grupy and p.grupaGrupy = :nazwa_grupy")
    GrupyGrup findGrupyGrupByIdGrupyAndGrupaGrupy(@Param("id_grupy") int id_grupy, @Param("nazwa_grupy") String nazwa_grupy);

    @Query("Select p From GrupyGrup p WHERE p.id = :id")
    GrupyGrup findGrupyGrupById(@Param("id") int id);

}
