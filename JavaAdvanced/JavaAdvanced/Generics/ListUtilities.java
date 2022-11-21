package JavaAdvanced2021.JavaAdvanced.GenericsLAB0810;

import java.util.Collections;
import java.util.List;

public class ListUtilities {
    public static void main(String[] args) {

        List<Integer> listInt = List.of(1, 2, 3, 4, 5, 6);
        List<Double> listDouble = List.of(1.5, 2.5, 3.5, 4.5, 5.5, 6.5);

        System.out.println(ListUtils.getMin(listInt));
        System.out.println(ListUtils.getMax(listDouble));
    }

    public static class ListUtils {

        public static <T extends Comparable<T>> T getMin(List<T> listNumb) {
            exception(listNumb);
            return Collections.min(listNumb);
        }

        public static <T extends Comparable<T>> T getMax(List<T> listNumb) {
            exception(listNumb);
            return Collections.max(listNumb);
        }

        public static <T> void exception(List<T> listNumb) {
            if (listNumb.isEmpty()) {
                throw new IllegalArgumentException("Illegal Argument Exception");
            }
        }
    }
}
