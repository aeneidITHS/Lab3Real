package com.example.javafxttlabthree.Model;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SVGSaver {
    static FileChooser filechooser = new FileChooser();
    public static void save(Model model){
        setUpFileSaveTemplate();
        Path path = Path.of(filechooser.showSaveDialog(new Stage()).getPath());
        List<String> savedShapes = new ArrayList<>();
        savedShapes.add(startOfSvg());
        System.out.println("stuff has happened");
        for (Shape shape: model.getShapeObservableList()) {
            savedShapes.add(shape.convertToSVG());
        }
        savedShapes.add("</svg>");
        savedShapes.forEach(System.out::println);
        try {
            Files.write(path,savedShapes);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    private static String startOfSvg(){
        return"<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"3840\" height=\"1080\">";
    }
    private static void setUpFileSaveTemplate(){
        filechooser.setTitle("Save as");
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("SVG file", ".svg"));
    }

}
