package com.vaca.roger.peliculas;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
 * Interfaz que se encarga de hablar con la base de datos
 * 
 * Esta es la tercer capa
 */
@Repository
public interface PeliculaRepositorio extends MongoRepository<Pelicula, ObjectId>{

    //Buscar por el imdbId
    Optional<Pelicula> findByImdbId(String ImdbId);

}