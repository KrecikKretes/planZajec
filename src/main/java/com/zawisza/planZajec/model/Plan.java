package com.zawisza.planZajec.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor

public class Plan {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name="id_zajecia")
    private Zajecia zajecia;

    @ManyToOne
    @JoinColumn(name="id_grupy_grup")
    private GrupyGrup grupyGrup;

    @ManyToOne
    @JoinColumn(name="id_wykladowcy")
    private Wykladowcy wykladowcy;

    @ManyToOne
    @JoinColumn(name="id_sale")
    private Sale sale;

    @Setter
    private String tydzien;
    @Setter
    private String dzien;
    @Setter
    private String godz;

    private static int id_count = 1;

    public static void reset(){
        id_count = 1;
    }

    public Plan(String tydzien, String godz, String dzien, GrupyGrup grupyGrup,
                Sale sale, Wykladowcy wykladowcy, Zajecia zajecia) {
        this.id = id_count++;
        this.tydzien = tydzien;
        this.godz = godz;
        this.dzien = dzien;
        this.grupyGrup = grupyGrup;
        this.sale = sale;
        this.wykladowcy = wykladowcy;
        this.zajecia = zajecia;
    }

    public Plan(int id, String tydzien, String godz, String dzien, GrupyGrup grupyGrup,
                Sale sale, Wykladowcy wykladowcy, Zajecia zajecia) {
        this.id = id;
        this.zajecia = zajecia;
        this.grupyGrup = grupyGrup;
        this.wykladowcy = wykladowcy;
        this.sale = sale;
        this.tydzien = tydzien;
        this.dzien = dzien;
        this.godz = godz;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", zajecia=" + zajecia +
                ", grupyGrup=" + grupyGrup +
                ", wykladowcy=" + wykladowcy +
                ", sale=" + sale +
                ", tydzien=" + tydzien +
                ", dzien='" + dzien + '\'' +
                ", godz='" + godz + '\'' +
                '}';
    }
}
