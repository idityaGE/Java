
import java.util.*;

abstract class Shape {

    protected String color;

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract String getProperties();

    public void fillColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getProperties() {
        return "Circle: Radius=" + radius + ", Color=" + color;
    }
}

class Rectangle extends Shape {

    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getProperties() {
        return "Rectangle: Width=" + width + ", Height=" + height + ", Color=" + color;
    }
}

class Square extends Shape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String getProperties() {
        return "Square: Side=" + side + ", Color=" + color;
    }
}

class Triangle extends Shape {
    // it can be any triangle, so we need to store all sides and height
    private double base, height, sideA, sideB, sideC;

    public Triangle(double base, double height, double sideA, double sideB, double sideC) {
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getProperties() {
        return "Triangle: Base=" + base + ", Height=" + height + ", Color=" + color;
    }
}

class PaintBoard {

    private double width, height;
    private List<Shape> shapes;

    public PaintBoard(double width, double height) {
        this.width = width;
        this.height = height;
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void displayShapes() {
        for (Shape shape : shapes) {
            System.out.println(shape.getProperties() + " | Area: " + shape.getArea() + " | Perimeter: " + shape.getPerimeter());
        }
    }
}

public class PaintBoardApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<PaintBoard> boards = new ArrayList<>();

        while (true) {
            System.out.println("1. Create Paint Board\n2. Add Shape\n3. Display Shapes\n4. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Paint Board Width: ");
                    double width = sc.nextDouble();
                    System.out.print("Enter Paint Board Height: ");
                    double height = sc.nextDouble();
                    boards.add(new PaintBoard(width, height));
                    System.out.println("Paint Board Created!");
                    break;
                case 2:
                    if (boards.isEmpty()) {
                        System.out.println("No Paint Boards available!");
                        break;
                    }
                    System.out.println("Choose Paint Board (0 to " + (boards.size() - 1) + "): ");
                    int boardIndex = sc.nextInt();
                    if (boardIndex < 0 || boardIndex >= boards.size()) {
                        System.out.println("Invalid selection!");
                        break;
                    }
                    System.out.println("Choose Shape: 1. Circle 2. Rectangle 3. Square 4. Triangle");
                    int shapeChoice = sc.nextInt();
                    Shape shape = null;
                    switch (shapeChoice) {
                        case 1:
                            System.out.print("Enter Radius: ");
                            shape = new Circle(sc.nextDouble());
                            break;
                        case 2:
                            System.out.print("Enter Width: ");
                            double w = sc.nextDouble();
                            System.out.print("Enter Height: ");
                            double h = sc.nextDouble();
                            shape = new Rectangle(w, h);
                            break;
                        case 3:
                            System.out.print("Enter Side: ");
                            shape = new Square(sc.nextDouble());
                            break;
                        case 4:
                            System.out.print("Enter Base: ");
                            double base = sc.nextDouble();
                            System.out.print("Enter Height: ");
                            double triHeight = sc.nextDouble();
                            System.out.print("Enter Side A: ");
                            double sideA = sc.nextDouble();
                            System.out.print("Enter Side B: ");
                            double sideB = sc.nextDouble();
                            System.out.print("Enter Side C: ");
                            double sideC = sc.nextDouble();
                            shape = new Triangle(base, triHeight, sideA, sideB, sideC);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            continue;
                    }
                    System.out.print("Enter Color: ");
                    shape.fillColor(sc.next());
                    boards.get(boardIndex).addShape(shape);
                    System.out.println("Shape Added!");
                    break;
                case 3:
                    if (boards.isEmpty()) {
                        System.out.println("No Paint Boards available!");
                        break;
                    }
                    for (int i = 0; i < boards.size(); i++) {
                        System.out.println("Paint Board " + i + ":");
                        boards.get(i).displayShapes();
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
