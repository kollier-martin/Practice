package JavaSE8;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Functions {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter @Setter
    static class Paper {
        String spacing;
        Float margin;

        public void print() {
            System.out.println(this);
        }

        @Override
        public String toString(){
            return spacing + ": Margin - " + margin;
        }
    }

    public static void main(String[] args) {
        List<Paper> paperList = new ArrayList<>() {
            {
                add(new Paper("Wide Rule", 0.05F));
                add(new Paper("College Rule", 0.10F));
            }
        };

        //region Supplier
        System.out.println("====== Enter Supplier ======");
        for (Paper p : paperList) {
            print(() -> p);
        }
        System.out.println("====== Exiting Supplier ======\n");
        //endregion

        //region Consumer
        System.out.println("====== Enter Consumer ======");
        log(paperList, System.out::println);
        System.out.println("====== Exiting Consumer ======\n");
        //endregion

        //region Predicate
        System.out.println("====== Enter Predicate ======");
        System.out.println("Wide Ruled Paper:");
        evaluate(paperList, (n) -> n.spacing.contains("Wide"));

        System.out.println();

        System.out.println("College Ruled Paper:");
        evaluate(paperList, (n) -> n.spacing.contains("College"));
        System.out.println("====== Exit Predicate ======\n");
        //endregion

        //region Function
        System.out.println("====== Enter Function ======");
        for (Paper p : paperList) {
            double calculation = calculate(p.getMargin(), currentInt -> currentInt * 5.10);
            System.out.println("Previous Value: " + p.getMargin() + ", After Value: " + calculation);
        }
        System.out.println("====== Exiting Function ======");
        //endregion
    }

    public static void print(Supplier<? extends Paper> supplier) {
        supplier.get().print();
    }

    public static void log(List<Paper> strList, Consumer<Paper> consumer) {
        for (Paper s : strList) {
            consumer.accept(s);
        }
    }

    public static void evaluate(List<Paper> list, Predicate<Paper> predicate){
        for (Paper p : list) {
            if (predicate.test(p)) {
                System.out.println("\t" + p);
            }
        }
    }

    public static double calculate(Float e, Function<Float, Double> func) {
        return func.apply(e);
    }
}
