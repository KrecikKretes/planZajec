package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Sale;
import com.zawisza.planZajec.model.Wykladowcy;
import com.zawisza.planZajec.model.Zajecia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Integer>{

    @Query("Select p From Sale p where p.sala LIKE :sala")
    Sale findSaleBySala(@Param("sala") String sala);

    @Query("select count(*) from Sale ")
    int countAll();

    @Query("Select p from Sale p")
    List<Sale> getSales();

    @Query("Select p From Sale p WHERE p.id = :id")
    Sale getSaleById(@Param("id") int id);

    @Query("select max(p.id) FROM Sale p")
    int getLastID();
}
