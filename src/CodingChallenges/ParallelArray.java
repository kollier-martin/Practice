package CodingChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParallelArray {
    public static void main(String[] args) {
        int arraysize = 3;
        String names = "Malcolm,John,Lucy";
        String heights = "4.2,6.1,2.6";

        System.out.println(sortedNames(arraysize, names, heights));
    }

    public static String sortedNames(int arraysize, String names, String heights){
        // Convert these String to Lists
        List<String> heightsList = new ArrayList<>(List.of(heights.split(",")));
        List<String> namesList = new ArrayList<>(List.of(names.split(",")));

        // Convert each element of the height list to a list doubles
        List<Double> heightsAsDoubles = new ArrayList<>() {
            {
                for (String h : heightsList) {
                    add(Double.valueOf(h));
                }
            }
        };

        // Sort height list and refactor the names list to match these new indexes
        // Create int array to hold the sorted index values
        int[] dubArrIndices = new int[arraysize];
        int maxIndex = 0;
        // System.out.println(heightsAsDoubles);

        // Populate int array with sorted values
        //region TODO: Do I even need this and how?
        for (int i = 0; i < arraysize; i++) {
            maxIndex = heightsAsDoubles.get(i) > heightsAsDoubles.get(maxIndex) ? i : maxIndex;
            dubArrIndices[i] = maxIndex;
        }

        // TODO: How to do this?
        dubArrIndices[0] = maxIndex;
        dubArrIndices[1] = maxIndex - 1;
        dubArrIndices[2] = maxIndex + 1;
        //endregion

        // Add sorted values from list to new array
        String[] nameArr = new String[arraysize];
        for (int i = 0; i < arraysize; i++) {
            nameArr[i] = namesList.get(dubArrIndices[i]);
        }

        // System.out.println(names);
        // System.out.println(Arrays.toString(nameArr));
        // Convert sorted array to String and return
        StringBuilder newNames = new StringBuilder();

        for (int i = 0; i < arraysize; i ++) {
            if (i != arraysize - 1) {
                newNames.append(nameArr[i]).append(",");
            } else {
                newNames.append(nameArr[i]);
            }
        }

        return newNames.toString();
    }
}