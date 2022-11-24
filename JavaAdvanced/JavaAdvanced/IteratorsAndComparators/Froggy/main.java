import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stones = scanner.nextLine().split(", ");

        Lake lake = new Lake(Arrays.stream(stones).map(Integer::parseInt).collect(Collectors.toList()));

        List<String> output = new ArrayList<>();
        for (Integer result : lake) {
            output.add(String.valueOf(result));
        }
        System.out.println(String.join(", ", output));
    }
}


