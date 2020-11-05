package controller;

import bussiness.BOFactory;
import bussiness.BOType;
import bussiness.custom.MemberBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Member;
import util.MemberTM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;

public class MembershipUpdationController {
    public AnchorPane root;
    public JFXComboBox memberCategoryCmbbx;
    public Button btnSearchMember;
    public Button btnHomeMenu;
    public ImageView imgNewMembership;
    public Label lblPriceMembership;
    public JFXButton btnUpdateMembership;
    public Label lblMemberID;
    public Label lblMemberNic;
    public Label lblmemnerName;
    public ImageView imgCurrentCategory;
    public Label lblexpDate;
    public String mexpDate;

    ObservableList<String> memberCategoryList = FXCollections.observableArrayList("Free","Bronze","Silver","Gold","Platinum");

    private MemberBO memberBO= BOFactory.getInstance().getBO(BOType.MEMBER);

    public void initialize(){
        //memberCategoryCmbbx.setValue("Default");
        memberCategoryCmbbx.setItems(memberCategoryList);
        imgNewMembership.imageProperty().set(null);
        lblPriceMembership.setText("00.00");

    }

    public void updateMember(Member member){
        lblMemberID.setText(member.getId());
        lblMemberNic.setText(member.getNic());
        lblmemnerName.setText(member.getName());
        lblexpDate.setText(new SimpleDateFormat("dd MMMM yyyy").format(member.getExpDate()));

        String currentmembership=member.getCategory();

        if (currentmembership.equals("Free")){
            imgCurrentCategory.imageProperty().set(new Image("/asset/free-membership.png"));
        }
        if (currentmembership.equals("Bronze")){
            imgCurrentCategory.imageProperty().set(new Image("/asset/bronze.png"));
        }
        if (currentmembership.equals("Silver")){
            imgCurrentCategory.imageProperty().set(new Image("/asset/silver.png"));
        }
        if (currentmembership.equals("Gold")){
            imgCurrentCategory.imageProperty().set(new Image("/asset/gold.png"));
        }
        if (currentmembership.equals("Platinum")){
            imgCurrentCategory.imageProperty().set(new Image("/asset/Platinum-Membership+(1).png"));
        }

        imgNewMembership.setVisible(false);
        memberCategoryCmbbx.getSelectionModel().clearSelection();
        lblPriceMembership.setText("00.00");

    }

    public void setDate(){

        Calendar cal= Calendar.getInstance();
        int year =(cal.get(Calendar.YEAR));
        int month=cal.get(Calendar.MONTH)+1;
        int day=cal.get(Calendar.DATE);

        year=year+1;

        Formatter fmt = new Formatter();
        lblexpDate.setText(day+" - "+fmt.format("%tB ", cal)+" - "+year);
        mexpDate=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);

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
        if(memberCategoryCmbbx.getSelectionModel().isEmpty()){
            imgNewMembership.setVisible(false);
        }

        if (memberCategoryCmbbx.getValue().equals("Free")){
            imgNewMembership.imageProperty().set(new Image("/asset/free-membership.png"));
            lblPriceMembership.setText("00.00");
            imgNewMembership.setVisible(true);
            setDate();
        }
        if (memberCategoryCmbbx.getValue().equals("Bronze")){
            imgNewMembership.imageProperty().set(new Image("/asset/bronze.png"));
            lblPriceMembership.setText("300.00");
            imgNewMembership.setVisible(true);
            setDate();
        }
        if (memberCategoryCmbbx.getValue().equals("Silver")){
            imgNewMembership.imageProperty().set(new Image("/asset/silver.png"));
            lblPriceMembership.setText("500.00");
            imgNewMembership.setVisible(true);
            setDate();
        }
        if (memberCategoryCmbbx.getValue().equals("Gold")){
            imgNewMembership.imageProperty().set(new Image("/asset/gold.png"));
            lblPriceMembership.setText("1000.00");
            imgNewMembership.setVisible(true);
            setDate();
        }
        if (memberCategoryCmbbx.getValue().equals("Platinum")){
            imgNewMembership.imageProperty().set(new Image("/asset/Platinum-Membership+(1).png"));
            lblPriceMembership.setText("1200.00");
            imgNewMembership.setVisible(true);
            setDate();
        }

    }

    public void updateMembershipOnAction(ActionEvent actionEvent) {

        boolean result = false;
        String selectedval=(String) memberCategoryCmbbx.getValue();
        try {
            result = memberBO.updateCategory(lblMemberID.getText(),
                    (String) memberCategoryCmbbx.getValue(),Date.valueOf(mexpDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!result){
            new Alert(Alert.AlertType.ERROR, "Failed to update the Member Category ", ButtonType.OK).show();
        }
        if (result){
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully Update Member Category", ButtonType.OK).show();

            if (selectedval.equals("Free")){
                imgCurrentCategory.imageProperty().set(new Image("/asset/free-membership.png"));
            }
            if (selectedval.equals("Bronze")){
                imgCurrentCategory.imageProperty().set(new Image("/asset/bronze.png"));
            }
            if (selectedval.equals("Silver")){
                imgCurrentCategory.imageProperty().set(new Image("/asset/silver.png"));
            }
            if (selectedval.equals("Gold")){
                imgCurrentCategory.imageProperty().set(new Image("/asset/gold.png"));
            }
            if (selectedval.equals("Platinum")){
                imgCurrentCategory.imageProperty().set(new Image("/asset/Platinum-Membership+(1).png"));
            }


        }
        imgNewMembership.setVisible(false);
        //lblPriceMembership.setText("00.00");
        //memberCategoryCmbbx.getSelectionModel().clearSelection();


    }
}
