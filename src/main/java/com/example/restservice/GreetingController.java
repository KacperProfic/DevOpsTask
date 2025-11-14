package com.example.restservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private final JpaRepository<Greeting, Long> repository;

    public GreetingController(JpaRepository<Greeting, Long> repository) {
        this.repository = repository;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "World") String name) {
        Greeting greeting = new Greeting("Hello, " + name + "!");
        Greeting saved = repository.save(greeting);
        return new Greeting(saved.getId(), saved.getContent());
    }
}
