package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionLAB0511.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Identifiable> list = new ArrayList<>();

        while (!input.equals("End")) {
            String[] command = input.split("\\s+");

            Identifiable identifiable = command.length == 2
                    ? new Robot(command[0], command[1])
                    : new Citizen(command[0], Integer.parseInt(command[1]), command[2]);

            list.add(identifiable);

            input = scanner.nextLine();
        }
        String lastDigit = scanner.nextLine();

        System.out.println(list.stream().map(Identifiable::getId).filter(i -> i.endsWith(lastDigit))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
