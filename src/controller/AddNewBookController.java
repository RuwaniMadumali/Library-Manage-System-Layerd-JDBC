package controller;

import bussiness.BOFactory;
import bussiness.BOType;
import bussiness.custom.BookBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.regexp.*;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import util.BookT;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;


public class AddNewBookController implements Initializable {


    public Button btnHomeMenu;
    public AnchorPane root;
    public Spinner<Integer> spnrNoOfPage;

    final  int initValue=100;
    public JFXButton btnAddNewBook;
    public Label lblBookID;
    public JFXComboBox memberCategoryCmbbx;
    public JFXTextField txtBookTitle;
    public JFXTextField txtEdition;
    public JFXTextField txtPrice;
    public JFXTextField txtAuthor;
    public JFXTextArea txtDescription;
    public JFXButton btnSave;
    public Label errorBookCategory;
    public Label errorBookTitle;
    public Label errorBookAuthor;
    public Label errorBookEdition;
    public Label errorBookNoOfPages;
    public Label errorBookPrice;
    public JFXButton btnReset;

    private BookBO bookBO= BOFactory.getInstance().getBO(BOType.BOOK);

    ObservableList<String> memberCategoryList = FXCollections.observableArrayList("Adventure","Art","Cooking","Dystopian","Fantasy","Guide","Health","Historical","History","Horror","Humor","Memoir","Mystery","Novels","Paranormal","Romance","Science","Self-help","Thriller","Travel");
    SpinnerValueFactory<Integer> svf =new SpinnerValueFactory.IntegerSpinnerValueFactory(1,5000,initValue);

    public void initialize(URL url, ResourceBundle resourceBundle){
        //Generate New Book ID
        try {
            lblBookID.setText(bookBO.getNewBookID());
        } catch (Exception e) {
            e.printStackTrace();
        }

        spnrNoOfPage.setValueFactory(svf);
        memberCategoryCmbbx.setItems(memberCategoryList);
        removeErrors();
    }
    public void setBook(BookT bookT){
        lblBookID.setText(bookT.getBookID());
        String comboValue=bookT.getBcategoryID();
        memberCategoryCmbbx.getSelectionModel().select(comboValue);
        txtBookTitle.setText(bookT.getBname());
        txtAuthor.setText(bookT.getBauthor());
        txtEdition.setText(bookT.getBedition());
        spnrNoOfPage.getValueFactory().setValue(bookT.getBnoofPages());
        txtPrice.setText(String.valueOf(bookT.getBprice()));
        txtDescription.setText(bookT.getBbscription());
        btnSave.setText("Update");
    }

    public void resetAll(){
        memberCategoryCmbbx.getSelectionModel().clearSelection();
        txtBookTitle.clear();
        txtAuthor.clear();
        txtEdition.clear();
        spnrNoOfPage.getValueFactory().setValue(100);
        txtPrice.clear();
        txtDescription.clear();
        removeErrors();

    }
    public void removeErrors(){
        errorBookCategory.setVisible(false);
        errorBookAuthor.setVisible(false);
        errorBookTitle.setVisible(false);
        errorBookEdition.setVisible(false);
        errorBookNoOfPages.setVisible(false);
        errorBookPrice.setVisible(false);
    }


    public void navigateToHome(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/HomePage.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void btnAddNew_OnAction(ActionEvent actionEvent) {
        spnrNoOfPage.setValueFactory(svf);
        memberCategoryCmbbx.setValue(null);
        txtBookTitle.clear();
        txtAuthor.clear();
        txtEdition.clear();
        txtPrice.clear();
        txtDescription.clear();
        spnrNoOfPage.getValueFactory().setValue(100);

        //Generate new book ID
        try {
            lblBookID.setText(bookBO.getNewBookID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSaveAction(ActionEvent actionEvent) {
            boolean result = false;
            boolean errors = false;


            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR_OF_DAY, 0);

            String x=(String) memberCategoryCmbbx.getValue();

            removeErrors();

            if (x==null){
                errorBookCategory.setVisible(true);
                errors=true;
            }
            if (txtBookTitle.getText().isEmpty()){
                errorBookTitle.setVisible(true);
                errors=true;
            }
            if (txtAuthor.getText().isEmpty()){
                errorBookAuthor.setVisible(true);
                errors=true;
            }
            if (txtEdition.getText().isEmpty()){
                errorBookEdition.setVisible(true);
                errors=true;
            }

            if (txtPrice.getText().isEmpty()){
                errorBookPrice.setVisible(true);
                errorBookPrice.setText("Price can not be empty");
                errors=true;
            }
            if(!txtPrice.getText().matches("^(?!0*\\.0+$)\\d*(?:\\.\\d+)?$")){
                errorBookPrice.setVisible(true);
                errorBookPrice.setText("Price can contains only numbers");
                errors=true;
            }
            if ( errors==false ){

                if (btnSave.getText().equals("Save")){
                    try {
                        result = bookBO.saveBook(lblBookID.getText(),
                                (String) memberCategoryCmbbx.getValue(),
                                txtBookTitle.getText(),
                                txtDescription.getText(),
                                txtEdition.getText(),
                                txtAuthor.getText(),
                                ((Integer)spnrNoOfPage.getValue()).intValue(),
                                Double.parseDouble(txtPrice.getText()),
                                null,
                                Date.valueOf("2020-8-04")
                        );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!result){
                        new Alert(Alert.AlertType.ERROR, "Failed to save the Book ", ButtonType.OK).show();
                    }

                    btnAddNew_OnAction(actionEvent);
                    new Alert(Alert.AlertType.CONFIRMATION, "Successfully Saved", ButtonType.OK).show();

                }
                if (btnSave.getText().equals("Update")){
                    try {
                        result = bookBO.updateBook(
                                (String) memberCategoryCmbbx.getValue(),
                                txtBookTitle.getText(),
                                txtDescription.getText(),
                                txtEdition.getText(),
                                txtAuthor.getText(),
                                ((Integer)spnrNoOfPage.getValue()).intValue(),
                                Double.parseDouble(txtPrice.getText()),
                                null,
                                Date.valueOf("2020-8-04"),
                                lblBookID.getText()
                        );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!result){
                        new Alert(Alert.AlertType.ERROR, "Failed to update the Book ", ButtonType.OK).show();
                    }
                    if (result){
                        btnAddNew_OnAction(actionEvent);
                        new Alert(Alert.AlertType.CONFIRMATION, "Successfully Updated", ButtonType.OK).show();
                    }
                }
            }
    }

    public void btnResetAction(ActionEvent actionEvent) {
        resetAll();
    }
}
