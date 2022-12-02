import java.util.*;

public class FoodFinder {
    public static int wordFound = 0;
    public static String pear = "pear";
    public static String flour = "flour";
    public static String pork = "pork";
    public static String olive = "olive";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(String::valueOf).forEach(queue::offer);

        ArrayDeque<String> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(String::valueOf).forEach(stack::push);

        List<String> listWords = new ArrayList<>();

        while (!queue.isEmpty() && !stack.isEmpty()) {
            String vowels = queue.poll();
            String consonants = stack.pop();

            foundLetterFromString(vowels, consonants);

            queue.offer(vowels);
        }

        if (pear.isEmpty()) {
            pear = "pear";
            listWords.add(pear);
            wordFound++;
        }

        if (flour.isEmpty()) {
            flour = "flour";
            listWords.add(flour);
            wordFound++;
        }

        if (pork.isEmpty()) {
            pork = "pork";
            listWords.add(pork);
            wordFound++;
        }

        if (olive.isEmpty()) {
            olive = "olive";
            listWords.add(olive);
            wordFound++;
        }

        System.out.printf("Words found: %d%n", wordFound);
        listWords.forEach(System.out::println);
    }

    public static void foundLetterFromString(String vowels, String consonants) {
        if (pear.contains(vowels)) {
            pear = getRemove(pear, vowels);
        }
        if (flour.contains(vowels)) {
            flour = getRemove(flour, vowels);
        }
        if (pork.contains(vowels)) {
            pork = getRemove(pork, vowels);
        }
        if (olive.contains(vowels)) {
            olive = getRemove(olive, vowels);
        }

        if (pear.contains(consonants)) {
            pear = getRemove(pear, consonants);
        }
        if (flour.contains(consonants)) {
            flour = getRemove(flour, consonants);
        }
        if (pork.contains(consonants)) {
            pork = getRemove(pork, consonants);
        }
        if (olive.contains(consonants)) {
            olive = getRemove(olive, consonants);
        }
    }

    public static String getRemove(String input, String letter) {
        String foundLetter = "";

        String[] arr = input.split("");

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(letter)) {
                foundLetter += arr[i];
            }
        }
        return foundLetter;
    }
}
