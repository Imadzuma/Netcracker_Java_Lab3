package model.task2;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@NoArgsConstructor
@Setter
public class People {
    private List<Integer> values = new ArrayList<Integer>();
    private Set<Person> peopleSet = new HashSet<Person>();
    private Map<Person, Integer> peopleMap = new HashMap<Person, Integer>();

    @Override
    public String toString() {
        return "People{" +
                "values=" + values +
                "\n\t\tpeopleSet=" + peopleSet +
                "\n\t\tpeopleMap=" + peopleMap +
                '}';
    }
}
