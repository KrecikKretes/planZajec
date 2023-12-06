package com.zawisza.planZajec.service;

import com.zawisza.planZajec.model.GrupyGrup;
import com.zawisza.planZajec.repository.GrupyGrupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupyGrupService {

    private final GrupyGrupRepository grupyGrupRepository;

    public int getCount(){
        return grupyGrupRepository.countAll();
    }

    public int getDistinctCount(){
        return grupyGrupRepository.countAllDistinct();
    }

    public List<String> getGrupyGrupy() {
        return grupyGrupRepository.findAllGrupyGrup();
    }

    public List<GrupyGrup> getAll(){
        return grupyGrupRepository.findAll();
    }

    public GrupyGrup findGrupyGrupById(int id){
        return grupyGrupRepository.findGrupyGrupById(id);
    }

    public GrupyGrup getGrupyGrupByIdGrupyAndNazwaGrup(int id_grupy, String nazwa_grupy){
        return grupyGrupRepository.findGrupyGrupByIdGrupyAndGrupaGrupy(id_grupy, nazwa_grupy);
    }
}
