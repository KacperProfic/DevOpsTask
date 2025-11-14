package com.example.restservice;

import jakarta.persistence.*;

@Entity
@Table(name = "greetings")
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    // Konstruktor domyślny (dla JPA)
    public Greeting() {}

    // Konstruktor z treścią (do zapisu)
    public Greeting(String content) {
        this.content = content;
    }

    // KONSTRUKTOR Z ID I CONTENT (DLA ODPOWIEDZI)
    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    // Gettery i settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
