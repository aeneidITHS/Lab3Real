package com.example.demo.Model;

import javafx.scene.paint.Color;

public class Square extends ShapeRepository {
    private Position position;
    private Size size;
    private Shapes shape;
    private Color color;

    public Square(Position position,Size size,Shapes shape,Color color){
        this.shape = shape;
        this.size = size;
        this.color = color;
        this.position = position;
    }

    @Override
    public Shapes getShape() {
        return this.shape;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public Size getSize() {
        return this.size;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public String ShapetoString() {
        return ""+ shape;
    }
}
