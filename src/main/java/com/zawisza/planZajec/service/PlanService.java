package com.zawisza.planZajec.service;

import com.zawisza.planZajec.model.Plan;
import com.zawisza.planZajec.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    /*
    public List<Plan> getAllResults(List<String> wykladowcyNazwa, List<String> grupa,
                                    List<String> grupaGrupy, List<String> sala,
                                    List<String> zajeciaNazwa, List<String> wykladowcySkrot,
                                    List<String> tydzien, List<String> godz,
                                    List<String> dzien){
        return planRepository.getAllResults(wykladowcyNazwa, grupa, grupaGrupy,
                sala, zajeciaNazwa,
                wykladowcySkrot, tydzien,
                godz, dzien);
    }

     */

    public List<Plan> getPlan(){
        return planRepository.getPlan();
    }


    //Jeden warunek

    public List<Plan> getPlanByWykladowcyNazwisko(List<String> wykladowcyNazwa){
        return planRepository.getPlanByWykladowcyNazwisko(wykladowcyNazwa);
    }

    public List<Plan> getPlanByWykladowcySkrot(List<String> wykladowcySkrot){
        return planRepository.getPlanByWykladowcySkrot(wykladowcySkrot);
    }

    public List<Plan> getPlanByZajeciaNazwa(List<String> zajeciaNazwa){
        return planRepository.getPlanByZajeciaNazwa(zajeciaNazwa);
    }

    public List<Plan> getPlanByGrupyGrupGrupy(List<String> grupy){
        return planRepository.getPlanByGrupyGrupGrupy(grupy);
    }

    public List<Plan> getPlanByGrupyGrup(List<String> grupyGrup){
        return planRepository.getPlanByGrupyGrup(grupyGrup);
    }


    public List<Plan> getPlanBySale(List<String> sale){
        return planRepository.getPlanBySale(sale);
    }

    public List<Plan> getPlanByTydzien(List<String> tydzien){
        return planRepository.getPlanByTydzien(tydzien);
    }

    public List<Plan> getPlanByDzien(List<String> dzien){
        return planRepository.getPlanByDzien(dzien);
    }

    public List<Plan> getPlanByGodz(List<String> godz){
        return planRepository.getPlanByGodz(godz);
    }

    //Dwa warunki

    public List<Plan> getPlanByWykladowcyNazwiskoAndDzien(
            List<String> wykladowcyName, List<String> dzien) {
        return planRepository.getPlanByWykladowcyNazwiskoAndDzien(
                wykladowcyName, dzien
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGodz(
            List<String> wykladowcyName, List<String> godz) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGodz(wykladowcyName, godz);
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndTydzien(
            List<String> wykladowcyName, List<String> tydzien) {
        return planRepository.getPlansByWykladowcyNazwiskoAndTydzien(
                wykladowcyName, tydzien
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa) {
        return planRepository.getPlanByWykladowcyNazwiskoAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupy(
            List<String> wykladowcyName, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupy(
                wykladowcyName, grupaGrupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupy(
            List<String> wykladowcyName, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupy(
                wykladowcyName, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSale(
            List<String> wykladowcyName, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSale(
                wykladowcyName, sale
        );
    }

    //3 warunki

    public List<Plan> getPlanByWykladowcyNazwiskoAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz, List<String> dzien) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGodzAndDzien(wykladowcyName, godz, dzien);
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien, List<String> tydzien) {
        return planRepository.getPlanByWykladowcyNazwiskoAndTydzienAndDzien(
                wykladowcyName, dzien, tydzien
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz, List<String> tydzien) {
        return planRepository.getPlanByWykladowcyNazwiskoAndTydzienAndGodz(
                wykladowcyName, godz, tydzien
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien, List<String> zajeciaNazwa) {
        return planRepository.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndDzien(
                wykladowcyName,dzien,zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz, List<String> zajeciaNazwa) {
        return planRepository.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndGodz(
                wykladowcyName,godz, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien, List<String> zajeciaNazwa) {
        return planRepository.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzien(
                wykladowcyName,tydzien,zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndDzien(
                wykladowcyName, dzien, grupaGrupy);
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndGodz(
                wykladowcyName, godz, grupaGrupy);
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndDzien(
                wykladowcyName, dzien, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGodz(
                wykladowcyName, godz, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndTydzien(
                wykladowcyName, tydzien, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupy(
            List<String> wykladowcyName, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupy(
                wykladowcyName, grupaGrupy, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzien(
                wykladowcyName, tydzien, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndDzien(
            List<String> wykladowcyName, List<String> dzien, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndDzien(
                wykladowcyName, dzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGodz(
            List<String> wykladowcyName, List<String> godz, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGodz(
                wykladowcyName, godz, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndTydzien(
            List<String> wykladowcyName, List<String> tydzien, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndTydzien(
                wykladowcyName, tydzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupy(
            List<String> wykladowcyName, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupy(
                wykladowcyName, grupaGrupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupy(
            List<String> wykladowcyName, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupy(
                wykladowcyName, grupy, sale
        );
    }

    //4 warunki

    public List<Plan> getPlanByWykladowcyNazwiskoAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien) {
        return planRepository.getPlanByWykladowcyNazwiskoAndTydzienAndGodzAndDzien(
                wykladowcyName,godz,dzien,tydzien);
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa) {
        return planRepository.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, godz, dzien, zajeciaNazwa);
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa) {
        return planRepository.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName,dzien,tydzien,zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa) {
        return planRepository.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName,godz,tydzien,zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndGodzAndDzien(
                wykladowcyName, godz,
                dzien, grupaGrupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzienAndDzien(
                wykladowcyName, dzien,
                tydzien, grupaGrupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndDzien(
                wykladowcyName, dzien, zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndGodz(
                wykladowcyName, godz, zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGodzAndDzien(
                wykladowcyName, godz, dzien, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndDzien(
                wykladowcyName, tydzien, dzien, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndGodz(
                wykladowcyName, tydzien, godz, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndDzien(
                wykladowcyName, dzien, zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndGodz(
                wykladowcyName, godz, zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzien(
                wykladowcyName, tydzien, zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndDzien(
                wykladowcyName, dzien, grupaGrupy, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndGodz(
                wykladowcyName, godz, grupaGrupy, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndGodz(
                wykladowcyName, godz, tydzien, grupy
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, grupaGrupy, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGodzAndDzien(
                wykladowcyName, godz, dzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndDzien(
                wykladowcyName, tydzien, dzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndGodz(
                wykladowcyName, tydzien, godz, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndDzien(
                wykladowcyName, dzien, zajeciaNazwa, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndGodz(
                wykladowcyName, godz, zajeciaNazwa, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzien(
                wykladowcyName, tydzien, zajeciaNazwa, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndDzien(
                wykladowcyName, dzien, grupaGrupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndGodz(
                wykladowcyName, godz, grupaGrupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyGrupAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyGrupAndTydzien(
                wykladowcyName, tydzien, grupaGrupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, grupaGrupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndDzien(
                wykladowcyName, dzien, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGodz(
                wykladowcyName, godz, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzien(
                wykladowcyName, tydzien, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupy(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupy(
                wykladowcyName, grupaGrupy, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzien(
                wykladowcyName, tydzien, grupy, sale
        );
    }

    //5 warunków

    public List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien, List<String> zajeciaNazwa) {
        return planRepository.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, godz, dzien, tydzien, zajeciaNazwa
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzienAndGodzAndDzien(
                wykladowcyName, godz, dzien, tydzien, grupaGrupy
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, godz, dzien, zajeciaNazwa, grupaGrupy
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, dzien, tydzien,
                zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, godz, tydzien,
                zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndGodzAndDzien(
                wykladowcyName, godz, tydzien,
                dzien, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, godz, zajeciaNazwa,
                dzien, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, tydzien, zajeciaNazwa,
                dzien, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, tydzien, zajeciaNazwa,
                godz, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndGodzAndDzien(
                wykladowcyName, dzien, grupaGrupy,
                godz, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndDzien(
                wykladowcyName, dzien, grupaGrupy,
                tydzien, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
                wykladowcyName, dzien, grupaGrupy,
                zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
                wykladowcyName, godz, grupaGrupy,
                zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                wykladowcyName, tydzien, grupaGrupy,
                zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndGodzAndDzien(
                wykladowcyName, tydzien, godz,
                dzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, zajeciaNazwa, godz,
                dzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, zajeciaNazwa, tydzien,
                dzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, zajeciaNazwa, tydzien,
                godz, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndGodzAndDzien(
                wykladowcyName, grupaGrupy, dzien,
                godz, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndDzien(
                wykladowcyName, grupaGrupy, dzien,
                tydzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndGodz(
                wykladowcyName, grupaGrupy, godz,
                tydzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(
                wykladowcyName, grupaGrupy, dzien,
                zajeciaNazwa, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(
                wykladowcyName, grupaGrupy, godz,
                zajeciaNazwa, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                wykladowcyName, grupaGrupy, tydzien,
                zajeciaNazwa, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndDzien(
                wykladowcyName, tydzien, dzien,
                grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndGodz(
                wykladowcyName, tydzien, godz,
                grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndDzien(
                wykladowcyName, dzien, zajeciaNazwa,
                grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndGodz(
                wykladowcyName, godz, zajeciaNazwa,
                grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskAndSaleoAndGrupyAndZajeciaNazwaAndTydzien(
                wykladowcyName, tydzien, zajeciaNazwa,
                grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndDzien(
                wykladowcyName, dzien, grupaGrupy,
                grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndGodz(
                wykladowcyName, godz, grupaGrupy,
                grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
                wykladowcyName, godz, tydzien,
                grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, grupaGrupy,
                grupy, sale
        );
    }

    //6 warunków


    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                tydzien, zajeciaNazwa, grupaGrupy
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                tydzien, zajeciaNazwa, grupy
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                tydzien, grupaGrupy, grupy
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                zajeciaNazwa, grupaGrupy, grupy
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, tydzien, dzien,
                zajeciaNazwa, grupaGrupy, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, tydzien, godz,
                zajeciaNazwa, grupaGrupy, grupy
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, tydzien, godz,
                zajeciaNazwa, dzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(
                wykladowcyName, tydzien, godz,
                grupaGrupy, dzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, zajeciaNazwa, godz,
                grupaGrupy, dzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, zajeciaNazwa, tydzien,
                grupaGrupy, dzien, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, zajeciaNazwa, tydzien,
                grupaGrupy, godz, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndGodzAndDzien(
                wykladowcyName, godz, tydzien,
                dzien, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, godz, zajeciaNazwa,
                dzien, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, tydzien, zajeciaNazwa,
                dzien, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, tydzien, zajeciaNazwa,
                godz, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupaGrupy,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(
                wykladowcyName, dzien, grupaGrupy,
                godz, grupy, sale
        );

    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(
                wykladowcyName, dzien, grupaGrupy,
                tydzien, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
                wykladowcyName, dzien, grupaGrupy,
                zajeciaNazwa, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
                wykladowcyName, godz, grupaGrupy,
                zajeciaNazwa, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                wykladowcyName, tydzien, grupaGrupy,
                zajeciaNazwa, grupy, sale
        );
    }

    //7 warunków

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, tydzien, godz,
                dzien, zajeciaNazwa, grupaGrupy, grupy
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, tydzien, godz,
                dzien, zajeciaNazwa, grupaGrupy, sale
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, tydzien, godz,
                dzien, zajeciaNazwa, grupy, sale
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
                wykladowcyName, tydzien, godz,
                dzien, grupaGrupy, grupy, sale
        );

    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, zajeciaNazwa, godz,
                dzien, grupaGrupy, grupy, sale
        );
    }


    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, zajeciaNazwa, tydzien,
                dzien, grupaGrupy, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, zajeciaNazwa, tydzien,
                godz, grupaGrupy, grupy, sale
        );
    }

    //8 warunków


    public List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, zajeciaNazwa, tydzien,
                godz, dzien, grupaGrupy, grupy, sale
        );
    }
}
