package JavaAdvanced2021.JavaOPP.PolymorphismLAB1011.Shapes;

import JavaAdvanced2021.JavaOPP.PolymorphismLAB1011.Shapes.Shape;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public Double calculatePerimeter() {
        if (this.getPerimeter() != null) {
            return this.getPerimeter();
        }
        Double perim = 2 * Math.PI * this.radius;
        super.setPerimeter(perim);
        return perim;
    }

    @Override
    public Double calculateArea() {
        if (this.getArea() != null) {
            return this.getArea();
        }
        Double area = Math.PI * Math.pow(this.radius, 2);
        super.setArea(area);
        return area;
    }
}
