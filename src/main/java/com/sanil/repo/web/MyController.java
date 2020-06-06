package com.sanil.repo.web;

import com.sanil.model.User;
import com.sanil.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    UserRepository userRepo;

    @PostMapping("/save-user")
    public String save(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping("/update-user")
    public User update(@RequestBody User user) {
        return userRepo.update(user);
    }

    @GetMapping("/get-users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/get-user/{id}")
    public List<User> getUserById(@PathVariable Integer id) {
        return userRepo.findById(id);
    }

    @DeleteMapping("delete-user/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userRepo.delete(id);
        return "deleted user with id "+id;
    }
}
