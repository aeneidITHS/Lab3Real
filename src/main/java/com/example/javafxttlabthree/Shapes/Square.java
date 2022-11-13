package com.example.javafxttlabthree.Shapes;

import com.example.javafxttlabthree.Shapes.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends Shape {

    public Square(double x, double y, double size, Color color) {
        super(x, y, size, color);

    }

    @Override
    public boolean contains(double x, double y) {
        Rectangle shape = new Rectangle(getPositionX(), getPositionY(), getSize(), getSize());
        return shape.contains(x, y);
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(getPositionX(), getPositionY(), getSize(), getSize());
    }

    @Override
    public String convertToSVG() {
        String color = "#" + getColor().toString().substring(2,10);
        return "<rect x=\""+ getPositionX() + "\" y=\"" +getPositionY() + "\" width=\"" + getSize() + "\" height=\"" + getSize() + "\" fill=\""+ color + "\"/>" ;
    }
}
