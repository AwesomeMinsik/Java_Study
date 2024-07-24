package Patterns.Adepter;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();

        Shape rectAdapter = new RectangleAdapter(rectangle);

        rectAdapter.draw();  // Outputs "Drawing a rectangle"
    }
}