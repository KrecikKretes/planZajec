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

public class Wykladowcy {

    @Id
    private int id;

    private String nazwisko;

    private String skrot;
    private int id_strony;

    private static int id_count = 1;

    @OneToMany(
            mappedBy = "wykladowcy",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Plan> planList;

    public Wykladowcy(String nazwisko, String skrot, int id_strony) {
        id = id_count++;
        this.nazwisko = nazwisko;
        this.skrot = skrot;
        this.id_strony = id_strony;
    }

    public Wykladowcy(char id, String nazwisko, String skrot, int id_strony) {
        this.id = id;
        this.nazwisko = nazwisko;
        this.skrot = skrot;
        this.id_strony = id_strony;
    }

    public static void reset(){
        id_count = 1;
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
