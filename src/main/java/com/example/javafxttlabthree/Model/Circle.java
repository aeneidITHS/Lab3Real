package com.example.javafxttlabthree.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {


    public Circle(double x, double y, double size, Color color) {
        super(x, y, size, color);

    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(getPositionX()-(getSize()/2), getPositionY()-(getSize()/2), getSize(), getSize());
    }

    @Override
    public boolean contains(double x, double y) {
        double a = (x-getPositionX());
        double b = (y-getPositionY());
        double distance = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
        return (distance<=(getSize()/2));
    }

    @Override
    public String convertToSVG() {
        String color = "#" + getColor().toString().substring(2,10);
        return "<circle cx=\""+ (getPositionX()-(getSize()/2)) + "\" cy=\"" +(getPositionY()-(getSize()/2)) + "\" r=\"" +getSize() + "\" fill=\""+ color + "\"/>";
    }


}
