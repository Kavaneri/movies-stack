package com.vaca.roger.peliculas;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Document(collection="peliculas") //necesario para que lo trabaje mongdb
@Data //getters y setters proporcionados por lombok
@AllArgsConstructor //constructor tomando todos los atributos proporcionado por lombok
@NoArgsConstructor //constructor por defecto
public class Pelicula {

    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String>genres;
    private List<String> backdrops;

    @DocumentReference //guarda solo las id de los objetos, creando una colección aparte
    private List<Review> reviewIds;//Relacion uno a muchos de toda la vida
}
