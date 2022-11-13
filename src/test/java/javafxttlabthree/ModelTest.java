package javafxttlabthree;

import com.example.javafxttlabthree.Shapes.Circle;
import com.example.javafxttlabthree.Model.Model;
import com.example.javafxttlabthree.Shapes.ShapeType;
import com.example.javafxttlabthree.Shapes.Square;
import javafx.scene.paint.Color;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ModelTest {
    Model model = new Model();
    Square square = new Square(10,10,5, Color.BLUE);
    Circle circle = new Circle(10,10,5,Color.BLUE);
    @Test
    void checkIfCreatedAndAddedCorrectly() {
        model.setCreateShapeType(ShapeType.CIRCLE);
        model.setCreatePositionY(5);
        model.setCreatePositionX(5);
        model.setCreateShapeColor(Color.BLUE);
        model.setCreateShapeSize(10);
        model.constructShape();
        model.setCreateShapeType(ShapeType.SQUARE);
        model.setCreatePositionY(5);
        model.setCreatePositionX(5);
        model.setCreateShapeColor(Color.BLUE);
        model.setCreateShapeSize(10);
        model.constructShape();
        assertEquals(2,model.getShapeObservableList().size());
    }

    @Test
    void modifySelectedShapes() {
        model.getShapeObservableList().add(square);
        model.setCreateShapeSize(10);
        model.setCreateShapeType(ShapeType.SQUARE);
        model.modifySelectedShapes(model.getShapeObservableList().get(0).getPositionX(), model.getShapeObservableList().get(0).getPositionY());
        assertEquals(10,model.getShapeObservableList().get(0).getSize());

    }
}