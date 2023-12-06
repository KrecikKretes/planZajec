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
    private final ZajeciaRepository zajeciaRepository;
    private final GrupyRepository grupyRepository;

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
        List<String> zajeciaList = new ArrayList<>();

        planRepository.deleteAll();

        for(int i = 1; i < 88; i++){
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

                            if(grupyService.getGrupyByNazwa(grupName) == null){
                                grupy = new Grupy(grupName);
                            }else{
                                grupy = grupyService.getGrupyByNazwa(grupName);

                            }

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

                                System.out.println(week[j]);
                                System.out.println("-----");

                                wykladowcy = null;

                                a = j;

                                setLine(br.readLine());
                                //Jezeli pole jest puste -> pomin
                                if (getLine().contains("&nbsp;")) {
                                    continue;
                                }

                                resztaLinii = getLine();

                                while (resztaLinii.contains("-n") || resztaLinii.contains("-p")) {

                                    reset();
                                    wykladowcy = null;

                                    System.out.println();
                                    System.out.println();
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("***************");

                                    //Usuwanie niepotrzebnych znaków
                                    System.out.println("Linia PRZED : " + resztaLinii);
                                    System.out.println("GetLine PRZED : " + getLine());


                                    System.out.println("..................................");
                                    if(resztaLinii.contains("-n") && resztaLinii.contains("-p")){
                                        if(resztaLinii.indexOf("-n") < resztaLinii.indexOf("-p")){
                                            System.out.println("Zawiera pierwsze -n i -p");
                                            setTydzien("n");
                                            getString();
                                        }else{
                                            System.out.println("Zawiera pierwsze -p i -n");
                                            setTydzien("p");
                                            getString2();
                                        }
                                    }else{
                                        if(resztaLinii.contains("-n")){
                                            System.out.println("Zawiera -n");
                                            setTydzien("n");
                                            getString2();
                                        } else {
                                            System.out.println("Zawiera -p");
                                            setTydzien("p");
                                            getString();
                                        }
                                    }
                                    System.out.println("..................................");
                                    System.out.println("");

                                    System.out.println("Tydzien : " + getTydzien());

                                    System.out.println("Linia PO : " + resztaLinii);
                                    System.out.println("GetLine PO : " + getLine());


                                    //Znalezienie id wykladowcy
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
                                    System.out.println("GetLine przed replace : " + getLine());
                                    setLine(getLine().replaceAll("<.*?>", ""));
                                    System.out.println("GetLine po replace : " + getLine());

                                    getString3();

                                    System.out.println("___________________");

                                    trim();

                                    zajecia = zajeciaService.getZajeciaByNazwa(getZajeciaName());
                                    if(zajecia == null){
                                        if(!zajeciaList.contains(getZajeciaName())){
                                            zajeciaList.add(getZajeciaName());
                                            zajecia = new Zajecia(getZajeciaName());
                                            zajeciaRepository.save(zajecia);
                                        }
                                    }

                                    assert grupy != null;
                                    grupyGrup = grupyGrupService.getGrupyGrupByIdGrupyAndNazwaGrup(grupy.getId(), getGrupaGrupyName());

                                    System.out.println("Grupy ID : " + grupy.getId());

                                    assert zajecia != null;
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

                                    assert wykladowcy != null;
                                    System.out.println("Wykladowca : " + wykladowcy.getNazwisko());

                                    substring();

                                    trim();

                                    System.out.println("Sala przed : " + getLine());
                                    if(getLine().substring(0, getLine().indexOf("-n") + 2).endsWith("-n") ||
                                            getLine().substring(0, getLine().indexOf("-p") + 2).endsWith("-p")){
                                        setSalaName(getLine().substring(0, getLine().length() - 2));
                                    }else{
                                        if(getLine().contains(" ")){
                                            setSalaName(getLine().substring(0, getLine().indexOf(" ")));
                                        }else{
                                            setSalaName(getLine());
                                        }
                                    }

                                    System.out.println("Sala po : " + getSalaName());

                                    if(saleService.getSaleBySala(getSalaName()) == null &&
                                            !salaList.contains(getSalaName())){
                                        System.out.println("Nie znaleziono sale");
                                        salaList.add(getSalaName());
                                        sale = new Sale(getSalaName(), -1);
                                        System.out.println("Sale stworzono : " + sale);
                                        saleRepository.save(sale);
                                    }else{
                                        sale = saleRepository.findSaleBySala(getSalaName());
                                    }

                                    System.out.println("TEST : " + sale);

                                    if(getLine().contains(" ")){
                                        substring();
                                    }else{
                                        setLine("");
                                    }

                                    podsumowanie(grupyGrup,zajecia,wykladowcy,sale);

                                    Plan plan = new Plan(getTydzien(),godzina, week[j], grupyGrup, sale, wykladowcy, zajecia);

                                    System.out.println("Plan : " + plan);

                                    planRepository.save(plan);
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
        if(resztaLinii.contains("<br>")){
            System.out.println("Zawiera <br>");
            setLine(resztaLinii.substring(0, resztaLinii.indexOf("<br>")));
            System.out.println("Lin : " + resztaLinii);
            System.out.println("Getl : " + getLine());
            resztaLinii = resztaLinii.substring(resztaLinii.indexOf("<br>") +4 );
        }else{
            System.out.println("Nie zawiera <br>");
            setLine(resztaLinii.substring(0, resztaLinii.indexOf("-n") +2 ));
            resztaLinii = resztaLinii.substring(resztaLinii.indexOf("-n") + 2);
        }
    }


    private void getString() {
        System.out.println("GetString 1");
        if(resztaLinii.contains("<br>")){
            System.out.println("Zawiera <br>");
            setLine(resztaLinii.substring(0, resztaLinii.indexOf("<br>")));
            resztaLinii = resztaLinii.substring(resztaLinii.indexOf("<br>") + 4);
        }else{
            System.out.println("Nie zawiera <br>");
            setLine(resztaLinii.substring(0, resztaLinii.indexOf("-p") +2));
            resztaLinii = resztaLinii.substring(resztaLinii.indexOf("-p") +2);
        }
    }

    private void getString3() {
        StringBuilder zajeciaName = new StringBuilder();
        String grup = "";
        trim();
        String substring;

        while(!getLine().isEmpty()){
            System.out.println("Przed : " + getLine());
            setLine(getLine() + " ");
            substring = getLine().substring(0, getLine().indexOf(" "));
            setLine(getLine().substring(getLine().indexOf(" ")));
            if(substring.contains("-(") || substring.contains("-1ps") || substring.contains("-2ps")){
                System.out.println("TAK");
                if(substring.contains("-(")){
                    grup = substring.substring(0,substring.indexOf("-("));
                    if(grup.equals("angielski")){
                        zajeciaName = new StringBuilder("J angielski");
                    }
                }else{
                    if(substring.contains("-1ps")){
                        grup = substring.substring(0,substring.indexOf("-1ps"));
                    }else{
                        grup = substring.substring(0,substring.indexOf("-2ps"));
                    }
                }
                break;
            }else{
                System.out.println("NIE");
                if(substring.contains(" ")){
                    break;
                }else{
                    if(zajeciaName.isEmpty()){
                        zajeciaName.append(substring);
                    }else{
                        zajeciaName.append(" ").append(substring);
                    }

                    setLine(getLine().substring(getLine().indexOf(" ") + 1));
                    System.out.println("Text : " + getLine());
                }
            }
        }
        System.out.println("ZajeciaTest : " + zajeciaName);
        System.out.println("GrupTest : " + grup);

        System.out.println("GetLine po getString3 : " + getLine());
        setGrupaGrupyName(grup);
        setZajeciaName(zajeciaName.toString());
    }

    private void podsumowanie(GrupyGrup grupyGrup, Zajecia zajecia, Wykladowcy wykladowcy, Sale sale){
        System.out.println("+++++++++++++++++");
        System.out.println("Podsumowanie");
        System.out.println("+++++++++++++++++");

        System.out.println("Grupa grupy : " + grupyGrup);

        System.out.println("------");

        System.out.println("Zajecia : " + zajecia);

        System.out.println("------");

        System.out.println("Wykladowcy : " + wykladowcy);

        System.out.println("------");

        System.out.println("Sala : " + sale);

        System.out.println("------");

        System.out.println("Tydzien : " + getTydzien());
        System.out.println("Pozostała linia : " + getLine());
    }
}
