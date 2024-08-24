package com.vaca.roger.peliculas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Clase que procesa la petición del cliente pero no tiene conocimiento
 * de como se hace la operación.
 * 
 * Esta es la primera capa
 */
@RestController
@RequestMapping("/api/v1/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaServicio peliculaServicio;

    // Obtener todas las peliculas
    @GetMapping
    public ResponseEntity<List<Pelicula>> getAllMovies() {
        return new ResponseEntity<List<Pelicula>>(peliculaServicio.todaPelicula(), HttpStatus.OK);
    }

    // Obtener una pelicula en especifico
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Pelicula>> getPeliculaId(@PathVariable("imdbId") String imdbId) {
        return new ResponseEntity<Optional<Pelicula>>(peliculaServicio.peliculaId(imdbId), HttpStatus.OK);
    }

}