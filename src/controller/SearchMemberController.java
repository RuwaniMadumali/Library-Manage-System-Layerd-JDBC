package controller;


import bussiness.BOFactory;
import bussiness.BOType;
import bussiness.BookSearchType;
import bussiness.MemberSearchType;
import bussiness.custom.MemberBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.BookT;
import util.Member;
import util.MemberTM;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class SearchMemberController implements Initializable {

    public Button btnHomeMenu;
    public Button btnAddMember;
    public AnchorPane root;
    public TableView<Member> tableView;
    public JFXButton btnSeearchAll;
    public JFXButton btnSearch;
    public RadioButton rbtnMemberID;
    public ToggleGroup SearchType;
    public RadioButton rbtnMemberNIC;
    public RadioButton rbtnMemberName;
    public JFXTextField txtmemberID;
    public JFXTextField txtmemberNIC;
    public JFXTextField txtmemberName;
    public Member selecteditem;

    private MemberBO memberBO= BOFactory.getInstance().getBO(BOType.MEMBER);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearallfields();
        tableView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tableView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("name"));
        tableView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tableView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("email"));
        tableView.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tableView.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tableView.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("category"));
        tableView.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("expDate"));
        tableView.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("deleteButton"));
        tableView.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("updateButton"));

        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Member>() {
            @Override
            public void changed(ObservableValue<? extends Member> observable, Member oldValue, Member selectedMember) {
                 selecteditem = selectedMember;
                System.out.println("Selected in Initialize - "+selecteditem);
            }
        });

    }

    public void loadAllMembers(){
        List<Member> members = tableView.getItems();
        members.clear();
        List<Member> memberdb;
        try {
            memberdb=memberBO.getfewMemberDetails();
            for (Member member:memberdb) {
                JFXButton btnDelete = new JFXButton("   Delete  ");
                btnDelete.setStyle("-fx-background-color: #79d1f4 ;-fx-background-radius: 20px; -fx-padding: 5px"
                );
                JFXButton btnUpdate = new JFXButton("  Update  ");
                btnUpdate.setStyle("-fx-background-color: #7eda67 ;-fx-background-radius: 20px; -fx-padding: 5px"
                );

                Member memberdb1=new Member(member.getId(),member.getNic(),member.getName(),member.getAddress(),member.getEmail(),member.getGender(),member.getContactNo(),member.getCategory(),member.getExpDate(),btnDelete,btnUpdate);
                tableView.getItems().add(memberdb1);

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
                                boolean deleteMember = memberBO.deleteMember(memberdb1.getId());
                                if (deleteMember==true){
                                    new Alert(Alert.AlertType.INFORMATION, "Successfully Deteted",ButtonType.OK).show();
                                    tableView.getItems().remove(memberdb1);
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
                        Member bookTpassValue=memberdb1;
                        URL resource = this.getClass().getResource("/view/AddNewMemberForm.fxml");
                        Parent root = null;
                        System.out.println(a);
                        FXMLLoader fxmlLoader = new FXMLLoader(resource);
                        try {
                            root = fxmlLoader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene scene = new Scene(root);

                        AddNewMemberController addNewMemberController=fxmlLoader.getController();
                        System.out.println(selecteditem);
                        try {
                            addNewMemberController.setMember(selecteditem);
                        }catch (NullPointerException e){
                            System.out.println("No data found");
                        }

                        Stage primaryStage = (Stage) (((Node)event.getSource()).getScene().getWindow());
                        primaryStage.setScene(scene);
                        primaryStage.centerOnScreen();
                    }
                });
            }
        }catch (NullPointerException e) {
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

    public void navigateToAddMember(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/AddNewMemberForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void searchAllAction(ActionEvent actionEvent) {
        btnSearch.setDisable(true);
        SearchType.selectToggle(null);
        loadAllMembers();
        clearallfields();
    }

    private void clearallfields() {
        txtmemberID.clear();
        txtmemberNIC.clear();
        txtmemberName.clear();
        SearchType.selectToggle(null);
        txtmemberID.setDisable(true);
        txtmemberNIC.setDisable(true);
        txtmemberName.setDisable(true);
        btnSearch.setDisable(true);
    }

    public void searchAction(ActionEvent actionEvent) {
        if (rbtnMemberID.isSelected() && txtmemberID.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING, "Empty value.Please enter Member ID", ButtonType.OK).show();
        }
        else if(rbtnMemberNIC.isSelected() && txtmemberNIC.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING, "Empty value.Please enter Member NIC", ButtonType.OK).show();
        }
        else if(rbtnMemberName.isSelected() && txtmemberName.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING, "Empty value.Please enter Member Name", ButtonType.OK).show();
        }
        else {

            RadioButton radioButton=(RadioButton)SearchType.getSelectedToggle();
            if (radioButton.getText().equals("Member ID : ")) loadMember(MemberSearchType.MEMBER_ID,txtmemberID.getText());
            if (radioButton.getText().equals("Member NIC : ")) loadMember(MemberSearchType.MEMBER_NIC,txtmemberNIC.getText());
            if (radioButton.getText().equals("Member Name : ")) loadMember(MemberSearchType.MEMBER_NAME,txtmemberName.getText());

        }
        clearallfields();
    }

    public void loadMember(MemberSearchType memberSearchType,String value){
        ObservableList<Member> members = tableView.getItems();
        members.clear();
        try {
            JFXButton btnDelete = new JFXButton("     Delete     ");
            btnDelete.setStyle("-fx-background-color: #79d1f4 ;-fx-background-radius: 20px; -fx-padding: 5px"
            );
            JFXButton btnUpdate = new JFXButton("    Update    ");
            btnUpdate.setStyle("-fx-background-color: #7eda67 ;-fx-background-radius: 20px; -fx-padding: 5px"
            );

            Member member =memberBO.getSingleMemberByAll(memberSearchType,value);
            Member memberdb=new Member(
                    member.getId(),
                    member.getNic(),
                    member.getName(),
                    member.getAddress(),
                    member.getEmail(),
                    member.getGender(),
                    member.getContactNo(),
                    member.getCategory(),
                    member.getExpDate(),
                    btnDelete,
                    btnUpdate
            );

            tableView.getItems().add(memberdb);
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
                            boolean deleteBook = memberBO.deleteMember(memberdb.getId());
                            if (deleteBook==true){
                                new Alert(Alert.AlertType.INFORMATION, "Successfully Deteted",ButtonType.OK).show();
                                tableView.getItems().remove(memberdb);
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
                    Member bookTpassValue=memberdb;
                    URL resource = this.getClass().getResource("/view/AddNewMemberForm.fxml");
                    Parent root = null;

                    FXMLLoader fxmlLoader = new FXMLLoader(resource);
                    try {
                        root = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);

                    AddNewMemberController addNewMemberController=fxmlLoader.getController();
                    System.out.println(selecteditem);
                    try {
                        addNewMemberController.setMember(selecteditem);
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

    public void rbtnClickMemberIdAction(ActionEvent actionEvent) {
        if(rbtnMemberID.isSelected()) {
            btnSearch.setDisable(false);
            txtmemberID.setDisable(false);
            txtmemberName.setDisable(true);
            txtmemberNIC.setDisable(true);
            tableView.getItems().clear();
        }
    }

    public void rbtnClickMemberNICAction(ActionEvent actionEvent) {
        if(rbtnMemberNIC.isSelected()) {
            btnSearch.setDisable(false);
            txtmemberNIC.setDisable(false);
            txtmemberName.setDisable(true);
            txtmemberID.setDisable(true);
            tableView.getItems().clear();
        }
    }

    public void rbtnClickMemberNameAction(ActionEvent actionEvent) {
        if(rbtnMemberName.isSelected()) {
            btnSearch.setDisable(false);
            txtmemberName.setDisable(false);
            txtmemberNIC.setDisable(true);
            txtmemberID.setDisable(true);
            tableView.getItems().clear();
        }
    }
}
