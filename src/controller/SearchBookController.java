package controller;

import bussiness.BOFactory;
import bussiness.BOType;
import bussiness.BookSearchType;
import bussiness.custom.BookBO;
import bussiness.custom.impl.BookBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.custom.BookDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.BookT;
import util.BookTM;



import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class SearchBookController implements Initializable {

    public Button btnHomeMenu;
    public Button btnAddMember;
    public AnchorPane root;
    public TableView<BookT> tableView;
    public TableColumn<BookT,String> columnID;
    public TableColumn<BookT,String> columnCategory;
    public ToggleGroup SearchType;
    public JFXTextField txtbookID;
    public JFXTextField txtbookTitle;
    public JFXTextField txtauthor;
    public JFXComboBox memberCategoryCmbbx;
    public RadioButton rbtnBookID;
    public RadioButton rbtnBookTitle;
    public RadioButton rbtnAuthor;
    public RadioButton rbtnBookCategory;
    public JFXButton btnSearch;
    public JFXButton btnSearchAll;
    public  BookT selecteditem;

    private BookBO bookBO= BOFactory.getInstance().getBO(BOType.BOOK);

    ObservableList<String> memberCategoryList = FXCollections.observableArrayList("Adventure","Art","Cooking","Dystopian","Fantasy","Guide","Health","Historical","History","Horror","Humor","Memoir","Mystery","Novels","Paranormal","Romance","Science","Self-help","Thriller","Travel");


    @Override
    public void initialize(URL location, ResourceBundle resources){
        memberCategoryCmbbx.setItems(memberCategoryList);
        clearallfields();
        tableView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bookID"));
        tableView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("bcategoryID"));
        tableView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("bname"));
        tableView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("bauthor"));
        tableView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("bedition"));
        tableView.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("bprice"));
        tableView.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("bnoofPages"));
        tableView.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("bbscription"));
        tableView.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));
        tableView.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("updateBtn"));

        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookT>() {
            @Override
            public void changed(ObservableValue<? extends BookT> observable, BookT oldValue, BookT selectedBook) {
                selecteditem=selectedBook;
                System.out.println(selecteditem);

            }
        });
    }

    private void clearallfields(){
        txtbookID.clear();
        txtbookTitle.clear();
        txtauthor.clear();
        memberCategoryCmbbx.getSelectionModel().clearSelection();
        SearchType.selectToggle(null);
        txtbookID.setDisable(true);
        txtbookTitle.setDisable(true);
        txtauthor.setDisable(true);
        memberCategoryCmbbx.setDisable(true);
        btnSearch.setDisable(true);
    }

    private void loadAllBooks() {
        List<BookT> books = tableView.getItems();
        books.clear();
        List<BookT> bookTS = new ArrayList<>();
        try {
            bookTS =bookBO.findfewAll();
            for (BookT book:bookTS) {
                JFXButton btnDelete = new JFXButton("     Delete     ");
                btnDelete.setStyle("-fx-background-color: #79d1f4 ;-fx-background-radius: 20px; -fx-padding: 5px"
                );
                JFXButton btnUpdate = new JFXButton("    Update    ");
                btnUpdate.setStyle("-fx-background-color: #7eda67 ;-fx-background-radius: 20px; -fx-padding: 5px"
                );

                BookT bookTS1=new BookT(book.getBookID(),book.getBcategoryID(), book.getBname(), book.getBauthor(), book.getBedition(), book.getBprice(), book.getBnoofPages(), book.getBbscription(),btnDelete,btnUpdate);
                tableView.getItems().add(bookTS1);

                btnDelete.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                        ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete this book", yes, cancel);

                        Optional<ButtonType> result = alert.showAndWait();
                        System.out.println(result);
                        if (result.orElse(yes) == yes) {
                            try {
                                boolean deleteBook = bookBO.deleteBook(bookTS1.getBookID());
                                if (deleteBook==true){
                                    new Alert(Alert.AlertType.INFORMATION, "Successfully Deteted",ButtonType.OK).show();
                                    tableView.getItems().remove(bookTS1);
                                }
                                else {
                                    new Alert(Alert.AlertType.ERROR, "Error occured",ButtonType.OK).show();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

                int a = 10;
                btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        BookT bookTpassValue=bookTS1;
                        URL resource = this.getClass().getResource("/view/AddNewBookForm.fxml");
                        Parent root = null;
                        FXMLLoader fxmlLoader = new FXMLLoader(resource);
                        try {
                            root = fxmlLoader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene scene = new Scene(root);
                        AddNewBookController addNewBookController =fxmlLoader.getController();
                        System.out.println(selecteditem);
                        try {
                            addNewBookController.setBook(selecteditem);
                        }catch (NullPointerException e){
                            System.out.println("No data found");
                        }

                        Stage primaryStage = (Stage) (((Node)event.getSource()).getScene().getWindow());
                        primaryStage.setScene(scene);
                        primaryStage.centerOnScreen();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBook(BookSearchType bookSearchType,String value){
        ObservableList<BookT> books = tableView.getItems();
        books.clear();
        try {
            JFXButton btnDelete = new JFXButton("     Delete     ");
            btnDelete.setStyle("-fx-background-color: #79d1f4 ;-fx-background-radius: 20px; -fx-padding: 5px"
            );
            JFXButton btnUpdate = new JFXButton("    Update    ");
            btnUpdate.setStyle("-fx-background-color: #7eda67 ;-fx-background-radius: 20px; -fx-padding: 5px"
            );

            BookT book =bookBO.getSingleBookByAll(bookSearchType,value);
            BookT bookT=new BookT(book.getBookID(),book.getBcategoryID(), book.getBname(), book.getBauthor(), book.getBedition(), book.getBprice(), book.getBnoofPages(), book.getBbscription(),btnDelete,btnUpdate);

            tableView.setItems((ObservableList<BookT>) bookT);
            btnDelete.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                    ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete this book", yes, cancel);

                    Optional<ButtonType> result = alert.showAndWait();
                    System.out.println(result);
                    if (result.orElse(yes) == yes) {
                        try {
                            boolean deleteBook = bookBO.deleteBook(bookT.getBookID());
                            if (deleteBook==true){
                                new Alert(Alert.AlertType.INFORMATION, "Successfully Deteted",ButtonType.OK).show();
                                tableView.getItems().remove(bookT);
                            }
                            else {
                                new Alert(Alert.AlertType.ERROR, "Error occured",ButtonType.OK).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            btnUpdate.setOnAction(new EventHandler<ActionEvent>() {


                @Override
                public void handle(ActionEvent event) {
                    tableView.getSelectionModel().clearSelection();
//                  Object row = tableView.getItems().get(event.);
                    BookT bookTpassValue=bookT;
                    URL resource = this.getClass().getResource("/view/AddNewBookForm.fxml");
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(resource);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    AddNewBookController addNewBookController =new FXMLLoader().getController();
                    System.out.println(selecteditem);
                    try {
                        addNewBookController.setBook(selecteditem);
                    }catch (NullPointerException e){
                        System.out.println("No data found");
                    }

                    Stage primaryStage = (Stage) (((Node)event.getSource()).getScene().getWindow());
                    primaryStage.setScene(scene);
                    primaryStage.centerOnScreen();
                }
            });



        } catch (NullPointerException e) {
            new Alert(Alert.AlertType.INFORMATION, "No any matching results", ButtonType.OK).show();
            clearallfields();
        }catch (Exception e) {
            e.printStackTrace();
        }


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

    public void resultDueToRadioSelection(){
        RadioButton selectedRadioButton= (RadioButton)SearchType.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();

    }

    
    public void rbtnClickBookIDAction(ActionEvent actionEvent) {
        if(rbtnBookID.isSelected()) {
            btnSearch.setDisable(false);
            txtbookID.setDisable(false);
            txtbookTitle.setDisable(true);
            txtauthor.setDisable(true);
            memberCategoryCmbbx.setDisable(true);
            tableView.getItems().clear();
        }

    }

    public void rbtnClickBookTitleAction(ActionEvent actionEvent) {
        if(rbtnBookTitle.isSelected()) {
            btnSearch.setDisable(false);
            txtbookTitle.setDisable(false);
            txtbookID.setDisable(true);
            txtauthor.setDisable(true);
            memberCategoryCmbbx.setDisable(true);
            tableView.getItems().clear();
        }
    }

    public void rbtnClickAuthorAction(ActionEvent actionEvent) {
        if(rbtnAuthor.isSelected()) {
            btnSearch.setDisable(false);
            txtauthor.setDisable(false);
            txtbookID.setDisable(true);
            txtbookTitle.setDisable(true);
            memberCategoryCmbbx.setDisable(true);
            tableView.getItems().clear();
        }
    }

    public void rbtnClickBookCategoryAction(ActionEvent actionEvent) {
        if(rbtnBookCategory.isSelected()) {
            btnSearch.setDisable(false);
            memberCategoryCmbbx.setDisable(false);
            txtauthor.setDisable(true);
            txtbookID.setDisable(true);
            txtbookTitle.setDisable(true);
            tableView.getItems().clear();
        }
    }

    public void searchAction(ActionEvent actionEvent) {
        if (rbtnBookID.isSelected() && txtbookID.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING, "Empty value.Please enter Book ID", ButtonType.OK).show();
        }
        else if(rbtnBookTitle.isSelected() && txtbookTitle.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING, "Empty value.Please enter Book Title", ButtonType.OK).show();
        }
        else if(rbtnAuthor.isSelected() && txtauthor.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING, "Empty value.Please enter Author Name", ButtonType.OK).show();
        }
        else if(rbtnBookCategory.isSelected() && memberCategoryCmbbx.getSelectionModel().isEmpty()){
            new Alert(Alert.AlertType.WARNING, "Empty value.Please select Book Category", ButtonType.OK).show();
        } else {

           RadioButton radioButton=(RadioButton)SearchType.getSelectedToggle();
            if (radioButton.getText().equals("Book ID")) loadBook(BookSearchType.BOOK_ID,txtbookID.getText());
            if (radioButton.getText().equals("Book Title")) loadBook(BookSearchType.BOOK_TITLE,txtbookTitle.getText());
            if (radioButton.getText().equals("Author")) loadBook(BookSearchType.BOOK_AUTHOR,txtauthor.getText());
           // if (radioButton.getId()=="rbtnBookCategory") {}
        }
        clearallfields();
    }

    public void searchAllAction(ActionEvent actionEvent) {
        btnSearch.setDisable(true);
        SearchType.selectToggle(null);
        loadAllBooks();
        clearallfields();

    }
}
