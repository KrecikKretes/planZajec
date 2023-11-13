package com.zawisza.planZajec.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Grupy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idGrupy;

    private String grupa;

    @OneToMany
    @JoinColumn(name="idGrupy", nullable=false)
    private Set<GrupyGrup> grupyGrupSet;

    public Grupy(String grupa) {
        this.grupa = grupa;
    }


    @Override
    public String toString() {
        return "Grupa{" +
                "id=" + idGrupy +
                ", grupa='" + grupa + '\'' +
                '}';
    }
}
