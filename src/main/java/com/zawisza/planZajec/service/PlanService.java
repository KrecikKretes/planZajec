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

    public List<Plan> getPlanByGrupy(List<String> grupy){
        return planRepository.getPlanByGrupyGrupGrupy(grupy);
    }

    public List<Plan> getPlanByGrupaGrupy(List<String> grupyGrup){
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
        return planRepository.getPlanByWykladowcyNazwiskoAndGodz(
                wykladowcyName, godz
        );
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

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrot(
            List<String> wykladowcyName, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrot(
                wykladowcyName, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByGodzAndDzien(
            List<String> godz, List<String> dzien) {
        return planRepository.getPlanByGodzAndDzien(
                godz, dzien
        );
    }

    public List<Plan> getPlanByTydzienAndDzien(
            List<String> dzien, List<String> tydzien) {
        return planRepository.getPlanByTydzienAndDzien(
                tydzien, dzien
        );
    }

    public List<Plan> getPlanByTydzienAndGodz(
            List<String> godz, List<String> tydzien) {
        return planRepository.getPlanByTydzienAndGodz(
                tydzien, godz
        );

    }

    public List<Plan> getPlanByZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa) {
        return planRepository.getPlanByZajeciaNazwaAndDzien(
                dzien, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa) {
        return planRepository.getPlanByZajeciaNazwaAndGodz(
                godz, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa) {
        return planRepository.getPlanByZajeciaNazwaAndTydzien(
                tydzien, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndDzien(
            List<String> dzien, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndDzien(
                dzien, grupaGrupy
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndGodz(
            List<String> godz, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndGodz(
                godz, grupaGrupy
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndZajeciaNazwa(
                zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanByGrupyAndDzien(
            List<String> dzien, List<String> grupy) {
        return planRepository.getPlanByGrupyAndDzien(
                dzien, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndGodz(
            List<String> godz, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGodz(
                godz, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndTydzien(
            List<String> tydzien, List<String> grupy) {
        return planRepository.getPlanByGrupyAndTydzien(
                tydzien, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByGrupyAndZajeciaNazwa(
                zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupy(
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupy(
                grupaGrupy, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndTydzien(
            List<String> tydzien, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndTydzien(
                tydzien, grupy
        );
    }

    public List<Plan> getPlanBySaleAndDzien(
            List<String> dzien, List<String> sale) {
        return planRepository.getPlanBySaleAndDzien(
                dzien, sale
        );
    }

    public List<Plan> getPlanBySaleAndGodz(
            List<String> godz, List<String> sale) {
        return planRepository.getPlanBySaleAndGodz(
                godz, sale
        );
    }

    public List<Plan> getPlanBySaleAndTydzien(
            List<String> tydzien, List<String> sale) {
        return planRepository.getPlanBySaleAndTydzien(
                tydzien, sale
        );
    }

    public List<Plan> getPlanBySaleAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanBySaleAndZajeciaNazwa(
                zajeciaNazwa, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupy(
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupy(
                grupaGrupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupy(
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupy(
                grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndDzien(
            List<String> dzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndDzien(
                dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGodz(
            List<String> godz, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGodz(
                godz, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndTydzien(
            List<String> tydzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndTydzien(
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndZajeciaNazwa(
                zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupy(
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupy(
                grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupy(
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupy(
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSale(
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSale(
                sale, wykladowcySkrot
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

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndDzien(
            List<String> wykladowcyName, List<String> dzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndDzien(
                wykladowcyName, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGodz(
            List<String> wykladowcyName, List<String> godz, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGodz(
                wykladowcyName, godz, wykladowcySkrot
        );
    }

   
    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupy(
            List<String> wykladowcyName, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupy(
                wykladowcyName, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupy(
            List<String> wykladowcyName, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupy(
                wykladowcyName, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSale(
            List<String> wykladowcyName, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSale(
                wykladowcyName, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzien(
            List<String> wykladowcyName, List<String> tydzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzien(
                wykladowcyName, tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> tydzien) {
        return planRepository.getPlanByTydzienAndGodzAndDzien(
                godz, tydzien, dzien
        );
    }

    public List<Plan> getPlanByZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> zajeciaNazwa) {
        return planRepository.getPlanByZajeciaNazwaAndGodzAndDzien(
                godz, zajeciaNazwa, dzien
        );
    }

    public List<Plan> getPlanByZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien, List<String> zajeciaNazwa) {
        return planRepository.getPlanByZajeciaNazwaAndTydzienAndDzien(
                tydzien, zajeciaNazwa, dzien
        );
    }

    public List<Plan> getPlanByZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien, List<String> zajeciaNazwa) {
        return planRepository.getPlanByZajeciaNazwaAndTydzienAndGodz(
                tydzien, zajeciaNazwa, godz
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndGodzAndDzien(
                dzien, grupaGrupy, godz
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndTydzienAndDzien(
                dzien, grupaGrupy, tydzien
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndZajeciaNazwaAndDzien(
                dzien, grupaGrupy, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndZajeciaNazwaAndGodz(
                godz, grupaGrupy, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndZajeciaNazwaAndTydzien(
                tydzien, grupaGrupy, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGodzAndDzien(
                godz, dzien, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien, List<String> grupy) {
        return planRepository.getPlanByGrupyAndTydzienAndDzien(
                tydzien, dzien, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien, List<String> grupy) {
        return planRepository.getPlanByGrupyAndTydzienAndGodz(
                tydzien, godz, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByGrupyAndZajeciaNazwaAndDzien(
                dzien, zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByGrupyAndZajeciaNazwaAndGodz(
                godz, zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByGrupyAndZajeciaNazwaAndTydzien(
                tydzien, zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndDzien(
            List<String> dzien, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndDzien(
                dzien, grupaGrupy, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndGodz(
            List<String> godz, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndGodz(
                godz, grupaGrupy, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndTydzienAndGodz(
                godz, tydzien, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwa(
                zajeciaNazwa, grupaGrupy, grupy
        );
    }

    public List<Plan> getPlanBySaleAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> sale) {
        return planRepository.getPlanBySaleAndGodzAndDzien(
                godz, dzien, sale
        );
    }

    public List<Plan> getPlanBySaleAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien, List<String> sale) {
        return planRepository.getPlanBySaleAndTydzienAndDzien(
                tydzien, dzien, sale
        );
    }

    public List<Plan> getPlanBySaleAndTydzienAndGodz(
            List<String> godz, List<String> tydzien, List<String> sale) {
        return planRepository.getPlanBySaleAndTydzienAndGodz(
                tydzien, godz, sale
        );
    }

    public List<Plan> getPlanBySaleAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanBySaleAndZajeciaNazwaAndDzien(
                dzien, zajeciaNazwa, sale
        );
    }

    public List<Plan> getPlanBySaleAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanBySaleAndZajeciaNazwaAndGodz(
                godz, zajeciaNazwa, sale
        );
    }

    public List<Plan> getPlanBySaleAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanBySaleAndZajeciaNazwaAndTydzien(
                tydzien, zajeciaNazwa, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndDzien(
            List<String> dzien, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndDzien(
                dzien, grupaGrupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndGodz(
            List<String> godz, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndGodz(
                godz, grupaGrupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyGrupAndTydzien(
            List<String> tydzien, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyGrupAndTydzien(
                tydzien, grupaGrupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndZajeciaNazwa(
                zajeciaNazwa, grupaGrupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndDzien(
            List<String> dzien, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndDzien(
                dzien, grupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGodz(
            List<String> godz, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGodz(
                godz, grupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndTydzien(
            List<String> tydzien, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndTydzien(
                tydzien, grupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndZajeciaNazwa(
                zajeciaNazwa, grupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupy(
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupy(
                grupaGrupy, grupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndTydzien(
            List<String> tydzien, List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndTydzien(
                tydzien,grupaGrupy, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGodzAndDzien(
                godz, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndTydzienAndDzien(
                tydzien, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndTydzienAndGodz(
            List<String> godz, List<String> tydzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndTydzienAndGodz(
                tydzien, godz, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndZajeciaNazwaAndDzien(
                dzien, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndZajeciaNazwaAndGodz(
                godz, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzien(
                tydzien, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndDzien(
            List<String> dzien, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndDzien(
                dzien, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndGodz(
            List<String> godz, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndGodz(
                godz, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndTydzien(
            List<String> tydzien, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndTydzien(
                tydzien, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwa(
                zajeciaNazwa, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndDzien(
            List<String> dzien, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndDzien(
                dzien, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGodz(
            List<String> godz, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGodz(
                godz, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndTydzien(
            List<String> tydzien, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndTydzien(
                tydzien, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwa(
                zajeciaNazwa, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupy(
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupy(
                grupaGrupy, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzien(
            List<String> tydzien, List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzien(
                tydzien, grupaGrupy, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndDzien(
            List<String> dzien, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndDzien(
                dzien, wykladowcySkrot, sale
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGodz(
            List<String> godz, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGodz(
                godz, wykladowcySkrot, sale
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndTydzien(
            List<String> tydzien, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndTydzien(
                tydzien, wykladowcySkrot, sale
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwa(
                zajeciaNazwa, wykladowcySkrot, sale
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupy(
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupy(
                grupaGrupy, wykladowcySkrot, sale
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupy(
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupy(
                wykladowcySkrot, grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzien(
            List<String> wykladowcyName, List<String> grupaGrupy, List<String> tydzien) {
        return planRepository.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzien(
                wykladowcyName, grupaGrupy, tydzien
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
            List<String> grupy, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzien(
                wykladowcyName, tydzien, grupy, grupaGrupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzien(
                wykladowcyName, tydzien, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGodzAndDzien(
                wykladowcyName, godz, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndDzien(
                wykladowcyName, tydzien, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndGodz(
                wykladowcyName, godz, tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndDzien(
                wykladowcyName, zajeciaNazwa, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndGodz(
                wykladowcyName, godz, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzien(
                wykladowcyName, tydzien, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndDzien(
                wykladowcyName, grupaGrupy, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndGodz(
                wykladowcyName, godz, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndDzien(
                wykladowcyName, grupy, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGodz(
                wykladowcyName, godz, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzien(
                wykladowcyName, tydzien, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupy(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupy(
                wykladowcyName, grupaGrupy, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzien(
                wykladowcyName, tydzien, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndDzien(
                wykladowcyName, sale, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGodz(
                wykladowcyName, godz, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzien(
                wykladowcyName, tydzien, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupy(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupy(
                wykladowcyName, grupaGrupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupy(
            List<String> wykladowcyName, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupy(
                wykladowcyName, grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa) {
        return planRepository.getPlanByZajeciaNazwaAndTydzienAndGodzAndDzien(
                godz, dzien, tydzien, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndTydzienAndGodzAndDzien(
                godz, dzien, tydzien, grupaGrupy
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                godz, dzien, zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                dzien, tydzien, zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                godz, tydzien, zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanByGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> grupy) {
        return planRepository.getPlanByGrupyAndTydzienAndGodzAndDzien(
                godz, grupy, dzien, tydzien
        );
    }

    public List<Plan> getPlanByGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByGrupyAndZajeciaNazwaAndGodzAndDzien(
                godz, grupy, dzien, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByGrupyAndZajeciaNazwaAndTydzienAndDzien(
                dzien, grupy, tydzien, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByGrupyAndZajeciaNazwaAndTydzienAndGodz(
                godz, grupy, tydzien, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndGodzAndDzien(
                godz, grupy, dzien, grupaGrupy
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndTydzienAndDzien(
                dzien, grupy, tydzien, grupaGrupy
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
                dzien, grupy, zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
                godz, grupy, zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                tydzien, grupy, zajeciaNazwa, grupaGrupy
        );
    }

    public List<Plan> getPlanBySaleAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> sale) {
        return planRepository.getPlanBySaleAndTydzienAndGodzAndDzien(
                godz, dzien, sale, tydzien
        );
    }

    public List<Plan> getPlanBySaleAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanBySaleAndZajeciaNazwaAndGodzAndDzien(
                godz, dzien, sale, zajeciaNazwa
        );
    }

    public List<Plan> getPlanBySaleAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanBySaleAndZajeciaNazwaAndTydzienAndDzien(
                dzien, tydzien, sale, zajeciaNazwa
        );
    }

    public List<Plan> getPlanBySaleAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanBySaleAndZajeciaNazwaAndTydzienAndGodz(
                godz, tydzien, sale, zajeciaNazwa
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndGodzAndDzien(
                godz, dzien, sale, grupaGrupy
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndTydzienAndDzien(
                dzien, tydzien, sale, grupaGrupy
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndTydzienAndGodz(
                godz, tydzien, sale, grupaGrupy
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndDzien(
                dzien, zajeciaNazwa, sale, grupaGrupy
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndGodz(
                godz, zajeciaNazwa, sale, grupaGrupy
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                tydzien, zajeciaNazwa, sale, grupaGrupy
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGodzAndDzien(
                godz, grupy, sale, dzien
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndTydzienAndDzien(
                dzien, grupy, sale, tydzien
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndTydzienAndGodz(
                godz, grupy, sale, tydzien
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndZajeciaNazwaAndDzien(
                dzien, grupy, sale, zajeciaNazwa
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndZajeciaNazwaAndGodz(
                godz, grupy, sale, zajeciaNazwa
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzien(
                tydzien, grupy, sale, zajeciaNazwa
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndDzien(
            List<String> dzien, List<String> grupaGrupy,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndDzien(
                dzien, grupy, sale, grupaGrupy
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndGodz(
            List<String> godz, List<String> grupaGrupy,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndGodz(
                godz, grupy, sale, grupaGrupy
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
                godz, grupy, sale, tydzien
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(
                zajeciaNazwa, grupy, sale, grupaGrupy
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndTydzienAndGodzAndDzien(
                godz, dzien, tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndZajeciaNazwaAndGodzAndDzien(
                godz, dzien, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzienAndDzien(
                dzien, tydzien, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodz(
                godz, tydzien, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndGodzAndDzien(
                godz, dzien, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndTydzienAndDzien(
                dzien, tydzien, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndTydzienAndGodz(
                godz, tydzien, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndDzien(
                dzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodz(
                godz, zajeciaNazwa, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                tydzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGodzAndDzien(
                godz, grupy, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndTydzienAndDzien(
                dzien, grupy, tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndTydzienAndGodz(
                godz, grupy, tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndDzien(
                dzien, grupy, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodz(
                godz, grupy, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzien(
                tydzien, grupy, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndDzien(
            List<String> dzien, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndDzien(
                dzien, grupy, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndGodz(
            List<String> godz, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndGodz(
                godz, grupy, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodz(
                godz, grupy, tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwa(
                zajeciaNazwa, grupy, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGodzAndDzien(
                godz, dzien, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndTydzienAndDzien(
                dzien, tydzien, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndTydzienAndGodz(
                godz, tydzien, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndDzien(
                dzien, zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndGodz(
                godz, zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzien(
                tydzien, zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndDzien(
            List<String> dzien, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndDzien(
                dzien, grupaGrupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndGodz(
            List<String> godz, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndGodz(
                godz, grupaGrupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyGrupAndTydzien(
            List<String> tydzien, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyGrupAndTydzien(
                tydzien, grupaGrupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwa(
                zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndDzien(
                dzien, grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGodz(
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGodz(
                godz, grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzien(
            List<String> tydzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzien(
                tydzien, grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwa(
                zajeciaNazwa, grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupy(
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupy(
                grupaGrupy, grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzien(
            List<String> tydzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzien(
                tydzien, grupy, sale, wykladowcySkrot
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
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzien(
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
            List<String> tydzien, List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
                wykladowcyName, godz, tydzien,
                grupaGrupy ,grupy, sale
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

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, zajeciaNazwa, dzien,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, godz, zajeciaNazwa,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzienAndDzien(
                wykladowcyName, grupaGrupy, dzien,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndDzien(
                wykladowcyName, zajeciaNazwa, dzien,
                grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodz(
                wykladowcyName, godz, zajeciaNazwa,
                grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                wykladowcyName, zajeciaNazwa, grupaGrupy,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndDzien(
                wykladowcyName, grupy, dzien,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndGodz(
                wykladowcyName, godz, grupy,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndDzien(
                wykladowcyName, zajeciaNazwa, dzien,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodz(
                wykladowcyName, godz, zajeciaNazwa,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzien(
                wykladowcyName, zajeciaNazwa, grupy,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndDzien(
                wykladowcyName, grupaGrupy, dzien,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndGodz(
                wykladowcyName, godz, grupaGrupy,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodz(
                wykladowcyName, godz, grupy,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, grupaGrupy,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndDzien(
                wykladowcyName, sale, dzien,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndGodz(
                wykladowcyName, godz, sale,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndDzien(
                wykladowcyName, zajeciaNazwa, dzien,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndGodz(
                wykladowcyName, godz, zajeciaNazwa,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzien(
                wykladowcyName, zajeciaNazwa, sale,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndDzien(
                wykladowcyName, grupaGrupy, dzien,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndGodz(
                wykladowcyName, godz, grupaGrupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyGrupAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyGrupAndTydzien(
                wykladowcyName, grupaGrupy, sale,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, grupaGrupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndDzien(
                wykladowcyName, grupy, dzien,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGodz(
                wykladowcyName, godz, grupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzien(
                wykladowcyName, grupy, sale,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwa(
                wykladowcyName, zajeciaNazwa, grupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupy(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupy(
                wykladowcyName, godz, dzien,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzien(
                wykladowcyName, grupy, sale,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> grupaGrupy) {
        return planRepository.getPlanByGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                godz, dzien, zajeciaNazwa,
                tydzien, grupaGrupy
        );
    }

    public List<Plan> getPlanByGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> grupy) {
        return planRepository.getPlanByGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                godz, dzien, zajeciaNazwa,
                tydzien, grupy
        );

    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
                godz, dzien, grupaGrupy,
                tydzien, grupy
        );

    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                godz, dzien, grupaGrupy,
                zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                tydzien, dzien, grupaGrupy,
                zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                tydzien, godz, grupaGrupy,
                zajeciaNazwa, grupy
        );
    }

    public List<Plan> getPlanBySaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> sale) {
        return planRepository.getPlanBySaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                tydzien, godz, dzien,
                zajeciaNazwa, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndTydzienAndGodzAndDzien(
                tydzien, godz, dzien,
                grupaGrupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                zajeciaNazwa, godz, dzien,
                grupaGrupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                zajeciaNazwa, tydzien, dzien,
                grupaGrupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                zajeciaNazwa, tydzien, godz,
                grupaGrupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndTydzienAndGodzAndDzien(
                dzien, tydzien, godz,
                grupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(
                dzien, zajeciaNazwa, godz,
                grupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
                dzien, zajeciaNazwa, tydzien,
                grupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
                godz, zajeciaNazwa, tydzien,
                grupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndGodzAndDzien(
                godz, dzien, grupaGrupy,
                grupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(
                tydzien, dzien, grupaGrupy,
                grupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
                zajeciaNazwa, dzien, grupaGrupy,
                grupy, sale
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
                zajeciaNazwa, godz, grupaGrupy,
                grupy, sale
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                zajeciaNazwa, godz, dzien,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndTydzienAndGodzAndDzien(
                grupaGrupy, godz, dzien,
                tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                grupaGrupy, godz, dzien,
                zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                grupaGrupy, tydzien, dzien,
                zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                grupaGrupy, tydzien, godz,
                zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndTydzienAndGodzAndDzien(
                dzien, tydzien, godz,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndTydzienAndGodzAndDzien(
                dzien, zajeciaNazwa, godz,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
                dzien, zajeciaNazwa, tydzien,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
                godz, zajeciaNazwa, tydzien,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndGodzAndDzien(
                godz, dzien, grupaGrupy,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndDzien(
                tydzien, dzien, grupaGrupy,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
                zajeciaNazwa, dzien, grupaGrupy,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
                zajeciaNazwa, godz, grupaGrupy,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                zajeciaNazwa, tydzien, grupaGrupy,
                grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndTydzienAndGodzAndDzien(
                godz, tydzien, dzien,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndGodzAndDzien(
                godz, zajeciaNazwa, dzien,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndDzien(
                tydzien, zajeciaNazwa, dzien,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodz(
                tydzien, zajeciaNazwa, godz,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndGodzAndDzien(
                dzien, grupaGrupy, godz,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndDzien(
                dzien, grupaGrupy, tydzien,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodz(
                godz, grupaGrupy, tydzien,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(
                dzien, grupaGrupy, zajeciaNazwa,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(
                godz, grupaGrupy, zajeciaNazwa,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                tydzien, grupaGrupy, zajeciaNazwa,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGodzAndDzien(
                godz, dzien, grupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGodzAndDzien(
                tydzien, dzien, grupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodz(
                tydzien, godz, grupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndDzien(
                dzien, zajeciaNazwa, grupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodz(
                godz, zajeciaNazwa, grupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodz(
                tydzien, zajeciaNazwa, grupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndDzien(
            List<String> dzien, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndDzien(
                dzien, grupaGrupy, grupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodz(
            List<String> godz, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodz(
                godz, grupaGrupy, grupy,
                sale, wykladowcySkrot
        );
    }



    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
                godz, tydzien, grupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(
                zajeciaNazwa, grupaGrupy, grupy,
                sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                zajeciaNazwa, grupaGrupy, grupy,
                sale, tydzien
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

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, tydzien, godz,
                zajeciaNazwa, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzienAndGodzAndDzien(
                wykladowcyName, tydzien, godz,
                grupaGrupy, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, zajeciaNazwa, godz,
                grupaGrupy, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, zajeciaNazwa, tydzien,
                grupaGrupy, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, zajeciaNazwa, tydzien,
                grupaGrupy, godz, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndGodzAndDzien(
                wykladowcyName, dzien, tydzien,
                grupy, godz, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, dzien, zajeciaNazwa,
                grupy, godz, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, dzien, zajeciaNazwa,
                grupy, tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, godz, zajeciaNazwa,
                grupy, tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                grupy, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndDzien(
                wykladowcyName, tydzien, dzien,
                grupy, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
                wykladowcyName, godz, zajeciaNazwa,
                grupy, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
                wykladowcyName, dzien, zajeciaNazwa,
                grupy, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                wykladowcyName, tydzien, zajeciaNazwa,
                grupy, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndGodzAndDzien(
                wykladowcyName, tydzien, godz,
                dzien, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, zajeciaNazwa, godz,
                dzien, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, zajeciaNazwa, tydzien,
                dzien, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, zajeciaNazwa, tydzien,
                godz, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndGodzAndDzien(
                wykladowcyName, grupaGrupy, dzien,
                godz, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndDzien(
                wykladowcyName, grupaGrupy, dzien,
                tydzien, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodz(
                wykladowcyName, grupaGrupy, godz,
                tydzien, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(
                wykladowcyName, grupaGrupy, dzien,
                zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(
                wykladowcyName, grupaGrupy, godz,
                zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                wykladowcyName, grupaGrupy, tydzien,
                zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGodzAndDzien(
                wykladowcyName, grupy, godz,
                dzien, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndDzien(
                wykladowcyName, grupy, tydzien,
                dzien, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodz(
                wykladowcyName, grupy, tydzien,
                godz, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndDzien(
                wykladowcyName, grupy, dzien,
                zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodz(
                wykladowcyName, grupy, godz,
                zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzien(
                wykladowcyName, grupy, tydzien,
                zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndDzien(
                wykladowcyName, grupy, dzien,
                grupaGrupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodz(
                wykladowcyName, grupy, godz,
                grupaGrupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
                wykladowcyName, grupy, godz,
                tydzien, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(
                wykladowcyName, grupy, zajeciaNazwa,
                grupaGrupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(
                dzien, tydzien, grupaGrupy,
                grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> grupy) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                dzien, tydzien, grupaGrupy,
                grupy, godz, zajeciaNazwa
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                dzien, tydzien, godz,
                grupy, sale, zajeciaNazwa
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                dzien, tydzien, grupaGrupy,
                grupy, sale, godz
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                dzien, godz, grupaGrupy,
                grupy, sale, zajeciaNazwa
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                dzien, tydzien, grupaGrupy,
                grupy, sale, zajeciaNazwa
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                godz, tydzien, grupaGrupy,
                grupy, sale, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                dzien, tydzien, grupaGrupy,
                godz, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                dzien, tydzien, godz,
                grupy, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                dzien, tydzien, grupaGrupy,
                grupy, godz, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                dzien, godz, grupaGrupy,
                grupy, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                dzien, tydzien, grupaGrupy,
                grupy, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                godz, tydzien, grupaGrupy,
                grupy, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                dzien, tydzien, godz,
                zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(
                dzien, tydzien, grupaGrupy,
                godz, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                dzien, godz, grupaGrupy,
                zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                dzien, tydzien, grupaGrupy,
                zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                godz, tydzien, grupaGrupy,
                zajeciaNazwa, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> tydzien,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodzAndDzien(
                dzien, tydzien, godz,
                grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(
                dzien, godz, zajeciaNazwa,
                grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
                dzien, tydzien, zajeciaNazwa,
                grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
                godz, tydzien, zajeciaNazwa,
                grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(
                dzien, godz, grupaGrupy,
                grupy, sale, wykladowcySkrot
        );
    }


    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
                dzien, zajeciaNazwa, grupaGrupy,
                grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
                godz, zajeciaNazwa, grupaGrupy,
                grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                godz, zajeciaNazwa, grupaGrupy,
                dzien, sale, tydzien
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                zajeciaNazwa, grupaGrupy, grupy,
                sale, tydzien, wykladowcySkrot
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

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, zajeciaNazwa, tydzien,
                godz, grupaGrupy, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, zajeciaNazwa, tydzien,
                godz, grupy, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
                wykladowcyName, grupaGrupy, tydzien,
                godz, grupy, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, grupaGrupy, zajeciaNazwa,
                godz, grupy, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, grupaGrupy, zajeciaNazwa,
                tydzien, grupy, dzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, grupaGrupy, zajeciaNazwa,
                tydzien, grupy, godz, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, dzien, zajeciaNazwa,
                tydzien, sale, godz, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(
                wykladowcyName, dzien, grupaGrupy,
                tydzien, sale, godz, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, dzien, grupaGrupy,
                zajeciaNazwa, sale, godz, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, dzien, grupaGrupy,
                zajeciaNazwa, sale, tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, godz, grupaGrupy,
                zajeciaNazwa, sale, tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                grupy, sale, tydzien, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, godz, dzien,
                grupy, sale, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, tydzien, dzien,
                grupy, sale, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, tydzien, godz,
                grupy, sale, zajeciaNazwa, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(
                wykladowcyName, dzien, godz,
                grupy, sale, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(
                wykladowcyName, dzien, tydzien,
                grupy, sale, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
                wykladowcyName, dzien, zajeciaNazwa,
                grupy, sale, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
                wykladowcyName, godz, zajeciaNazwa,
                grupy, sale, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
                wykladowcyName, tydzien, zajeciaNazwa,
                grupy, sale, grupaGrupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
                dzien, tydzien,
                grupaGrupy, godz,
                grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> sale) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                dzien, tydzien,
                grupaGrupy, godz,
                grupy, sale, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                dzien, tydzien,
                grupaGrupy, godz,
                grupy, wykladowcySkrot, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                dzien, tydzien,
                grupaGrupy, godz,
                sale, wykladowcySkrot, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                dzien, grupy,
                grupaGrupy, godz,
                sale, wykladowcySkrot, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                dzien, grupy,
                grupaGrupy, tydzien,
                sale, wykladowcySkrot, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                godz, grupy,
                grupaGrupy, tydzien,
                sale, wykladowcySkrot, zajeciaNazwa
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                godz, grupy,
                dzien, tydzien,
                sale, wykladowcySkrot, zajeciaNazwa
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

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, zajeciaNazwa, tydzien,
                godz, dzien, grupaGrupy, grupy, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, zajeciaNazwa, tydzien,
                godz, dzien, grupaGrupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, zajeciaNazwa, tydzien,
                godz, dzien, grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
                wykladowcyName, grupaGrupy, tydzien,
                godz, dzien, grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
                wykladowcyName, grupaGrupy, zajeciaNazwa,
                godz, dzien, grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
                wykladowcyName, grupaGrupy, zajeciaNazwa,
                tydzien, dzien, grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
                wykladowcyName, grupaGrupy, zajeciaNazwa,
                tydzien, godz, grupy, sale, wykladowcySkrot
        );
    }

    public List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                grupaGrupy, zajeciaNazwa, tydzien,
                dzien, godz, grupy, sale, wykladowcySkrot
        );
    }

        //9 warunków

    public List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot) {
        return planRepository.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
                wykladowcyName, grupaGrupy, zajeciaNazwa,
                tydzien, dzien, godz, grupy, sale, wykladowcySkrot
        );
    }


}
