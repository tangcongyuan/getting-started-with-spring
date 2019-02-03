package com.erictang.gettingstartedwithspring;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {

    /*
        Lombok will generate all missing methods(equals(),
        hashCode(), toString()) as well as constructor that
        accepts all final properties as arguments.
    */
    private final String id;    // Otherwise, final fields will need to be initialized at definition.
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
