package Tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
      return this.elements.remove(index);
    }

    public boolean contains(T element) {
        if (this.elements.contains(element)) {
            return true;
        }
        return false;
    }

    public void swap(int first, int second) {
        Collections.swap(this.elements, first, second);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T tokens : elements) {
            if (tokens.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
     return Collections.max(this.elements);

    }

    public T getMin() {
        return Collections.min(this.elements);

    }

    public void Print() {
        this.elements.forEach(System.out::println);
    }
}
