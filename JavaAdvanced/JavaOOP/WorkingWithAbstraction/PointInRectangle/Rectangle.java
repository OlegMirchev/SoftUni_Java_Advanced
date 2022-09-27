package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionLAB2610.PointInRectangle;

public class Rectangle {
    private final Point A;
    private final Point B;

    public Rectangle(Point a, Point b) {
       this.A = a;
       this.B = b;
    }

    public boolean contains(Point p) {
        return p.greaterOrEqual(this.A) && p.lessOrEqual(this.B);
    }
}
