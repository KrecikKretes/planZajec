package com.zawisza.planZajec.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Search {

    private List<String> wykladowcyName;
    private List<String> wykladowcySkrot;
    private List<String> sale;
    private List<String> grupy;
    private char tydzien;
    private String dzien;
    private String godzina;
}
