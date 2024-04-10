package org.example.mongorestapi.controller;

import org.example.mongorestapi.collection.Forms;
import org.example.mongorestapi.dto.res.ObjectDataResponse;
import org.example.mongorestapi.service.FormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forms")
public class FormsController {

    @Autowired
    private FormsService formsService;

    @PostMapping
    public ResponseEntity<ObjectDataResponse> addForm(@RequestBody Forms form) {
        formsService.addForm(form);
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Add form successfully!",
                        true,
                        null
                )
        );
    };

    @PutMapping("/{id}")
    public ResponseEntity<ObjectDataResponse> updateForm(@PathVariable String id, @RequestBody Forms form) {
        formsService.updateForm(id, form);
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Update form successfully!",
                        true,
                        null
                )
        );
    };

    @GetMapping
    public ResponseEntity<ObjectDataResponse> getAllForms() {
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Get forms successfully!",
                        true,
                        formsService.getForms()
                )
        );
    };

    @GetMapping("/{id}")
    public ResponseEntity<ObjectDataResponse> getFormById(@PathVariable String id) {
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Get form successfully!",
                        true,
                        formsService.getFormById(id)
                )
        );
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<ObjectDataResponse> deleteForm(@PathVariable String id) {
        formsService.deleteForm(id);
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Delete form successfully!",
                        true,
                        null
                )
        );
    };

    // rename
    @PutMapping("/rename/{id}")
    public ResponseEntity<ObjectDataResponse> renameForm(@PathVariable String id, @RequestBody String name) {
        formsService.renameForm(id, name);
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Rename successfully!",
                        true,
                        null
                )
        );
    };

    // clone
    @PostMapping("/clone/{id}")
    public ResponseEntity<ObjectDataResponse> cloneForm(@PathVariable String id) {
        formsService.cloneForm(id);
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Clone form successfully!",
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
