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
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private int id;

    private String sala;

    public Sale(String sala) {
        this.sala = sala;
    }


    @Override
    public String toString() {
        return "Grupa{" +
                "id=" + id +
                ", sala='" + sala + '\'' +
                '}';
    }
}
