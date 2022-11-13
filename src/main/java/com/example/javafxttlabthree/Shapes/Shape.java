package com.example.javafxttlabthree.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    private final double positionX;
    private final double positionY;
    private double size;
    private Color color;

    public Shape(double positionX, double positionY, double size, Color color) {

        this.size = size;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
    }


    public double getPositionY() {
        return positionY;
    }


    public double getPositionX() {
        return positionX;
    }


    public double getSize() {
        return this.size;
    }


    public Color getColor() {
        return this.color;
    }

    public abstract void draw(GraphicsContext context);

    public abstract boolean contains(double findX, double findY);


    public static Shape createShape(ShapeType shapeType, double x, double y, double size, Color color) {
        return switch (shapeType) {
            case CIRCLE -> new Circle(x, y, size, color);
            case SQUARE -> new Square(x, y, size, color);
        };
    }

    public abstract String convertToSVG();


}
