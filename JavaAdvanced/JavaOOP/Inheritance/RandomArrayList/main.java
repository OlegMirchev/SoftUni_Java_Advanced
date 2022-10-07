package JavaAdvanced2021.JavaOPP.InheritanceLAB0211.RandomArrayList;

public class main {
    public static void main(String[] args) {

        RandomArrayList<Integer> list = new RandomArrayList<>();

        for (int i = 1; i < 13; i++) {
            list.add(i);
        }
        System.out.println(list.getRandomElement());
    }
}
