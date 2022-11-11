package com.example.demo.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends Shape {
    Model modelRepository = new Model();

    public Square(double x, double y, double size, Color color) {
        super(x, y, size, color);

    }

    @Override
    public boolean find(double findX, double findY, double size) {
        Rectangle shape = new Rectangle(getPositionX(), getPositionY(), size, size);
        return shape.contains(findX, findY);
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(getPositionX(), getPositionY(), getSize(), getSize());
    }

    @Override
    public String convertToSVG() {
        String color = "#" + getColor().toString().substring(2,10);
        return "<rectangle x=\""+ getPositionX() + "\" y=\"" +getPositionY() + "\" width=\"" + getSize() + "\" height=\"" + getSize() + "\" fill=\""+ "black" + "\" stroke-width=\"" + 4 + "\" stroke=\""+ "black" +"\"/>" ;
    }
}
