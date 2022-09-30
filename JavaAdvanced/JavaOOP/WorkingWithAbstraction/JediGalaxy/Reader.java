package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionExercise2810.JediGalaxy;

import java.util.Scanner;

public class Reader {
    private Scanner scanner;

    public void Reader() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        return this.scanner.nextLine();
    }
}
