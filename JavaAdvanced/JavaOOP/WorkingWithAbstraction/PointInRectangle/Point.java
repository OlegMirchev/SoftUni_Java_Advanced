package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionLAB2610.PointInRectangle;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean greaterOrEqual(Point p) {
        return p.x <= x && p.y <= y;
    }

    public boolean lessOrEqual(Point p) {
        return p.x >= x && p.y >= y;
    }
}
