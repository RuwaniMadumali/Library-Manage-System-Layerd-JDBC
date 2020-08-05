package controller;

import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Member;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;

public class SearchMemberController {

    public Button btnHomeMenu;
    public Button btnAddMember;
    public AnchorPane root;
    public TableView<Member> tableView;




    public void initialize() {
        tableView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tableView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("name"));
        tableView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tableView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("email"));
        tableView.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tableView.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tableView.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("category"));
        tableView.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("expDate"));
        tableView.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("button"));

        ObservableList<Member> members = tableView.getItems();
//        java.awt.Button btnDelete =new java.awt.Button("Delete");


        members.add(new Member("Mem0001", "916690185v", "Ruwani Madumali", "Kaluwadumulla,Ambalangoda", "asd@gmail.com", "Female", "07130775", "Silver", null,new java.awt.Button("Delete")));

    }

    public void navigateToHome(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/HomePage.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void navigateToAddMember(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/AddNewMemberForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }
}
