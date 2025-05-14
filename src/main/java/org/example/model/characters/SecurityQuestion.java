package org.example.model.characters;

public enum SecurityQuestion {
    Q1("In what city did you attend elementary school?"),
    Q2("What was the name of your first teacher?"),
    Q3("What is the name of your childhood best friend?"),
    Q4("What was the make or model of your first vehicle?"),
    Q5("What street did you live on when you were ten years old?");

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