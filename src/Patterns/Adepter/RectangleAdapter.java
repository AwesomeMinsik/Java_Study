package Patterns.Adepter;

import Patterns.Adepter.Shape;

public class RectangleAdapter implements Shape {
    private Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void draw() {
        rectangle.drawRectangle();
    }
}