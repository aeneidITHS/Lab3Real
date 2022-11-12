package com.example.demo.Model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class Model {
    DoubleProperty createPositionX = new SimpleDoubleProperty();
    DoubleProperty createPositionY = new SimpleDoubleProperty();
    DoubleProperty createShapeSize = new SimpleDoubleProperty();
    ObjectProperty<ShapeType> createShapeType = new SimpleObjectProperty<>();
    ObjectProperty<Color> createShapeColor = new SimpleObjectProperty<>();


    ObservableList<Shape> shapeObservableList = FXCollections.observableArrayList();




    public ObservableList<Shape> getShapeObservableList() {
        return shapeObservableList;
    }

    public double getCreatePositionY() {
        return createPositionY.get();
    }

    public void setCreatePositionY(double createPositionY) {
        this.createPositionY.set(createPositionY);
    }
    

    public double getCreatePositionX() {
        return createPositionX.get();
    }

    public void setCreatePositionX(double createPositionX) {
        this.createPositionX.set(createPositionX);
    }

    public double getCreateShapeSize() {
        return createShapeSize.get();
    }

    public void setCreateShapeSize(double createShapeSize) {
        this.createShapeSize.set(createShapeSize);
    }

    public DoubleProperty createShapeSizeProperty() {
        return createShapeSize;
    }

    public ShapeType getCreateShapeType() {
        return createShapeType.get();
    }

    public void setCreateShapeType(ShapeType createShapeType) {
        this.createShapeType.set(createShapeType);
    }

    public Color getCreateShapeColor() {
        return createShapeColor.get();
    }

    public void setCreateShapeColor(Color createShapeColor) {
        this.createShapeColor.set(createShapeColor);
    }

    public ObjectProperty<Color> createShapeColorProperty() {
        return createShapeColor;
    }

    public void constructShape() {
        Shape shape = Shape.createShape(getCreateShapeType(), getCreatePositionX(), getCreatePositionY(), getCreateShapeSize(), getCreateShapeColor());
        shapeObservableList.add(shape);

    }
    public void pop(){
        shapeObservableList.remove(shapeObservableList.size()-1);
    }
    public void modifySelectedShapes(double x, double y) {
        for (Shape s :
                shapeObservableList) {
            if (s.contains(x, y)) {
                shapeObservableList.remove(s);
                setCreatePositionY(s.getPositionY());
                setCreatePositionX(s.getPositionX());
                setCreateShapeSize(getCreateShapeSize());
                setCreateShapeColor(getCreateShapeColor());
                constructShape();
            }

        }

    }

}







