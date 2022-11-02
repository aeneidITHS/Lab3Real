package com.example.demo.Model;

import javafx.scene.paint.Color;

public abstract class ShapeRepository {
      public abstract Shapes getShape();
      public abstract double getPositionX();
      public abstract double getPositionY();
      public abstract double getSize();
      public abstract Color getColor();

      public abstract String ShapetoString();
}

