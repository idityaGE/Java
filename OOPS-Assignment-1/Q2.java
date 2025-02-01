class Point {
    float x, y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void displayCoordinates() {
        System.out.println("(" + x + ", " + y + ")");
    }
}

class Line {

    Point startPoint, endPoint;

    public void setPoints(float startX, float startY, float endX, float endY) {
        startPoint = new Point(startX, startY);
        endPoint = new Point(endX, endY);
    }

    public void setPoints(Point start, Point end) {
        this.startPoint = start;
        this.endPoint = end;
    }

    public void displayLine() {
        System.out.print("Start Point: ");
        startPoint.displayCoordinates();
        System.out.print("End Point: ");
        endPoint.displayCoordinates();
    }

    public float calculateSlope() {
        if (endPoint.x - startPoint.x == 0) {
            throw new ArithmeticException("Slope is undefined (vertical line).");
        }
        return (endPoint.y - startPoint.y) / (endPoint.x - startPoint.x);
    }
}

public class Q2 {

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 6);

        Line line = new Line();
        line.setPoints(p1, p2);

        line.displayLine();

        try {
            System.out.println("Slope of the line: " + line.calculateSlope());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
