package org.example.mongorestapi.repository;

import org.example.mongorestapi.collection.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionsRepository extends MongoRepository<Questions, String> {
}
