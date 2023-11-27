package com.zawisza.planZajec.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@NoArgsConstructor

public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
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


    public Plan(String tydzien, String godz, String dzien, GrupyGrup grupyGrup,
                Sale sale, Wykladowcy wykladowcy, Zajecia zajecia) {
        this.tydzien = tydzien;
        this.godz = godz;
        this.dzien = dzien;
        this.grupyGrup = grupyGrup;
        this.sale = sale;
        this.wykladowcy = wykladowcy;
        this.zajecia = zajecia;
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
