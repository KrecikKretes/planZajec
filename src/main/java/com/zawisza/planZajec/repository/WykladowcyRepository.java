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
    List<Wykladowcy> findAllWykloadowcyBySkrot(@Param("skrot") String skrot);


}
