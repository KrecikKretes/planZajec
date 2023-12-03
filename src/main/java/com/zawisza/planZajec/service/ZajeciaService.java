package com.zawisza.planZajec.service;

import com.zawisza.planZajec.model.GrupyGrup;
import com.zawisza.planZajec.model.Zajecia;
import com.zawisza.planZajec.repository.ZajeciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ZajeciaService {

    private final ZajeciaRepository zajeciaRepository;

    public int getCount(){
        return zajeciaRepository.countAll();
    }

    public List<Zajecia> getZajecia() {
        return zajeciaRepository.findAllZajecia();
    }

    public Zajecia getZajeciaByNazwa(String nazwa) {
        return zajeciaRepository.findZajeciaByNazwa(nazwa);
    }

    public Zajecia findZajeciaById(int id){
        return zajeciaRepository.findZajeciaById(id);
    }
}
