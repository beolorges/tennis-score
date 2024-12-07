package com.ufmg.tennisscore.model.entity;

import com.ufmg.tennisscore.model.enums.EventPhase;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "EventoEsportivo")
public class SportEvent implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    @Nullable
    @Column(name = "data")
    private LocalDateTime dateTime;

    @Column(name = "fase")
    @Enumerated(EnumType.STRING)
    private EventPhase eventPhase;

    @JoinColumn(name = "competicao")
    private Contest contest;

    @Nullable
    @JoinColumn(name = "estadio")
    private Stadium stadium;
}
