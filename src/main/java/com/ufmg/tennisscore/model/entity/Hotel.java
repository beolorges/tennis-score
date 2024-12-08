package com.ufmg.tennisscore.model.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "Hotel")
public class Stadium implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "cep")
    private String zipCode;

    @Column(name = "nome")
    protected String name;

    @Column(name = "capacidade")
    private int capacity;

    @Column(name = "estrelas")
    private int starRating;

    @Nullable
    @Column(name = "site")
    private String siteUrl;

}
