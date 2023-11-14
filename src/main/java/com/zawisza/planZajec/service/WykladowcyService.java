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

    public List<Wykladowcy> getWykladowcy(String skrot) {
        return wykladowcyRepository.findAllWykloadowcyBySkrot(skrot);
    }
}
