package com.example.demo.Model;

import javafx.scene.paint.Color;

import static com.example.demo.Model.Shapes.CIRCLE;
import static com.example.demo.Model.Shapes.SQUARE;

public class Factory {


    public static ShapeRepository getShape(Position position, Size size, Shapes shapes, Color color){
        if(SQUARE.equals(shapes)) return new Square(position,size,shapes,color);
        else if (CIRCLE.equals(shapes)) return new Circle(position,size,shapes,color);

        return null;
    }




}
