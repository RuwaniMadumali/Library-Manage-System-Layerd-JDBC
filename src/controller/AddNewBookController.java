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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;


public class AddNewBookController {


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

    private BookBO bookBO= BOFactory.getInstance().getBO(BOType.BOOK);

    ObservableList<String> memberCategoryList = FXCollections.observableArrayList("Free","Bronze","Silver","Gold","Platinum");
    SpinnerValueFactory<Integer> svf =new SpinnerValueFactory.IntegerSpinnerValueFactory(1,5000,initValue);

    public void initialize(){
        //Generate New Book ID
        try {
            lblBookID.setText(bookBO.getNewBookID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        spnrNoOfPage.setValueFactory(svf);
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

        if (btnSave.getText().equals("Save")){
            boolean result = false;


            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR_OF_DAY, 0);

            String x=(String) memberCategoryCmbbx.getValue();


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

    }
}
