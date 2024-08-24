package com.vaca.roger.peliculas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewServicio {

    @Autowired
    private ReviewRespositorio reviewRespositorio;

    /*
     * Otra forma de acceder a la base de datos sin la necesidad
     * de usar un repositorio es usando templates.
     * 
     * Se utilizan en caso de que la logica sea muy complicada
     * y al repositorio simplemente no le de
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRespositorio.insert(new Review(reviewBody));  // crear y guardar una reseña nueva 
       

        mongoTemplate.update(Pelicula.class) //Debemos actualizar la clase Pelicula
                //Actualizamos la pelicula suyo imdbId sea igual al imdbId de la reseña
                .matching(Criteria.where("imdbId").is(imdbId))
                //Aplicamos los cambios en la base de datos
                .apply(new Update().push("reviewIds").value(review))
                .first(); //Asegurandonos que solo se actualice una

        return review;
    }
}
