package org.example.mongorestapi.repository;

import org.example.mongorestapi.collection.Forms;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormsRepository extends MongoRepository<Forms, String> {
}
