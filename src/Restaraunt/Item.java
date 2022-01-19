package Restaraunt;

import lombok.*;

@Getter @Setter
public class Item {
    private String description;
    private String name;
    private double price;

    public enum Category {
        BEVERAGES,
        SIDES,
        ENTREES,
        ALCOHOL,
        DESSERTS
    }

    public Item(String description, String name, double price) {
        this.description = description;
        this.name = name;
        this.price = price;
    }
}
