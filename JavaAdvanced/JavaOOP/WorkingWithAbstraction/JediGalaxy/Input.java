package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionExercise2810.JediGalaxy;

import java.util.Arrays;

public class Input {
    public static int[] parseIntegerArray(String input) {
        return Arrays
                .stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
