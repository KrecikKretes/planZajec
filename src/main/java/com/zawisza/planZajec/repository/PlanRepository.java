package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Plan;
import org.springframework.data.repository.CrudRepository;

public interface PlanRepository  extends CrudRepository<Plan, Integer> {
}
