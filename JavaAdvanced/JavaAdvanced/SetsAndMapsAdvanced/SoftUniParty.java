package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedLAB2109;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        while (!command.equals("PARTY")) {
            if (Character.isDigit(command.charAt(0))) {
                vipGuests.add(command);
            }else {
                regularGuests.add(command);
            }
            command = scanner.nextLine();
        }
        String existGuests = scanner.nextLine();

        while (!existGuests.equals("END")) {
            if (vipGuests.contains(existGuests)) {
                vipGuests.remove(existGuests);
            }else if (regularGuests.contains(existGuests)) {
                regularGuests.remove(existGuests);
            }
            existGuests = scanner.nextLine();
        }
        int size = vipGuests.size() + regularGuests.size();

        System.out.println(size);

        for (String resultVip : vipGuests) {
            System.out.println(resultVip);
        }
        for (String resultRegular : regularGuests) {
            System.out.println(resultRegular);
        }
    }
}
