package nl.inholland.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage window) throws Exception {
        window.setHeight(150);
        window.setWidth(700);
        window.setTitle("Simple Calculator");

        VBox containter = new VBox(10);

        /*
        *
        * Code goes here
        *
        * */

        Scene scene = new Scene(containter);
        window.setScene(scene);
        window.show();
    }
}
