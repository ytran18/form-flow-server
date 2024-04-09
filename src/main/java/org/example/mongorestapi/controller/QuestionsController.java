package org.example.mongorestapi.controller;

import org.example.mongorestapi.collection.Questions;
import org.example.mongorestapi.dto.master.QuestionsDto;
import org.example.mongorestapi.dto.res.ObjectDataResponse;
import org.example.mongorestapi.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @PostMapping
    public ResponseEntity<ObjectDataResponse> addQuestions(@RequestBody List<Questions> questions) {
        questionsService.addQuestions(questions);
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Add questions successfully!",
                        true,
                        null
                )
        );
    };

    @GetMapping("/{id}")
    public ResponseEntity<ObjectDataResponse> getQuestions(@PathVariable String id) {
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Get questions successfully!",
                        true,
                        questionsService.getQuestionsById(id)
                )
        );
    };

    @PutMapping("/{id}")
    public ResponseEntity<ObjectDataResponse> updateQuestions(@PathVariable String id, @RequestBody List<Questions> questions) {
        questionsService.updateQuestions(questions, id);
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Update questions successfully!",
                        true,
                        null
                )
        );
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<ObjectDataResponse> deleteQuestions(@PathVariable String id, @RequestBody List<QuestionsDto> questions) {
        questionsService.deleteQuestions(questions, id);
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Delete questions successfully!",
                        true,
                        null
                )
        );
    };

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ObjectDataResponse> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ObjectDataResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), false, null));
    };

}
