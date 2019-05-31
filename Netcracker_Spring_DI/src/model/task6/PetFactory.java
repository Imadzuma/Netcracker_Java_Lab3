package model.task6;

public class PetFactory {
    public Pet getPetFromFactory() {
        System.out.println("\t-->PetFactory.getPetFromFactory");
        return Pet.builder().type("Dog").name("Chappi").build();
    }
}
