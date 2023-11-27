package com.zawisza.planZajec.controller;


import com.zawisza.planZajec.Constant;
import com.zawisza.planZajec.model.*;
import com.zawisza.planZajec.repository.*;
import com.zawisza.planZajec.service.*;
import jakarta.persistence.NonUniqueResultException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class PlanController extends Constant {

    private final PlanRepository planRepository;
    private final WykladowcyRepository wykladowcyRepository;
    private final SaleRepository saleRepository;

    private final ZajeciaService zajeciaService;
    private final GrupyGrupService grupyGrupService;
    private final WykladowcyService wykladowcyService;
    private final SaleService saleService;
    private final GrupyService grupyService;

    @RequestMapping(value="/plan/updatePlan")
    public String savePlan(){
        URL url;
        String[] week = {"Pon", "Wt", "Sr", "Czw", "Pt"};
        int id = 0;

        String grupName;
        Grupy grupy = null;

        GrupyGrup grupyGrup;
        Wykladowcy wykladowcy;
        Sale sale;
        Zajecia zajecia;

        int a = -1;

        String godzina = null;

        List<String> wykladowcyList = new ArrayList<>();
        List<String> salaList = new ArrayList<>();

        planRepository.deleteAll();

        for(int i = 1; i < 2; i++){
            try {
                url = new URL("https://podzial.mech.pk.edu.pl/stacjonarne/html/plany/o" + i + ".html");
                URLConnection con = url.openConnection();
                InputStream inputStream = con.getInputStream();


                id = i;

                try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

                    String lin;
                    // read each line and write to System.out
                    while ((lin = br.readLine()) != null) {
                        //System.out.println(lin);
                        setLine(lin);


                        if(getLine().contains("<span class=\"tytulnapis\">")){
                            setLine(getLine().replaceAll("<.*?>", ""));
                            System.out.println(getLine());
                            grupName = getLine();


                            grupy = grupyService.getGrupyByNazwa(grupName);

                            System.out.println("----------------");
                            continue;
                        }


                        if(getLine().contains("<td class=\"g\">")) {

                            //Wypisanie godziny
                            setLine(getLine().replaceAll("<.*?>", ""));
                            System.out.println("-----");
                            System.out.println(id);
                            System.out.println(getLine());
                            System.out.println("-----");

                            godzina = getLine();

                            //Wypisanie dla kazdego dnia
                            for (int j = 0; j < 5; j++) {
                                wykladowcy = null;

                                a = j;

                                setLine(br.readLine());
                                //Jezeli pole jest puste -> pomin
                                if (getLine().contains("&nbsp;")) {
                                    continue;
                                }

                                linia = getLine();

                                while (linia.contains("-n") || linia.contains("-p")) {

                                    System.out.println();
                                    System.out.println();
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("***************");

                                    //Usuwanie niepotrzebnych znaków
                                    System.out.println("Linia PRZED : " + linia);
                                    System.out.println("GetLine PRZED : " + getLine());

                                    if(linia.contains("-n") && linia.contains("-p")){
                                        if(linia.indexOf("-n") > linia.indexOf("-p")){
                                            System.out.println("Zawiera pierwsze -n i -p");
                                            setTydzien("n");
                                            getString();
                                        }else{
                                            System.out.println("Zawiera pierwsze -p i -n");
                                            setTydzien("p");
                                            getString2();
                                        }
                                    }else{
                                        if(linia.contains("-n")){
                                            System.out.println("Zawiera -n");
                                            setTydzien("n");
                                            getString2();
                                        } else {
                                            System.out.println("Zawiera -p");
                                            setTydzien("p");
                                            getString();
                                        }
                                    }

                                    System.out.println("Linia PO : " + linia);
                                    System.out.println("GetLine PO : " + getLine());

                                    reset();

                                    //Znalezienie wykladowcy
                                    String id_wykladowcy_href;
                                    int id_wykladowcy_href_int;
                                    if(getLine().contains("a href=\"n") &&
                                            (getLine().indexOf("a href=\"n") < getLine().indexOf("-n") ||
                                            getLine().indexOf("a href=\"n") < getLine().indexOf("-p"))){
                                        id_wykladowcy_href = getLine().substring(getLine().indexOf("a href=\"n") +9,
                                                getLine().indexOf("a href=\"n") + 12);

                                        if(!(id_wykladowcy_href.charAt(2) > 47 && id_wykladowcy_href.charAt(2) < 58)){
                                            if(id_wykladowcy_href.charAt(1) > 47 && id_wykladowcy_href.charAt(1) < 58){
                                                id_wykladowcy_href = id_wykladowcy_href.substring(0,2);
                                            }else{
                                                id_wykladowcy_href = id_wykladowcy_href.substring(0,1);
                                            }
                                        }
                                        System.out.println("ID wykladowcy ze strony : " + id_wykladowcy_href);
                                        id_wykladowcy_href_int = Integer.parseInt(id_wykladowcy_href);

                                        wykladowcy = wykladowcyService.getWykladwcyById(id_wykladowcy_href_int);
                                    }


                                    System.out.println("___________________");
                                    System.out.println(getLine());


                                    //Usunięcie niepotrzebnych znaków
                                    //replace();
                                    //line = line.replaceAll("<.*?>", "");
                                    System.out.println("Test2 : " + getLine());

                                    setLine(getLine().replaceAll("<.*?>", ""));

                                    System.out.println("Test : " + getLine());
                                    String test = getString3(getLine());

                                    //setLine(getLine().trim());
                                    System.out.println(getLine());

                                    System.out.println("___________________");

                                    /*
                                    if(getLine().contains("-n") && getLine().indexOf("-n") < getLine().indexOf("-p") &&
                                            getLine().contains("-p") ){
                                        setTydzien("n");
                                    }else{
                                        if(getLine().contains("-n") && getLine().contains("-p")){
                                            setTydzien("p");
                                        }else{
                                            if(getLine().contains("-n") && !getLine().contains("-p")) {
                                                setTydzien("n");
                                            }else{
                                                setTydzien("p");
                                            }
                                        }
                                    }

                                     */

                                    trim();



                                    //substring();

                                    setGrupaGrupyName(findGrup());
                                    zajecia = zajeciaService.getZajeciaByNazwa(getZajeciaName());

                                    System.out.println("Grupy ID : " + grupy.getId());

                                    grupyGrup = grupyGrupService.getGrupyGrupByIdGrupyAndNazwaGrup(grupy.getId(), getGrupaGrupyName());

                                    System.out.println("Zajecia : " + zajecia.getNazwa());

                                    System.out.println("Wyszukane grupa grupy : " + getGrupaGrupyName());

                                    System.out.println("Linia po findGrup() : " + getLine());

                                    System.out.println("Grupa grupy : " + grupyGrup);

                                    trim();

                                    if(wykladowcy != null){
                                        setWykladowcyName(wykladowcy.getNazwisko());
                                    }else{
                                        String skrot = getLine().substring(0, getLine().indexOf(" "));
                                        wykladowcy = wykladowcyRepository.findWykladowcyBySkrotAndId_strony(skrot,-1);
                                        if(wykladowcy == null){
                                            if(!wykladowcyList.contains(skrot)){
                                                wykladowcyList.add(skrot);
                                                wykladowcy = new Wykladowcy("Nieznane", skrot, -1);
                                                wykladowcyRepository.save(wykladowcy);
                                                setWykladowcyName(skrot);
                                            }
                                        }
                                    }

                                    System.out.println("Wykladowca : " + wykladowcy.getNazwisko());

                                    substring();



                                    String salaText;
                                    if(getLine().length() < 7){
                                        salaText = getLine();
                                    }else{
                                        salaText = getLine().substring(0,6);
                                    }

                                    System.out.println("Test 2 : " + salaText);
                                    if(getLine().substring(0, getLine().indexOf("-n") + 2).endsWith("-n") ||
                                            getLine().substring(0, getLine().indexOf("-p") + 2).endsWith("-p")){
                                        setSalaName(getLine().substring(0, getLine().indexOf("-")));
                                    }else{
                                        setSalaName(getLine().substring(0, getLine().indexOf(" ")));
                                    }


                                    if(salaText.contains("-n") || salaText.contains("-p")){
                                        salaText = salaText.replace("-n", "");
                                        salaText = salaText.replace("-p", "");
                                    }else{
                                        if(salaText.contains(" ")){
                                            salaText = salaText.substring(0, salaText.indexOf(" "));
                                        }
                                    }
                                    System.out.println("SalaText : " + salaText);
                                    setSalaName(salaText);

                                    if(saleService.getSaleBySala(getSalaName()) == null &&
                                            !salaList.contains(getSalaName())){
                                        salaList.add(getSalaName());
                                        saleRepository.save(new Sale(getSalaName()));
                                        sale = new Sale(getSalaName());
                                    }else{
                                        sale = saleRepository.findSaleBySala(salaText);
                                    }

                                    if(getLine().contains(" ")){
                                        substring();
                                    }else{
                                        setLine("");
                                    }

                                    podsumowanie(grupyGrup,zajecia,wykladowcy,sale);

                                    Plan plan = new Plan(getTydzien(),godzina, week[j], grupyGrup, sale, wykladowcy, zajecia);

                                    System.out.println("Plan : " + plan);

                                    planRepository.save(plan);

                                     //public Plan(char tydzien, String godz, String dzien, GrupyGrup grupyGrup,
                                     //       Sale sale, Wykladowcy wykladowcy, Zajecia zajecia) {

                                    //Plan plan = new Plan(id_sale, id_wykladowcy, id_zajecia, getTydzien(), godzina, week[j], new GrupyGrup());
                                    //id_grupy, id_grupy_grup, id_sale, id_wykladowcy, id_zajecia, tydzien, godz, dzien
                                    //System.out.println(week[j] + "  " + text);

                                    //System.out.println(plan);

                                    //if(!planList.contains(plan)){
                                    //    planRepository.save(plan);
                                    //    planList.add(plan);
                                    //}

                                }
                            }

                            System.out.println();
                        }

                    }
                }




            } catch (NullPointerException | NonUniqueResultException e){
                System.out.println("NullPointerException : " + e);
                System.out.println("Line : " + getLine());
                System.out.println("Grupa : " + id);
                System.out.println("GrupaGrupy : " + getGrupaGrupyName());
                System.out.println("Zajecie : " + getZajeciaName());
                System.out.println("Wykladowca : " + getWykladowcyName());
                System.out.println("Godzina : " + godzina);
                if(a == -1){
                    System.out.println("Dzien : -----");

                }else{
                    System.out.println("Dzien : " + week[a]);
                }
                System.out.println("Tydzien : "+ getTydzien());
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Brak strony");
            } catch (ConnectException e){
                return "Brak połączenia";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Complete";
    }

    private void getString2() {
        System.out.println("GetString 2");
        if(linia.contains("<br>")){
            System.out.println("Zawiera <br>");
            setLine(linia.substring(0,linia.indexOf("<br>")));
            System.out.println("Lin : " + linia);
            System.out.println("Getl : " + getLine());
            linia = linia.substring(linia.indexOf("<br>") +4 );
        }else{
            System.out.println("Nie zawiera <br>");
            setLine(linia.substring(0,linia.indexOf("-n") +2 ));
            linia = linia.substring(linia.indexOf("-n") + 2);
        }
    }


    private void getString() {
        System.out.println("GetString 1");
        if(linia.contains("<br>")){
            System.out.println("Zawiera <br>");
            setLine(linia.substring(0,linia.indexOf("<br>")));
            linia = linia.substring(linia.indexOf("<br>") + 4);
        }else{
            System.out.println("Nie zawiera <br>");
            setLine(linia.substring(0,linia.indexOf("-p") +2));
            linia = linia.substring(linia.indexOf("-p") +2);
        }
    }



    private String getString3(String text) {
        String zajeciaName = "";
        String grup = "";
        text = text.trim();
        String substring;

        while(!text.isEmpty()){
            System.out.println(text);
            substring = text.substring(0, text.indexOf(" "));
            if(substring.contains("-(") || substring.contains("-1ps") || substring.contains("-2ps")){
                if(substring.contains("-(")){
                    grup = substring.substring(0,text.indexOf("-("));
                }else{
                    if(substring.contains("-1ps")){
                        grup = substring.substring(0,text.indexOf("-1ps"));
                    }else{
                        grup = substring.substring(0,text.indexOf("-2ps"));
                    }
                }
                break;
            }else{
                if(substring.contains(" ")){
                    break;
                }else{
                    if(zajeciaName.isEmpty()){
                        zajeciaName = zajeciaName + substring;
                    }else{
                        zajeciaName = zajeciaName + " " + substring;
                    }

                    text = text.substring(text.indexOf(" ") + 1);
                    System.out.println("Text : " + text);
                }
            }
        }
        System.out.println("ZajeciaTest : " + zajeciaName);
        System.out.println("GrupTest : " + grup);
        /*
        try{
            switch (text.substring(0, 6)) {
                case "J angi" -> grup = "ang";
                case "Mat DK" -> grup = "Ć";
                case "Ster p" -> grup = text.substring(text.indexOf("pc ") + 3, text.indexOf("pc ") + 6);
                case "Ap Med" -> grup = text.substring(text.indexOf("Med ") + 4, text.indexOf("Med ") + 7);
                case "PM3D C" -> grup = text.substring(text.indexOf("CAD ") + 4, text.indexOf("CAD ") + 7);
                case "Ind 4." -> grup = text.substring(text.indexOf("4.0 ") + 4, text.indexOf("4.0 ") + 7);
                case "TerTec" -> grup = text.substring(text.indexOf("II ") + 3, text.indexOf("II ") + 4);
                case "TKszWy" -> grup = text.substring(text.indexOf(" ") + 1, text.indexOf(" ") + 2);
                default -> grup = switch (substring.charAt(0)) {
                    case 'W' -> "W";
                    case 'S' -> "S";
                    case 'Ć' -> "Ć";
                    default -> text.substring(text.indexOf(" ") + 1, text.indexOf(" ") + 4);
                };
            }
        } finally {
            System.out.println(text);
            System.out.println(substring);
        }

         */
        return grup;
    }


    private String findGrup(){
        try {
            String substring = getLine().substring(getLine().indexOf(" ") + 1, getLine().indexOf(" ") + 2);

            switch (getLine().substring(0, 6)) {
                case "J angi" -> {
                    setGrupaGrupyName("angielski");
                    setZajeciaName("J angielski");
                    if (getLine().indexOf("-n") > 0) {
                        System.out.println("Ang Posiada -n");
                        setTydzien("n");
                    } else {
                        if (getLine().indexOf("-p") > 0) {
                            System.out.println("Ang Posiada -p");
                            setTydzien("p");
                        }
                    }
                    setLine(getLine().substring(11));
                }

                case "Mat DK" -> {
                    setGrupaGrupyName("Ć");
                    if (getLine().indexOf("-n") > 0) {
                        System.out.println("Mat DK Posiada -n");
                        setTydzien("n");
                    } else {
                        if (getLine().indexOf("-p") > 0) {
                            System.out.println("Mat DK Posiada -p");
                            setTydzien("n");
                        }
                    }
                    setLine(getLine().substring(7));
                }

                case "Ster p" -> {
                    setGrupaGrupyName(getLine().substring(getLine().indexOf("pc ") + 3,
                            getLine().indexOf("pc ") + 6));
                    if (getLine().indexOf("-n") > 0) {
                        System.out.println("Ster pc Posiada -n");
                        setTydzien("n");
                    } else {
                        if (getLine().indexOf("-p") > 0) {
                            System.out.println("Ster pc Posiada -p");
                            setTydzien("p");
                        }
                    }
                    setLine(getLine().substring(getLine().indexOf("pc ") + 3));
                }

                case "Ap Med" -> {
                    setGrupaGrupyName(getLine().substring(getLine().indexOf("Med ") + 4,
                            getLine().indexOf("Med ") + 7));

                    if (getLine().indexOf("-n") > 0) {
                        System.out.println("Ap Med Posiada -n");
                        setTydzien("n");
                    } else {
                        if (getLine().indexOf("-p") > 0) {
                            System.out.println("Ap Med Posiada -p");
                            setTydzien("p");
                        }
                    }
                    setLine(getLine().substring(getLine().indexOf("Med ") + 4));
                }

                case "PM3D C" -> {
                    setGrupaGrupyName(getLine().substring(getLine().indexOf("CAD ") + 4,
                            getLine().indexOf("CAD ") + 7));

                    if (getLine().indexOf("-n") > 0) {
                        System.out.println("PM3D CAD Posiada -n");
                        setTydzien("n");
                    } else {
                        if (getLine().indexOf("-p") > 0) {
                            System.out.println("PM3D CAD Posiada -p");
                            setTydzien("p");
                        }
                    }
                    setLine(getLine().substring(getLine().indexOf("CAD ") + 4));
                }

                case "Ind 4." -> {
                    setGrupaGrupyName(getLine().substring(getLine().indexOf("4.0 ") + 4,
                            getLine().indexOf("4.0 ") + 7));

                    if (getLine().indexOf("-n") > 0) {
                        System.out.println("Ind 4.0 Posiada -n");
                        setTydzien("n");
                    } else {
                        if (getLine().indexOf("-p") > 0) {
                            System.out.println("Ind 4.0 Posiada -p");
                            setTydzien("p");
                        }
                    }
                    setLine(getLine().substring(getLine().indexOf("4.0 ") + 4));
                }

                default -> {
                    setZajeciaName(getLine().substring(0,getLine().indexOf(" ")));
                    switch (substring.charAt(0)) {
                        case 'W' -> {
                            setGrupaGrupyName("W");
                            setLine(getLine().substring(getLine().indexOf(" ") + 1));
                        }
                        case 'S' -> {
                            setGrupaGrupyName("S");
                            setLine(getLine().substring(getLine().indexOf(" ") + 1));
                        }
                        case 'Ć' -> {
                            setGrupaGrupyName("Ć");
                            setLine(getLine().substring(getLine().indexOf(" ") + 1));
                        }
                        default -> {
                            System.out.println("ASDSADASD  " + getLine());
                            setLine(getLine().substring(getLine().indexOf(" ") + 1));
                            setGrupaGrupyName(getLine().substring(0, getLine().indexOf(" ")));
                            System.out.println("ASDSADASD  " + getLine());

                        }
                    }
                }
            }

            return getGrupaGrupyName();

        } finally {
            if(!getGrupaGrupyName().equals("angielski")) {
                if(getLine().startsWith("W 1ps")){
                    setGrupaGrupyName(getLine().substring(0, 1));
                    substring();
                }else{
                    setGrupaGrupyName(getLine().substring(0, getLine().indexOf(" ")));
                }
                substring();
            }
        }
    }



    private void replace(){
        setLine(getLine().replaceAll("<td class=\"l\">",""));
        setLine(getLine().replaceAll("<span .*?>",""));
        setLine(getLine().replaceFirst("<a href=\"s.*? class=\"s\">",""));
        setLine(getLine().replaceFirst("<a href=\"n.*? class=\"n\">",""));
        setLine(getLine().replaceAll("</a>", " "));
        setLine(getLine().replaceAll("</.*?>", ""));
        setLine(getLine().replaceFirst("<br>", ""));
        setLine(getLine().replaceFirst("-", " "));
        setLine(getLine().replaceAll("-n", "-n "));
        setLine(getLine().replaceAll("-p", "-p "));
        setLine(getLine().replaceAll("\\(\\w\\)", ""));
        //setLine(getLine().replaceAll("\\(N.", ""));
        //setLine(getLine().replaceAll("\\(P.", ""));
        //setLine(getLine().replaceAll("\\(n.", ""));
        //setLine(getLine().replaceAll("\\(p.", ""));
        setLine(getLine().replaceAll(" {2}", " "));
    }

    private void podsumowanie(GrupyGrup grupyGrup, Zajecia zajecia, Wykladowcy wykladowcy, Sale sale){
        System.out.println("+++++++++++++++++");
        System.out.println("Podsumowanie");
        System.out.println("+++++++++++++++++");

        System.out.println("Grupa grupy nazwa : " + grupyGrup.getGrupaGrupy());
        System.out.println("Grupa grupy id : " + grupyGrup.getId());
        System.out.println("Grupa grupy : " + grupyGrup);

        System.out.println("------");

        System.out.println("Zajecia : " + zajecia.getNazwa());
        System.out.println("ID zajecia : " + zajecia.getId());

        System.out.println("------");

        System.out.println("Skrót : " + wykladowcy.getSkrot());
        System.out.println("ID a href : " + wykladowcy.getId_strony());
        System.out.println("Nazwisko : " + wykladowcy.getNazwisko());
        //if(wykladowcyService.getWykladowcyBySkrotAndIdStrony(getWykladowcyName(), id_wykladowcy_href_int) == null &&
        //        !wykladowcyList.contains(getWykladowcyName())){
        //    wykladowcyList.add(getWykladowcyName());
        //    wykladowcyRepository.save(new Wykladowcy("Nieznane", getWykladowcyName(), -1));
        //    id_wykladowcy = wykladowcyService.getWykladowcyByNazwiskoAndSkrot("Nieznane",getWykladowcyName()).getId();
        //}else{
        //    id_wykladowcy = wykladowcyService.getWykladowcyBySkrotAndIdStrony(getWykladowcyName(), id_wykladowcy_href_int).getId();
        //}
        //System.out.println("Id wykladowcy : " + id_wykladowcy);

        System.out.println("------");

        System.out.println("Sala : " + sale.getSala());

        System.out.println("------");

        System.out.println("Tydzien : " + getTydzien());
        System.out.println("Pozostała linia : " + getLine());
    }
}
