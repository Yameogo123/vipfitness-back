package vip.fitnessback.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Base64;

@Entity
@Table(name="coach")
@Data
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nom")
    private String nom;

    @Column(name="telephone")
    private String telephone;

    @Column(name="role")
    private String role;

    @Column(name="file", length = 1000)
    private String file;

    @Column(name="facebook")
    private String facebook;

    @Column(name="instagram")
    private String instagram;

    @Column(name="active")
    private boolean active;
}













