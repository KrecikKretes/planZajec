package com.zawisza.planZajec.controller;


import com.zawisza.planZajec.model.Zajecia;
import com.zawisza.planZajec.repository.ZajeciaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ZajeciaController {

    private final ZajeciaRepository zajeciaRepository;

    public ZajeciaController(ZajeciaRepository zajeciaRepository) {
        this.zajeciaRepository = zajeciaRepository;
    }

    @GetMapping("/zajecia/zajecia")
    public Iterable<Zajecia> getAllZajecia(){
        return zajeciaRepository.findAll();
    }

    @GetMapping("/zajecia/{zajecia_id}")
    public Optional<Zajecia> getOneZajecia(@PathVariable("zajecia_id") int zajeciaID){
        return zajeciaRepository.findById(zajeciaID);
    }

    @RequestMapping(value="/zajecia/updateZajecia")
    public String saveZajecia(){
        URL url;
        String[] week = {"Pon : ", "Wt : ", "Sr : ", "Czw : ", "Pt : "};

        List<String> zajeciaList = new ArrayList<>();

        zajeciaRepository.deleteAll();
        Zajecia.reset();

        for(int i = 1; i < 87; i++){
            try {
                url = new URL("https://podzial.mech.pk.edu.pl/stacjonarne/html/plany/o" + i + ".html");
                URLConnection con = url.openConnection();
                InputStream inputStream = con.getInputStream();

                try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                    String line;

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

                                while (line.contains("-n") || line.contains("-p")) {
                                    //System.out.println(line);
                                    String text = "";
                                    if(line.startsWith("J ang")){
                                        text = "J angielski";
                                        if (line.indexOf("-n") > 0) {
                                            System.out.println("Posiada -n");
                                            line = line.substring(line.indexOf("-n") + 3);
                                        } else {
                                            if(line.indexOf("-p") > 0){
                                                System.out.println("Posiada -p");
                                                line = line.substring(line.indexOf("-p") + 3);
                                            }
                                        }
                                    }else{
                                        if(line.startsWith("Mat DK")){
                                            text = "Mat DK";
                                            if (line.indexOf("-n") > 0) {
                                                System.out.println("Posiada -n");
                                                line = line.substring(line.indexOf("-n") + 3);
                                            } else {
                                                if(line.indexOf("-p") > 0){
                                                    System.out.println("Posiada -p");
                                                    line = line.substring(line.indexOf("-p") + 3);
                                                }
                                            }
                                        }else{
                                            if(line.startsWith("Ster pc")){
                                                text = "Ster pc";
                                                if (line.indexOf("-n") > 0) {
                                                    System.out.println("Posiada -n");
                                                    line = line.substring(line.indexOf("-n") + 3);
                                                } else {
                                                    if(line.indexOf("-p") > 0){
                                                        System.out.println("Posiada -p");
                                                        line = line.substring(line.indexOf("-p") + 3);
                                                    }
                                                }
                                            }else {
                                                if(line.startsWith("Ap Med")) {
                                                    text = "Ap Med";
                                                    if (line.indexOf("-n") > 0) {
                                                        System.out.println("Posiada -n");
                                                        line = line.substring(line.indexOf("-n") + 3);
                                                    } else {
                                                        if (line.indexOf("-p") > 0) {
                                                            System.out.println("Posiada -p");
                                                            line = line.substring(line.indexOf("-p") + 3);
                                                        }
                                                    }
                                                }else{
                                                    if(line.startsWith("PM3D CAD")){
                                                        text = "PM3D CAD";
                                                        if (line.indexOf("-n") > 0) {
                                                            System.out.println("Posiada -n");
                                                            line = line.substring(line.indexOf("-n") + 3);
                                                        } else {
                                                            if (line.indexOf("-p") > 0) {
                                                                System.out.println("Posiada -p");
                                                                line = line.substring(line.indexOf("-p") + 3);
                                                            }
                                                        }
                                                    }else{
                                                        if(line.startsWith("Ind 4.0")){
                                                            text = "Ind 4.0";
                                                            if (line.indexOf("-n") > 0) {
                                                                System.out.println("Posiada -n");
                                                                line = line.substring(line.indexOf("-n") + 3);
                                                            } else {
                                                                if (line.indexOf("-p") > 0) {
                                                                    System.out.println("Posiada -p");
                                                                    line = line.substring(line.indexOf("-p") + 3);
                                                                }
                                                            }
                                                        }else{
                                                            if (line.indexOf("-n") > 0) {
                                                                System.out.println("Posiada -n");
                                                                text = line.substring(0, line.indexOf(" "));
                                                                line = line.substring(line.indexOf("-n") + 3);
                                                            } else {
                                                                if (line.indexOf("-p") > 0) {
                                                                    System.out.println("Posiada -p");
                                                                    text = line.substring(0, line.indexOf(" "));
                                                                    line = line.substring(line.indexOf("-p") + 3);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    if(zajeciaRepository.findZajeciaByNazwa(text) == null){
                                        Zajecia zajecia = new Zajecia(text);
                                        zajeciaRepository.save(zajecia);
                                        zajeciaList.add(text);
                                    }


                                    System.out.println(week[j] + "  " + text);
                                }
                            }

                            System.out.println();
                        }

                    }
                }


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
}
