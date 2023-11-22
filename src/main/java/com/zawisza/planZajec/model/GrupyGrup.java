package com.zawisza.planZajec.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GrupyGrup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private int id;

    @Column(name="id_grupy")
    private int idGrupy;

    @ManyToOne
    Grupy grupy;

    @Column(name="grupa_grupy")
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
