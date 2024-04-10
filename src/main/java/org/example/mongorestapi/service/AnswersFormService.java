package org.example.mongorestapi.service;

import org.example.mongorestapi.collection.AnswersForm;
import org.example.mongorestapi.dto.master.AnswersFormDto;

import java.util.List;

public interface AnswersFormService {

    void addAnswer(String id, AnswersForm answersForm);
    List<AnswersFormDto> getAnswer(String id);
}
