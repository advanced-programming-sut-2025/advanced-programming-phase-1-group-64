package org.example.model.characters;

public enum SecurityQuestion {
    Q1("aaa"),
    Q2("bbb"),
    Q3("ccc"),
    Q4("ddd"),
    Q5("eee");

    private final String question;

    SecurityQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public static SecurityQuestion getQuestion(String question) {
        return switch (question){
            case "1" -> SecurityQuestion.Q1;
            case "2" -> SecurityQuestion.Q2;
            case "3" -> SecurityQuestion.Q3;
            case "4" -> SecurityQuestion.Q4;
            case "5" -> SecurityQuestion.Q5;
            default -> null;
        };
    }
}