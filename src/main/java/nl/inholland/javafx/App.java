package nl.inholland.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class App extends Application {

    TextField numerator, divider, outcome;
    Button calculate, reset;
    Label divideSymbol = new Label("/");
    Label equalsSymbol = new Label("=");
    Label errorLabel = new Label("");

    @Override
    public void start(Stage window) throws Exception {
        window.setHeight(150);
        window.setWidth(700);
        window.setTitle("Simple Calculator");

        VBox containter = new VBox(10);
        containter.setPadding(new Insets(10));
        HBox box = new HBox();
        box.setPadding(new Insets(10));
        box.setSpacing(10);

        numerator = new TextField();
        divider = new TextField();
        outcome = new TextField();

        calculate = new Button("Calculate");
        reset = new Button("Reset");

        box.getChildren().addAll(numerator, divideSymbol, divider, equalsSymbol, outcome, calculate, reset);
        containter.getChildren().addAll(box, errorLabel);

        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    errorLabel.setText("");
                    double result = parseDouble(numerator.getText()) / parseDouble(divider.getText());
                    outcome.setText(String.valueOf(result));
                }catch (NumberFormatException nfe) {
                    errorLabel.setText("Input was in the wrong format...");
                }catch (ArithmeticException ae) {
                    errorLabel.setText("Cannot divide by 0!");
                }
            }
        });

        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numerator.clear();
                divider.clear();
                outcome.clear();
                errorLabel.setText("");
            }
        });

        errorLabel.setStyle("-fx-text-fill: #ff0000");
        Scene scene = new Scene(containter);
        window.setScene(scene);
        window.show();
    }
}
