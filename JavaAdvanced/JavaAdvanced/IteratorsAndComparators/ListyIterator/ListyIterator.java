import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> list;
    private int index;

    public ListyIterator(String... args) {
        this.list = Arrays.asList(args);
        this.index = 0;
    }

    public boolean hasNext() {
        return this.index < list.size() - 1;
    }

    public boolean move() {
       if (hasNext()) {
           this.index++;
           return true;
       }
       return false;
    }

    public void print() {
        if (this.list.size() == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.list.get(index));
    }
}
