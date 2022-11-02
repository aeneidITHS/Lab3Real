package com.example.demo.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class ModelTemplate  {
    private final double positionX;
    private final double positionY;
    private  double size;
    private Shapes shape;
    private   Color color;

    public ModelTemplate(double positionX, double positionY, double size){

        this.size = size;
        color = getColor();
        this.positionX = positionX;
        this.positionY = positionY;
    }


    public Shapes getShape() {
        return this.shape;
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

    public void setSize(double size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public abstract void draw(GraphicsContext context);

   public static ModelTemplate createShape(Shapes shape,double x, double y, double size){
       return switch (shape){
           case CIRCLE -> new Circle(x,y,size);
           case SQUARE -> new Square(x, y, size);
       };
   }



}
