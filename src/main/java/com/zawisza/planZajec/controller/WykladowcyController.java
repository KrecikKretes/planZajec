package com.zawisza.planZajec.controller;

import com.zawisza.planZajec.model.Wykladowcy;
import com.zawisza.planZajec.repository.WykladowcyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WykladowcyController {


    private final WykladowcyRepository wykladowcyRepository;

    public WykladowcyController(WykladowcyRepository wykladowcyRepository) {
        this.wykladowcyRepository = wykladowcyRepository;
    }

    @ResponseBody
    @RequestMapping(value="/wykladowcy/updateWykladowcy")
    public String saveWykladowcy(){
        URL url;
        String grupName;

        int id;

        List<Wykladowcy> wykladowcyList = new ArrayList<>();


        procces: for(int i = 1; i < 1000; i++){
            try {
                url = new URL("https://podzial.mech.pk.edu.pl/stacjonarne/html/plany/n" + i + ".html");
                URLConnection con = url.openConnection();
                InputStream isOdd = con.getInputStream();

                id = i;

                try(BufferedReader br = new BufferedReader(new InputStreamReader(isOdd))) {
                    String line;

                    // read each line and write to System.out
                    while ((line = br.readLine()) != null) {
                        //System.out.println(line);
                        if(line.contains("<span class=\"tytulnapis\">")){
                            line = line.replaceAll("<span.*?>", "");
                            line = line.replaceAll("</span.*?table>", "");
                            System.out.println("-----");
                            System.out.println(i);
                            System.out.println(line);
                            String nazwisko;
                            if(line.contains("-n")){
                                nazwisko = line.substring(0, line.indexOf("-n"));
                            }else{
                                nazwisko = line.substring(0, line.indexOf("-p"));
                            }
                            String skrot = line.substring(line.indexOf("(") + 1, line.indexOf(")"));

                            Wykladowcy wykladowcy = new Wykladowcy(nazwisko,skrot);
                            if(!wykladowcyList.contains(wykladowcy)){
                                wykladowcyRepository.save(wykladowcy);
                            }

                            continue procces;
                        }
                    }
                }

            } catch (FileNotFoundException e){
                continue procces;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Complete";
    }
}
