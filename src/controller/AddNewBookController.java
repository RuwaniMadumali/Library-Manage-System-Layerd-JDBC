package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AddNewBookController {


    public Button btnHomeMenu;
    public AnchorPane root;
    public Spinner<Integer> spnrNoOfPage;

    final  int initValue=100;

    SpinnerValueFactory<Integer> svf =new SpinnerValueFactory.IntegerSpinnerValueFactory(1,5000,initValue);

    public void initialize(){
        spnrNoOfPage.setValueFactory(svf);


    }


    public void navigateToHome(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/HomePage.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }
}
