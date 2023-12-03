package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Wykladowcy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WykladowcyRepository extends CrudRepository<Wykladowcy, Integer> {


    @Query("Select p From Wykladowcy p where p.id_strony = :id_strony")
    Wykladowcy findWykladowcyById_strony(@Param("id_strony") int id_strony);

    @Query("Select p From Wykladowcy p where p.id = :id")
    Wykladowcy findWykladowcyById(@Param("id") int id);


    @Query("Select p From Wykladowcy p where p.skrot LIKE :skrot and p.id_strony = :id_strony")
    Wykladowcy findWykladowcyBySkrotAndId_strony(@Param("skrot") String skrot, @Param("id_strony") int id_strony);


    @Query("select count(*) from Wykladowcy ")
    int countAll();

    @Query("Select p from Wykladowcy p")
    List<Wykladowcy> getWykladowcies();

    @Query("Select DISTINCT p.nazwisko from Wykladowcy p")
    List<String> getUniqueName();

    @Query("Select DISTINCT p.skrot from Wykladowcy p")
    List<String> getUniqueSkrot();

}
