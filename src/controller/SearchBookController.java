package controller;

import bussiness.BOFactory;
import bussiness.BOType;
import bussiness.custom.BookBO;
import bussiness.custom.impl.BookBOImpl;
import dao.custom.BookDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.BookTM;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchBookController {

    public Button btnHomeMenu;
    public Button btnAddMember;
    public AnchorPane root;
    public TableView<BookTM> tableView;

    private BookBO bookBO= BOFactory.getInstance().getBO(BOType.BOOK);


    public void initialize(){
      tableView.getColumns().get(0).setCellFactory(new PropertyValueFactory<>("bookID"));
      tableView.getColumns().get(1).setCellFactory(new PropertyValueFactory<>("bCategoryID"));
      tableView.getColumns().get(2).setCellFactory(new PropertyValueFactory<>("bName"));
      tableView.getColumns().get(3).setCellFactory(new PropertyValueFactory<>("bAuthor"));
      tableView.getColumns().get(4).setCellFactory(new PropertyValueFactory<>("bEdition"));
      tableView.getColumns().get(5).setCellFactory(new PropertyValueFactory<>("bPrice"));
      tableView.getColumns().get(6).setCellFactory(new PropertyValueFactory<>("bNoOfPages"));
      tableView.getColumns().get(6).setCellFactory(new PropertyValueFactory<>("bDescription"));

        loadAllCustomers();

    }

    private void loadAllCustomers() {
        ObservableList<BookTM> books = tableView.getItems();
        books.clear();
        try {
            books = FXCollections.observableArrayList(bookBO.getAllBooks());
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableView.setItems(books);
    }

    public void navigateToHome(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/HomePage.fxml");
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
}
