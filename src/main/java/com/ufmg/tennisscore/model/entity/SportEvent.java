package com.ufmg.tennisscore.model.entity;

import com.ufmg.tennisscore.model.enums.EventPhase;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "EventoEsportivo")
public class SportEvent implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Nullable
    @Column(name = "data")
    private LocalDateTime dateTime;

    @Column(name = "fase")
    @Enumerated(EnumType.STRING)
    private EventPhase eventPhase;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "competicao")
    private Contest contest;

    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadio")
    private Stadium stadium;
}
