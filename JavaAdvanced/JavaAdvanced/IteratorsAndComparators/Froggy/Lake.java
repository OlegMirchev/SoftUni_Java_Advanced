import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> listNumber;

    public Lake(List<Integer> listNumber) {
        this.listNumber = listNumber;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    class Frog implements Iterator<Integer> {
        int index = 0;
        boolean isValid = false;
        @Override
        public boolean hasNext() {
            return index < listNumber.size();
        }

        @Override
        public Integer next() {
            int currentIndex = index;
            index += 2;
            if (index >= listNumber.size() && !isValid) {
                index = 1;
                isValid = true;
            }
            return listNumber.get(currentIndex);
        }
    }
}
