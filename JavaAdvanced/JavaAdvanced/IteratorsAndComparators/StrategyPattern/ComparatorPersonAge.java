package IteratorsAndComparators;

import java.util.Comparator;

public class ComparatorPersonAge implements Comparator<PersonStrategy> {

    @Override
    public int compare(PersonStrategy f, PersonStrategy s) {
        return Integer.compare(f.getAge(), s.getAge());
    }
}
