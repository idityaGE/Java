
class Point {

    float x = 0;
    float y = 0;

    public void setValue(float _x, float _y) {
        this.x = _x;
        this.y = _y;
    }

    public void displayCoordinates() {
        System.out.println("(" + x + ", " + y + ")");
    }

    public Point compare(Point otherPoint) {
        if (Math.abs(this.x) < Math.abs(otherPoint.x)) {
            return this;
        } else if (Math.abs(this.x) > Math.abs(otherPoint.x)) {
            return otherPoint;
        } else {
            throw new ArithmeticException("Both points have same x-coordinate.");
        }
    }
}

class Q1 {

    public static void main(String[] args) {
        Point p1 = new Point();
        p1.setValue(10, 10);

        Point p2 = new Point();
        p2.setValue(5, 5);

        Point cp = p1.compare(p2);

        System.out.println("Point 1: ");
        p1.displayCoordinates();

        System.out.println("Point 2: ");
        p2.displayCoordinates();

        System.out.println("\nPoint closer to the origin along the x-axis: ");
        cp.displayCoordinates();
    }
}
