package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Plan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanRepository  extends CrudRepository<Plan, Integer> {

    //@Query("Select p from Plan p WHERE p.id_wykladowcy in :id_wykladowcy  AND p.tydzien = :tydzien")
    //List<Plan> getPlanById_wykladowcyAndTydzien(@Param("id_wykladowcy") List<Integer> id_wykladowcy,@Param("tydzien") char tydzien);

    /*@Query("Select grupa,grupa_grupy, sala, nazwisko, nazwa from Plan p" +
            "JOIN grupy ON grupy.id = plan.id_grupy" +
            "JOIN grupy_grup ON grupy_grup.id_grupy = grupy.id" +
            "JOIN sale ON sale.id = plan.id_sale" +
            "JOIN wykladowcy ON wykladowcy.id = plan.id_wykladowcy")
    List<Plan> getAll();

     */

}
