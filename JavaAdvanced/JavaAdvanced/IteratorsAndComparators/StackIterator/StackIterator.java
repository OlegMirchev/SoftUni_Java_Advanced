package IteratorsAndComparators;

import java.util.ArrayDeque;
import java.util.Iterator;

public class StackIterator implements Iterable<Integer> {
    private ArrayDeque<Integer> stack;

    public StackIterator() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int[] element) {
        for (int i = 0; i < element.length; i++) {
        this.stack.push(element[i]);
        }
    }

    public void pop() {
        if (this.stack.isEmpty()) {
            throw new IllegalArgumentException("No elements");
        }
        this.stack.pop();
    }

    private class LibIterator implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            return stack.pop();
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LibIterator();
    }
}
