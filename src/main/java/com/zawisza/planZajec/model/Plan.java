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
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private int id;

    private int id_grupy;
    private int id_grupy_grupy;
    private int id_sale;
    private int id_wykladowcy;
    private int id_zajecia;

    public Plan(int id_grupy, int id_grupy_grupy, int id_sale, int id_wykladowcy, int id_zajecia) {
        this.id_grupy = id_grupy;
        this.id_grupy_grupy = id_grupy_grupy;
        this.id_sale = id_sale;
        this.id_wykladowcy = id_wykladowcy;
        this.id_zajecia = id_zajecia;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", id_grupy=" + id_grupy +
                ", id_grupy_grupy=" + id_grupy_grupy +
                ", id_sale=" + id_sale +
                ", id_wykladowcy=" + id_wykladowcy +
                ", id_zajecia=" + id_zajecia +
                '}';
    }
}
