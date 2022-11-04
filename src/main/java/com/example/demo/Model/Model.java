package com.example.demo.Model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class Model {
    DoubleProperty positionX = new SimpleDoubleProperty();
    DoubleProperty positionY = new SimpleDoubleProperty();
    DoubleProperty size = new SimpleDoubleProperty();
    ObjectProperty<ShapeType> shape = new SimpleObjectProperty<>();
    ObjectProperty<Color> color = new SimpleObjectProperty<>();


    ObservableList<Shape> shapeObservableList = FXCollections.observableArrayList();

    public ObservableList<Shape> getShapeObservableList() {
        return shapeObservableList;
    }

    public void setShapeObservableList(ObservableList<Shape> shapeObservableList) {
        this.shapeObservableList = shapeObservableList;
    }

    public double getPositionY() {
        return positionY.get();
    }

    public void setPositionY(double positionY) {
        this.positionY.set(positionY);
    }

    public DoubleProperty positionYProperty() {
        return positionY;
    }

    public double getPositionX() {
        return positionX.get();
    }

    public void setPositionX(double positionX) {
        this.positionX.set(positionX);
    }

    public DoubleProperty positionXProperty() {
        return positionX;
    }

    public double getSize() {
        return size.get();
    }

    public void setSize(double size) {
        this.size.set(size);
    }

    public DoubleProperty sizeProperty() {
        return size;
    }

    public ShapeType getShape() {
        return shape.get();
    }

    public void setShape(ShapeType shape) {
        this.shape.set(shape);
    }

    public ObjectProperty<ShapeType> shapesProperty() {
        return shape;
    }

    public Color getColor() {
        return color.get();
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public void add() {
        Shape shape = Shape.createShape(getShape(), getPositionX(), getPositionY(), getSize(), getColor());
        shapeObservableList.add(shape);

    }

    public void find(double findX, double findY) {
        for (Shape s :
                shapeObservableList) {
            if (s.find(findX, findY, s.getSize())) {
                shapeObservableList.remove(s);
                setPositionY(s.getPositionY());
                setPositionX(s.getPositionX());
                setSize(getSize());
                setColor(getColor());
                add();
            }

        }

    }
}







