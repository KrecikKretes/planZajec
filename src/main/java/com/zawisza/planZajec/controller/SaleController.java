package com.zawisza.planZajec.controller;

import com.zawisza.planZajec.model.Sale;
import com.zawisza.planZajec.repository.SaleRepository;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SaleController {

    private final SaleRepository saleRepository;

    public SaleController(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @RequestMapping(value="/sale/updateSale")
    public String saveSale(){
        URL url;
        String sala = null;

        List<String> saleList = new ArrayList<>();

        saleRepository.deleteAll();

        int id = 1;

        procces:
        for(int i = 1; i < 400; i++){
            try {
                url = new URL("https://podzial.mech.pk.edu.pl/stacjonarne/html/plany/s" + i + ".html");
                URLConnection con = url.openConnection();
                InputStream inputStream = con.getInputStream();

                try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                    String line;

                    while ((line = br.readLine()) != null) {
                        if(line.contains("<span class=\"tytulnapis\">")){
                            line = line.replaceAll("<.*?>", "");
                            line = line.replaceAll("</span.*?table>", "");

                            System.out.println(line);
                            if(line.contains("-n") || line.contains("-p")){
                                if(line.contains("--")){
                                    continue procces;
                                }else{
                                    if(line.contains("-n")){
                                        sala = line.substring(0, line.indexOf("-n"));
                                    }else{
                                        if(line.contains("-p")){
                                            sala = line.substring(0, line.indexOf("-p"));
                                        }
                                    }
                                }
                            }else{
                                if(line.contains("*")){
                                    continue procces;
                                }else{
                                    if(line.contains(" ")){
                                        sala = line.substring(0, line.indexOf(" "));
                                    }else{
                                        sala = line;
                                    }
                                }
                            }

                            if(sala.charAt(0) < 65 && sala.charAt(0) > 90){
                                continue procces;
                            }

                            System.out.println(sala);

                            if(!saleList.contains(sala)){
                                Sale sale = new Sale(sala,i);
                                saleRepository.save(sale);
                                saleList.add(sala);
                                id++;
                            }

                            continue procces;
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


    @GetMapping("/sale/{sale_id}")
    public Optional<Sale> getOneSale(@PathVariable("sale_id") int sale_id){
        return saleRepository.findById(sale_id);
    }

    @GetMapping("/sale/sale")
    public Iterable<Sale> getAllSale(){
        return saleRepository.findAll();
    }

}
