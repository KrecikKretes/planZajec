package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Grupy;
import org.springframework.data.repository.CrudRepository;

public interface PlanRepository  extends CrudRepository<Grupy, Integer> {
}
