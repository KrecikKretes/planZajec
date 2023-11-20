package com.zawisza.planZajec;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Constant {

    private String line;
    private String zajeciaName = "";
    private String salaName = "";
    private String wykladowcyName = "";
    private String grupaGrupyName = "";
    private char tydzien = 0;

    public void substring(){
        line = line.substring(line.indexOf(" "));
        line = line.trim();
    }

    public void reset() {
        this.zajeciaName = "";
        this.salaName = "";
        this.wykladowcyName = "";
        this.grupaGrupyName = "";
        this.tydzien = 0;
    }
}
