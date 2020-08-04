package controller;

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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class MembershipUpdationController {
    public AnchorPane root;
    public JFXComboBox memberCategoryCmbbx;
    public Button btnSearchMember;
    public Button btnHomeMenu;
    public ImageView imgNewMembership;
    public Label lblPriceMembership;

    ObservableList<String> memberCategoryList = FXCollections.observableArrayList("Free","Bronze","Silver","Gold","Platinum");

    public void initialize(){
        //memberCategoryCmbbx.setValue("Default");
        memberCategoryCmbbx.setItems(memberCategoryList);
        imgNewMembership.imageProperty().set(null);
        lblPriceMembership.setText("00.00");




    }

    public void navigateToSearchMember(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/SearchMemberForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void navigateToHome(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/HomePage.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void getComboSelection(ActionEvent actionEvent)  {


        if (memberCategoryCmbbx.getValue().equals("Free")){
            imgNewMembership.imageProperty().set(new Image("/asset/free-membership.png"));
            lblPriceMembership.setText("00.00");
        }
        if (memberCategoryCmbbx.getValue().equals("Bronze")){
            imgNewMembership.imageProperty().set(new Image("/asset/bronze.png"));
            lblPriceMembership.setText("300.00");
        }
        if (memberCategoryCmbbx.getValue().equals("Silver")){
            imgNewMembership.imageProperty().set(new Image("/asset/silver.png"));
            lblPriceMembership.setText("500.00");
        }
        if (memberCategoryCmbbx.getValue().equals("Gold")){
            imgNewMembership.imageProperty().set(new Image("/asset/gold.png"));
            lblPriceMembership.setText("1000.00");
        }
        if (memberCategoryCmbbx.getValue().equals("Platinum")){
            imgNewMembership.imageProperty().set(new Image("/asset/Platinum-Membership+(1).png"));
            lblPriceMembership.setText("1200.00");
        }

    }
}
