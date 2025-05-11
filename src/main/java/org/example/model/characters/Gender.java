package org.example.model.characters;

public enum Gender {
    MALE,FEMALE;

    public static Gender getGender(String gender){
        return switch (gender){
            case "male" -> Gender.MALE;
            case "female" -> Gender.FEMALE;
            default -> null;
        };
    }
}