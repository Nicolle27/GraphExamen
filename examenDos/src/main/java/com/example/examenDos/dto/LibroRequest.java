package com.example.examenDos.dto;

public record LibroRequest(
        Integer id,
        String titulo,
        String descripcion,
        Long paginas,
        String edicion,
        int autorId,
        int editorialId
) {
}
