package org.example.mongorestapi.repository;

import org.example.mongorestapi.collection.AnswersForm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswersFormRepository extends MongoRepository<AnswersForm, String> {
}
