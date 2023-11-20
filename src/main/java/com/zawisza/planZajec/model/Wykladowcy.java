package com.zawisza.planZajec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Wykladowcy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private int id;

    private String nazwisko;

    private String skrot;
    private int id_strony;

    public Wykladowcy(String nazwisko, String skrot, int id_strony) {
        this.nazwisko = nazwisko;
        this.skrot = skrot;
        this.id_strony = id_strony;
    }

    @Override
    public String toString() {
        return "Wykladowcy{" +
                "id=" + id +
                ", nazwisko='" + nazwisko + '\'' +
                ", skrot='" + skrot + '\'' +
                ", id_strony=" + id_strony +
                '}';
    }
}
