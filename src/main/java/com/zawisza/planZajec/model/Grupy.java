package com.zawisza.planZajec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Grupy {

    @Id
    private int id;

    private String grupa;

    private static int id_count = 1;

    @OneToMany(
            mappedBy = "grupy",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<GrupyGrup> grupyGrupList;

    public Grupy(String grupa) {
        id = id_count++;
        this.grupa = grupa;
    }

    public Grupy(int id, String grupa) {
        this.id = id;
        this.grupa = grupa;
    }

    public static void reset(){
        id_count = 1;
    }

    @Override
    public String toString() {
        return "Grupa{" +
                "id=" + id +
                ", grupa='" + grupa + '\'' +
                '}';
    }
}
