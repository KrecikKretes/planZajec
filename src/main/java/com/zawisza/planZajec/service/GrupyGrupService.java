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

    public List<GrupyGrup> getGrupyGrup(int id) {
        return grupyGrupRepository.findAllGrupyGrupByIdGrupy(id);
    }

    public GrupyGrup getGrupyGrupByIdGrupyAndNazwaGrup(int id_grupy, String nazwa_grupy){
        return grupyGrupRepository.findGrupyGrupByIdGrupyAndGrupaGrupy(id_grupy, nazwa_grupy);
    }
}
