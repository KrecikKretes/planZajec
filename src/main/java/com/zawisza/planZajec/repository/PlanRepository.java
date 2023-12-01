package com.zawisza.planZajec.repository;

import com.zawisza.planZajec.model.Plan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanRepository  extends CrudRepository<Plan, Integer> {

    @Query("Select p.id, p.grupyGrup.grupy.grupa, p.grupyGrup.grupaGrupy," +
            "p.zajecia.nazwa, p.wykladowcy.nazwisko, p.wykladowcy.skrot," +
            "p.dzien, p.godz, p.tydzien" +
            " from Plan p WHERE " +
            "p.wykladowcy.nazwisko IN :wykladowcyNazwa AND " +
            "p.grupyGrup.grupy.grupa IN :grupa AND " +
            "p.grupyGrup.grupaGrupy IN :grupaGrupy AND " +
            "p.sale.sala IN :sala AND " +
            "p.zajecia.nazwa IN :zajeciaNazwa AND " +
            "p.wykladowcy.skrot IN :wykladowcySkrot AND " +
            "p.tydzien IN :tydzien AND " +
            "p.godz IN :godz AND " +
            "p.dzien IN :dzien")
    List<Plan> getAllResults(@Param("wykladowcyNazwa") List<String> wykladowcyNazwa,
                             @Param("grupa") List<String> grupa,
                             @Param("grupaGrupy") List<String> grupaGrupy,
                             @Param("sala") List<String> sala,
                             @Param("zajeciaNazwa") List<String> zajeciaNazwa,
                             @Param("wykladowcySkrot") List<String> wykladowcySkrot,
                             @Param("tydzien") List<String> tydzien,
                             @Param("godz") List<String> godz,
                             @Param("dzien") List<String> dzien);

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
    List<Plan> getPlanByWykladowcyNazwiskAndSaleoAndGrupyAndZajeciaNazwaAndTydzien(
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
}
