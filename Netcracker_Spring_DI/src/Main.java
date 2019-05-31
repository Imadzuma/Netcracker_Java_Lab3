
import model.task1.Employer;
import model.task2.People;
import model.task3.Message;
import model.task4.Circle;
import model.task5.Element;
import model.task6.Pet;
import model.task6.PetFactory;
import model.task7.ToyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        System.out.println("<-----------------------TASK1------------------------->");
        Employer employer1 = (Employer)context.getBean("CIEmployer");
        Employer employer2 = (Employer)context.getBean("SIEmployer");
        System.out.println("\tCI: " + employer1);
        System.out.println("\tSI: " + employer2);
        System.out.println();

        System.out.println("<-----------------------TASK2------------------------->");
        People people = (People)context.getBean("People");
        System.out.println("\tPeople: " + people);
        System.out.println();

        System.out.println("<-----------------------TASK3------------------------->");
        Message parent = (Message)context.getBean("Parent");
        Message child = (Message)context.getBean("Child");
        System.out.println("\tParent: "+ parent);
        System.out.println("\tChild: " + child);
        System.out.println();

        System.out.println("<-----------------------TASK4------------------------->");
        Circle circle = (Circle)context.getBean("Circle");
        System.out.println("\tCircle: " + circle);
        System.out.println();

        System.out.println("<-----------------------TASK5------------------------->");
        Element withoutAutowiring = (Element)context.getBean("ElementWithoutAutowiring");
        Element byName = (Element)context.getBean("ElementByName");
        Element byType = (Element)context.getBean("ElementByType");
        Element constructor = (Element)context.getBean("ElementConstructor");
        System.out.println("\tWothoutAutowiring: " + withoutAutowiring);
        System.out.println("\tByName: " + byName);
        System.out.println("\tByType: " + byType);
        System.out.println("\tConstructor: " + constructor);
        System.out.println();

        System.out.println("<-----------------------TASK6------------------------->");
        Pet myCat = (Pet)context.getBean("PetFromFactory1");
        Pet myDog = (Pet)context.getBean("PetFromFactory2");
        System.out.println("\tFromFactoryMethod: " + myCat);
        System.out.println("\tFromFactoryBean: " + myDog);
        System.out.println();

        System.out.println("<-----------------------TASK7------------------------->");
        ToyFactory toyFactory = (ToyFactory)context.getBean("LookupToy");
        System.out.println("\tFrom lookupFactory: " +   toyFactory.getToyFromFactory());
    }
}
