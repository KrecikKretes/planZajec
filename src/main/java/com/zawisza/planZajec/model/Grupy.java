package com.zawisza.planZajec.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Grupy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private int id;

    private String grupa;

    @OneToMany(mappedBy = "id_grupy")
    List<GrupyGrup> grupyGrupList;

    public Grupy(String grupa) {
        this.grupa = grupa;
    }


    @Override
    public String toString() {
        return "Grupa{" +
                "id=" + id +
                ", grupa='" + grupa + '\'' +
                '}';
    }
}
