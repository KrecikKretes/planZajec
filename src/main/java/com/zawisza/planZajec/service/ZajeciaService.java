package com.zawisza.planZajec.service;

import com.zawisza.planZajec.model.Zajecia;
import com.zawisza.planZajec.repository.ZajeciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ZajeciaService {

    private final ZajeciaRepository zajeciaRepository;

    public Zajecia getZajeciaByNazwa(String nazwa) {
        return zajeciaRepository.findZajeciaByNazwa(nazwa);
    }
}
