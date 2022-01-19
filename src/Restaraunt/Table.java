package Restaraunt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter @Setter
@ToString
public class Table {
    private int customers;
    private int tableNumber;
    private boolean occupied;

    public Table(int tableNumber){
        occupied = false;
        this.tableNumber = tableNumber;
    }
}
