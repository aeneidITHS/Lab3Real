package com.example.demo.Controller;

import com.example.demo.Model.*;
import javafx.beans.Observable;
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
    ModelRepository modelRepository = new ModelRepository();
    public Button squareButton;
    public Button circleButton;
    public ToggleButton selectModeButton;
    public Slider slider;
    public ColorPicker colorPicker = new ColorPicker();
    public Button rectangleButton;
    public Color c;
    public GraphicsContext context;
    double newSize;
    MouseEvent clickedOnCanvas;
    public void initialize(){
        context= canvas.getGraphicsContext2D();
        slider.valueProperty().bindBidirectional(modelRepository.sizeProperty());
        //modelRepository.getShapeObservableList().addListener(this::listChanged);




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

    public void render(){
        context.setFill(Color.GREEN);
    }
    public void listChanged(Observable observable){
        for (ModelTemplate s:
                modelRepository.getShapeObservableList() ) {
            modelRepository.drawCircle(context);

        }
    }
    public void onMousePressedPlaceObject(MouseEvent event){

        if (selectMode()) {
            modelRepository.contains(event.getX(), event.getY(),context,canvas);
            for (ModelTemplate s:
                    modelRepository.getShapeObservableList()) {
                System.out.println(s);
                s.draw(context);

            }

        }
        else if (!selectMode()) {

            modelRepository.setColor(colorPicker.getValue());
            modelRepository.setPositionX(event.getX());
            modelRepository.setPositionY(event.getY());
            modelRepository.setShape(chosenShape);
            modelRepository.build();
            switch (chosenShape) {
                case SQUARE ->
                modelRepository.drawSquare(context);
                case CIRCLE ->
                    modelRepository.drawCircle(context);
            }
                }
            }


}




