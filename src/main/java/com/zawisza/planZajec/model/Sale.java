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
public class Sale {

    @Id
    private int id;

    private String sala;

    private int id_strony;

    private static int id_count = 1;

    @OneToMany(
            mappedBy = "sale",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Plan> planList;

    public Sale(String sala, int id_strony) {
        id = id_count++;
        this.sala = sala;
        this.id_strony = id_strony;
    }

    public Sale(int id, String sala, int id_strony) {
        this.id = id;
        this.sala = sala;
        this.id_strony = id_strony;
    }

    public static void reset(){
        id_count = 1;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", sala='" + sala + '\'' +
                '}';
    }
}
