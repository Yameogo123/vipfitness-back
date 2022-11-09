package vip.fitnessback.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="message")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nom")
    private String nom;

    @Column(name="telephone")
    private String telephone;

    @Column(name="message")
    private String message;
}
