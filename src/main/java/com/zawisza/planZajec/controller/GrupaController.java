package com.zawisza.planZajec.controller;

import com.zawisza.planZajec.repository.WykladowcyRepository;
import com.zawisza.planZajec.service.GrupyGrupService;
import com.zawisza.planZajec.model.Grupy;
import com.zawisza.planZajec.model.GrupyGrup;
import com.zawisza.planZajec.repository.GrupyGrupRepository;

import com.zawisza.planZajec.repository.GrupyRepository;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Optional;

@RestController
public class GrupaController {


    private final GrupyRepository grupyRepository;
    private final GrupyGrupRepository grupyGrupRepository;
    private final GrupyGrupService grupyGrupService;

    public GrupaController(GrupyRepository grupyRepository, GrupyGrupRepository grupyGrupRepository,
                           GrupyGrupService grupyGrupService) {
        this.grupyRepository = grupyRepository;
        this.grupyGrupRepository = grupyGrupRepository;
        this.grupyGrupService = grupyGrupService;
    }


    @GetMapping("/grupy/grupy")
    public Iterable<Grupy> getAllGrupas(){
        return grupyRepository.findAll();
    }


    @GetMapping("/grupy/{grupa_id}")
    public Optional<Grupy> getOneGrupa(@PathVariable("grupa_id") int grupaID){
        return grupyRepository.findById(grupaID);
    }

    @RequestMapping(value="/grupy/updateGrupy")
    public String saveGrupy(){
        URL url;
        String[] week = {"Pon : ", "Wt : ", "Sr : ", "Czw : ", "Pt : "};
        String grupName;

        int id;

        grupyGrupRepository.deleteAll();
        grupyRepository.deleteAll();

        for(int i = 1; i < 88; i++){
            try {
                url = new URL("https://podzial.mech.pk.edu.pl/stacjonarne/html/plany/o" + i + ".html");
                URLConnection con = url.openConnection();
                InputStream isOdd = con.getInputStream();


                id = i;

                try(BufferedReader br = new BufferedReader(new InputStreamReader(isOdd))) {
                    String line;

                    // read each line and write to System.out
                    while ((line = br.readLine()) != null) {
                        //System.out.println(line);
                        if(line.contains("<span class=\"tytulnapis\">")){
                            line = line.replaceAll("<.*?>", "");
                            System.out.println(line);
                            grupName = line;

                            Grupy grupy = new Grupy(grupName);
                            grupyRepository.save(grupy);

                            System.out.println("----------------");
                            System.out.println("Nieparzysty tydzień");
                            continue;
                        }

                        if(line.contains("<td class=\"g\">")) {

                            //Wypisanie godziny
                            line = line.replaceAll("<.*?>", "");
                            System.out.println(line);


                            //Wypisanie dla kazdego dnia
                            for (int j = 0; j < 5; j++) {
                                line = br.readLine();
                                if (line.contains("&nbsp;")) {
                                    //System.out.println();
                                    continue;
                                }

                                line = line.replaceAll("<.*?>", "");
                                line = line.replaceAll("-n", "-n ");
                                line = line.replaceAll("-p", "-p ");

                                while (line.contains("-n")) {
                                    //System.out.println(line);
                                    String text;
                                    String grup = "";
                                    if (line.indexOf("-n") > 0) {
                                        //System.out.println("Posiada -n");
                                        text = line.substring(0, line.indexOf("-n") + 2);
                                        line = line.substring(line.indexOf("-n") + 2);
                                        //} else {
                                        //if(line.indexOf("-p") > 0){
                                        //    System.out.println("Posiada -p");
                                        //    text = line.substring(0, line.indexOf("-p") + 2);
                                        //    line = line.substring(line.indexOf("-p") + 2, line.length());
                                        //}
                                        grup = getString(id, text);

                                    }

                                    System.out.println(week[j] + "  " + grup);
                                }
                            }

                            System.out.println();
                        }

                    }
                }

                con = url.openConnection();
                InputStream isEven = con.getInputStream();

                try(BufferedReader br = new BufferedReader(new InputStreamReader(isEven))) {
                    String line;

                    System.out.println("----------------");
                    System.out.println("Parzysty tydzień");

                    // read each line and write to System.out
                    while ((line = br.readLine()) != null) {
                        //System.out.println(line);

                        if(line.contains("<td class=\"g\">")) {

                            //Wypisanie godziny
                            line = line.replaceAll("<.*?>", "");
                            System.out.println(line);


                            //Wypisanie dla kazdego dnia
                            for (int j = 0; j < 5; j++) {
                                line = br.readLine();
                                if (line.contains("&nbsp;")) {
                                    //System.out.println();
                                    continue;
                                }

                                line = line.replaceAll("<.*?>", "");
                                line = line.replaceAll("-n", "-n ");
                                line = line.replaceAll("-p", "-p ");

                                while (line.contains("-p")) {
                                    String text;
                                    String grup = "";
                                    if(line.indexOf("-p") > 0){
                                        text = line.substring(0, line.indexOf("-p") + 2);
                                        line = line.substring(line.indexOf("-p") + 2);

                                        grup = getString(id, text);

                                    }

                                    System.out.println(week[j] + "  " + grup);
                                }
                            }

                            System.out.println();
                        }

                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Complete";
    }

    private String getString(int id, String text) {
        String grup;
        text = text.trim();
        String substring = text.substring(text.indexOf(" ") + 1, text.indexOf(" ") + 2);
        if(text.startsWith("J ang") || text.startsWith("Mat DK") || text.startsWith("Ster pc") ||
                text.startsWith("Ap Med") ||
                substring.equals("W") || substring.equals("Ć") || substring.equals("S")){
            System.out.println(text);
            System.out.println(substring);
            if(text.startsWith("J ang")){
                grup = "ang";
            } else{
                if(text.startsWith("Mat DK")) {
                    grup = "Ć";
                } else {
                    if(text.startsWith("Ster pc")){
                        grup = text.substring(text.indexOf("pc ") + 3, text.indexOf("pc ") + 6);
                    }else{
                        if(text.startsWith("Ap Med")){
                            grup = text.substring(text.indexOf("Med ") + 4, text.indexOf("Med ") + 7);
                        }else{
                            if(text.startsWith("PM3D CAD")){
                                grup = text.substring(text.indexOf("CAD ") + 4, text.indexOf("CAD ") + 7);
                            }else {
                                if(text.startsWith("Ind 4.0")){
                                    grup = text.substring(text.indexOf("4.0 ") + 4, text.indexOf("4.0 ") + 7);
                                }else{
                                    if(substring.startsWith("W")){
                                        grup = "W";
                                    }else{
                                        if(substring.startsWith("S")){
                                            grup = "S";
                                        }else{
                                            grup = "Ć";
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else{
            grup = text.substring(text.indexOf(" ") + 1, text.indexOf(" ") +4);
        }

        List<GrupyGrup> grupyGrupIterable = grupyGrupService.getGrupyGrup(id);

        boolean exist = true;

        for(GrupyGrup grupyGrup : grupyGrupIterable){
            if(grupyGrup.getGrupaGrupy().equals(grup)){
                exist = false;
                break;
            }
        }
        if(exist){
            grupyGrupRepository.save(new GrupyGrup(id,grup));
        }
        return grup;
    }

}
