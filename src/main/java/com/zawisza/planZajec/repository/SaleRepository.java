package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Sale;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Integer>{
}
