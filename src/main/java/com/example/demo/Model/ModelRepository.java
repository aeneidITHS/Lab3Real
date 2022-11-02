package com.example.demo.Model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.stream.Collectors;

public class ModelRepository {
   DoubleProperty positionX = new SimpleDoubleProperty();
   DoubleProperty positionY = new SimpleDoubleProperty();
   DoubleProperty size = new SimpleDoubleProperty();
   ObjectProperty<Shapes> shape  =new SimpleObjectProperty<>();
   ObjectProperty<Color> color = new SimpleObjectProperty<>();


   ObservableList<ModelTemplate> shapeObservableList = FXCollections.observableArrayList();

    public ObservableList<ModelTemplate> getShapeObservableList() {
        return shapeObservableList;
    }

    public void setShapeObservableList(ObservableList<ModelTemplate> shapeObservableList) {
        this.shapeObservableList = shapeObservableList;
    }
    public double getPositionY() {
        return positionY.get();
    }

    public void setPositionY(double positionY) {
        this.positionY.set(positionY);
    }
    public DoubleProperty positionYProperty(){
        return positionY;
    }

    public double getPositionX() {
        return positionX.get();
   }

    public void setPositionX(double positionX) {
        this.positionX.set(positionX);
    }
    public DoubleProperty positionXProperty(){
        return positionX;
    }
   public double getSize() {
        return size.get();
    }

    public void setSize(double size) {
        this.size.set(size);
    }

    public DoubleProperty sizeProperty(){
        return size;
    }
    public Shapes getShape() {
        return shape.get();
    }

    public void setShape(Shapes shape) {
        this.shape.set(shape);
    }
    public ObjectProperty<Shapes> shapesProperty(){
        return shape;
    }
    public Color getColor() {
        return color.get();
    }

    public void setColor(Color color) {
        this.color.set(color);
    }
    public ObjectProperty<Color> colorProperty(ColorPicker colorPicker){
        return color;
    }
    public void build(){
        var shape = new Factory()
                .setPositionX(getPositionX())
                .setPositionY(getPositionY())
                .setSize(getSize())
                .setColor(getColor())
                .build(getShape());
        shapeObservableList.add(shape);


        }

   public void contains(double findX, double findY, GraphicsContext graphicsContext, Canvas canvas){
       for (ModelTemplate m:
            shapeObservableList) {
           var posX = shapeObservableList.stream().map(modelTemplate -> getPositionX()).findAny().get();
           var posY = shapeObservableList.stream().map(ModelTemplate->getPositionY()).findAny().get();
           var size = shapeObservableList.stream().map(ModelTemplate->getSize()).findAny().get();
           Rectangle shape = new Rectangle(posX,posY,size,size);
           if (shape.contains(findX,findY)){
               System.out.println("Found it");
               shapeObservableList.stream().reduce((first,second)->second).ifPresent(modelTemplate -> modelTemplate.setSize(getSize()));
               graphicsContext.clearRect(0,0,canvas.getWidth(),canvas.getHeight());


               //drawCircle(graphicsContext);
               System.out.println(shapeObservableList.size());
           }

       }

   }


    public void drawSquare(GraphicsContext graphicsContext){
        //for (ModelTemplate p:
          //   shapeObservableList) {
           // var posX = shapeObservableList.stream().filter(modelTemplate -> modelTemplate.getShape() == Shapes.SQUARE).map(modelTemplate -> getPositionX()).findAny().get();
           // var posY = shapeObservableList.stream().filter(modelTemplate -> modelTemplate.getShape() == Shapes.SQUARE).map(ModelTemplate->getPositionY()).findAny().get();
           // var size = shapeObservableList.stream().filter(modelTemplate -> modelTemplate.getShape() == Shapes.SQUARE).map(ModelTemplate->getSize()).findAny().get();
           // var color = shapeObservableList.stream().filter(modelTemplate -> modelTemplate.getShape() == Shapes.SQUARE).map(ModelTemplate->getColor()).findAny().get();
            graphicsContext.setFill(getColor());
            graphicsContext.fillRect(getPositionX(),getPositionY(),getSize(),getSize());
            }
        //}
    public void drawCircle(GraphicsContext graphicsContext){
        for (ModelTemplate s:
                shapeObservableList) {
            var posX = shapeObservableList.stream().filter(modelTemplate -> modelTemplate.getShape() == Shapes.CIRCLE).map(modelTemplate -> getPositionX()).findAny().get();
            var posY = shapeObservableList.stream().filter(modelTemplate -> modelTemplate.getShape() == Shapes.CIRCLE).map(ModelTemplate->getPositionY()).findAny().get();
            var size = shapeObservableList.stream().filter(modelTemplate -> modelTemplate.getShape() == Shapes.CIRCLE).map(ModelTemplate->getSize()).findAny().get();
            var color = shapeObservableList.stream().filter(modelTemplate -> modelTemplate.getShape() == Shapes.CIRCLE).map(ModelTemplate->getColor()).findAny().get();
            graphicsContext.setFill(color);
            graphicsContext.fillRoundRect(posX,posY,size,size,size,size);
        }
    }


    }







