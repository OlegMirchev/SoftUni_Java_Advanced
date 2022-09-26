package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionLAB2610;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        int size = readInput();
        String rhombus = createRhombus(size);
        printOut(rhombus);

    }

    private static int readInput() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    private static String createRhombus(int size) {
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            output.append(printLine(size - i, i)).append(System.lineSeparator());
        }
        for (int i = size - 1; i >= 1; i--) {
            output.append(printLine(size - i, i)).append(System.lineSeparator());
        }

        return output.toString();
    }

    private static String printLine(int spaces, int stars) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            output.append(" ");
        }
        for (int i = 0; i < stars; i++) {
            output.append("* ");
        }
        return output.toString();
    }

    private static void printOut(String rhombus) {
        System.out.println(rhombus);
    }
}
