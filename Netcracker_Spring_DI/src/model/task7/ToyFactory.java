package model.task7;

public class ToyFactory {
    public Toy getToyFromFactory() {
        System.out.println("/t-->ToyFactory.getToyFromFactory");
        return Toy.builder().type("Constructor").name("Lego").build();
    }
}
