package com.example.demo.Model;

import javafx.scene.paint.Color;

public class ModelRepository {
    private Position position;
    private Size size;
    private Shapes shape;
    private Color c;
   public ModelRepository (){

   }

    public ModelRepository(Position position, Size size,Shapes shape,Color color) {
    this.shape = shape;
    this.position = position;
    this.size = size;
    this.c = color;
   }

    public Position getPosition() {
        return position;
   }
    public Size getSize() {
        return size;
    }

    public Shapes getShape() {
        return shape;
    }

    public Color getC() {
        return c;
    }
}
