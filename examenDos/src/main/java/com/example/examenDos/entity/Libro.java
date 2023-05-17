package com.example.examenDos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;
    private String titulo;
    private String descripcion;
    private Long paginas;
    private String edicion;

    @ManyToOne
    @JoinColumn(name="idAutor", nullable=false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name="idEditorial", nullable=false)
    private Editorial editorial;
}
