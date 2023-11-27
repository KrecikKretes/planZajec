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

    public List<Wykladowcy> getWykladowcies(String skrot) {
        return wykladowcyRepository.findAllWykladowcyBySkrot(skrot);
    }

    public Wykladowcy getWykladwcyById(int id_strony){
        return wykladowcyRepository.findWykladowcyById_strony(id_strony);
    }

    public Wykladowcy getWykladowcy(String skrot) {
        return wykladowcyRepository.findWykladowcyBySkrot(skrot);
    }

    public Wykladowcy getWykladowcyBySkrotAndIdStronyMoreThan0(String skrot){
        return wykladowcyRepository.findWykladowcyBySkrotAndId_stronyMoreThan0(skrot);
    }

    public Wykladowcy getWykladowcyBySkrotAndIdStrony(String skrot, int id_strony){
        return wykladowcyRepository.findWykladowcyBySkrotAndId_strony(skrot, id_strony);
    }

    public Wykladowcy getWykladowcyByNazwiskoAndSkrot(String nazwisko, String skrot){
        return wykladowcyRepository.findWykladowcyByNazwiskoAndSkrot(nazwisko, skrot);
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

    public List<Integer> getIdByNazwisko(List<String> nazwisko){
        return wykladowcyRepository.getIdByNazwisko(nazwisko);
    }
}
