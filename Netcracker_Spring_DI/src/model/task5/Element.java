package model.task5;

import lombok.*;

@NoArgsConstructor
@Setter
@ToString
public class Element {
    private String name = "";
    private SimpleElement simpleElement;

    public Element(SimpleElement simpleElement) {
        this.simpleElement = simpleElement;
    }
}
