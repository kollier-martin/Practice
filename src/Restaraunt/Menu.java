package Restaraunt;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Menu {
    public enum Type {
        KIDS,
        ADULT
    }

    Map<Item, Item.Category> menuItems;

    public Menu(Type type) {
        switch (type) {
            case ADULT:
                menuItems = new HashMap<>() {
                    {
                        put(new Item("Some description here", "Shrimp Scampi", 14.99), Item.Category.ENTREES);
                        put(new Item("Some description here", "Chicken Parmesan", 12.99), Item.Category.ENTREES);
                    }
                };
                break;

            case KIDS:
                menuItems = new HashMap<>() {
                    {
                        put(new Item("Some description here", "Chicken Fingers", 6.99), Item.Category.ENTREES);
                        put(new Item("Some description here", "Corn Dog", 5.99), Item.Category.ENTREES);
                    }
                };
                break;
        }
    }
}
