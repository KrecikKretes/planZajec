package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Plan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanRepository  extends CrudRepository<Plan, Integer> {

    @Query("Select DISTINCT p from Plan p")
    List<Plan> getPlan();

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwisko(@Param("wykladowcyNazwa") List<String> wykladowcyNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrot(@Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyGrupGrupy(@Param("grupa") List<String> grupa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupyGrup" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyGrup(@Param("grupyGrup") List<String> grupyGrup);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwa(@Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sala" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySale(@Param("sala") List<String> sala);

    @Query("Select p from Plan p WHERE p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByTydzien(@Param("tydzien") List<String> tydzien);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByDzien(@Param("dzien") List<String> dzien);

    @Query("Select p from Plan p WHERE p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGodz(@Param("godz") List<String> godz);



    //2 warunki

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndDzien(@Param("wykladowcyNazwa") List<String> wykladowcyNazwa,
                                                   @Param("dzien") List<String> dzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGodz(@Param("wykladowcyNazwa") List<String> wykladowcyName,
                                                  @Param("godz") List<String> godz);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlansByWykladowcyNazwiskoAndTydzien(@Param("wykladowcyNazwa")List<String> wykladowcyName,
                                                      @Param("tydzien")List<String> tydzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwa(@Param("wykladowcyNazwa")List<String> wykladowcyName,
                                                          @Param("zajeciaNazwa")List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupy(List<String> wykladowcyName,
                                                        List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupy(
            List<String> wykladowcyName, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSale(List<String> wykladowcyName, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrot(List<String> wykladowcyName, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGodzAndDzien(List<String> godz, List<String> dzien);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByTydzienAndDzien(List<String> tydzien, List<String> dzien);

    @Query("Select p from Plan p WHERE p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByTydzienAndGodz(List<String> tydzien, List<String> godz);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndDzien(List<String> dzien, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndGodz(List<String> godz, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndTydzien(List<String> tydzien, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndDzien(List<String> dzien, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndGodz(List<String> godz, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndZajeciaNazwa(List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndDzien(List<String> dzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGodz(List<String> godz, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndTydzien(List<String> tydzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndZajeciaNazwa(List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupy(List<String> grupaGrupy, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndTydzien(List<String> tydzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndDzien(List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGodz(List<String> godz, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndTydzien(List<String> tydzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndZajeciaNazwa(List<String> zajeciaNazwa, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupy(List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupy(List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndDzien(List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGodz(List<String> godz, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndTydzien(List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwa(List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupy(List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupy(List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSale(List<String> sale, List<String> wykladowcySkrot);



    //3 warunki

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGodzAndDzien(@Param("wykladowcyNazwa")List<String> wykladowcyName,
                                                          @Param("godz")List<String> godz,
                                                          @Param("dzien")List<String> dzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndTydzienAndDzien(@Param("wykladowcyNazwa")List<String> wykladowcyName,
                                                             @Param("dzien")List<String> dzien,
                                                             @Param("tydzien")List<String> tydzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndTydzienAndGodz(@Param("wykladowcyNazwa")List<String> wykladowcyName,
                                                            @Param("godz")List<String> godz,
                                                            @Param("tydzien")List<String> tydzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndDzien(@Param("wykladowcyNazwa")List<String> wykladowcyName,
                                                                  @Param("dzien")List<String> dzien,
                                                                  @Param("zajeciaNazwa")List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndGodz(@Param("wykladowcyNazwa")List<String> wykladowcyName,
                                                                 @Param("godz")List<String> godz,
                                                                 @Param("zajeciaNazwa")List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzien(List<String> wykladowcyName,
                                                                    List<String> tydzien,
                                                                    List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupy(
            List<String> wykladowcyName, List<String> grupaGrupy, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndDzien(
            List<String> wykladowcyName, List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.godz IN :godz" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGodz(
            List<String> wykladowcyName, List<String> godz, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndTydzien(
            List<String> wykladowcyName, List<String> tydzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupy(
            List<String> wykladowcyName, List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupy(
            List<String> wykladowcyName, List<String> grupy, List<String> sale);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndDzien(List<String> wykladowcyName, List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGodz(List<String> wykladowcyName, List<String> godz, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwa(List<String> wykladowcyName, List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupy(List<String> wykladowcyName, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupy(List<String> wykladowcyName, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSale(List<String> wykladowcyName, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzien(List<String> wykladowcyName, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByTydzienAndGodzAndDzien(List<String> godz, List<String> tydzien, List<String> dzien);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndGodzAndDzien(List<String> godz, List<String> zajeciaNazwa, List<String> dzien);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndTydzienAndDzien(List<String> tydzien, List<String> zajeciaNazwa, List<String> dzien);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndTydzienAndGodz(List<String> tydzien, List<String> zajeciaNazwa, List<String> godz);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndGodzAndDzien(List<String> dzien, List<String> grupaGrupy, List<String> godz);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndTydzienAndDzien(List<String> dzien, List<String> grupaGrupy, List<String> tydzien);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndDzien(List<String> dzien, List<String> grupaGrupy, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndGodz(List<String> godz, List<String> grupaGrupy, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndTydzien(List<String> tydzien, List<String> grupaGrupy, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGodzAndDzien(List<String> godz, List<String> dzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndTydzienAndDzien(List<String> tydzien, List<String> dzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndTydzienAndGodz(List<String> tydzien, List<String> godz, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndZajeciaNazwaAndDzien(List<String> dzien, List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndZajeciaNazwaAndGodz(List<String> godz, List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndZajeciaNazwaAndTydzien(List<String> tydzien, List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndDzien(List<String> dzien, List<String> grupaGrupy, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndGodz(List<String> godz, List<String> grupaGrupy, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndTydzienAndGodz(List<String> godz, List<String> tydzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwa(List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> grupy);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGodzAndDzien(List<String> godz, List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndTydzienAndDzien(List<String> tydzien, List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndTydzienAndGodz(List<String> tydzien, List<String> godz, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndZajeciaNazwaAndDzien(List<String> dzien, List<String> zajeciaNazwa, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndZajeciaNazwaAndGodz(List<String> godz, List<String> zajeciaNazwa, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndZajeciaNazwaAndTydzien(List<String> tydzien, List<String> zajeciaNazwa, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndDzien(List<String> dzien, List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndGodz(List<String> godz, List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyGrupAndTydzien(List<String> tydzien, List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwa(List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndDzien(List<String> dzien, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGodz(List<String> godz, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndTydzien(List<String> tydzien, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE  p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwa(List<String> zajeciaNazwa, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupy(List<String> grupaGrupy, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGodzAndDzien(List<String> godz, List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndTydzienAndDzien(List<String> tydzien, List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndTydzienAndGodz(List<String> tydzien, List<String> godz, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndDzien(List<String> dzien, List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndGodz(List<String> godz, List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzien(List<String> tydzien, List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndDzien(List<String> dzien, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndGodz(List<String> godz, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndTydzien(List<String> tydzien, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwa(List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndDzien(List<String> dzien, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGodz(List<String> godz, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndTydzien(List<String> tydzien, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwa(List<String> zajeciaNazwa, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupy(List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot);


    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndDzien(List<String> dzien, List<String> wykladowcySkrot, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGodz(List<String> godz, List<String> wykladowcySkrot, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndTydzien(List<String> tydzien, List<String> wykladowcySkrot, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwa(List<String> zajeciaNazwa, List<String> wykladowcySkrot, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupy(List<String> grupaGrupy, List<String> wykladowcySkrot, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupy(List<String> wykladowcySkrot, List<String> grupy, List<String> sale);





    //4 warunki

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndTydzienAndGodzAndDzien(
            @Param("wykladowcyNazwa")List<String> wykladowcyName,
            @Param("godz")List<String> godz,
            @Param("dzien")List<String> dzien,
            @Param("tydzien")List<String> tydzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndGodzAndDzien(
            @Param("wykladowcyNazwa")List<String> wykladowcyName,
            @Param("godz")List<String> godz,
            @Param("dzien")List<String> dzien,
            @Param("zajeciaNazwa")List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> dzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.dzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.godz IN :godz" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyGrupAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupy(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndDzien(
            List<String> wykladowcyName, List<String> grupy,
            List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupy(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndDzien(
            List<String> wykladowcyName, List<String> sale,
            List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupy(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupy(
            List<String> wykladowcyName, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndTydzien(
            List<String> tydzien, List<String> grupaGrupy,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzien(
            List<String> tydzien, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE  p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> grupy,
            List<String> dzien, List<String> tydzien);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> grupy,
            List<String> dzien, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> tydzien, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> grupy,
            List<String> tydzien, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndGodzAndDzien(List<String> godz, List<String> grupy, List<String> dzien, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> tydzien, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> grupy,
            List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> grupy,
            List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> sale, List<String> tydzien);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> sale, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> sale, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> sale, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> sale, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> sale, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> sale, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> sale, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGodzAndDzien(
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> dzien);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> tydzien);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndTydzienAndGodz(
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> tydzien);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> grupy,
            List<String> sale, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndGodz(
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> tydzien);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGodzAndDzien(
            List<String> godz, List<String> grupy,
            List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndTydzienAndGodz(
            List<String> godz, List<String> grupy,
            List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> grupy,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> grupy,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndGodz(
            List<String> godz, List<String> grupy,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> grupy,
            List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndDzien(
            List<String> dzien, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndGodz(
            List<String> godz, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyGrupAndTydzien(
            List<String> tydzien, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGodz(
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzien(
            List<String> tydzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupy(
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzien(
            List<String> tydzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);



    //5 warunki



    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> dzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> dzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> dzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> godz, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> godz, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> tydzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupaGrupy, List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> godz, List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> godz, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> dzien, List<String> godz, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> dzien, List<String> tydzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> godz, List<String> tydzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> dzien, List<String> zajeciaNazwa, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> godz, List<String> zajeciaNazwa, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> tydzien, List<String> zajeciaNazwa, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> dzien, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> dzien, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.godz IN :godz" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.godz IN :godz" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> dzien, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> dzien, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> grupy,
            List<String> dzien, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupy, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> dzien, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupy, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> dzien, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupy, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> sale,
            List<String> dzien, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> sale, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> dzien, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> sale, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> dzien, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyGrupAndTydzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> sale, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndDzien(
            List<String> wykladowcyName, List<String> grupy,
            List<String> dzien, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzien(
            List<String> wykladowcyName, List<String> grupy,
            List<String> sale, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.godz IN :godz" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupy(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzien(
            List<String> wykladowcyName, List<String> grupy,
            List<String> sale, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> tydzien, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> tydzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> tydzien, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> tydzien, List<String> dzien,
            List<String> grupaGrupy, List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> tydzien, List<String> godz,
            List<String> grupaGrupy, List<String> zajeciaNazwa, List<String> grupy);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> tydzien, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> tydzien, List<String> godz,
            List<String> dzien, List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> zajeciaNazwa, List<String> godz,
            List<String> dzien, List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> zajeciaNazwa, List<String> tydzien,
            List<String> dzien, List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndTydzienAndGodzAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> godz, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> zajeciaNazwa, List<String> tydzien,
            List<String> godz, List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> godz, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> tydzien, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> zajeciaNazwa, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> zajeciaNazwa, List<String> godz,
            List<String> grupaGrupy, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> zajeciaNazwa, List<String> godz,
            List<String> dzien, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> grupaGrupy, List<String> godz,
            List<String> dzien, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> grupaGrupy, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> grupaGrupy, List<String> tydzien,
            List<String> dzien, List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> grupaGrupy, List<String> tydzien,
            List<String> godz, List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndTydzienAndGodzAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> godz, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> tydzien, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> zajeciaNazwa, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> zajeciaNazwa, List<String> godz,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> zajeciaNazwa, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> tydzien,
            List<String> dzien, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndGodzAndDzien(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> dzien, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndDzien(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> dzien, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodz(
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> godz, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndGodzAndDzien(
            List<String> dzien, List<String> grupaGrupy,
            List<String> godz, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> grupaGrupy,
            List<String> tydzien, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> grupaGrupy,
            List<String> tydzien, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> grupaGrupy,
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> grupaGrupy,
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> tydzien, List<String> grupaGrupy,
            List<String> zajeciaNazwa, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGodzAndDzien(
            List<String> godz, List<String> dzien,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodz(
            List<String> tydzien, List<String> godz,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndDzien(
            List<String> dzien, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodz(
            List<String> godz, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale, List<String> tydzien);



    //6 warunków

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> zajeciaNazwa,
            List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> grupaGrupy,
            List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> godz, List<String> grupaGrupy,
            List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> grupaGrupy,
            List<String> dzien, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> grupaGrupy,
            List<String> godz, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> tydzien, List<String> dzien,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> dzien,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> dzien,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> godz,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> godz,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> tydzien,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> grupaGrupy, List<String> zajeciaNazwa,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> zajeciaNazwa,
            List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> grupaGrupy,
            List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> godz, List<String> grupaGrupy,
            List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> grupaGrupy,
            List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> grupaGrupy,
            List<String> godz, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupy,
            List<String> godz, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> godz, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupy,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupyGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> dzien, List<String> grupy,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupyGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupyGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupyGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> dzien,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> godz, List<String> dzien,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> dzien,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> godz,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> dzien, List<String> godz,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> dzien, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> godz, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> godz, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> grupy,
            List<String> godz, List<String> dzien,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> grupy,
            List<String> tydzien, List<String> dzien,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> grupy,
            List<String> tydzien, List<String> godz,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> grupy,
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> grupy,
            List<String> godz, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> grupy,
            List<String> tydzien, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndDzien(
            List<String> wykladowcyName, List<String> grupy,
            List<String> dzien, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodz(
            List<String> wykladowcyName, List<String> grupy,
            List<String> godz, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> grupy,
            List<String> godz, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(
            List<String> wykladowcyName, List<String> grupy,
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy,
            List<String> godz, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> dzien, List<String> godz,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> godz,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> godz, List<String> grupy,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> dzien, List<String> godz,
            List<String> grupaGrupy, List<String> grupy,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupaGrupy, List<String> grupy,
            List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> godz, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> godz,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> dzien, List<String> godz,
            List<String> grupaGrupy, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> grupaGrupy, List<String> zajeciaNazwa,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodzAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> dzien, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> dzien, List<String> godz,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> dzien, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> zajeciaNazwa,
            List<String> grupaGrupy, List<String> dzien,
            List<String> sale, List<String> tydzien);

    @Query("Select p from Plan p WHERE p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> zajeciaNazwa, List<String> grupaGrupy,
            List<String> grupy, List<String> sale,
            List<String> tydzien, List<String> wykladowcySkrot);


    //7 warunków

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> grupy);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupaGrupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy, List<String> sale);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupyGrup" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupyGrup" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> godz, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupyGrup" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> dzien,
            List<String> grupaGrupy, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupyGrup" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> godz,
            List<String> grupaGrupy, List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupyGrup" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> godz,
            List<String> grupaGrupy, List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> godz,
            List<String> grupy, List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> tydzien, List<String> godz,
            List<String> grupy, List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> zajeciaNazwa, List<String> godz,
            List<String> grupy, List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> zajeciaNazwa, List<String> tydzien,
            List<String> grupy, List<String> dzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> zajeciaNazwa, List<String> tydzien,
            List<String> grupy, List<String> godz, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> tydzien,
            List<String> sale, List<String> godz, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> tydzien,
            List<String> sale, List<String> godz, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> zajeciaNazwa,
            List<String> sale, List<String> godz, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> grupaGrupy, List<String> zajeciaNazwa,
            List<String> sale, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> grupaGrupy, List<String> zajeciaNazwa,
            List<String> sale, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> tydzien, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> godz,
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> zajeciaNazwa, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> tydzien, List<String> grupy,
            List<String> sale, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            List<String> wykladowcyName, List<String> dzien,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            List<String> wykladowcyName, List<String> godz,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            List<String> wykladowcyName, List<String> tydzien,
            List<String> zajeciaNazwa, List<String> grupy,
            List<String> sale, List<String> grupaGrupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> godz,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> godz,
            List<String> grupy, List<String> sale, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> dzien, List<String> tydzien,
            List<String> grupaGrupy, List<String> godz,
            List<String> sale, List<String> wykladowcySkrot, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> grupaGrupy, List<String> godz,
            List<String> sale, List<String> wykladowcySkrot, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> dzien, List<String> grupy,
            List<String> grupaGrupy, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> godz, List<String> grupy,
            List<String> grupaGrupy, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot, List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> godz, List<String> grupy,
            List<String> dzien, List<String> tydzien,
            List<String> sale, List<String> wykladowcySkrot, List<String> zajeciaNazwa);

    

    //8 warunków


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupyGrup" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> godz,
            List<String> dzien, List<String> grupaGrupy,
            List<String> grupy, List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupyGrup" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> godz,
            List<String> dzien, List<String> grupaGrupy,
            List<String> grupy, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupyGrup" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> godz,
            List<String> dzien, List<String> grupaGrupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> godz,
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> tydzien, List<String> godz,
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> zajeciaNazwa, List<String> godz,
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> zajeciaNazwa, List<String> tydzien,
            List<String> dzien, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> zajeciaNazwa, List<String> tydzien,
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> grupaGrupy, List<String> zajeciaNazwa,
            List<String> tydzien, List<String> dzien,
            List<String> godz, List<String> grupy,
            List<String> sale, List<String> wykladowcySkrot);


    //9 warunków


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyNazwa" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            List<String> wykladowcyName, List<String> grupaGrupy,
            List<String> zajeciaNazwa, List<String> tydzien,
            List<String> dzien, List<String> godz,
            List<String> grupy, List<String> sale, List<String> wykladowcySkrot);


}
