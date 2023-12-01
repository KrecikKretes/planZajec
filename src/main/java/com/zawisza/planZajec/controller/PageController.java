package com.zawisza.planZajec.controller;

import com.zawisza.planZajec.model.*;
import com.zawisza.planZajec.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PageController {

    private final WykladowcyService wykladowcyService;
    private final GrupyService grupyService;
    private final GrupyGrupService grupyGrupService;
    private final SaleService saleService;
    private final PlanService planService;
    private final ZajeciaService zajeciaService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/page/update")
    public String update(){
        return "/page/update";
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

        int grupyGrupySize = grupyGrupService.getCount();
        model.addAttribute("grupyGrupySize", grupyGrupySize);

        List<String> grupyGrupyList;
        grupyGrupyList = grupyGrupService.getGrupyGrupy();

        model.addAttribute("grupyGrup", grupyGrupyList);

        int zajeciaSize = zajeciaService.getCount();
        model.addAttribute("zajeciaSize", zajeciaSize);

        List<Zajecia> zajeciaList;
        zajeciaList = zajeciaService.getZajecia();
        model.addAttribute("zajecia", zajeciaList);

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

        List<String> grupaGrupy = search.getGrupyGrup();
        List<String> zajeciaNazwa = search.getZajecia();
        List<String> tydzien = search.getTydzien();
        List<String> godz = search.getGodzina();
        List<String> dzien = search.getDzien();

        List<Plan> planList;

        System.out.println();

        planList = checkWhatIsNull(wykladowcyName,wykladowcySkrot,
                sale, grupy, grupaGrupy, zajeciaNazwa, tydzien, godz, dzien);



        model.addAttribute("planList", planList);





        return "/page/results";
    }

    private List<Plan> checkWhatIsNull(List<String> wykladowcyName,
    List<String> wykladowcySkrot, List<String> sale,
    List<String> grupy, List<String> grupaGrupy,
    List<String> zajeciaNazwa, List<String> tydzien,
    List<String> godz, List<String> dzien) {

        if(wykladowcyName != null){
            if(wykladowcySkrot == null){
                if(sale == null){
                    if(grupy == null){
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwisko(wykladowcyName);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndDzien(wykladowcyName,dzien);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGodz(wykladowcyName,godz);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGodzAndDzien(wykladowcyName,godz,dzien);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndTydzien(wykladowcyName, tydzien);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndTydzienAndDzien(wykladowcyName,dzien,tydzien);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndTydzienAndGodz(wykladowcyName,godz,tydzien);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwa(wykladowcyName, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupy(wykladowcyName, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndTydzien(wykladowcyName, tydzien);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndTydzienAndGodz(wykladowcyName,godz,tydzien);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupy(wykladowcyName, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndDzien(wykladowcyName,dzien,grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGodz(wykladowcyName,godz, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndTydzien(wykladowcyName, tydzien, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupy);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupy);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupy(wykladowcyName, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzien(wykladowcyName, tydzien, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, grupy);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else{
                    if(grupy == null){
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSale(wykladowcyName,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndDzien(wykladowcyName,dzien,sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGodz(wykladowcyName,godz,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGodzAndDzien(wykladowcyName,godz,dzien,sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndTydzien(wykladowcyName,tydzien,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndDzien(wykladowcyName,dzien,tydzien,sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndGodz(wykladowcyName,godz,tydzien,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien,sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwa(wykladowcyName, zajeciaNazwa,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, sale);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupy(wykladowcyName, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyGrupAndTydzien(wykladowcyName, tydzien, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupy(wykladowcyName, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndDzien(wykladowcyName,dzien,grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGodz(wykladowcyName,godz, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzien(wykladowcyName, tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupy, sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupy(wykladowcyName, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzien(wykladowcyName, tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else{
                //
                //
                //
                if(sale == null){
                    if(grupy == null){
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrot(wykladowcyName, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndDzien(wykladowcyName,dzien, wykladowcySkrot);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGodz(wykladowcyName,godz, wykladowcySkrot);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGodzAndDzien(wykladowcyName,godz,dzien, wykladowcySkrot);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzien(wykladowcyName, tydzien);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndDzien(wykladowcyName,dzien,tydzien);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndGodz(wykladowcyName,godz,tydzien);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwa(wykladowcyName, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupy(wykladowcyName, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzien(wykladowcyName, tydzien);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndTydzienAndGodz(wykladowcyName,godz,tydzien);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupy(wykladowcyName, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndDzien(wykladowcyName,dzien,grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGodz(wykladowcyName,godz, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzien(wykladowcyName, tydzien, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupy);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupy);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupy(wykladowcyName, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzien(wykladowcyName, tydzien, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, grupy);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, grupy);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else{
                    if(grupy == null){
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSale(wykladowcyName,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndDzien(wykladowcyName,dzien,sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGodz(wykladowcyName,godz,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGodzAndDzien(wykladowcyName,godz,dzien,sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzien(wykladowcyName,tydzien,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndDzien(wykladowcyName,dzien,tydzien,sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndGodz(wykladowcyName,godz,tydzien,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien,sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwa(wykladowcyName, zajeciaNazwa,sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, sale);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupy(wykladowcyName, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyGrupAndTydzien(wykladowcyName, tydzien, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, sale);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(grupaGrupy == null){
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupy(wykladowcyName, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndDzien(wykladowcyName,dzien,grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGodz(wykladowcyName,godz, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzien(wykladowcyName, tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupy, sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupy, sale);
                                        }
                                    }
                                }
                            }
                        }else{
                            if(zajeciaNazwa == null){
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupy(wykladowcyName, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndDzien(wykladowcyName,dzien, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodz(wykladowcyName,godz, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndGodzAndDzien(wykladowcyName,godz,dzien, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzien(wykladowcyName, tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndDzien(wykladowcyName,dzien,tydzien, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodz(wykladowcyName,godz,tydzien, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }
                            }else{
                                if(tydzien == null){
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwa(wykladowcyName, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndDzien(wykladowcyName,dzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodz(wykladowcyName,godz, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndGodzAndDzien(wykladowcyName,godz,dzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }else{
                                    if(godz == null){
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzien(wykladowcyName, tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndDzien(wykladowcyName,dzien,tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }else{
                                        if(dzien == null){
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodz(wykladowcyName,godz,tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }else{
                                            return planService.getPlanByWykladowcyNazwiskoAndWykladowcySkrotAndSaleAndGrupyAndGrupaGrupyAndZajeciaNazwaAndTydzienAndGodzAndDzien(wykladowcyName,godz,dzien, tydzien, zajeciaNazwa, grupaGrupy, grupy, sale);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //
                //
                //
            }


        }else{




            if(wykladowcySkrot != null && sale == null && grupy == null &&
                    grupaGrupy == null && zajeciaNazwa == null &&
                    tydzien == null && godz == null && dzien == null){
                return planService.getPlanByWykladowcySkrot(wykladowcySkrot);
            }else{
                if(sale != null && grupy == null && grupaGrupy == null &&
                        zajeciaNazwa == null && tydzien == null &&
                        godz == null && dzien == null){
                    return planService.getPlanBySale(sale);
                }else{
                    if(grupy != null && grupaGrupy == null && zajeciaNazwa == null &&
                            tydzien == null && godz == null && dzien == null){
                        return planService.getPlanByGrupyGrupGrupy(grupy);
                    }else{
                        if(grupaGrupy != null && zajeciaNazwa == null &&
                                tydzien == null && godz == null && dzien == null){
                            return planService.getPlanByGrupyGrup(grupaGrupy);
                        }else{
                            if(zajeciaNazwa != null && tydzien == null &&
                                    godz == null && dzien == null){
                                return planService.getPlanByZajeciaNazwa(zajeciaNazwa);
                            }else{
                                if (tydzien != null && godz == null && dzien == null) {
                                    return planService.getPlanByTydzien(tydzien);
                                }else{
                                    if (godz != null && dzien == null) {
                                        return planService.getPlanByGodz(godz);
                                    }else{
                                        if (dzien != null) {
                                            return planService.getPlanByDzien(dzien);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;

    }

}
