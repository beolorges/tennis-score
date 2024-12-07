package com.ufmg.tennisscore.model.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(name = "Estadio")
public class Stadium implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "cep")
    private String zipCode;

    @Column(name = "nome")
    private String name;

    @Column(name = "capacidade")
    private int capacity;

    @Nullable
    @Column(name = "site")
    private String siteUrl;

}
