package com.example.examenDos.controller;

import com.example.examenDos.dto.LibroRequest;
import com.example.examenDos.entity.Autor;
import com.example.examenDos.entity.Editorial;
import com.example.examenDos.entity.Libro;
import com.example.examenDos.repository.AutorRepository;
import com.example.examenDos.repository.EditorialRepository;
import com.example.examenDos.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EditorialRepository editorialRepository;

    @QueryMapping
    public List<Libro> listarLibro(){
        return libroRepository.findAll();
    }

    @QueryMapping
    public Libro listarLibroPorId(@Argument int id) {
        return libroRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Libro guardarLibro(@Argument LibroRequest libroRequest) {
        Autor autor = autorRepository.findById(libroRequest.autorId()).orElse(null);
        Editorial editorial = editorialRepository.findById(libroRequest.editorialId()).orElse(null);
        Libro libroBD = new Libro();

        libroBD.setTitulo(libroRequest.titulo());
        libroBD.setDescripcion(libroRequest.descripcion());
        libroBD.setPaginas(libroRequest.paginas());
        libroBD.setEdicion(libroRequest.edicion());
        libroBD.setAutor(autor);
        libroBD.setEditorial(editorial);

        return libroRepository.save(libroBD);
    }

    @MutationMapping
    public Libro actualizarLibro(@Argument int id ,@Argument LibroRequest libroRequest) {
        Autor autor = autorRepository.findById(libroRequest.autorId()).orElse(null);
        Editorial editorial = editorialRepository.findById(libroRequest.editorialId()).orElse(null);
        Libro libroBD = new Libro();

        libroBD.setIdLibro(id);
        libroBD.setTitulo(libroRequest.titulo());
        libroBD.setDescripcion(libroRequest.descripcion());
        libroBD.setPaginas(libroRequest.paginas());
        libroBD.setEdicion(libroRequest.edicion());
        libroBD.setAutor(autor);
        libroBD.setEditorial(editorial);

        return libroRepository.save(libroBD);
    }

    @MutationMapping
    public void eliminarLibro(@Argument int id) {
        libroRepository.deleteById(id);
    }
}
