package CodingChallenges;

import java.util.ArrayList;
import java.util.Arrays;

public class Heteromecic {
    public static void main(String[] args) {
        ArrayList<Integer> areTheseHeteromecic =
                new ArrayList<> (Arrays.asList (0, 2, 7, 110, 136, 156));

        areTheseHeteromecic
                .forEach(s -> System.out.println(isHeteromecic(s)));
    }

    public static boolean isHeteromecic(int num) {

        return false;
    }
}