package com.example.demo.Model;

import javafx.scene.canvas.GraphicsContext;

public class Square extends ModelTemplate{

    public Square(double x, double y, double size){
        super(x,y,size);

    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(getPositionX(),getPositionY(),getSize(),getSize());
    }
}
