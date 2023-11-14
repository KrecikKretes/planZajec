package com.zawisza.planZajec.controller;

import com.zawisza.planZajec.model.Grupy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Controller
public class SaleController {

    @RequestMapping(value="/updateSale")
    @ResponseBody
    public String saveSale(){
        URL url;
        String[] week = {"Pon : ", "Wt : ", "Sr : ", "Czw : ", "Pt : "};
        String grupName;

        int id;


        for(int i = 1; i < 300; i++){
            try {
                url = new URL("https://podzial.mech.pk.edu.pl/stacjonarne/html/plany/s" + i + ".html");
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

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Complete";
    }
}
