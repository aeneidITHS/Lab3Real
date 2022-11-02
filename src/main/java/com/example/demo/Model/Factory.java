package com.example.demo.Model;

import javafx.css.Size;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.math.BigDecimal;

import static com.example.demo.Model.Shapes.*;

public class Factory {


    private double positionY;
    private double positionX;
    private double size;
    private Color color;
    private Shapes shape;

    public Factory setPositionY(double positionY) {
        this.positionY = positionY;
        return this;
    }

    public Factory setPositionX(double positionX) {
        this.positionX = positionX;
        return this;
    }

    public Factory setSize(double size) {
        this.size = size;
        return this;
    }

    public Factory setColor(Color color) {
        this.color = color;
        return this;
    }

    public Factory setShape(Shapes shape) {
        this.shape = shape;
        return this;
    }

    public ModelTemplate build(Shapes shape){
                return new Square(positionX, positionY, size);


    }




}
