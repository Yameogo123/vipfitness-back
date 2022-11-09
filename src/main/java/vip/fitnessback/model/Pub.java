package vip.fitnessback.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="pub")
@Data
public class Pub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="pub")
    private String pub;

    @Column(name="lien")
    private String lien;
}
