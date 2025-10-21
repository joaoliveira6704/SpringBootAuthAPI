package com.joaooliveira.crudProject.controller;

import com.joaooliveira.crudProject.business.UserService;
import com.joaooliveira.crudProject.infrastructure.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return  ResponseEntity.ok().build();
    }

    @GetMapping  // GET /users or GET /users?email=john@example.com
    public ResponseEntity<?> getUsers(@RequestParam(required = false) Integer id){
        if (id != null) {
            return ResponseEntity.ok(userService.getUserById(id));
        }
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // DELETE /users?email=john@example.com
    @DeleteMapping
    public ResponseEntity<Void> deleteUserById(@RequestParam Integer id){
        userService.deleteUserById(id);
        return  ResponseEntity.ok().build();
    }

    // DELETE /users?id=john@example.com
    @PutMapping
    public ResponseEntity<Void> updateUserById(@RequestParam Integer id, @RequestBody User user){
        userService.updateUserById(id, user);
        return ResponseEntity.ok().build();
    }
}
