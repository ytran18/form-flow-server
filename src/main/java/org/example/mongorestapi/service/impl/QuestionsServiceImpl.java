package org.example.mongorestapi.service.impl;

import org.example.mongorestapi.collection.Questions;
import org.example.mongorestapi.dto.master.QuestionsDto;
import org.example.mongorestapi.repository.QuestionsRepository;
import org.example.mongorestapi.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    private List<Questions> getQuestionsByCriteria(Criteria criteria) {
        MatchOperation matchOperation = Aggregation.match(criteria);
        Aggregation aggregation = Aggregation.newAggregation(matchOperation);
        AggregationResults<Questions> aggregationResults = mongoTemplate.aggregate(aggregation, "questions", Questions.class);
        return aggregationResults.getMappedResults();
    }

    @Override
    public Object getQuestionsById(String id) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("formId").is(id))
        );

        AggregationResults<Questions> questions = mongoTemplate.aggregate(aggregation, "questions", Questions.class);
        return questions.getMappedResults();
    };

    @Override
    public void addQuestions(List<Questions> questions) {
        mongoTemplate.insertAll(questions);
    };

    @Override
    public void deleteQuestions(List<QuestionsDto> questions, String id) {
        Criteria criteria = Criteria.where("formId").is(id);
        List<Questions> existingQuestions = getQuestionsByCriteria(criteria);

        for (Questions existingQuestion : existingQuestions) {
            Optional<QuestionsDto> matchingQuestion = questions.stream()
                    .filter(q -> q.getQuestionId().equals(existingQuestion.get_id()))
                    .findFirst();

            matchingQuestion.ifPresent(value -> questionsRepository.deleteById(value.getQuestionId()));
        };
    };

    @Override
    public void updateQuestions(List<Questions> questions, String id) {
        Criteria criteria = Criteria.where("formId").is(id);
        List<Questions> existingQuestions = getQuestionsByCriteria(criteria);

        for (Questions existingQuestion : existingQuestions) {
            Optional<Questions> matchingQuestion = questions.stream()
                    .filter(q -> q.get_id().equals(existingQuestion.get_id()))
                    .findFirst();

            matchingQuestion.ifPresent(value -> mongoTemplate.save(value));
        };
    };

}
