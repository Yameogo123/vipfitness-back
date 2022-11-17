package vip.fitnessback.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name="budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name="montant")
    private int montant;

    @Column(name="nom")
    private String nom;


}
