package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HomeFormController {
    public AnchorPane root;
    public Button btnAddMember;
    public Button btnSearchMember;
    public Button btnAddBook;
    public Button btnSearchBook;
    public Button btnIssueAndReturn;

    public void navigateToAddMember(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/AddNewMemberForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void navigateToSearchMember(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/SearchMemberForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void navigateToAddBook(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/AddNewBookForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void navigateToSearchBook(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/SearchBookForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void navigateToIssueAndReturn(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/IssueAndReturnBooks.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }
}
