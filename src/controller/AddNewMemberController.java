package controller;

import bussiness.BOFactory;
import bussiness.BOType;
import bussiness.custom.BookBO;
import bussiness.custom.MemberBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.BookT;
import util.Member;
import util.MemberTM;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.ResourceBundle;

public class AddNewMemberController implements Initializable {

    public Button btnHomeMenu;
    public AnchorPane root;

    public Label lblMemberDuration;
    public Label lblexpdate;
    public JFXButton btnSaveAndUpdate;
    public JFXButton btnSave;
    public JFXButton btnCancel;
    public JFXTextField txtMemberContactNo;
    public JFXTextField txtMemberNIC;
    public ToggleGroup gender;
    public JFXTextField txtMemberEmail;
    public JFXTextField txtMemberName;
    public JFXTextArea txtMemberAddress;
    public Label lblmemberID;
    public Label errorMemberName;
    public Label errorMemberNIC;
    public Label errorMemberAddress;
    public ImageView imgmemberCategory;
    public RadioButton rbtnMale;
    public RadioButton rbtnFemale;
    public Label lblcategory;
    public Label lblhead;
    public String mexpDate;
    public String maddDate;
    public String existAddDate;
    public String existExpDate;
    public String mID;


    private MemberBO memberBO= BOFactory.getInstance().getBO(BOType.MEMBER);
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            lblmemberID.setText(memberBO.getNewMemberID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setExpDate(1);
        removeErrors();
    }

    public void removeErrors(){
        errorMemberName.setVisible(false);
        errorMemberNIC.setVisible(false);
        errorMemberAddress.setVisible(false);
    }

