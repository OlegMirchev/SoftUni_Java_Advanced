package JavaAdvanced2021.JavaOPP.PolymorphismLAB1011.Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public Double calculatePerimeter() {
        if (this.getPerimeter() != null) {
            return this.getPerimeter();
        }
        Double perim = this.height * 2 + this.width * 2;
        super.setPerimeter(perim);
        return perim;
    }

    @Override
    public Double calculateArea() {
        if (this.getArea() != null) {
            return this.getArea();
        }
        Double area = this.height * this.width;
        super.setArea(area);
        return area;
    }
}
