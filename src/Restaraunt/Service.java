package Restaraunt;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Service {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Service.class.toString());
        Scanner scn = new Scanner(System.in);
        Set<Table> tables = createTables();
        String strInput;

        // To show that there are no duplicate tables
        System.out.println(tables.stream()
                .sorted(Comparator.comparingInt(Table::getTableNumber))
                .collect(Collectors.toList()));

        System.out.println("Welcome to Primavera II. How many today?");
        int numOfCustomers = scn.nextInt();

        try {
            System.out.println("Great. Will you be needing any kids menus today?");

            strInput = scn.next();

            switch (strInput.toLowerCase(Locale.ROOT)) {
                case "yes":
                case "y":
                    System.out.println("Alright. How many?");
                    int numOfMenus = scn.nextInt();
                    break;

                case "no":
                case "n":
                    // TODO: Assign and store table
                    System.out.println("Alright. Follow me this way to your table.");

                    break;

                default:
                    System.out.println("... Well then. Just going to take that as 1. Follow me.");
                    break;
            }
        }
        catch (Exception e) {
            logger.warning(e.getMessage());
            System.exit(0);
        }
    }

    private static Set<Table> createTables(){
        Random rand = new Random();
        
        Stack<Integer> nums = new Stack<>() {
            {
                addAll(new LinkedHashSet<>() {
                    {
                        while (this.size() < 30) {
                            add(rand.nextInt(30) + 1);
                        }
                    }
                });
            }
        };

        return new HashSet<>() {
            {
                for (int i = 0; i < 30; i++) {
                    add(new Table(nums.pop(), rand.nextInt(10 + 1)));
                }
            }
        };
    }
}