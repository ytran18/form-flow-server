package org.example.mongorestapi.controller;

import org.example.mongorestapi.collection.AnswersForm;
import org.example.mongorestapi.dto.res.ObjectDataResponse;
import org.example.mongorestapi.service.AnswersFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswersFormController {

    @Autowired
    private AnswersFormService answersFormService;

    @PostMapping
    public ResponseEntity<ObjectDataResponse> addForm(@RequestBody AnswersForm answersForm, String id) {
        answersFormService.addAnswer(id, answersForm);
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Add answer successfully!",
                        true,
                        null
                )
        );
    };

    @GetMapping("/{id}")
    public ResponseEntity<ObjectDataResponse> geAnswersById(@PathVariable String id) {
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Get answer successfully!",
                        true,
                        answersFormService.getAnswer(id)
                )
        );
    };

}
