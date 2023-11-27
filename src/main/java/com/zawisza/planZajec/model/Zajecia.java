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
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private int id;

    private String nazwa;

    @OneToMany(
            mappedBy = "zajecia",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Plan> planList;

    public Zajecia(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Zajecia{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
