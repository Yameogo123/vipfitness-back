package vip.fitnessback.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="membre")
@Data
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nom")
    private String nom;

    @Column(name="telephone")
    private String telephone;

    @Column(name="mail")
    private String mail;

    @Column(name="fin")
    private LocalDate FinInscription;

    @Column(name = "confirmation")
    private boolean confirmation;

    @Column(name="nbre")
    private int nbre;

    @Column(name="qrcode")
    private String qrcode;

    public void increase(){
        this.nbre+=1;
    }
}
