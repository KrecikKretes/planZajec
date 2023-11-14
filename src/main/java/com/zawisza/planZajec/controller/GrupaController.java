package com.zawisza.planZajec.controller;

import com.zawisza.planZajec.model.Wykladowcy;
import com.zawisza.planZajec.repository.WykladowcyRepository;
import com.zawisza.planZajec.service.GrupyGrupService;
import com.zawisza.planZajec.model.Grupy;
import com.zawisza.planZajec.model.GrupyGrup;
import com.zawisza.planZajec.repository.GrupyGrupRepository;

import com.zawisza.planZajec.repository.GrupyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class GrupaController {


    private final GrupyRepository grupyRepository;
    private final GrupyGrupRepository grupyGrupRepository;
    private final GrupyGrupService grupyGrupService;



    private final List<Grupy> grupies = new ArrayList<>();

    public GrupaController(GrupyRepository grupyRepository, GrupyGrupRepository grupyGrupRepository,
                           GrupyGrupService grupyGrupService, WykladowcyRepository wykladowcyRepository) {
        this.grupyRepository = grupyRepository;
        this.grupyGrupRepository = grupyGrupRepository;
        this.grupyGrupService = grupyGrupService;
    }

    @GetMapping("/error")
    @ResponseBody
    public String error(){
        return "error";
    }

    @GetMapping(value= "/work")
    @ResponseBody
    public String work(){
        return "Work";
    }


    @GetMapping("/grupy")
    public @ResponseBody Iterable<Grupy> getAllGrupas(){
        return grupyRepository.findAll();
    }


    @GetMapping("/{grupa_id}")
    public @ResponseBody Optional<Grupy> getOneGrupa(@PathVariable("grupa_id") int grupaID){
        return grupyRepository.findById(grupaID);
    }

    @RequestMapping(value="/updateGrupy")
    @ResponseBody
    public String saveGrupy(){
        URL url;
        String[] week = {"Pon : ", "Wt : ", "Sr : ", "Czw : ", "Pt : "};
        String grupName;

        int id;


        for(int i = 1; i < 87; i++){
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
        if(text.startsWith("J ang") || substring.equals("W") || substring.equals("Ć")){
            if(text.startsWith("J ang")){
                grup = "ang";
            }else{
                if(text.startsWith("W")){
                    grup = "W";
                }else{
                    grup = "Ć";
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
