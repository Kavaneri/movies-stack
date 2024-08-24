package com.vaca.roger.peliculas;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRespositorio extends MongoRepository<Review, ObjectId>{
}
