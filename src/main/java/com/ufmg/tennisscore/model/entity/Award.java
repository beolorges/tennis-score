package com.ufmg.tennisscore.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "Premiacao")
public class Award implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne
    @JoinColumn(name = "competicao")
    private Contest contest;

    @OneToOne
    @JoinColumn(name = "evento_esportiov")
    private SportEvent sportEvent;

    @Column(name = "valor")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "vencedor")
    private Contender winner;
}
