package JavaAdvanced2021.JavaOPP.InheritanceLAB0211.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement() {
        int end = super.size();
        Random random = new Random();
        int randomIndex = random.nextInt(end);
        return remove(randomIndex);
    }
}
