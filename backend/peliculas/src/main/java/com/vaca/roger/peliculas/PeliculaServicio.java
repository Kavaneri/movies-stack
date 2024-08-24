package com.vaca.roger.peliculas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Clase que trabaja sobre los datos obtenidos por el repositorio.
 * 
 * Aqui se va a encontrar toda la logica del negocio
 * Esta es la segunda capa
*/
@Service
public class PeliculaServicio {

    @Autowired //instancia el objeto por nosotros
    private PeliculaRepositorio peliculaRepositorio;

    public List<Pelicula> todaPelicula(){
        return peliculaRepositorio.findAll();
    }

    /*
     * Optional se utiliza para declarar la posiblidad de
     * que no se pueda encontrar el objeto que está buscando
     */
    public Optional<Pelicula> peliculaId(String imdbId){
        return peliculaRepositorio.findByImdbId(imdbId);
    }
}
