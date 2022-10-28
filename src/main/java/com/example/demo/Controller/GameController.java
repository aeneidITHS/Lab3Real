package com.example.demo.Controller;

import com.example.demo.Model.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.example.demo.Model.Shapes.SQUARE;

public class GameController {

    Group root = new Group();
    public Canvas canvas = new Canvas(805,1000);
    Shapes chosenShape;
    Size sizeSquare = new Size(100,100,0,0);
    Size sizeCircle = new Size(100,100,100,100);
    public Button squareButton;
    public Button circleButton;
    public ToggleButton selectModeButton;
    public Slider slider;
    public ColorPicker colorPicker = new ColorPicker();
    public Button rectangleButton;
    public Color c;
    public GraphicsContext context;
    public ObservableList<ShapeRepository> savedShapeRepositories = FXCollections.observableArrayList();
    double newSize;


    public void initialize(){
        context=canvas.getGraphicsContext2D();
        slider.valueProperty().addListener((observableValue, number, t1) -> {
            sizeSquare =new Size(newSize,newSize,0,0);
            sizeCircle = new Size(newSize,newSize,newSize,newSize);
        });
        render();

    }
public void setColorPicker(){
        colorPicker.setOnAction(e -> { c = colorPicker.getValue();});
    }

    public void onButtonPressSquare(){
        chosenShape = SQUARE;
    }
    public void onButtonPressCircle(){
        chosenShape= Shapes.CIRCLE;
    }
    public boolean selectMode(){
        BooleanProperty selectMode = selectModeButton.selectedProperty();
        BooleanProperty normalOperations = new SimpleBooleanProperty(false);
        normalOperations.bind(selectMode);
        return selectMode.getValue();
    }
    public void onButtonPressRectangle(){
        chosenShape=chosenShape.RECTANGLE;
    }
    public void render(){
        context.setFill(Color.GREEN);
    }

    public void onMousePressedPlaceObject(MouseEvent event){
        Position temp1 = new Position(event.getX(),event.getY());
        Square temp = new Square(temp1,null,null,null);
        ShapeRepository element = temp;
        if (selectMode()) {
            System.out.println(temp1.x()+ ","+ temp1.y()+ "\n--------");
            context.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
            context.fillRect(event.getX(),event.getY(),sizeSquare.x(),sizeSquare.y());

        }
        else if (!selectMode()) {

            switch (chosenShape) {
                case SQUARE -> {
                    System.out.println("Check 1");
                    context.fillRect(100,100,sizeSquare.x(),sizeSquare.y());
                    System.out.println("check 2");
                    savedShapeRepositories.add(Factory.getShape(new Position(event.getX(), event.getY()), sizeSquare, chosenShape, c));

                }
                case CIRCLE -> {
                    context.setFill(c);
                    context.fillRoundRect(event.getX(), event.getY(), sizeCircle.x(), sizeCircle.y(), sizeCircle.z(), sizeCircle.w());

                }
            }
        }
    }
    private <C,T> List<T> valueGrabber(List<C> items, Function<C,T> func){
        return items.stream().map(func).collect(Collectors.toList());
    }



}