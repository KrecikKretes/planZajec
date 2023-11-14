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

    public Wykladowcy(String nazwisko, String skrot) {
        this.nazwisko = nazwisko;
        this.skrot = skrot;
    }

    @Override
    public String toString() {
        return "Wykladowcy{" +
                "id=" + id +
                ", nazwisko='" + nazwisko + '\'' +
                ", skrot='" + skrot + '\'' +
                '}';
    }
}
