package StrdewValley.Models.Animals;

public enum AnimalType {
    HEN(new Animal("Hen", 80, true));
    //TODO

    private final Animal animal;

    AnimalType(Animal animal) {
        this.animal = animal;
    }
}
