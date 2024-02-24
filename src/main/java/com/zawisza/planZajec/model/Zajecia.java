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
public class Zajecia {

    @Id
    private int id;

    private String nazwa;

    @OneToMany(
            mappedBy = "zajecia",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Plan> planList;

    private static int id_count = 1;

    public Zajecia(String nazwa) {
        this.id = id_count++;
        this.nazwa = nazwa;
    }

    public Zajecia(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public static void reset(){
        id_count = 1;
    }

    @Override
    public String toString() {
        return "Zajecia{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
