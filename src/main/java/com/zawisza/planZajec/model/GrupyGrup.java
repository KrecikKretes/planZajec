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
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
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

    public GrupyGrup(String grupaGrupy, Grupy grupy) {
        this.grupaGrupy = grupaGrupy;
        this.grupy = grupy;
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
