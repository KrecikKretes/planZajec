package com.zawisza.planZajec.service;

import com.zawisza.planZajec.model.Plan;
import com.zawisza.planZajec.repository.PlanRepository;
import com.zawisza.planZajec.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    //public List<Plan> getPlanById_wykladowcyAndTydzien(List<Integer> id_wykladowcy, char tydzien){
    //    return planRepository.getPlanById_wykladowcyAndTydzien(id_wykladowcy, tydzien);
    //}
}
