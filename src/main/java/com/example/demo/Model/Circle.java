package com.example.demo.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends ModelTemplate {


    public Circle(double x,double y, double size ){
        super(x,y,size);

    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(getPositionX(),getPositionY(),getSize(),getSize());
    }


}
