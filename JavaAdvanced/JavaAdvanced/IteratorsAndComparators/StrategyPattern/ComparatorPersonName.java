package IteratorsAndComparators;

import java.util.Comparator;

public class ComparatorPersonName implements Comparator<PersonStrategy> {

    @Override
    public int compare(PersonStrategy f, PersonStrategy s) {
        if (f.getName().length() == s.getName().length()) {
            return Character.compare(f.getName().toLowerCase().charAt(0), s.getName().toLowerCase().charAt(0));
        }
        return Integer.compare(f.getName().length(), s.getName().length());
    }
}
