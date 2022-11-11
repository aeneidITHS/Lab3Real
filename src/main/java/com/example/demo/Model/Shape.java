package com.example.demo.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    private final double positionX;
    private final double positionY;
    private  double size;
    private ShapeType shape;
    private   Color color;

    public Shape(double positionX, double positionY, double size, Color color){

        this.size = size;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
    }


    public ShapeType getShape() {
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
    public abstract boolean find(double findX,double findY,double size);


   public static Shape createShape(ShapeType shape, double x, double y, double size, Color color){
       return switch (shape){
           case CIRCLE -> new Circle(x,y,size,color);
           case SQUARE -> new Square(x, y, size,color);
       };
   }
   public abstract String convertToSVG();


}
