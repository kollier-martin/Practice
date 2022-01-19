package CodingChallenges;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberFromSquares {
    public static void main(String[] args) {
        ArrayList<Integer> numToUse =
                new ArrayList<> (Arrays.asList (203, 11, 107));

        numToUse
                .forEach(s -> System.out.println(newNum(s)));
    }

    public static boolean newNum(int num) {

        return false;
    }
}
