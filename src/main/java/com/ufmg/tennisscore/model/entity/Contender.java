package com.ufmg.tennisscore.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Competidor")
public class Contender implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_nascimento")
    private LocalDate birthDay;

    @OneToMany(mappedBy = "winner", fetch = FetchType.LAZY)
    private List<Award> awards;
}
