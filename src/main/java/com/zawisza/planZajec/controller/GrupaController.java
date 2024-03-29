package com.zawisza.planZajec.controller;

import com.zawisza.planZajec.model.Grupy;
import com.zawisza.planZajec.model.GrupyGrup;
import com.zawisza.planZajec.repository.GrupyGrupRepository;
import com.zawisza.planZajec.repository.GrupyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GrupaController {


    private final GrupyRepository grupyRepository;
    private final GrupyGrupRepository grupyGrupRepository;

    public GrupaController(GrupyRepository grupyRepository, GrupyGrupRepository grupyGrupRepository) {
        this.grupyRepository = grupyRepository;
        this.grupyGrupRepository = grupyGrupRepository;
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
        String grupName;
        Grupy grupy = null;

        List<GrupyGrup> grupyGrupList = new ArrayList<>();

        grupyGrupRepository.deleteAll();
        grupyRepository.deleteAll();

        Grupy.reset();
        GrupyGrup.reset();

        outerloop:
        for(int i = 1; i < 88; i++){

            List<String> grupayList = new ArrayList<>();

            try {
                url = new URL("https://podzial.mech.pk.edu.pl/stacjonarne/html/plany/o" + i + ".html");
                URLConnection con = url.openConnection();
                InputStream inputStream = con.getInputStream();

                try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                    String line;

                    // read each line and write to System.out
                    while ((line = br.readLine()) != null) {
                        //System.out.println("***FULL LINE***");
                        //System.out.println(line);

                        if(line.contains("<span class=\"tytulnapis\">")){
                            line = line.replaceAll("<.*?>", "");
                            //System.out.println("***FIRST CHANGE OF LINE***");
                            //System.out.println(line);
                            grupName = line;

                            if(grupyRepository.getGrupyByGrupa(grupName) != null){
                                continue outerloop;
                            }else{
                                grupy = new Grupy(grupName);
                                //System.out.println(grupy);
                            }

                            System.out.println("----------------");
                            continue;
                        }

                        if(line.contains("<td class=\"g\">")) {

                            //Wypisanie godziny
                            line = line.replaceAll("<.*?>", "");
                            //System.out.println("***FIRST CHANGE OF LINE***");
                            //System.out.println(line);
                            //System.out.println("i = " + i);


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

                                while (line.contains("-n") || line.contains("-p")) {
                                    //System.out.println("LINE : " + line);
                                    String text;
                                    String grup;

                                    if(line.contains("-n") && line.contains("-p")){
                                        if(line.indexOf("-n") < line.indexOf("-p")){
                                            //System.out.println("Zawiera pierwsze -n i -p");
                                            text = line.substring(0, line.indexOf("-n") + 2);
                                            line = line.substring(line.indexOf("-n") + 2);
                                        }else{
                                            //System.out.println("Zawiera pierwsze -p i -n");
                                            text = line.substring(0, line.indexOf("-p") + 2);
                                            line = line.substring(line.indexOf("-p") + 2);
                                        }
                                    }else{
                                        if(line.contains("-n")){
                                            //System.out.println("Zawiera tylko -n");
                                            text = line.substring(0, line.indexOf("-n") + 2);
                                            line = line.substring(line.indexOf("-n") + 2);
                                        } else {
                                            //System.out.println("Zawiera tylko -p");
                                            text = line.substring(0, line.indexOf("-p") + 2);
                                            line = line.substring(line.indexOf("-p") + 2);
                                        }
                                    }

                                    grup = getString(text);
                                    if(!grupayList.contains(grup)){
                                        grupayList.add(grup);
                                        GrupyGrup grupyGrup = new GrupyGrup(grup, grupy);
                                        grupyGrupList.add(grupyGrup);
                                    }
                                }
                            }

                            //System.out.println();
                        }

                    }
                }

                System.out.println("------");
                System.out.println(grupyGrupList);
                System.out.println("------");

                grupy.setGrupyGrupList(grupyGrupList);
                System.out.println(grupy);
                grupyRepository.save(grupy);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Complete";
    }

    private String getString(String text) {
        String grup = "";
        text = text.trim() + " ";
        String substring;

        while(!text.isEmpty()){
            //System.out.println(text);
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
                    text = text.substring(text.indexOf(" ") + 1);
                }
            }
        }

        //System.out.println("getString return = " + grup);

        return grup;
    }

}
