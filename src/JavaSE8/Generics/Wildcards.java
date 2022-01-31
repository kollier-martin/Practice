package JavaSE8.Generics;

import JavaSE8.Generics.Models.Building;
import JavaSE8.Generics.Models.House;
import JavaSE8.Generics.Models.Office;

import java.util.ArrayList;
import java.util.List;

/**
 * Wildcards
 *
 * ? is a wildcard that indicates any Object
 * Don't rely on wildcards, as they can make code confusing
 *
 * '? extends Building' indicates any type that extends from the Building type
 * Using extends or super after '?' is dependent on is the arg is invariable or outvariable
 *
 * invariable means that you are passing in something that provides data to be used inside the method
 * outvariable means that you are giving additional data
 */

public class Wildcards {
    public static void main(String[] args) {
        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building());
        buildings.add(new Office());
        printBuildings(buildings);

        List<Office> offices = new ArrayList<>();
        offices.add(new Office());
        offices.add(new Office());
        printBuildings(offices);

        List<House> houses = new ArrayList<>();
        houses.add(new House());

        addHouseToList(houses);
        addHouseToList(buildings);
    }

    public static void printBuildings(List<? extends Building> buildings) {
        buildings
                .forEach(System.out::println);
        System.out.println();
    }

    public static void addHouseToList(List<? super House> buildings) {
        buildings.add(new House());
        System.out.println();
    }
}
