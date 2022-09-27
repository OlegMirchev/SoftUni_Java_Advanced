package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionLAB2610.StudentSystem;

import java.util.*;

public class StudentSystem {
    private Command command;
    private boolean isValid;

    public StudentSystem() {
        this.command = new Command();
    }

    public void startSystem(Scanner scanner) {
       this.isValid = true;
        while (isValid) {
            String[] input = scanner.nextLine().split("\\s+");
          String result = this.command.handle(input);
            if (result != null && !result.equals("Exit")) {
                System.out.println(result);
            }
            this.isValid = !"Exit".equals(result);
        }
    }
}
