package JavaSE8.AdvancedDataStructures.Models;

public class Office extends Building {
    int age = 3;

    @Override
    public String toString() {
        return "Office {\n" +
                "  age: " + age + ",\n" +
                '}';
    }
}
