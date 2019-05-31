package model.task6;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
public class Pet {
    private String name;
    private String type;

    private static final Pet myCat =  Pet.builder().type("Cat").name("Boris").build();
    public static Pet getPetFromFactory() {
        System.out.println("\t-->Pet.getPetFromFactory");
        return myCat;
    }
}
