package JavaAdvanced2021.JavaAdvanced.GenericsLAB0810;

import java.util.ArrayDeque;

public class JarOfT {
    public static void main(String[] args) {
        Jar<Integer> intJar = new Jar<>();

        intJar.add(29);
        intJar.add(1);

        intJar.remove();
    }

    public static class Jar<T> {
        private ArrayDeque<T> elements;

        public Jar() {
            this.elements = new ArrayDeque<>();
        }

        public void add(T element) {
            this.elements.push(element);
        }

        public T remove() {
            return this.elements.pop();
        }
    }
}

