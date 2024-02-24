package com.zawisza.planZajec.service;

import com.zawisza.planZajec.model.Grupy;
import com.zawisza.planZajec.repository.GrupyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GrupyService {

    private final GrupyRepository grupyRepository;

    public int getCount(){
        return grupyRepository.countAll();
    }

    public List<Grupy> getAll(){
        return grupyRepository.getGrupies();
    }

    public Grupy getGrupyByNazwa(String nazwa){
        return grupyRepository.getGrupyByGrupa(nazwa);
    }

}
