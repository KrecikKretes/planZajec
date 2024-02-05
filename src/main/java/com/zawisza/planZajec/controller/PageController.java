package com.zawisza.planZajec.controller;

import com.zawisza.planZajec.model.*;
import com.zawisza.planZajec.repository.*;
import com.zawisza.planZajec.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.sql.*;
import org.h2.tools.Csv;
import org.h2.tools.SimpleResultSet;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class PageController extends Variables{

    private final WykladowcyService wykladowcyService;
    private final GrupyService grupyService;
    private final GrupyGrupService grupyGrupService;
    private final SaleService saleService;
    private final PlanService planService;
    private final ZajeciaService zajeciaService;

    private final GrupyRepository grupyRepository;
    private final SaleRepository saleRepository;
    private final WykladowcyRepository wykladowcyRepository;
    private final ZajeciaRepository zajeciaRepository;
    private final PlanRepository planRepository;



    @GetMapping("/")
    public String index() throws SQLException {

        File directoryPath = new File("./");
        //List of all files and directories
        String contents[] = directoryPath.list();
        System.out.println("List of files and directories in the specified directory:");
        for(int i=0; i<contents.length; i++) {
            System.out.println(contents[i]);
        }



        if(!isUpdate){
            ResultSet rs = new Csv().read("./data/data/grupy.csv", null, null);
            ResultSet rs1 = new Csv().read("../data/grupyGrup.csv", null, null);
            while (rs.next()) {
                Grupy grupy = new Grupy(rs.getString(2));
                List<GrupyGrup> grupyGrupList = new ArrayList<>();

                while (rs1.next()) {
                    if(rs1.getInt(3) == grupy.getId()){
                        GrupyGrup grupyGrup = new GrupyGrup(rs1.getString(2), grupy);
                        grupyGrupList.add(grupyGrup);
                    }
                    if(rs1.getInt(3) > grupy.getId()){
                        break;
                    }

                }

                grupy.setGrupyGrupList(grupyGrupList);
                grupyRepository.save(grupy);
            }
            rs.close();
            rs1.close();

            System.out.println("Grupy complete");

            rs = new Csv().read("../data/sale.csv", null, null);
            while (rs.next()) {
                Sale sale = new Sale(rs.getString(2), rs.getInt(3));
                saleRepository.save(sale);
            }
            rs.close();

            System.out.println("Sale complete");

            rs = new Csv().read("../data/wykladowcy.csv", null, null);
            while (rs.next()) {
                Wykladowcy wykladowcy = new Wykladowcy(rs.getString(2), rs.getString(3), rs.getInt(4));
                wykladowcyRepository.save(wykladowcy);
            }
            rs.close();

            System.out.println("Wykladowcy complete");

            rs = new Csv().read("../data/zajecia.csv", null, null);
            while (rs.next()) {
                Zajecia zajecia = new Zajecia(rs.getString(2));
                zajeciaRepository.save(zajecia);
            }
            rs.close();

            System.out.println("Zajecia complete");

            rs = new Csv().read("../data/plan.csv", null, null);
            while (rs.next()) {
                String tydzien = rs.getString(2);
                String godzina = rs.getString(3);
                String week = rs.getString(4);
                int idGG = rs.getInt(5);
                int idSale = rs.getInt(6);
                int idWykladowcy = rs.getInt(7);
                int idZajecia = rs.getInt(8);

                GrupyGrup grupyGrup = grupyGrupService.findGrupyGrupById(idGG);
                Sale sale = saleService.getSaleById(idSale);
                Wykladowcy wykladowcy = wykladowcyService.findWykladowcyById(idWykladowcy);
                Zajecia zajecia = zajeciaService.findZajeciaById(idZajecia);

                Plan plan = new Plan(tydzien,godzina, week, grupyGrup, sale, wykladowcy, zajecia);

                System.out.println(plan);

                planRepository.save(plan);
            }
            rs.close();

            System.out.println("Plan complete");


        }



        System.out.println("COUNT BEFORE : " + planRepository.countAll());

        //System.out.println(planService.getPlan());

        return "index";
    }

    @GetMapping("/update")
    public String update() {

        isUpdate = true;

        return "update";
    }

    @GetMapping("/complete")
    public String complete() throws SQLException {

        SimpleResultSet rs = new SimpleResultSet();
        rs.addColumn("id", Types.INTEGER, 255, 0);
        rs.addColumn("grupa", Types.VARCHAR, 255, 0);

        List<Grupy> grupyList = grupyService.getGrupy();

        for(Grupy grupy: grupyList){
            rs.addRow(grupy.getId(), grupy.getGrupa());
        }
        new Csv().write("../data/grupy.csv", rs, null);

        rs = new SimpleResultSet();
        rs.addColumn("id", Types.INTEGER, 255, 0);
        rs.addColumn("grupa_grupy", Types.VARCHAR, 255, 0);
        rs.addColumn("grupy_id", Types.INTEGER, 255, 0);

        List<GrupyGrup> grupyGrups = grupyGrupService.getAll();

        for(GrupyGrup grupyGrup: grupyGrups){
            rs.addRow(grupyGrup.getId(), grupyGrup.getGrupaGrupy(), grupyGrup.getGrupy().getId());
        }
        new Csv().write("../data/grupyGrup.csv", rs, null);


        rs = new SimpleResultSet();
        rs.addColumn("id", Types.INTEGER, 255, 0);
        rs.addColumn("sala", Types.VARCHAR, 255, 0);
        rs.addColumn("id_strony", Types.INTEGER, 255, 0);

        List<Sale> saleList = saleService.getSale();

        for(Sale sale: saleList){
            rs.addRow(sale.getId(), sale.getSala(), sale.getId_strony());
        }
        new Csv().write("../data/sale.csv", rs, null);

        rs = new SimpleResultSet();
        rs.addColumn("id", Types.INTEGER, 255, 0);
        rs.addColumn("nazwisko", Types.VARCHAR, 255, 0);
        rs.addColumn("skrot", Types.VARCHAR, 255, 0);
        rs.addColumn("id_strony", Types.INTEGER, 255, 0);

        List<Wykladowcy> wykladowcyList = wykladowcyService.getWykladowcy();

        for(Wykladowcy wykladowcy: wykladowcyList){
            rs.addRow(wykladowcy.getId(), wykladowcy.getNazwisko(), wykladowcy.getSkrot() , wykladowcy.getId_strony());
        }
        new Csv().write("../data/wykladowcy.csv", rs, null);

        rs = new SimpleResultSet();
        rs.addColumn("id", Types.INTEGER, 255, 0);
        rs.addColumn("nazwa", Types.VARCHAR, 255, 0);

        List<Zajecia> zajeciaList = zajeciaService.getZajecia();

        for(Zajecia zajecia: zajeciaList){
            rs.addRow(zajecia.getId(), zajecia.getNazwa());
        }
        new Csv().write("../data/zajecia.csv", rs, null);



        rs = new SimpleResultSet();
        rs.addColumn("id", Types.INTEGER, 255, 0);
        rs.addColumn("dzien", Types.VARCHAR, 255, 0);
        rs.addColumn("godz", Types.VARCHAR, 255, 0);
        rs.addColumn("tydzien", Types.VARCHAR, 255, 0);
        rs.addColumn("id_grupy_grup", Types.INTEGER, 255, 0);
        rs.addColumn("id_sale", Types.INTEGER, 255, 0);
        rs.addColumn("id_wykladowcy", Types.INTEGER, 255, 0);
        rs.addColumn("id_zajecia", Types.INTEGER, 255, 0);

        List<Plan> planList = planService.getPlan();



        for(Plan plan: planList){
            System.out.println(plan);
            rs.addRow(plan.getId(), plan.getDzien(),
                    plan.getGodz(), plan.getTydzien(),
                    plan.getGrupyGrup().getId(),
                    plan.getSale().getId(),
                    plan.getWykladowcy().getId(),
                    plan.getZajecia().getId()
                    );
        }
        new Csv().write("../data/plan.csv", rs, null);





        return "complete";
    }

    @GetMapping("/search")
    public String search(Model model){
        int wykladowcySize = wykladowcyService.getCount();
        model.addAttribute("wykladowcySize", wykladowcySize);

        List<String> wykladowcyList;
        wykladowcyList = wykladowcyService.getUniqueName();
        model.addAttribute("wykladowcyName", wykladowcyList);

        List<String> wykladowcySkrotList;
        wykladowcySkrotList = wykladowcyService.getUniqueSkrot();
        model.addAttribute("wykladowcySkrot", wykladowcySkrotList);

        int grupySize = grupyService.getCount();
        model.addAttribute("grupySize", grupySize);

        List<Grupy> grupyList;
        grupyList = grupyService.getGrupy();
        model.addAttribute("grupy", grupyList);

        int grupyGrupySize = grupyGrupService.getDistinctCount();
        model.addAttribute("grupyGrupySize", grupyGrupySize);

        List<String> grupyGrupyList;
        grupyGrupyList = grupyGrupService.getGrupyGrupy();
        model.addAttribute("grupyGrup", grupyGrupyList);

        int zajeciaSize = zajeciaService.getCount();
        model.addAttribute("zajeciaSize", zajeciaSize);

        List<Zajecia> zajeciaList;
        zajeciaList = zajeciaService.getZajecia();
        model.addAttribute("zajecia", zajeciaList);

        int saleSize = saleService.getCount();
        model.addAttribute("saleSize", saleSize);

        List<Sale> saleList;
        saleList = saleService.getSale();
        model.addAttribute("sale", saleList);

        String[] week = {"Pon", "Wt", "Sr", "Czw", "Pt"};
        model.addAttribute("week", week);

        String[] hours = {"7:30-8:15", "8:15-9:00", "9:15-10:00",
                "10:00-10:45", "11:00-11:45", "11:45-12:30",
                "12:45-13:30", "13:30-14:15", "14:30-15:15",
                "15:15-16:00", "16:15-17:00", "17:00-17:45",
                "18:00-18:45", "18:45-19:30"
        };
        model.addAttribute("godziny", hours);

        System.out.println("COUNT BEFORE : " + planRepository.countAll());

        return "search";
    }

    @PostMapping("/results")
    public String submit(@ModelAttribute("search") Search search,
                         ModelMap model) {

        System.out.println("Search : " + search);

        System.out.println(search.getWykladowcyName());
        System.out.println(search.getGrupy());
        System.out.println(search.getSale());
        System.out.println(search.getWykladowcySkrot());
        System.out.println(search.getTydzien());




        List<Plan> planList;

        System.out.println();
        System.out.println("COUNT BEFORE : " + planRepository.countAll());


        planList = checkWhatIsNull(search);

        System.out.println("COUNT AFTER : " + planRepository.countAll());

        System.out.println(planList);

        model.addAttribute("planList", planList);


        return "results";
    }

    private List<Plan> checkWhatIsNull(Search search) {

        List<String> wykladowcyName = search.getWykladowcyName();
        List<String> wykladowcySkrot = search.getWykladowcySkrot();
        List<String> sale = search.getSale();
        List<String> grupy = search.getGrupy();

        List<String> grupaGrupy = search.getGrupyGrup();
        List<String> zajeciaNazwa = search.getZajecia();
        List<String> tydzien = search.getTydzien();
        List<String> godz = search.getGodzina();
        List<String> dzien = search.getDzien();



        if(wykladowcyName != null){
            System.out.println("wykladowcyName != null");
            if(wykladowcySkrot == null){
                System.out.println("wykladowcySkrot == null");
                if(sale == null){
                    if(grupy == null){
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwisko(wykladowcyName);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndDzien(wykladowcyName,dzien);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGodz(wykladowcyName,godz);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGodzAndDzien(wykladowcyName,godz,dzien);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndTydzien(wykladowcyName, tydzien);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndTydzienAndDzien(wykladowcyName,dzien,tydzien);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndTydzienAndGodz(wykladowcyName,godz,tydzien);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwa(wykladowcyName, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupy(wykladowcyName, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzien(wykladowcyName, grupaGrupy, tydzien);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndTydzienAndGodz(wykladowcyName,godz,tydzien);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupy(wykladowcyName, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndDzien(wykladowcyName,dzien,grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGodz(wykladowcyName,godz, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndTydzien(wykladowcyName, tydzien, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupy);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupy);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupy(wykladowcyName, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzien(wykladowcyName, tydzien, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, grupy);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else{
                    if(grupy == null){
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSale(wykladowcyName,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndDzien(wykladowcyName,dzien,sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGodz(wykladowcyName,godz,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGodzAndDzien(wykladowcyName,godz,dzien,sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndTydzien(wykladowcyName,tydzien,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndDzien(wykladowcyName,dzien,tydzien,sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndGodz(wykladowcyName,godz,tydzien,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien,sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwa(wykladowcyName, zajeciaNazwa,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, sale);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupy(wykladowcyName, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyGrupAndTydzien(wykladowcyName, tydzien, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupy(wykladowcyName, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndDzien(wykladowcyName,dzien,grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGodz(wykladowcyName,godz, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzien(wykladowcyName, tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupy, sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupy(wykladowcyName, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzien(wykladowcyName, tydzien, grupy, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else{
                if(sale == null){
                    if(grupy == null){
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrot(wykladowcyName, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndDzien(wykladowcyName,dzien, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGodz(wykladowcyName,godz, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGodzAndDzien(wykladowcyName,godz,dzien, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzien(wykladowcyName, tydzien, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndDzien(wykladowcyName,dzien,tydzien, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndGodz(wykladowcyName,godz,tydzien, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupy(wykladowcyName, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzien(wykladowcyName, tydzien, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndGodz(wykladowcyName,godz,tydzien, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName, godz, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupy(wykladowcyName, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndDzien(wykladowcyName,dzien,grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGodz(wykladowcyName,godz, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupy, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzien(wykladowcyName, tydzien, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupy, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodz(wykladowcyName, godz, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupy(wykladowcyName, grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzien(wykladowcyName, tydzien, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else{
                    if(grupy == null){
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSale(wykladowcyName,sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndDzien(wykladowcyName,dzien,sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGodz(wykladowcyName,godz,sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGodzAndDzien(wykladowcyName,godz,dzien,sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzien(wykladowcyName,tydzien,sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndDzien(wykladowcyName,dzien,tydzien,sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndGodz(wykladowcyName,godz,tydzien,sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien,sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwa(wykladowcyName, zajeciaNazwa,sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupy(wykladowcyName, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyGrupAndTydzien(wykladowcyName, tydzien, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupy(wykladowcyName, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndDzien(wykladowcyName,dzien,grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGodz(wykladowcyName,godz, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzien(wykladowcyName, tydzien, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupy(wykladowcyName, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzien(wykladowcyName, tydzien, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else{
            if(wykladowcySkrot == null){
                if(sale == null){
                    if(grupy == null){
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return null;
                                        }else{
                                            return planService.getPlanByDzien(dzien);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByGodz(godz);
                                        }else{
                                            return planService.getPlanByGodzAndDzien(godz,dzien);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByTydzien(tydzien);
                                        }else{
                                            return planService.getPlanByTydzienAndDzien(dzien,tydzien);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByTydzienAndGodz(godz,tydzien);
                                        }else{
                                            return planService.getPlanByTydzienAndGodzAndDzien(godz,dzien, tydzien);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByZajeciaNazwa(zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByZajeciaNazwaAndDzien(dzien, zajeciaNazwa);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByZajeciaNazwaAndGodz(godz, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByGrupaGrupy(grupaGrupy);
                                        }else{
                                            return planService.getPlanByGrupaGrupyAndDzien(dzien, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByGrupaGrupyAndGodz(godz, grupaGrupy);
                                        }else{
                                            return planService.getPlanByGrupaGrupyAndGodzAndDzien(godz,dzien, grupaGrupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByTydzien(tydzien);
                                        }else{
                                            return planService.getPlanByGrupaGrupyAndTydzienAndDzien(dzien,tydzien, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByTydzienAndGodz(godz,tydzien);
                                        }else{
                                            return planService.getPlanByGrupaGrupyAndTydzienAndGodzAndDzien(godz,dzien, tydzien, grupaGrupy);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByGrupaGrupyAndZajeciaNazwa(zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByGrupaGrupyAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByGrupaGrupyAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByGrupaGrupyAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByGrupy(grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndDzien(dzien,grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndGodz(godz, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndGodzAndDzien(godz,dzien, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndTydzien(tydzien, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndTydzienAndDzien(dzien,tydzien, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndTydzienAndGodz(godz,tydzien, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndTydzienAndGodzAndDzien(godz,dzien, tydzien, grupy);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndZajeciaNazwa(zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, grupy);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndGrupaGrupy(grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndGrupaGrupyAndDzien(dzien, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndGrupaGrupyAndGodz(godz, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndGrupaGrupyAndGodzAndDzien(godz,dzien, grupaGrupy, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndGrupaGrupyAndTydzien(tydzien, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndGrupaGrupyAndTydzienAndDzien(dzien,tydzien, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndGrupaGrupyAndTydzienAndGodz(godz,tydzien, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(godz,dzien, tydzien, grupaGrupy, grupy);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwa(zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else{
                    if(grupy == null){
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            System.out.println("Only Sale");
                                            return planService.getPlanBySale(sale);
                                        }else{
                                            return planService.getPlanBySaleAndDzien(dzien,sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGodz(godz,sale);
                                        }else{
                                            return planService.getPlanBySaleAndGodzAndDzien(godz,dzien,sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndTydzien(tydzien,sale);
                                        }else{
                                            return planService.getPlanBySaleAndTydzienAndDzien(dzien,tydzien,sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndTydzienAndGodz(godz,tydzien,sale);
                                        }else{
                                            return planService.getPlanBySaleAndTydzienAndGodzAndDzien(godz,dzien, tydzien,sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndZajeciaNazwa(zajeciaNazwa,sale);
                                        }else{
                                            return planService.getPlanBySaleAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, sale);
                                        }else{
                                            return planService.getPlanBySaleAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, sale);
                                        }else{
                                            return planService.getPlanBySaleAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, sale);
                                        }else{
                                            return planService.getPlanBySaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, sale);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupaGrupy(grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupaGrupyAndDzien(dzien, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupaGrupyAndGodz(godz, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupaGrupyAndGodzAndDzien(godz,dzien, grupaGrupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyGrupAndTydzien(tydzien, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupaGrupyAndTydzienAndDzien(dzien,tydzien, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupaGrupyAndTydzienAndGodz(godz,tydzien, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupaGrupyAndTydzienAndGodzAndDzien(godz,dzien, tydzien, grupaGrupy, sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupaGrupyAndZajeciaNazwa(zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupy(grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndDzien(dzien,grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndGodz(godz, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndGodzAndDzien(godz,dzien, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndTydzien(tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndTydzienAndDzien(dzien,tydzien, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndTydzienAndGodz(godz,tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndTydzienAndGodzAndDzien(godz,dzien, tydzien, grupy, sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndZajeciaNazwa(zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupy(grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndDzien(dzien, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndGodz(godz, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndGodzAndDzien(godz,dzien, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndTydzien(tydzien, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(dzien,tydzien, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(godz,tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(godz,dzien, tydzien, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanBySaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else{
                if(sale == null){
                    if(grupy == null){
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrot(wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndDzien(dzien, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGodz(godz, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGodzAndDzien(godz,dzien, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndTydzien(tydzien, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndTydzienAndDzien(dzien,tydzien, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndTydzienAndGodz(godz,tydzien, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndTydzienAndGodzAndDzien(godz,dzien, tydzien, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndZajeciaNazwa(zajeciaNazwa, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupy(grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndDzien(dzien, grupaGrupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndGodz(godz, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndGodzAndDzien(godz,dzien, grupaGrupy, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndTydzien(tydzien, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndTydzienAndDzien(dzien,tydzien, grupaGrupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndTydzienAndGodz(godz,tydzien, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndTydzienAndGodzAndDzien(godz,dzien, tydzien, grupaGrupy, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwa(zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupy(grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndDzien(dzien,grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGodz(godz, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGodzAndDzien(godz,dzien, grupy, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndTydzien(tydzien, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndTydzienAndDzien(dzien,tydzien, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndTydzienAndGodz(godz,tydzien, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndTydzienAndGodzAndDzien(godz,dzien, tydzien, grupy, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwa(zajeciaNazwa, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, grupy, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupy(grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndDzien(dzien, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndGodz(godz, grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndGodzAndDzien(godz,dzien, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzien(tydzien, grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndDzien(dzien,tydzien, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodz(godz,tydzien, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(godz,dzien, tydzien, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwa(zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, grupy, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else{
                    if(grupy == null){
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSale(sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndDzien(dzien,sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGodz(godz,sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGodzAndDzien(godz,dzien,sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndTydzien(tydzien,sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndTydzienAndDzien(dzien,tydzien,sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndTydzienAndGodz(godz,tydzien,sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndTydzienAndGodzAndDzien(godz,dzien, tydzien,sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwa(zajeciaNazwa,sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupy(grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndDzien(dzien, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndGodz(godz, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndGodzAndDzien(godz,dzien, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyGrupAndTydzien(tydzien, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndDzien(dzien,tydzien, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodz(godz,tydzien, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(godz,dzien, tydzien, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwa(zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupy(grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndDzien(dzien,grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGodz(godz, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGodzAndDzien(godz,dzien, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzien(tydzien, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzienAndDzien(dzien,tydzien, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodz(godz,tydzien, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodzAndDzien(godz,dzien, tydzien, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwa(zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupy(grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndDzien(dzien, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodz(godz, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(godz,dzien, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzien(tydzien, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(dzien,tydzien, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(godz,tydzien, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(godz,dzien, tydzien, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(dzien, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(godz, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(godz,dzien, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(tydzien, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(dzien,tydzien, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(godz,tydzien, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, grupy, sale, wykladowcySkrot);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
