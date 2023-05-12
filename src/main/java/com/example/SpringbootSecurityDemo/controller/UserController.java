package com.example.SpringbootSecurityDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class UserController {
    @GetMapping("/normal")
    public ResponseEntity<String> normalUser()
    {
        return ResponseEntity.ok("Yes, I am a normal user");
    }
    @GetMapping("/admin")
    public ResponseEntity<String> adminUser()
    {
        return ResponseEntity.ok("Yes, I am admin");
    }

}
