package com.zawisza.planZajec.service;

import com.zawisza.planZajec.controller.SaleController;
import com.zawisza.planZajec.model.Sale;
import com.zawisza.planZajec.model.Wykladowcy;
import com.zawisza.planZajec.repository.SaleRepository;
import com.zawisza.planZajec.repository.WykladowcyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;

    public Sale getSaleBySala(String sala){
        return saleRepository.findSaleBySala(sala);
    }

    public int getCount(){
        return saleRepository.countAll();
    }

    public List<Sale> getSale(){
        return saleRepository.getSales();
    }

}
