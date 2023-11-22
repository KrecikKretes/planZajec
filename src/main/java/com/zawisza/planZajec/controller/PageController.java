package com.zawisza.planZajec.controller;

import com.zawisza.planZajec.model.*;
import com.zawisza.planZajec.service.GrupyService;
import com.zawisza.planZajec.service.PlanService;
import com.zawisza.planZajec.service.SaleService;
import com.zawisza.planZajec.service.WykladowcyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@AllArgsConstructor
public class PageController {

    private final WykladowcyService wykladowcyService;
    private final GrupyService grupyService;
    private final SaleService saleService;
    private final PlanService planService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/page/search")
    public String search(Model model){
        int wykladowcySize = wykladowcyService.getCount();
        model.addAttribute("wykladowcySize", wykladowcySize);

        List<String> wykladowcyList;
        wykladowcyList = wykladowcyService.getUniqueName();
        model.addAttribute("wykladowcyName", wykladowcyList);

        List<String> wykladowcySkrotList;
        wykladowcySkrotList = wykladowcyService.getUniqueSkrot();
        model.addAttribute("wykladowcySkrot", wykladowcySkrotList);

        int grupySize = grupyService.getCount();
        model.addAttribute("grupySize", grupySize);

        List<Grupy> grupyList;
        grupyList = grupyService.getGrupy();
        model.addAttribute("grupy", grupyList);

        int saleSize = saleService.getCount();
        model.addAttribute("saleSize", saleSize);

        List<Sale> saleList;
        saleList = saleService.getSale();
        model.addAttribute("sale", saleList);

        String[] week = {"Pon", "Wt", "Sr", "Czw", "Pt"};
        model.addAttribute("week", week);

        String[] hours = {"7:30- 8:15", "8:15- 9:00", "9:15-10:00",
                "10:00-10:45", "11:00-11:45", "11:45-12:30",
                "12:45-13:30", "13:30-14:15", "14:30-15:15",
                "15:15-16:00", "16:15-17:00", "17:00-17:45",
                "18:00-18:45", "18:45-19:30"
        };
        model.addAttribute("godziny", hours);

        return "/page/search";
    }

    @PostMapping("/page/results")
    public String submit(@ModelAttribute("search") Search search,
                         ModelMap model) {

        System.out.println(search.getWykladowcyName());
        System.out.println(search.getGrupy());
        System.out.println(search.getSale());
        System.out.println(search.getWykladowcySkrot());
        System.out.println(search.getTydzien());


        List<String> wykladowcyName = search.getWykladowcyName();
        List<String> wykladowcySkrot = search.getWykladowcySkrot();
        List<String> sale = search.getSale();
        List<String> grupy = search.getGrupy();

        List<Integer> wykladowcyNameId = wykladowcyService.getIdByNazwisko(wykladowcyName);

        System.out.println(wykladowcyNameId);

        System.out.println();

        //List<Plan> planList = planService.getPlanById_wykladowcyAndTydzien(wykladowcyNameId,search.getTydzien());



        return "/page/results";
    }

}
