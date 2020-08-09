package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Formatter;

public class AddNewMemberController {
    public JFXComboBox memberCategoryCmbbx;
    public Button btnHomeMenu;
    public AnchorPane root;
    public Label lblMemberID;
    public Label lblMemberDuration;
    public Label lblexpdate;
    public JFXButton btnSaveAndUpdate;


    public void initialize(){

        generateNewMemberID();
        setExpDate();

    }

    public void generateNewMemberID(){
        lblMemberID.setText("MB0001");

    }

    public void setExpDate(){
        Calendar cal= Calendar.getInstance();
         int year =(cal.get(Calendar.YEAR));
       int month=cal.get(Calendar.MONTH)+1;
        int date=cal.get(Calendar.DATE);
        date=date+1;

        Formatter fmt = new Formatter();
        lblexpdate.setText(date+" - "+fmt.format("%tB ", cal)+" - "+year);

    }


    public void navigateToHome(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/HomePage.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }


    public void navigateToMemberUpdation(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/MembershipUpdationForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }
}

