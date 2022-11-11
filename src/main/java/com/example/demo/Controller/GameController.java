package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Model.SVGSaver;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ConcurrentModificationException;

import static com.example.demo.Model.ShapeType.SQUARE;

public class GameController {

    Group root = new Group();
    public Canvas canvas = new Canvas(805, 1000);
    ShapeType chosenShape;
    Model modelRepository = new Model();
    public Button squareButton;
    public Button circleButton;
    public ToggleButton selectModeButton;
    public Slider slider;
    public ColorPicker colorPicker = new ColorPicker();

    public Color c;
    public GraphicsContext context;



    public void initialize() {
        context = canvas.getGraphicsContext2D();
        slider.valueProperty().bindBidirectional(modelRepository.sizeProperty());
        modelRepository.getShapeObservableList().addListener(this::listChanged);
        colorPicker.valueProperty().bindBidirectional(modelRepository.colorProperty());


    }

    public void setColorPicker() {
        colorPicker.setOnAction(e -> {
            c = colorPicker.getValue();
        });
    }

    public void onButtonPressSquare() {
        chosenShape = SQUARE;
    }

    public void onButtonPressCircle() {
        chosenShape = ShapeType.CIRCLE;
    }
    public void undo(ActionEvent event){
        modelRepository.remove();
    }
    public void save(){
        SVGSaver.save(modelRepository);
    }
    public boolean selectMode() {
        BooleanProperty selectMode = selectModeButton.selectedProperty();
        BooleanProperty normalOperations = new SimpleBooleanProperty(false);
        normalOperations.bind(selectMode);
        return selectMode.getValue();
    }

    public void listChanged(Observable observable) {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Shape s :
                modelRepository.getShapeObservableList()) {
            s.draw(context);
        }
    }

    public void onMousePressedPlaceObject(MouseEvent event) {

        if (selectMode()) {
            try {
                modelRepository.find(event.getX(), event.getY());
            } catch (ConcurrentModificationException ignored) {
            }

        } else if (!selectMode()) {

            modelRepository.setColor(colorPicker.getValue());
            modelRepository.setPositionX(event.getX());
            modelRepository.setPositionY(event.getY());
            modelRepository.setShape(chosenShape);
            modelRepository.add();

        }

    }


}




