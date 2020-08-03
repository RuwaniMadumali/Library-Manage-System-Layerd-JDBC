package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AddNewMemberController {
    public JFXComboBox memberCategoryCmbbx;
    public Button btnHomeMenu;
    public AnchorPane root;

    ObservableList<String> memberCategoryList = FXCollections.observableArrayList("Default","Bronze","Silver","Gold","Platinum");

    public void initialize(){
        memberCategoryCmbbx.setValue("Default");
        memberCategoryCmbbx.setItems(memberCategoryList);

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
