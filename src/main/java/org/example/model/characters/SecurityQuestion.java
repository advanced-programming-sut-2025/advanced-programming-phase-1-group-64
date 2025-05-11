package org.example.model.characters;

public enum SecurityQuestion {
    Q1(""),
    Q2(""),
    Q3(""),
    Q4(""),
    Q5("");

    private final String question;

    SecurityQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
}