package JavaSE8.Generics;

import JavaSE8.Generics.Models.Building;
import JavaSE8.Generics.Models.Office;

import java.util.ArrayList;
import java.util.List;

/**
 * ListsAndMethods.Substitution Principle
 *
 * States that if you have a variable of a given type,
 * you can assign it to a value that is a subtype of the Building type
 *
 * By default, this does not apply to list types
 */

public class Substitution {
    public static void main(String[] args) {
        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building());
        buildings.add(new Office());
        printBuildings(buildings);

        // Will not work because of typing
        List<Office> offices = new ArrayList<>();
        offices.add(new Office());
        offices.add(new Office());
        // printBuildings(offices);
    }

    public static void printBuildings(List<Building> buildings) {
        buildings
                .forEach(System.out::println);
    }
}