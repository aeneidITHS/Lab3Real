package com.example.demo.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class UnusedClass {

/*
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

*/



}
