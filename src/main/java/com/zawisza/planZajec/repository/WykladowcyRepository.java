package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Wykladowcy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WykladowcyRepository extends CrudRepository<Wykladowcy, Integer> {

    @Query("Select p From Wykladowcy p where p.skrot LIKE :skrot")
    List<Wykladowcy> findAllWykladowcyBySkrot(@Param("skrot") String skrot);

    @Query("Select p From Wykladowcy p where p.skrot LIKE :skrot")
    Wykladowcy findWykladowcyBySkrot(@Param("skrot") String skrot);

    @Query("Select p From Wykladowcy p where p.skrot LIKE :skrot and p.id_strony = :id_strony")
    Wykladowcy findWykladowcyBySkrotAndId_strony(@Param("skrot") String skrot, @Param("id_strony") int id_strony);

    @Query("Select p From Wykladowcy p where p.skrot LIKE :skrot and p.id_strony > 0")
    Wykladowcy findWykladowcyBySkrotAndId_stronyMoreThan0(@Param("skrot") String skrot);

    @Query("Select p From Wykladowcy p where p.skrot LIKE :skrot and p.nazwisko LIKE :nazwisko")
    Wykladowcy findWykladowcyByNazwiskoAndSkrot(@Param("nazwisko") String nazwisko,@Param("skrot") String skrot);

    @Query("select count(*) from Wykladowcy ")
    int countAll();

    @Query("Select p from Wykladowcy p")
    List<Wykladowcy> getWykladowcies();

    @Query("Select DISTINCT p.nazwisko from Wykladowcy p")
    List<String> getUniqueName();

    @Query("Select DISTINCT p.skrot from Wykladowcy p")
    List<String> getUniqueSkrot();

    @Query( "select p.id from Wykladowcy p where p.nazwisko in :nazwisko" )
    List<Integer> getIdByNazwisko(@Param("nazwisko") List<String> nazwisko);

}
