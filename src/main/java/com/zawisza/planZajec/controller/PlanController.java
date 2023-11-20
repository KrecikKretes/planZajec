package com.zawisza.planZajec.controller;


import com.zawisza.planZajec.Constant;
import com.zawisza.planZajec.model.Plan;
import com.zawisza.planZajec.model.Sale;
import com.zawisza.planZajec.model.Wykladowcy;
import com.zawisza.planZajec.repository.*;
import com.zawisza.planZajec.service.GrupyGrupService;
import com.zawisza.planZajec.service.SaleService;
import com.zawisza.planZajec.service.WykladowcyService;
import com.zawisza.planZajec.service.ZajeciaService;
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

    @RequestMapping(value="/plan/updatePlan")
    public String savePlan(){
        URL url;
        String[] week = {"Pon", "Wt", "Sr", "Czw", "Pt"};
        int id = 0;

        int id_grupy_grup;
        int id_sale;
        int id_wykladowcy;
        int id_zajecia;

        int a = -1;

        String godzina = null;

        List<Plan> planList = new ArrayList<>();
        List<String> wykladowcyList = new ArrayList<>();
        List<String> salaList = new ArrayList<>();

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
                                a = j;

                                setLine(br.readLine());
                                if (getLine().contains("&nbsp;")) {
                                    //System.out.println();
                                    continue;
                                }

                                String test = getLine();

                                while (getLine().contains("-n") || getLine().contains("-p")) {
                                    System.out.println();
                                    System.out.println("***************");

                                    setLine(test);

                                    System.out.println("TEST PRZED : " + test);

                                    if(getLine().indexOf("-n") > 0 && getLine().indexOf("-p") > 0){
                                        if(getLine().indexOf("-n") > getLine().indexOf("-p")){
                                            if(!getLine().contains("<br>")){
                                                setLine(test.substring(0,test.indexOf("-p") +2));
                                                test = test.substring(test.indexOf("-p") +2);
                                            }else{
                                                setLine(test.substring(0,test.indexOf("<br>")));
                                                test = test.substring(test.indexOf("<br>"));
                                            }
                                        }else{
                                            if(!getLine().contains("<br>")){
                                                setLine(test.substring(0,test.indexOf("-n") +2 ));
                                                test = test.substring(test.indexOf("-n") + 2);
                                            }else{
                                                setLine(test.substring(0,test.indexOf("<br>")));
                                                test = test.substring(test.indexOf("<br>"));
                                            }
                                        }
                                    }else{
                                        if(getLine().indexOf("-n") > 0){
                                            if(!getLine().contains("<br>")){
                                                setLine(test.substring(0,test.indexOf("-n") +2 ));
                                                test = test.substring(test.indexOf("-n") + 2);
                                            }else{
                                                setLine(test.substring(0,test.indexOf("<br>")));
                                                test = test.substring(test.indexOf("<br>"));
                                            }
                                        } else {
                                            if(!getLine().contains("<br>")){
                                                setLine(test.substring(0,test.indexOf("-p") +2));
                                                test = test.substring(test.indexOf("-p") +2);
                                            }else{
                                                setLine(test.substring(0,test.indexOf("<br>")));
                                                test = test.substring(test.indexOf("<br>"));
                                            }
                                        }
                                    }

                                    System.out.println("TEST PO : " + test);

                                    reset();

                                    System.out.println(getLine());

                                    String id_wykladowcy_href;
                                    int id_wykladowcy_href_int = -1;
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
                                    }


                                    System.out.println("___________________");
                                    System.out.println(getLine());

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
                                    setLine(getLine().replaceAll("\\(N.", ""));
                                    setLine(getLine().replaceAll("\\(P.", ""));
                                    setLine(getLine().replaceAll("\\(n.", ""));
                                    setLine(getLine().replaceAll("\\(p.", ""));

                                    setLine(getLine().replaceAll(" {2}", " "));


                                    //setLine(getLine().trim());
                                    System.out.println(getLine());

                                    System.out.println("___________________");

                                    function1();

                                    setLine(getLine().trim());

                                    if(!getGrupaGrupyName().equals("ang")) {
                                        if(getLine().startsWith("W 1ps")){
                                            setGrupaGrupyName(getLine().substring(0, 1));
                                            substring();
                                        }else{
                                            setGrupaGrupyName(getLine().substring(0, getLine().indexOf(" ")));
                                        }
                                        substring();
                                    }

                                    setWykladowcyName(getLine().substring(0, getLine().indexOf(" ")));

                                    substring();

                                    System.out.println("BBB : " + getLine());
                                    String test2;
                                    if(getLine().length() < 7){
                                        test2 = getLine();
                                    }else{
                                        test2 = getLine().substring(0,5);
                                    }

                                    System.out.println("Test 2 : " + test2);
                                    if(getLine().substring(0, getLine().indexOf("-n") + 2).endsWith("-n") ||
                                            getLine().substring(0, getLine().indexOf("-p") + 2).endsWith("-p")){
                                        setSalaName(getLine().substring(0, getLine().indexOf("-")));
                                    }else{
                                        setSalaName(getLine().substring(0, getLine().indexOf(" ")));
                                    }

                                    if(test2.contains("-n") || test2.contains("-p")){
                                        test2 = test2.replace("-n", "");
                                        test2 = test2.replace("-p", "");
                                    }else{
                                        if(test2.contains(" ")){
                                            test2 = test2.substring(0, test2.indexOf(" "));
                                        }
                                    }
                                    System.out.println("Test 2 : " + test2);
                                    setSalaName(test2);

                                    if(getLine().contains(" ")){
                                        substring();
                                    }else{
                                        setLine("");
                                    }

                                    System.out.println("Zajecia : " + getZajeciaName());
                                    id_zajecia = zajeciaService.getZajeciaByNazwa(getZajeciaName()).getId();
                                    System.out.println("ID zajecia : " + id_zajecia);

                                    System.out.println("Grupa grupy : " + getGrupaGrupyName());
                                    id_grupy_grup = grupyGrupService.getGrupyGrupByIdGrupyAndNazwaGrup(id,getGrupaGrupyName()).getId();
                                    System.out.println("ID grupa grupy  : " + id_grupy_grup);


                                    System.out.println("Skrót : " + getWykladowcyName());
                                    System.out.println("ID a href : " + id_wykladowcy_href_int);
                                    if(wykladowcyService.getWykladowcyBySkrotAndIdStrony(getWykladowcyName(), id_wykladowcy_href_int) == null &&
                                            !wykladowcyList.contains(getWykladowcyName())){
                                        wykladowcyList.add(getWykladowcyName());
                                        wykladowcyRepository.save(new Wykladowcy("Nieznane", getWykladowcyName(), -1));
                                        id_wykladowcy = wykladowcyService.getWykladowcyByNazwiskoAndSkrot("Nieznane",getWykladowcyName()).getId();
                                    }else{
                                        id_wykladowcy = wykladowcyService.getWykladowcyBySkrotAndIdStrony(getWykladowcyName(), id_wykladowcy_href_int).getId();
                                    }
                                    System.out.println("Id wykladowcy : " + id_wykladowcy);


                                    System.out.println("Sala : " + getSalaName());
                                    if(saleService.getSaleBySala(getSalaName()) == null &&
                                            !salaList.contains(getSalaName())){
                                        salaList.add(getSalaName());
                                        saleRepository.save(new Sale(getSalaName()));
                                    }
                                    id_sale = saleService.getSaleBySala(getSalaName()).getId();
                                    System.out.println(id_sale);


                                    System.out.println(getTydzien());
                                    System.out.println("LINE : " + getLine());

                                    Plan plan = new Plan(id, id_grupy_grup, id_sale, id_wykladowcy, id_zajecia, getTydzien(), godzina, week[j]);
                                    //id_grupy, id_grupy_grup, id_sale, id_wykladowcy, id_zajecia, tydzien, godz, dzien
                                    //System.out.println(week[j] + "  " + text);

                                    System.out.println(plan);

                                    if(!planList.contains(plan)){
                                        planRepository.save(plan);
                                        planList.add(plan);
                                    }

                                }
                            }

                            System.out.println();
                        }

                    }
                }


            } catch (NullPointerException | NonUniqueResultException e){
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

    private void function1(){
        if(getLine().startsWith("J ang")){
            setZajeciaName("J angielski");
            if (getLine().indexOf("-n") > 0) {
                System.out.println("Ang Posiada -n");
                setTydzien('n');
                setGrupaGrupyName("ang");
                setLine(getLine().substring(11));
            } else {
                if(getLine().indexOf("-p") > 0){
                    System.out.println("Ang Posiada -p");
                    setTydzien('p');
                    setGrupaGrupyName("ang");
                    setLine(getLine().substring(11));
                }
            }
        }else {
            if(getLine().startsWith("Mat DK")){
                if (getLine().indexOf("-n") > 0) {
                    System.out.println("Mat DK Posiada -n");
                    setTydzien('n');
                    setGrupaGrupyName("Ć");
                    setLine(getLine().substring(7));
                } else {
                    if(getLine().indexOf("-p") > 0){
                        System.out.println("Mat DK Posiada -p");
                        setTydzien('p');
                        setGrupaGrupyName("Ć");
                        setLine(getLine().substring(7));
                    }
                }
            }else{
                if(getLine().startsWith("Ster pc")) {
                    if (getLine().indexOf("-n") > 0) {
                        System.out.println("Ster pc Posiada -n");
                        setTydzien('n');
                        setGrupaGrupyName(getLine().substring(getLine().indexOf("pc ") + 3, getLine().indexOf("pc ") + 6));
                        setLine(getLine().substring(getLine().indexOf("pc ") + 3));
                        System.out.println("AA : " + getLine());
                    } else {
                        if (getLine().indexOf("-p") > 0) {
                            System.out.println("Ster pc Posiada -p");
                            setTydzien('p');
                            setGrupaGrupyName(getLine().substring(getLine().indexOf("pc ") + 3, getLine().indexOf("pc ") + 6));
                            setLine(getLine().substring(getLine().indexOf("pc ") + 3));
                            System.out.println("AA : " + getLine());
                        }
                    }
                }else {
                    if(getLine().startsWith("Ap Med")){
                        if (getLine().indexOf("-n") > 0) {
                            System.out.println("Ap Med Posiada -n");
                            setTydzien('n');
                            setGrupaGrupyName(getLine().substring(getLine().indexOf("Med ") + 4, getLine().indexOf("Med ") + 7));
                            setLine(getLine().substring(getLine().indexOf("Med ") + 4));
                            System.out.println("AA : " + getLine());
                        } else {
                            if (getLine().indexOf("-p") > 0) {
                                System.out.println("Ap Med Posiada -p");
                                setTydzien('p');
                                setGrupaGrupyName(getLine().substring(getLine().indexOf("Med ") + 4, getLine().indexOf("Med ") + 7));
                                setLine(getLine().substring(getLine().indexOf("Med ") + 4));
                                System.out.println("AA : " + getLine());
                            }
                        }
                    } else {
                        if(getLine().startsWith("PM3D CAD")) {
                            if (getLine().indexOf("-n") > 0) {
                                System.out.println("PM3D CAD Posiada -n");
                                setTydzien('n');
                                setGrupaGrupyName(getLine().substring(getLine().indexOf("CAD ") + 4, getLine().indexOf("CAD ") + 7));
                                setLine(getLine().substring(getLine().indexOf("CAD ") + 4));
                                System.out.println("AA : " + getLine());
                            } else {
                                if (getLine().indexOf("-p") > 0) {
                                    System.out.println("PM3D CAD Posiada -p");
                                    setTydzien('p');
                                    setGrupaGrupyName(getLine().substring(getLine().indexOf("CAD ") + 4, getLine().indexOf("CAD ") + 7));
                                    setLine(getLine().substring(getLine().indexOf("CAD ") + 4));
                                    System.out.println("AA : " + getLine());
                                }
                            }
                        }else {
                            if(getLine().startsWith("Ind 4.0")) {
                                if (getLine().indexOf("-n") > 0) {
                                    System.out.println("Ind 4.0 Posiada -n");
                                    setTydzien('n');
                                    setGrupaGrupyName(getLine().substring(getLine().indexOf("4.0 ") + 4, getLine().indexOf("4.0 ") + 7));
                                    setLine(getLine().substring(getLine().indexOf("4.0 ") + 4));
                                    System.out.println("AA : " + getLine());
                                } else {
                                    if (getLine().indexOf("-p") > 0) {
                                        System.out.println("Ind 4.0 Posiada -p");
                                        setTydzien('p');
                                        setGrupaGrupyName(getLine().substring(getLine().indexOf("4.0 ") + 4, getLine().indexOf("4.0 ") + 7));
                                        setLine(getLine().substring(getLine().indexOf("4.0 ") + 4));
                                        System.out.println("AA : " + getLine());
                                    }
                                }
                            }else {
                                if (getLine().indexOf("-n") > 0 || getLine().indexOf("(N") > 0) {
                                    System.out.println("No ang Posiada -n");
                                    setTydzien('n');
                                    setZajeciaName(getLine().substring(0, getLine().indexOf(" ")));
                                    setLine(getLine().substring(getLine().indexOf(" ")));
                                } else {
                                    if (getLine().indexOf("-p") > 0) {
                                        System.out.println("No ang Posiada -p");
                                        setTydzien('p');
                                        setZajeciaName(getLine().substring(0, getLine().indexOf(" ")));
                                        setLine(getLine().substring(getLine().indexOf(" ")));
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
