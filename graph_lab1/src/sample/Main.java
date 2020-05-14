package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        double width = 991;
        double height = 600;

        Scene scene = new Scene(root, width, height);
        primaryStage.setTitle("Variant 13");
        primaryStage.setScene(scene);

        Circle blue_1 = new Circle(500,296,243,Color.BLUE);
        blue_1.setStrokeWidth(0);
        Circle blue_2 = new Circle(500,296,195,Color.BLUE);
        blue_2.setStroke(Color.BLACK);

        Circle red_1 = new Circle(500,296,144,Color.RED);
        red_1.setStrokeWidth(0);
        Circle red_2 = new Circle(500,296,104,Color.RED);
        red_2.setStroke(Color.BLACK);


        Circle yellow_1 = new Circle(500,296,62,Color.YELLOW);
        yellow_1.setStrokeWidth(0);
        Circle yellow_2 = new Circle(500,296,32,Color.YELLOW);
        yellow_2.setStroke(Color.BLACK);

        Line line1 = new Line(500,303,500,289);
        Line line2 = new Line(493,296,507,296);

        root.getChildren().addAll(blue_1,blue_2,red_1,red_2,yellow_1,yellow_2,line1,line2);
        scene.setFill(Color.BLACK);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
