package org.example.mongorestapi.service.impl;

import org.bson.Document;
import org.example.mongorestapi.collection.AnswersForm;
import org.example.mongorestapi.dto.master.AnswersFormDto;
import org.example.mongorestapi.dto.master.QuestionsDto;
import org.example.mongorestapi.repository.AnswersFormRepository;
import org.example.mongorestapi.service.AnswersFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswersServiceImpl implements AnswersFormService {

    @Autowired
    private AnswersFormRepository answersFormRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void addAnswer(String id, AnswersForm answersForm) {
        answersFormRepository.save(answersForm);
    };

    @Override
    public List<AnswersFormDto> getAnswer(String formId) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("formId").is(formId)),
                Aggregation.project()
                        .andExpression("dateToString('%Y-%m-%d', toDate(multiply(toInt('$modified_at'), 1000)))").as("date")
                        .and("$$ROOT").as("document"),
                Aggregation.group("date").push("document").as("documents")
        );

        AggregationResults<AnswersFormDto> result = mongoTemplate.aggregate(aggregation, "answers", AnswersFormDto.class);
        return result.getMappedResults();
    }

}
