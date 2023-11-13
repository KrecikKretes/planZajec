package com.zawisza.planZajec.controller;

import com.zawisza.planZajec.model.Grupy;
import com.zawisza.planZajec.model.GrupyGrup;
import com.zawisza.planZajec.repository.GrupyGrupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.zawisza.planZajec.repository.GrupyRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

@Controller
public class GrupaController {


    private final GrupyRepository grupyRepository;
    private final GrupyGrupRepository grupyGrupRepository;

    private final List<Grupy> grupies = new ArrayList<>();

    public GrupaController(GrupyRepository grupyRepository, GrupyGrupRepository grupyGrupRepository) {
        this.grupyRepository = grupyRepository;
        this.grupyGrupRepository = grupyGrupRepository;
    }

    @GetMapping("/error")
    @ResponseBody
    public String error(){
        return "error";
    }

/*
    @RequestMapping(value= "/{matchId}/saveDraw", method = RequestMethod.POST)
    @ResponseBody
    public String match(@PathVariable("matchId")int matchId, Draw draw){
        Grupa grupa = matchesRepository.findById(matchId).get();
        grupa.setKiller(grupaController.findById(draw.getIdKiller()).get().getName());
        grupa.setMap(mapsRepository.findById(draw.getIdMap()).get().getName());
        grupa.setAddon(draw.getAddonName());

        matchesRepository.save(grupa);
        return "Work";
    }

 */

    @GetMapping(value= "/work")
    @ResponseBody
    public String work(){
        return "Work";
    }


    /*
    @RequestMapping(value = "/{matchId}/draw",
            method = { RequestMethod.GET, RequestMethod.PUT })
    public String draw(@PathVariable("matchId") int matchId, Model model){
        killersID.clear();
        grupas.clear();
        mapsID.clear();
        maps.clear();
        Random rand = new Random();
        int n;
        for(int i = 0; i < 5; i++){
            do {
                n = rand.nextInt((int) grupaController.count()) + 1;
            }while(killersID.contains(n) && !killersID.isEmpty());
            killersID.add(n);
            grupaController.findById(n).get().setFile("/img/killers/" +
                    grupaController.findById(n).get().getFile());
            grupas.add(grupaController.findById(n).get());
        }
        for(int i = 0; i < 2; i++){
            do {
                n = rand.nextInt((int) mapsRepository.count()) + 1;
            }while(mapsID.contains(n) && !mapsID.isEmpty());
            mapsID.add(n);

            mapsRepository.findById(n).get().setFile("/img/maps/" +
                    mapsRepository.findById(n).get().getFile());
            maps.add(mapsRepository.findById(n).get());
        }
        model.addAttribute("killers", grupas);
        model.addAttribute("maps",maps);
        model.addAttribute("idMatch", matchId);
        model.addAttribute("draw", new Draw());
        return "draw";
    }


    @RequestMapping("leader")
    public String leader(Model model){
        if(teams.isEmpty()){
            for(int i = 1; i <= teamsRepository.count(); i++){
                teams.add(new Teams(teamsRepository.findById(i).get().getId(),
                        teamsRepository.findById(i).get().getName()
                ));
            }
            Collections.shuffle(teams,new Random());
            for(int i = 0; i < teams.size() + 3; i++){
                if(i < teams.size()){
                    matchesRepository.save(new Matches((i+2)/2, teams.get(i).getName(),
                            teams.get(++i).getName()));
                }else{
                    matchesRepository.save(new Matches((i+2)/2,"-","-"));
                }
            }
            for(int i = 1; i <= matchesRepository.count(); i ++){
                matches.add(matchesRepository.findById(i).get());
            }
        }


        model.addAttribute("teams", teams);
        model.addAttribute("matches", matches);
        return "leader";
    }
 */


    @GetMapping("/grupy")
    public @ResponseBody Iterable<Grupy> getAllGrupas(){
        return grupyRepository.findAll();
    }


    @GetMapping("/{grupa_id}")
    public @ResponseBody Optional<Grupy> getOneGrupa(@PathVariable("grupa_id") int grupaID){
        return grupyRepository.findById(grupaID);
    }

    @RequestMapping(value="/savegrupy")
    @ResponseBody
    public String saveGrupy(){
        URL url;
        String[] tydzien = {"Pon : ", "Wt : ", "Sr : ", "Czw : ", "Pt : "};
        String grupName;

        int id = 0;


        for(int i = 1; i < 88; i++){
            try {
                url = new URL("https://podzial.mech.pk.edu.pl/stacjonarne/html/plany/o" + i + ".html");
                URLConnection con = url.openConnection();
                InputStream isNieparzyste = con.getInputStream();
                InputStream isParzyste = con.getInputStream();

                try(BufferedReader br = new BufferedReader(new InputStreamReader(isNieparzyste))) {
                    String line;

                    // read each line and write to System.out
                    while ((line = br.readLine()) != null) {
                        //System.out.println(line);
                        if(line.contains("<span class=\"tytulnapis\">")){
                            line = line.replaceAll("<.*?>", "");
                            System.out.println(line);
                            grupName = line;

                            //Grupy grupy = new Grupy(grupName);
                            //grupyRepository.save(grupy);

                            id = (int)grupyRepository.count();

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
                                    String text = "";
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
                                        text = text.trim();
                                        if(text.startsWith("J ang") || text.substring(text.indexOf(" ") + 1, text.indexOf(" ") + 2).equals("W")){
                                            if(text.startsWith("J ang")){
                                                grup = "ang";
                                            }else{
                                                grup = "W";
                                            }
                                        }else{
                                            grup = text.substring(text.indexOf(" ") + 1, text.indexOf(" ") +4);
                                        }

                                        Iterable<GrupyGrup> grupyGrupIterable = grupyGrupRepository.findAllById(Collections.singleton(id));

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

                                    }

                                    System.out.println(tydzien[j] + "  " + grup);
                                }
                            }

                            System.out.println();
                        }

                    }
                }

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Complete";
    }

}
