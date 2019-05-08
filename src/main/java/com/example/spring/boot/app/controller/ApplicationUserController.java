package com.example.spring.boot.app.controller;

import com.example.spring.boot.app.entity.ApplicationUser;
import com.example.spring.boot.app.repository.ApplicationUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicationUserController {

    private final ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUserController(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @GetMapping
    public List<ApplicationUser> getApplicationUsers() {
        return (List<ApplicationUser>) applicationUserRepository.findAll();
    }

    @PostMapping("/sign-up")
    public void singUp(@RequestBody ApplicationUser applicationUser) {
        applicationUser.setPassword((bCryptPasswordEncoder.encode(applicationUser.getPassword())));
        applicationUserRepository.save(applicationUser);
    }
}
