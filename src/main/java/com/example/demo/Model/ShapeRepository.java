package com.example.demo.Model;

import javafx.scene.paint.Color;

public abstract class ShapeRepository {
      public abstract Shapes getShape();
      public abstract Position getPosition();
      public abstract Size getSize();
      public abstract Color getColor();


      public abstract String ShapetoString();
}

