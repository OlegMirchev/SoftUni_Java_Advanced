package JavaAdvanced2021.JavaOPP.PolymorphismLAB1011.Shapes;

public class main {
    public static void main(String[] args) {

        Shape firstShape = new Circle(23D);


        System.out.println(firstShape.calculatePerimeter());
        System.out.println(firstShape.calculateArea());

        Shape secondShape = new Rectangle(13D, 15D);

        System.out.println(secondShape.calculatePerimeter());
        System.out.println(secondShape.calculateArea());
    }
}
