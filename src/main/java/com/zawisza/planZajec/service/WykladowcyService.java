package com.zawisza.planZajec.service;

import com.zawisza.planZajec.model.Wykladowcy;
import com.zawisza.planZajec.repository.WykladowcyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WykladowcyService {

    private final WykladowcyRepository wykladowcyRepository;

    public Wykladowcy getWykladwcyById(int id_strony){
        return wykladowcyRepository.findWykladowcyById_strony(id_strony);
    }

    public List<Wykladowcy> getWykladowcy() {
        return wykladowcyRepository.getWykladowcies();
    }

    public int getCount(){
        return wykladowcyRepository.countAll();
    }

    public List<String> getUniqueName(){
        return wykladowcyRepository.getUniqueName();
    }

    public List<String> getUniqueSkrot(){
        return wykladowcyRepository.getUniqueSkrot();
    }

    public Wykladowcy findWykladowcyById(int id){
        return wykladowcyRepository.findWykladowcyById(id);
    }
}
