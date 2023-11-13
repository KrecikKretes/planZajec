package com.zawisza.planZajec.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GrupyGrup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private int idGrupy;
    private String grupaGrupy;

    public GrupyGrup(int idGrupy, String grupaGrupy) {
        this.idGrupy = idGrupy;
        this.grupaGrupy = grupaGrupy;
    }

    @Override
    public String toString() {
        return "GrupyGrup{" +
                "id=" + id +
                ", grupy=" + idGrupy +
                ", grupaGrupy='" + grupaGrupy + '\'' +
                '}';
    }
}
