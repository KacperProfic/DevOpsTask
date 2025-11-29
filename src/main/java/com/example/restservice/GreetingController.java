package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private final GreetingRepository repository;

    @Autowired
    public GreetingController(GreetingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "World") String name) {
        Greeting greeting = new Greeting("Hello, " + name + "!");
        Greeting saved = repository.save(greeting);
        return new Greeting(saved.getId(), saved.getContent());
    }
}
