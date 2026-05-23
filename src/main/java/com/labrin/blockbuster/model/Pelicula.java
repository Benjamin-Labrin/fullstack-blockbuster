package com.labrin.blockbuster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Peliculas")

public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String titulo;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "productora_id", nullable = false)
    private Productora productora;

    @NotNull
    private Integer fechaEstreno;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

}
