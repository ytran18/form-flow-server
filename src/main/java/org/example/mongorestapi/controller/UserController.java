package org.example.mongorestapi.controller;

import jakarta.validation.Valid;
import org.example.mongorestapi.collection.User;
import org.example.mongorestapi.dto.auth.LoginDto;
import org.example.mongorestapi.dto.res.ObjectDataResponse;
import org.example.mongorestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // sign up
    @PostMapping
    public ResponseEntity<ObjectDataResponse> addUser(@Valid @RequestBody User user) throws Exception {
        userService.addUser(user);
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Add user successfully!",
                        true,
                        null
                )
        );
    };

    // check email before login
    @GetMapping("/email/check")
    public ResponseEntity<ObjectDataResponse> checkEmail(@RequestParam String email) throws Exception {
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Successful!",
                        true,
                        userService.validEmail(email)
                )
        );
    }

    // login
    @GetMapping("/login")
    public ResponseEntity<ObjectDataResponse> login(@RequestBody LoginDto user) throws Exception {
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Login Successfully!",
                        true,
                        userService.login(user)
                )
        );
    };

    @GetMapping
    public ResponseEntity<ObjectDataResponse> getUsers() {
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Get users successfully!",
                        true,
                        userService.getUsers()
                )
        );
    };

    @GetMapping("/{id}")
    public ResponseEntity<ObjectDataResponse> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Get user successfully!",
                        true,
                        userService.getUserById(id)
                )
        );
    };

    @PutMapping("/{id}")
    public ResponseEntity<ObjectDataResponse> updateUserById(@PathVariable String id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Update user successfully!",
                        true,
                        null
                )
        );
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<ObjectDataResponse> deleteUserById(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(
                new ObjectDataResponse(
                        HttpStatus.OK.value(),
                        "Delete user successfully!",
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