    public void btnAddNew_OnAction(ActionEvent actionEvent) {
        txtMemberName.clear();
        txtMemberNIC.clear();
        txtMemberAddress.clear();
        txtMemberEmail.clear();
        txtMemberContactNo.clear();
        //Generate new book ID
        try {
            lblmemberID.setText(memberBO.getNewMemberID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMember(Member member)  {

        lblhead.setText("Update Member");
        removeErrors();
        mID=member.getId();

        existExpDate=new SimpleDateFormat("yyyy-MM-dd").format(member.getExpDate());

        System.out.println("exsist add date : "+existAddDate);
        System.out.println("exsist exp date : "+existExpDate);
        lblmemberID.setText(mID);
        String existMemberCategory = member.getCategory();
        if (existMemberCategory.equals("Free")){
            imgmemberCategory.imageProperty().set(new Image("/asset/free-membership.png"));
            lblcategory.setText("Free");
            lblMemberDuration.setText("1 Day");
        }
        if (existMemberCategory.equals("Bronze")){
            imgmemberCategory.imageProperty().set(new Image("/asset/bronze.png"));
            lblcategory.setText("Bronze");
            lblMemberDuration.setText("1 year");
        }
        if (existMemberCategory.equals("Silver")){
            imgmemberCategory.imageProperty().set(new Image("/asset/silver.png"));
            lblcategory.setText("Silver");
            lblMemberDuration.setText("1 year");
        }
        if (existMemberCategory.equals("Gold")){
            imgmemberCategory.imageProperty().set(new Image("/asset/gold.png"));
            lblcategory.setText("Gold");
            lblMemberDuration.setText("1 year");
        }
        if (existMemberCategory.equals("Platinum")){
            imgmemberCategory.imageProperty().set(new Image("/asset/Platinum-Membership+(1).png"));
            lblcategory.setText("Platinum");
            lblMemberDuration.setText("1 year");
        }
        txtMemberName.setText(member.getName());
        txtMemberNIC.setText(member.getNic());
        txtMemberAddress.setText(member.getAddress());
        String existGender=member.getGender();

        if(existGender.equals("Male")){
          rbtnMale.setSelected(true);
        }
        if(existGender.equals("Female")){
            rbtnFemale.setSelected(true);
        }
        txtMemberEmail.setText(member.getEmail());
        txtMemberContactNo.setText(member.getContactNo());
        lblexpdate.setText(new SimpleDateFormat("dd MMMM yyyy").format(member.getExpDate()));
        btnSave.setText("Update");


    }

    public void setExpDate(int duration){
        Calendar cal= Calendar.getInstance();
         int year =(cal.get(Calendar.YEAR));
       int month=cal.get(Calendar.MONTH)+1;
        int date=cal.get(Calendar.DATE);
        if (duration==1){
            date=date+1;
        }
        if (duration==2){
            year=year+1;
        }

        Formatter fmt = new Formatter();
        lblexpdate.setText(date+" - "+fmt.format("%tB ", cal)+" - "+year);

        mexpDate=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(date);
        maddDate=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(date-1);


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
        removeErrors();
        boolean result = false;
        boolean errors = false;


        RadioButton selectedRadioButton = (RadioButton) gender.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();

        if (txtMemberName.getText().isEmpty()){
            errorMemberName.setVisible(true);
            errors=true;
        }
        if (txtMemberNIC.getText().isEmpty()){
            errorMemberNIC.setVisible(true);
            errors=true;
        }
        if (txtMemberAddress.getText().isEmpty()){
            errorMemberAddress.setVisible(true);
            errors=true;
        }
        if ( errors==false ){


            if (btnSave.getText().equals("Save")){
                Member membertopass=new Member( lblmemberID.getText(),
                        txtMemberNIC.getText(),
                        txtMemberName.getText(),
                        txtMemberAddress.getText(),
                        txtMemberEmail.getText(),
                        toogleGroupValue,
                        txtMemberContactNo.getText(),
                        lblcategory.getText(),
                        Date.valueOf(mexpDate)
                );
                try {
                    result = memberBO.saveMember(lblmemberID.getText(),
                            txtMemberNIC.getText(),
                            txtMemberName.getText(),
                            lblcategory.getText(),
                            txtMemberAddress.getText(),
                            txtMemberEmail.getText(),
                            toogleGroupValue,
                            txtMemberContactNo.getText(),
                            Date.valueOf(maddDate),
                            Date.valueOf(mexpDate)
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!result){
                    new Alert(Alert.AlertType.ERROR, "Failed to save the Member Details ", ButtonType.OK).show();
                }
                if (result){
                    if (result){
                        Member memberpassValue=membertopass;
                        URL resource = this.getClass().getResource("/view/MembershipUpdationForm.fxml");
                        Parent root = null;
                        FXMLLoader fxmlLoader = new FXMLLoader(resource);
                        try {
                            root = fxmlLoader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene scene = new Scene(root);
                        MembershipUpdationController membershipUpdationController =fxmlLoader.getController();

                        try {
                            membershipUpdationController.updateMember(memberpassValue);
                        }catch (NullPointerException e){
                            System.out.println("No data found");
                        }

                        Stage primaryStage = (Stage) (((Node)actionEvent.getSource()).getScene().getWindow());
                        primaryStage.setScene(scene);
                        primaryStage.centerOnScreen();
                    }
                }

            }
            if (btnSave.getText().equals("Update")){
                Member membertopass=new Member( lblmemberID.getText(), txtMemberNIC.getText(), txtMemberName.getText(), txtMemberAddress.getText(), txtMemberEmail.getText(), toogleGroupValue, txtMemberContactNo.getText(), lblcategory.getText(), Date.valueOf(existExpDate)
                );
                try {
                    result = memberBO.updateMemberWithoutAddDate(
                            txtMemberNIC.getText(),
                            txtMemberName.getText(),
                            lblcategory.getText(),
                            txtMemberAddress.getText(),
                            txtMemberEmail.getText(),
                            toogleGroupValue,
                            txtMemberContactNo.getText(),
                            Date.valueOf(existExpDate),
                            lblmemberID.getText()

                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!result){
                    new Alert(Alert.AlertType.ERROR, "Failed to update the Book ", ButtonType.OK).show();
                }
                if (result){
                    Member memberpassValue=membertopass;
                    URL resource = this.getClass().getResource("/view/MembershipUpdationForm.fxml");
                    Parent root = null;
                    FXMLLoader fxmlLoader = new FXMLLoader(resource);
                    try {
                        root = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    MembershipUpdationController membershipUpdationController =fxmlLoader.getController();

                    try {
                        membershipUpdationController.updateMember(memberpassValue);
                    }catch (NullPointerException e){
                        System.out.println("No data found");
                    }

                    Stage primaryStage = (Stage) (((Node)actionEvent.getSource()).getScene().getWindow());
                    primaryStage.setScene(scene);
                    primaryStage.centerOnScreen();
                  }
            }
        }

    }

    public void btnSaveAction(ActionEvent actionEvent) {

        removeErrors();
        boolean result = false;
        boolean errors = false;

        if (txtMemberName.getText().isEmpty()){
            errorMemberName.setVisible(true);
            errors=true;
        }
        if (txtMemberNIC.getText().isEmpty()){
            errorMemberNIC.setVisible(true);
            errors=true;
        }
        if (txtMemberAddress.getText().isEmpty()){
            errorMemberAddress.setVisible(true);
            errors=true;
        }


        if ( errors==false ){

            RadioButton selectedRadioButton = (RadioButton) gender.getSelectedToggle();
            String toogleGroupValue = selectedRadioButton.getText();
            System.out.println(existAddDate);
            System.out.println(existExpDate);

            if (btnSave.getText().equals("Save")){
                try {
                    result = memberBO.saveMember(lblmemberID.getText(),
                            txtMemberNIC.getText(),
                            txtMemberName.getText(),
                            lblcategory.getText(),
                            txtMemberAddress.getText(),
                            txtMemberEmail.getText(),
                            toogleGroupValue,
                            txtMemberContactNo.getText(),
                            Date.valueOf(maddDate),
                            Date.valueOf(mexpDate)
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!result){
                    new Alert(Alert.AlertType.ERROR, "Failed to save the Member Details ", ButtonType.OK).show();
                }
                if (result){
                    btnAddNew_OnAction(actionEvent);
                    new Alert(Alert.AlertType.CONFIRMATION, "Successfully Saved", ButtonType.OK).show();
                }

            }
            if (btnSave.getText().equals("Update")){
                try {
                    result = memberBO.updateMemberWithoutAddDate(
                            txtMemberNIC.getText(),
                            txtMemberName.getText(),
                            lblcategory.getText(),
                            txtMemberAddress.getText(),
                            txtMemberEmail.getText(),
                            toogleGroupValue,
                            txtMemberContactNo.getText(),
                            Date.valueOf(existExpDate),
                            lblmemberID.getText()

                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!result){
                    new Alert(Alert.AlertType.ERROR, "Failed to update the Member Details ", ButtonType.OK).show();
                }
                if (result){
                    btnAddNew_OnAction(actionEvent);
                    new Alert(Alert.AlertType.CONFIRMATION, "Successfully Updated", ButtonType.OK).show();
                }
            }
        }

    }


}

