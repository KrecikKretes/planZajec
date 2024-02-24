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
public class GrupyGrup {

    @Id
    private int id;

    @Column(name="grupa_grupy")
    private String grupaGrupy;

    @ManyToOne
    @JoinColumn(name="grupy_id")
    private Grupy grupy;

    @OneToMany(
            mappedBy = "grupyGrup",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Plan> planList;

    private static int id_count = 1;

    public GrupyGrup(String grupaGrupy, Grupy grupy) {
        id = id_count++;
        this.grupaGrupy = grupaGrupy;
        this.grupy = grupy;
    }

    public GrupyGrup(int id, String grupaGrupy, Grupy grupy) {
        this.id = id;
        this.grupaGrupy = grupaGrupy;
        this.grupy = grupy;
    }

    public static void reset(){
        id_count = 1;
    }

    @Override
    public String toString() {
        return "GrupyGrup{" +
                "id=" + id +
                ", grupy=" + grupy +
                ", grupaGrupy='" + grupaGrupy + '\'' +
                '}';
    }
}
