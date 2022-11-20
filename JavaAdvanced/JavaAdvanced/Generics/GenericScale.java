package JavaAdvanced2021.JavaAdvanced.GenericsLAB0810;

public class GenericScale {
    public static void main(String[] args) {

        System.out.println(new Scale<>("A", "Z").getHeavier());
        System.out.println(new Scale<>("A", "A").getHeavier());
    }

    public static class Scale<T extends Comparable<T>> {
        private T left;
        private T right;

        public Scale(T left, T right) {
            this.left = left;
            this.right = right;
        }

        public T getHeavier() {
            int compare = left.compareTo(right);
            if (compare == 0) {
                return null;
            }
            return compare > 0 ? left : right;
        }
    }
}
