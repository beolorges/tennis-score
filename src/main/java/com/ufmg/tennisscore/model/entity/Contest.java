package com.ufmg.tennisscore.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(name = "Competicao")
public class Contest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "final")
    private SportEvent endGame;
}
