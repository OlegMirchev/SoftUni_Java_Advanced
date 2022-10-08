package JavaAdvanced2021.JavaOPP.InheritanceLAB0211.StackOfStrings;

public class main {
    public static void main(String[] args) {

        StackOfStrings stack = new StackOfStrings();

        stack.push("one");
        stack.push("two");
        stack.push("three");

        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
