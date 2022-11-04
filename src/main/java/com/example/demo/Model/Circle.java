package com.example.demo.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Circle extends Shape {


    public Circle(double x, double y, double size, Color color) {
        super(x, y, size, color);

    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(getPositionX(), getPositionY(), getSize(), getSize());
    }

    @Override
    public boolean find(double findX, double findY, double size) {
        Rectangle shape = new Rectangle(getPositionX(), getPositionY(), size, size);
        return shape.contains(findX, findY);
    }


}
