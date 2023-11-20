package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Sale;
import com.zawisza.planZajec.model.Zajecia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Integer>{

    @Query("Select p From Sale p where p.sala LIKE :sala")
    Sale findSaleBySala(@Param("sala") String sala);

}
