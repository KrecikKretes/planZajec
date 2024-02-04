package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Plan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanRepository  extends CrudRepository<Plan, Integer> {

    @Query("Select p from Plan p")
    List<Plan> getPlan();

    @Query("SELECT  count(*) FROM Plan")
    int countAll();

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwisko( @Param("wykladowcyName") List<String> wykladowcyName);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrot( @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
    List<Plan> getPlanByGrupyGrup( @Param("grupy") List<String> grupyGrup);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwa( @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sala" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySale( @Param("sala") List<String> sala);

    @Query("Select p from Plan p WHERE p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByTydzien( @Param("tydzien") List<String> tydzien);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByDzien( @Param("dzien") List<String> dzien);

    @Query("Select p from Plan p WHERE p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGodz( @Param("godz") List<String> godz);



    //2 warunki

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndDzien( @Param("wykladowcyName") List<String> wykladowcyName,
                                                    @Param("dzien") List<String> dzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGodz( @Param("wykladowcyName") List<String> wykladowcyName,
                                                   @Param("godz") List<String> godz);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlansByWykladowcyNazwiskoAndTydzien(@Param("wykladowcyName") List<String> wykladowcyName,
                                                      @Param("tydzien") List<String> tydzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwa(@Param("wykladowcyName") List<String> wykladowcyName,
                                                          @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupy(@Param("wykladowcyName") List<String> wykladowcyName,
                                                        @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupy(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSale(@Param("wykladowcyName") List<String> wykladowcyName, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrot(@Param("wykladowcyName") List<String> wykladowcyName, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGodzAndDzien(@Param("godz") List<String> godz, @Param("dzien") List<String> dzien);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByTydzienAndDzien(@Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien);

    @Query("Select p from Plan p WHERE p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByTydzienAndGodz(@Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndDzien(@Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndGodz(@Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndTydzien(@Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndDzien(@Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndGodz(@Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndZajeciaNazwa(@Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndDzien(@Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGodz(@Param("godz") List<String> godz, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndTydzien(@Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndZajeciaNazwa(@Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupy(@Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndTydzien(@Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndDzien(@Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGodz(@Param("godz") List<String> godz, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndTydzien(@Param("tydzien") List<String> tydzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndZajeciaNazwa(@Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupy(@Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupy(@Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.dzien IN :dzien" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndDzien(@Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGodz(@Param("godz") List<String> godz, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndTydzien(@Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwa(@Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupy(@Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupy(@Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSale(@Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);



    //3 warunki

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGodzAndDzien(@Param("wykladowcyName") List<String> wykladowcyName,
                                                          @Param("godz") List<String> godz,
                                                          @Param("dzien") List<String> dzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndTydzienAndDzien(@Param("wykladowcyName") List<String> wykladowcyName,
                                                             @Param("dzien") List<String> dzien,
                                                             @Param("tydzien") List<String> tydzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndTydzienAndGodz(@Param("wykladowcyName") List<String> wykladowcyName,
                                                            @Param("godz") List<String> godz,
                                                            @Param("tydzien") List<String> tydzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndDzien(@Param("wykladowcyName") List<String> wykladowcyName,
                                                                  @Param("dzien") List<String> dzien,
                                                                  @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndGodz(@Param("wykladowcyName") List<String> wykladowcyName,
                                                                 @Param("godz") List<String> godz,
                                                                 @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzien(@Param("wykladowcyName") List<String> wykladowcyName,
                                                                    @Param("tydzien") List<String> tydzien,
                                                                    @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndDzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndGodz(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwa(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.dzien IN :dzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndDzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.godz IN :godz" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGodz(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndTydzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwa(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupy(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.dzien IN :dzien" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndDzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.godz IN :godz" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGodz(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.tydzien IN :tydzien" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndTydzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwa(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupy(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupy(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndDzien(@Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGodz(@Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwa(@Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupy(@Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupy(@Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSale(@Param("wykladowcyName") List<String> wykladowcyName, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzien(@Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByTydzienAndGodzAndDzien(@Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndGodzAndDzien(@Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("dzien") List<String> dzien);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndTydzienAndDzien(@Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("dzien") List<String> dzien);

    @Query("Select p from Plan p WHERE p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByZajeciaNazwaAndTydzienAndGodz(@Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("godz") List<String> godz);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndGodzAndDzien(@Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("godz") List<String> godz);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndTydzienAndDzien(@Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("tydzien") List<String> tydzien);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndDzien(@Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndGodz(@Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupaGrupyAndZajeciaNazwaAndTydzien(@Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGodzAndDzien(@Param("godz") List<String> godz, @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndTydzienAndDzien(@Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndTydzienAndGodz(@Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndZajeciaNazwaAndDzien(@Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndZajeciaNazwaAndGodz(@Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndZajeciaNazwaAndTydzien(@Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndDzien(@Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndGodz(@Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndTydzienAndGodz(@Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByGrupyAndGrupaGrupyAndZajeciaNazwa(@Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGodzAndDzien(@Param("godz") List<String> godz, @Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndTydzienAndDzien(@Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndTydzienAndGodz(@Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndZajeciaNazwaAndDzien(@Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndZajeciaNazwaAndGodz(@Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndZajeciaNazwaAndTydzien(@Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndDzien(@Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndGodz(@Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyGrupAndTydzien(@Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupaGrupyAndZajeciaNazwa(@Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndDzien(@Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGodz(@Param("godz") List<String> godz, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndTydzien(@Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE  p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndZajeciaNazwa(@Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanBySaleAndGrupyAndGrupaGrupy(@Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGodzAndDzien(@Param("godz") List<String> godz, @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndTydzienAndDzien(@Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndTydzienAndGodz(@Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndDzien(@Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndGodz(@Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzien(@Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndDzien(@Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndGodz(@Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndTydzien(@Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwa(@Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndDzien(@Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGodz(@Param("godz") List<String> godz, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndTydzien(@Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwa(@Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndGrupyAndGrupaGrupy(@Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);


    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndDzien(@Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGodz(@Param("godz") List<String> godz, @Param("wykladowcySkrot") List<String> wykladowcySkrot, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndTydzien(@Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndZajeciaNazwa(@Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupaGrupy(@Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupy(@Param("wykladowcySkrot") List<String> wykladowcySkrot, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.tydzien IN :tydzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy, @Param("tydzien") List<String> tydzien);



    //4 warunki

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName,
            @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien,
            @Param("tydzien") List<String> tydzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName,
            @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.sale.sala IN :sale" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndDzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " AND p.dzien IN :dzien" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndDzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("sale") List<String> sale,
            @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

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
            @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
    List<Plan> getPlanByGrupyAndGrupaGrupyAndGodzAndDzien(@Param("godz") List<String> godz, @Param("grupy") List<String> grupy, @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("dzien") List<String> dzien);

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
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien);

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
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);



    //5 warunki



    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("godz") List<String> godz, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("godz") List<String> godz, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("godz") List<String> godz, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupy") List<String> grupy, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("sale") List<String> sale,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

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
            @Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

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
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);

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
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale);

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
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("tydzien") List<String> tydzien,
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

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
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

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
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

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
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

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
            @Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
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
    List<Plan> getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("tydzien") List<String> tydzien,
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("godz") List<String> godz, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("godz") List<String> godz, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("tydzien") List<String> tydzien, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("tydzien") List<String> tydzien, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("grupy") List<String> grupy, @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

    //6 warunków

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("godz") List<String> godz, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("dzien") List<String> dzien,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("dzien") List<String> dzien,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("tydzien") List<String> tydzien,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("godz") List<String> godz, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy,
            @Param("godz") List<String> godz, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("godz") List<String> godz, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndDzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.godz IN :godz" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.dzien IN :dzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.tydzien IN :tydzien" +
            " AND p.zajecia.nazwa IN :zajeciaNazwa" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("godz") List<String> godz,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("tydzien") List<String> tydzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("godz") List<String> godz, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupy") List<String> grupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy,
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("dzien") List<String> dzien, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("godz") List<String> godz,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("godz") List<String> godz, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("dzien") List<String> dzien,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien);

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
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale,
            @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.tydzien IN :tydzien" +
            " AND p.grupyGrup.grupy.grupa IN :grupaGrupy" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupy.grupa IN :grupy" +
            " AND p.godz IN :godz" +
            " ORDER BY p.tydzien ASC, CASE WHEN p.dzien LIKE 'Pon' THEN 1" +
            " WHEN p.dzien LIKE 'Wt' THEN 2" +
            " WHEN p.dzien LIKE 'Sr' THEN 3" +
            " WHEN p.dzien LIKE 'Czw' THEN 4" +
            " ELSE 5 END," +
            " p.godz ASC")
    List<Plan> getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("tydzien") List<String> tydzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);


    //7 warunków

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupaGrupy") List<String> grupaGrupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("godz") List<String> godz, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("tydzien") List<String> tydzien,
            @Param("grupy") List<String> grupy, @Param("dzien") List<String> dzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("tydzien") List<String> tydzien,
            @Param("grupy") List<String> grupy, @Param("godz") List<String> godz, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("godz") List<String> godz, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("godz") List<String> godz, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("godz") List<String> godz, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("tydzien") List<String> tydzien, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("tydzien") List<String> tydzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("dzien") List<String> dzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("godz") List<String> godz,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("tydzien") List<String> tydzien,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("grupaGrupy") List<String> grupaGrupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("godz") List<String> godz,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("godz") List<String> godz,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

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
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("dzien") List<String> dzien, @Param("tydzien") List<String> tydzien,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot, @Param("zajeciaNazwa") List<String> zajeciaNazwa);

    

    //8 warunków


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.sale.sala IN :sale" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("grupy") List<String> grupy, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
            " AND p.wykladowcy.skrot IN :wykladowcySkrot" +
            " AND p.grupyGrup.grupaGrupy IN :grupaGrupy" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("tydzien") List<String> tydzien, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("godz") List<String> godz,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("tydzien") List<String> tydzien,
            @Param("dzien") List<String> dzien, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("tydzien") List<String> tydzien,
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    @Query("Select p from Plan p WHERE p.wykladowcy.skrot IN :wykladowcySkrot" +
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
    List<Plan> getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(
            @Param("grupaGrupy") List<String> grupaGrupy, @Param("zajeciaNazwa") List<String> zajeciaNazwa,
            @Param("tydzien") List<String> tydzien, @Param("dzien") List<String> dzien,
            @Param("godz") List<String> godz, @Param("grupy") List<String> grupy,
            @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);

    
    
    
    //9 warunków


    @Query("Select p from Plan p WHERE p.wykladowcy.nazwisko IN :wykladowcyName" +
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
            @Param("wykladowcyName") List<String> wykladowcyName, @Param("grupaGrupy") List<String> grupaGrupy,
            @Param("zajeciaNazwa") List<String> zajeciaNazwa, @Param("tydzien") List<String> tydzien,
            @Param("dzien") List<String> dzien, @Param("godz") List<String> godz,
            @Param("grupy") List<String> grupy, @Param("sale") List<String> sale, @Param("wykladowcySkrot") List<String> wykladowcySkrot);


}
