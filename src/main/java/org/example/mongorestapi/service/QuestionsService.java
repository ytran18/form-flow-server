package org.example.mongorestapi.service;

import org.example.mongorestapi.collection.Questions;
import org.example.mongorestapi.dto.master.QuestionsDto;

import java.util.List;

public interface QuestionsService {

    Object getQuestionsById(String id); // get question with form id
    void addQuestions(List<Questions> questions); // add many question at the same time
    void deleteQuestions(List<QuestionsDto> questions, String id); // delete many question at the same time
    void updateQuestions(List<Questions> questions, String id); // update many question at the same time

}
