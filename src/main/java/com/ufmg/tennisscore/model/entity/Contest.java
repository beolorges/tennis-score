package com.ufmg.tennisscore.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Builder
@Table(name = "Competicao")
public class Contest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome")
    private String name;

}
