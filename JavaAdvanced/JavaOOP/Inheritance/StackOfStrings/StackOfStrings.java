package JavaAdvanced2021.JavaOPP.InheritanceLAB0211.StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(element);
    }

    public String peek() {
        int lastIndex = this.data.size() - 1;
        return this.data.get(lastIndex);
    }

    public String pop() {
        int lastIndex = this.data.size() - 1;
        return this.data.remove(lastIndex);
    }

    public Boolean isEmpty() {
        return this.data.isEmpty();
    }
}
