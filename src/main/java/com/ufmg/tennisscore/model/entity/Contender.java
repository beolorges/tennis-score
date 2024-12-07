package com.ufmg.tennisscore.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Competidor")
@Data
public class Contender implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_nascimento")
    private LocalDate birthDay;

    @OneToMany(mappedBy = "winner")
    private List<Award> awards;
}
