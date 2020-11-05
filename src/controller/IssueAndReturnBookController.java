package controller;

import bussiness.BOFactory;
import bussiness.BOType;
import bussiness.MemberSearchType;
import bussiness.custom.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import util.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class IssueAndReturnBookController  {

    public Button btnHomeMenu;
    public AnchorPane root;
    public JFXRadioButton rbtnMemberID;
    public JFXRadioButton rbtnBookID;
    public JFXTextField txtMemberID;
    public JFXTextField txtBookID;
    public ImageView imgNewMembership;
    public Label lblNoOfIssuedBooks;
    public Label lblMemberName;
    public Label lblLateFeeDue;
    public TableView<ReturnsTM> tblToReturns;
    public JFXButton btnPay;
    public JFXButton btnReturn;
    public JFXButton btnReissue;
    public JFXTextField txtToIssueBookID;
    public JFXButton btnIssueBooks;
    public JFXButton btnReset;
    public JFXButton btnCancel;
    public TableView<CustomTM2> tblToIssue;
    public JFXButton btnAddtolist;
    public JFXDatePicker dpicReturnDate;
    public ToggleGroup selection;
    public JFXButton btnSearch;
    public ObservableList<ReturnsTM> data;
    public List<CustomTM2> dataToIssue=new ArrayList<CustomTM2>();
    public ReturnsTM selecteditem;



    public List<ReturnsTM> selectedList=new ArrayList<ReturnsTM>();
    public Label lblIssueNewID;
    final  int initValue=7;
    public Spinner spnrNoOfDays;
    public Label lblMemberID;


    private MemberBO memberBO= BOFactory.getInstance().getBO(BOType.MEMBER);
    private IssueAndReturnsBO issueAndReturnsBO = BOFactory.getInstance().getBO(BOType.CUSTOM);
    private BookBO bookBO=BOFactory.getInstance().getBO(BOType.BOOK);

    SpinnerValueFactory<Integer> svf =new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5000,initValue);

    public void initialize(){

        clearallfields();

        tblToReturns.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        tblToReturns.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("issueNo"));
        tblToReturns.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("bookID"));
        tblToReturns.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        tblToReturns.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("lateFee"));


        tblToIssue.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("issueNo"));
        tblToIssue.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("bookID"));
        tblToIssue.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        tblToIssue.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("bookCategory"));
        tblToIssue.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("bookAuthoer"));
        tblToIssue.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("bookEdition"));
        tblToIssue.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        tblToIssue.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("btndelete"));

        //Generate New Issue ID
        try {
            lblIssueNewID.setText(issueAndReturnsBO.getNewIssueID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        spnrNoOfDays.setValueFactory(svf);
        setDatePickerValues();
        autosetDatePicker();
        tblToReturns.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ReturnsTM>() {
            @Override
            public void changed(ObservableValue<? extends ReturnsTM> observable, ReturnsTM oldValue, ReturnsTM selectedBook) {
                selecteditem=selectedBook;

            }
        });
    }

    private void clearallfields(){
        txtBookID.clear();
        txtMemberID.clear();
        lblLateFeeDue.setText("00.00");
        lblNoOfIssuedBooks.setText("00");
        lblMemberName.setVisible(false);
        imgNewMembership.setVisible(false);
        txtBookID.setDisable(true);
        txtMemberID.setDisable(true);
        btnPay.setDisable(true);
        btnReturn.setDisable(true);
        btnReissue.setDisable(true);
        btnAddtolist.setDisable(true);
        lblMemberID.setVisible(false);
    }

    public void sumOfLateFee(){
        List<Double> selectedfees = new ArrayList<>();
        Double sum=0.0;
        for (ReturnsTM val:selectedList) {
            selectedfees.add(val.getLateFee());
        }
        System.out.println(selectedfees);
        sum = selectedfees.stream().reduce(0.00, Double::sum);
        lblLateFeeDue.setText(String.valueOf(sum));
    }

    public void cleartable(){
        tblToReturns.getItems().clear();
    }

    public void reloadToReturnDetailsByBookID(String bookID){
        tblToReturns.getItems().clear();
        try {
            System.out.println("Second: "+bookID);
            CustomTM customTM=issueAndReturnsBO.getToReturnBooksByBookID(bookID);
            btnAddtolist.setDisable(false);
            lblMemberID.setText(customTM.getMemberID());
            lblMemberName.setText(customTM.getMemberName());
            lblMemberName.setVisible(true);

            if (customTM.getMemberType().equals("Free")){
                imgNewMembership.imageProperty().set(new Image("/asset/free-membership.png"));
                imgNewMembership.setVisible(true);
            }
            if (customTM.getMemberType().equals("Bronze")){
                imgNewMembership.imageProperty().set(new Image("/asset/bronze.png"));
                imgNewMembership.setVisible(true);
            }
            if (customTM.getMemberType().equals("Silver")){
                imgNewMembership.imageProperty().set(new Image("/asset/silver.png"));
                imgNewMembership.setVisible(true);
            }
            if (customTM.getMemberType().equals("Gold")){
                imgNewMembership.imageProperty().set(new Image("/asset/gold.png"));
                imgNewMembership.setVisible(true);
            }
            if (customTM.getMemberType().equals("Platinum")){
                imgNewMembership.imageProperty().set(new Image("/asset/Platinum-Membership+(1).png"));
                imgNewMembership.setVisible(true);
            }

            CheckBox checkBox = new CheckBox();
            ReturnsTM customtb= new ReturnsTM(checkBox,customTM.getIssueNo(),customTM.getBookID(),customTM.getBookTitle(),customTM.getLateFee());
            checkBox.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(customtb.getCheckBox().isSelected()) {
                        tblToReturns.getSelectionModel().select(customtb);
                        selectedList.add(customtb);
                        sumOfLateFee();
                        if (selectedList.size()>0 && Double.parseDouble(lblLateFeeDue.getText())>0.0){
                            btnPay.setDisable(false);
                        }
                    }
                    else {
                        selectedList.remove(customtb);
                        tblToReturns.getSelectionModel().clearSelection();
                        sumOfLateFee();
                        if (selectedList.isEmpty()||Double.parseDouble(lblLateFeeDue.getText())==0.0){
                            btnPay.setDisable(true);
                        }

                    }
                }
            });

            data= FXCollections.observableArrayList(customtb);
            if (data!=null){
                lblNoOfIssuedBooks.setText("1");
               // btnReturn.setDisable(false);
               // btnReissue.setDisable(false);
            }
            if (data.isEmpty()||data==null){
                lblNoOfIssuedBooks.setText("0");
                btnReturn.setDisable(true);
                btnReissue.setDisable(true);
            }

            tblToReturns.setItems(data);

            } catch (NullPointerException e) {
            btnReturn.setDisable(true);
            btnReissue.setDisable(true);
            lblNoOfIssuedBooks.setText("0");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadToReturnDetailsByBookID(String bookID){
        tblToReturns.getItems().clear();
        try {
            CustomTM customTM=issueAndReturnsBO.getToReturnBooksByBookID(bookID);
            if (customTM==null){
                btnReturn.setDisable(true);
                btnReissue.setDisable(true);
            }else {
                btnReturn.setDisable(false);
                btnReissue.setDisable(false);
            }
            btnAddtolist.setDisable(false);
            lblMemberID.setText(customTM.getMemberID());
            lblMemberID.setVisible(true);
            lblMemberName.setText(customTM.getMemberName());
            lblMemberName.setVisible(true);

            if (customTM.getMemberType().equals("Free")){
                imgNewMembership.imageProperty().set(new Image("/asset/free-membership.png"));
                imgNewMembership.setVisible(true);
            }
            if (customTM.getMemberType().equals("Bronze")){
                imgNewMembership.imageProperty().set(new Image("/asset/bronze.png"));
                imgNewMembership.setVisible(true);
            }
            if (customTM.getMemberType().equals("Silver")){
                imgNewMembership.imageProperty().set(new Image("/asset/silver.png"));
                imgNewMembership.setVisible(true);
            }
            if (customTM.getMemberType().equals("Gold")){
                imgNewMembership.imageProperty().set(new Image("/asset/gold.png"));
                imgNewMembership.setVisible(true);
            }
            if (customTM.getMemberType().equals("Platinum")){
                imgNewMembership.imageProperty().set(new Image("/asset/Platinum-Membership+(1).png"));
                imgNewMembership.setVisible(true);
            }

            CheckBox checkBox = new CheckBox();
            ReturnsTM customtb= new ReturnsTM(checkBox,customTM.getIssueNo(),customTM.getBookID(),customTM.getBookTitle(),customTM.getLateFee());

            checkBox.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(customtb.getCheckBox().isSelected()) {
                        tblToReturns.getSelectionModel().select(customtb);
                        selectedList.add(customtb);
                        sumOfLateFee();
                        if (selectedList.size()>0 && Double.parseDouble(lblLateFeeDue.getText())>0.0){
                            btnPay.setDisable(false);
                        }
                    }
                    else {
                        selectedList.remove(customtb);
                        tblToReturns.getSelectionModel().clearSelection();
                        sumOfLateFee();
                        if (selectedList.isEmpty()||Double.parseDouble(lblLateFeeDue.getText())==0.0){
                            btnPay.setDisable(true);
                        }

                    }
                }
            });

            data= FXCollections.observableArrayList(customtb);
            if (data!=null){
                lblNoOfIssuedBooks.setText("1");
            }

            tblToReturns.setItems(data);



        } catch (NullPointerException e) {
            new Alert(Alert.AlertType.WARNING, " No Data Found", ButtonType.OK).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reloadToReturnDetailsByMemberID(String memberID){

        tblToReturns.getItems().clear();
        try {
            Member member =memberBO.getSingleMemberByAll(MemberSearchType.MEMBER_ID,memberID);
            lblMemberID.setText(member.getId());
            lblMemberID.setVisible(true);
            lblMemberName.setText(member.getName());
            lblMemberName.setVisible(true);
            btnAddtolist.setDisable(false);

            if (member.getCategory().equals("Free")){
                imgNewMembership.imageProperty().set(new Image("/asset/free-membership.png"));
                imgNewMembership.setVisible(true);
            }
            if (member.getCategory().equals("Bronze")){
                imgNewMembership.imageProperty().set(new Image("/asset/bronze.png"));
                imgNewMembership.setVisible(true);
            }
            if (member.getCategory().equals("Silver")){
                imgNewMembership.imageProperty().set(new Image("/asset/silver.png"));
                imgNewMembership.setVisible(true);
            }
            if (member.getCategory().equals("Gold")){
                imgNewMembership.imageProperty().set(new Image("/asset/gold.png"));
                imgNewMembership.setVisible(true);
            }
            if (member.getCategory().equals("Platinum")){
                imgNewMembership.imageProperty().set(new Image("/asset/Platinum-Membership+(1).png"));
                imgNewMembership.setVisible(true);
            }


        } catch (NullPointerException e) {
            new Alert(Alert.AlertType.WARNING, " No Member Found", ButtonType.OK).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<ReturnsTM> bdata=new ArrayList<ReturnsTM>();
            List<CustomTM> customTM=issueAndReturnsBO.getToReturnBooksByMemberID(memberID);
            if (customTM.isEmpty()){
                btnReturn.setDisable(true);
                btnReissue.setDisable(true);
            }else {
                btnReturn.setDisable(false);
                btnReissue.setDisable(false);
            }

            int i=0;

            for (CustomTM customTM1:customTM) {
                i++;
                CheckBox checkBox = new CheckBox();
                ReturnsTM customtb= new ReturnsTM(checkBox,customTM1.getIssueNo(),customTM1.getBookID(),customTM1.getBookTitle(),customTM1.getLateFee());
                bdata.add(customtb);

                checkBox.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(customtb.getCheckBox().isSelected()) {
                            tblToReturns.getSelectionModel().select(customtb);
                            selectedList.add(customtb);
                            sumOfLateFee();
                            if (selectedList.size()>0 && Double.parseDouble(lblLateFeeDue.getText())>0.0){
                                btnPay.setDisable(false);
                            }
                        }
                        else {
                            selectedList.remove(customtb);
                            tblToReturns.getSelectionModel().clearSelection();
                            sumOfLateFee();
                            if (selectedList.isEmpty()||Double.parseDouble(lblLateFeeDue.getText())==0.0){
                                btnPay.setDisable(true);
                            }

                        }
                    }
                });

            }
            data= FXCollections.observableArrayList(bdata);

            if (data!=null){
                lblNoOfIssuedBooks.setText(String.valueOf(i));
              //  btnReturn.setDisable(false);
              //  btnReissue.setDisable(false);
            }

            tblToReturns.setItems(data);

        }catch (NullPointerException e){
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void loadToReturnDetailsByMemberID(String memberID){
        boolean ready=false;

        tblToReturns.getItems().clear();
        try {
            Member member =memberBO.getSingleMemberByAll(MemberSearchType.MEMBER_ID,memberID);
            ready=true;
            lblMemberID.setText(member.getId());
            lblMemberID.setVisible(true);
            lblMemberName.setText(member.getName());
            lblMemberName.setVisible(true);
            btnAddtolist.setDisable(false);

            if (member.getCategory().equals("Free")){
                imgNewMembership.imageProperty().set(new Image("/asset/free-membership.png"));
                imgNewMembership.setVisible(true);
            }
            if (member.getCategory().equals("Bronze")){
                imgNewMembership.imageProperty().set(new Image("/asset/bronze.png"));
                imgNewMembership.setVisible(true);
            }
            if (member.getCategory().equals("Silver")){
                imgNewMembership.imageProperty().set(new Image("/asset/silver.png"));
                imgNewMembership.setVisible(true);
            }
            if (member.getCategory().equals("Gold")){
                imgNewMembership.imageProperty().set(new Image("/asset/gold.png"));
                imgNewMembership.setVisible(true);
            }
            if (member.getCategory().equals("Platinum")){
                imgNewMembership.imageProperty().set(new Image("/asset/Platinum-Membership+(1).png"));
                imgNewMembership.setVisible(true);
            }


        } catch (NullPointerException e) {
            new Alert(Alert.AlertType.WARNING, " No Member Found", ButtonType.OK).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (ready==true){
            try {
                List<ReturnsTM> bdata=new ArrayList<ReturnsTM>();
                List<CustomTM> customTM=issueAndReturnsBO.getToReturnBooksByMemberID(memberID);
                if (customTM.isEmpty()){
                    new Alert(Alert.AlertType.INFORMATION, "This member does not have issued books", ButtonType.OK).show();
                }else {
                    btnReturn.setDisable(false);
                    btnReissue.setDisable(false);
                }
                int i=0;

                for (CustomTM customTM1:customTM) {
                    i++;
                    CheckBox checkBox = new CheckBox();
                    ReturnsTM customtb= new ReturnsTM(checkBox,customTM1.getIssueNo(),customTM1.getBookID(),customTM1.getBookTitle(),customTM1.getLateFee());
                    bdata.add(customtb);
                    checkBox.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                                if(customtb.getCheckBox().isSelected()) {
                                    tblToReturns.getSelectionModel().select(customtb);
                                    selectedList.add(customtb);
                                    sumOfLateFee();
                                    if (selectedList.size()>0 && Double.parseDouble(lblLateFeeDue.getText())>0.0){
                                        btnPay.setDisable(false);
                                    }
                                }
                                else {
                                    selectedList.remove(customtb);
                                    tblToReturns.getSelectionModel().clearSelection();
                                    sumOfLateFee();
                                    if (selectedList.isEmpty()||Double.parseDouble(lblLateFeeDue.getText())==0.0){
                                        btnPay.setDisable(true);
                                    }

                                }

                        }
                    });

                }

                data= FXCollections.observableArrayList(bdata);

                if (data!=null){
                    lblNoOfIssuedBooks.setText(String.valueOf(i));
                    // btnReturn.setDisable(false);
                    //  btnReissue.setDisable(false);
                }

                tblToReturns.setItems(data);

            }catch (NullPointerException e){
                new Alert(Alert.AlertType.WARNING, " No Book Found", ButtonType.OK).show();

            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }

    public void setDatePickerValues(){
        dpicReturnDate.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0 );
            }
        });
    }

    public String setDate(){
        String currentDate;
        Calendar cal= Calendar.getInstance();
        int year =(cal.get(Calendar.YEAR));
        int month=cal.get(Calendar.MONTH)+1;
        int date=cal.get(Calendar.DATE);
        Formatter fmt = new Formatter();

        currentDate=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(date);

        return currentDate;

    }

    public void payment(List<ReturnsTM> selectedListToUpdate) {
        List<ReturnsTM> customLateFees=new ArrayList<>();
        List<ReturnsTM> deSelectValues=new ArrayList<>();

        Iterator<ReturnsTM> iterator = selectedListToUpdate.iterator();
        while(iterator.hasNext()) {
            ReturnsTM val=iterator.next();
            deSelectValues.add(val);
            ReturnsTM singleSelectedFee = new ReturnsTM(val.getIssueNo());
            customLateFees.add(singleSelectedFee);
        }

        Iterator<ReturnsTM> iterator2 = deSelectValues.iterator();
        while(iterator2.hasNext()) {
            ReturnsTM deselected = iterator2.next();
            selectedList.remove(deselected);
        }

        boolean result;
        try {
            result=issueAndReturnsBO.updatepaymentForLate(customLateFees, Date.valueOf(setDate()));
            if (result){
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully paid", ButtonType.OK).show();
                if (rbtnBookID.isSelected()){
                    reloadToReturnDetailsByBookID(txtBookID.getText());
                }
                if (rbtnMemberID.isSelected()){
                    reloadToReturnDetailsByMemberID(txtMemberID.getText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reissueBooks(List<ReturnsTM> selectedListToReturn){
        List<ReturnsTM> customreturn=new ArrayList<>();
        List<ReturnsTM> listToDeSelect=new ArrayList<>();
        List<Issue_BookTM> reissuebookIds=new ArrayList<>();
        Iterator<ReturnsTM> iterator = selectedListToReturn.iterator();

        while(iterator.hasNext()) {
            ReturnsTM selected = iterator.next();
            listToDeSelect.add(selected);
            ReturnsTM singleSelecteditem = new ReturnsTM(selected.getIssueNo(),selected.getBookID());
            customreturn.add(singleSelecteditem);
            Issue_BookTM issue_bookTM=new Issue_BookTM(selected.getBookID());
            reissuebookIds.add(issue_bookTM);
        }

        Iterator<ReturnsTM> iterator2 = listToDeSelect.iterator();
        while(iterator2.hasNext()) {
            ReturnsTM deselected = iterator2.next();
            selectedList.remove(deselected);
        }

        boolean result;
        boolean access=false;
        try {
            result=issueAndReturnsBO.returnBooks(customreturn);
            if (result){
                access=true;
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully return", ButtonType.OK).show();
                if (rbtnBookID.isSelected()){
                    reloadToReturnDetailsByBookID(txtBookID.getText());
                }
                if (rbtnMemberID.isSelected()){
                    reloadToReturnDetailsByMemberID(txtMemberID.getText());
                }
            }
            if (!result){
                access=false;
                new Alert(Alert.AlertType.ERROR, "Error in Return", ButtonType.OK).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (access==true){
            try {
                List<BookT> toReissueBookList= bookBO.getBookListByBookListIDs(reissuebookIds);
                if(toReissueBookList.isEmpty()){ System.out.println("To Issue book details list is empty : check IssueAndReturnBookController -> reissueBooks method"); }
                for (BookT toIssueBook:toReissueBookList) {

                    JFXButton btnDelete = new JFXButton("  Delete  ");
                    btnDelete.setStyle("-fx-background-color: #79d1f4 ;-fx-background-radius: 20px; -fx-padding: 5px");

                    CustomTM2 customTM2= new CustomTM2(lblIssueNewID.getText(),toIssueBook.getBookID(),toIssueBook.getBname(),toIssueBook.getBcategoryID(),toIssueBook.getBauthor(),toIssueBook.getBedition(),Date.valueOf(dpicReturnDate.getValue()),btnDelete);
                    btnDelete.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                            ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to remove this book from issue list ", yes, cancel);

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.orElse(yes) == yes) {
                                tblToIssue.getItems().remove(customTM2);
                            }
                        }
                    });
                    tblToIssue.getItems().add(customTM2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void returnBooks(List<ReturnsTM> selectedListToReturn){
        List<ReturnsTM> customreturn=new ArrayList<>();
        List<ReturnsTM> listToDeSelect=new ArrayList<>();
        Iterator<ReturnsTM> iterator = selectedListToReturn.iterator();

        System.out.println("Third :"+selectedListToReturn);
        while(iterator.hasNext()) {
            ReturnsTM selected = iterator.next();
            listToDeSelect.add(selected);
            ReturnsTM singleSelecteditem = new ReturnsTM(selected.getIssueNo(),selected.getBookID());
            System.out.println("forth :"+singleSelecteditem);
            customreturn.add(singleSelecteditem);
        }
        Iterator<ReturnsTM> iterator2 = listToDeSelect.iterator();
        while(iterator2.hasNext()) {
            ReturnsTM deselected = iterator2.next();
            selectedList.remove(deselected);
        }

        boolean result;
        try {
            result=issueAndReturnsBO.returnBooks(customreturn);
            if (result){
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully return", ButtonType.OK).show();
                if (rbtnBookID.isSelected()){
                    reloadToReturnDetailsByBookID(txtBookID.getText());
                }
                if (rbtnMemberID.isSelected()){
                    reloadToReturnDetailsByMemberID(txtMemberID.getText());
                }
            }
            if (!result){
                new Alert(Alert.AlertType.ERROR, "Error in Return", ButtonType.OK).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveIssueBooks(List<CustomTM2> record,String memberID){
        boolean result=false;

        List<Issue_BookTM> issue_bookTMS=new ArrayList<Issue_BookTM>();
        for (CustomTM2 customTM2:record) {
            issue_bookTMS.add(new Issue_BookTM(customTM2.getIssueNo(),customTM2.getBookID(),memberID,Date.valueOf(setDate()),customTM2.getReturnDate(),"S001"));
        }

        try {
            result= issueAndReturnsBO.issuebook(issue_bookTMS);
            if (result==true){
                new Alert(Alert.AlertType.CONFIRMATION, " Successfully issued", ButtonType.OK).show();
                tblToIssue.getItems().clear();
            }
            else {
                new Alert(Alert.AlertType.WARNING, " Fail to Issue book", ButtonType.OK).show();
            }
        } catch (Exception e) {
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

    public void rbtnClickMemberIDAction(ActionEvent actionEvent) {
        clearallfields();
        if(rbtnMemberID.isSelected()){
            txtMemberID.setDisable(false);
            txtBookID.setDisable(true);
        }
    }

    public void rbtnClickBookIDAction(ActionEvent actionEvent) {
        clearallfields();
        if(rbtnBookID.isSelected()){
            txtBookID.setDisable(false);
            txtMemberID.setDisable(true);
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {

        if (rbtnBookID.isSelected()){
            loadToReturnDetailsByBookID(txtBookID.getText());
        }
        if (rbtnMemberID.isSelected()){
            loadToReturnDetailsByMemberID(txtMemberID.getText());
        }
    }

    public void btnPayOnAction(ActionEvent actionEvent) {
        payment(selectedList);
        sumOfLateFee();
    }

    public void btnReturnOnAction(ActionEvent actionEvent) {
        if(selectedList.isEmpty()){
            System.out.println("fifth Nothing Selected");
        }
        else {
            returnBooks(selectedList);
        }
        sumOfLateFee();
    }

    public void btnReissueOnAction(ActionEvent actionEvent) {
        if(selectedList.isEmpty()){
            System.out.println("sixth :Nothing Selected");
        }
        else {
            reissueBooks(selectedList);
        }
        sumOfLateFee();
    }

    public void btnIssueBooksOnAction(ActionEvent actionEvent) {
        ObservableList<CustomTM2> data =tblToIssue.getItems();
        for(CustomTM2 yd : data) {
            System.out.println("Seventh: "+yd);
        }
        saveIssueBooks(data,lblMemberID.getText());
    }

    public void btnResetOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/IssueAndReturnBooks.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/HomePage.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void btnAddtolistOnAction(ActionEvent actionEvent) {
        System.out.println("eigth: "+dpicReturnDate.getValue());
        try {
            BookT bookTAll=bookBO.getSingleBook(txtToIssueBookID.getText());

            JFXButton btnDelete = new JFXButton("  Delete  ");
            btnDelete.setStyle("-fx-background-color: #79d1f4 ;-fx-background-radius: 20px; -fx-padding: 5px"
            );
            CustomTM2 customTM2= new CustomTM2(lblIssueNewID.getText(),bookTAll.getBookID(),bookTAll.getBname(),bookTAll.getBcategoryID(),bookTAll.getBauthor(),bookTAll.getBedition(),Date.valueOf(dpicReturnDate.getValue()),btnDelete);
            btnDelete.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                    ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to remove this book from issue list ", yes, cancel);

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(yes) == yes) {
                        tblToIssue.getItems().remove(customTM2);
                    }
                }
            });
            tblToIssue.getItems().add(customTM2);
            txtToIssueBookID.clear();
            spnrNoOfDays.getValueFactory().setValue(7);
            autosetDatePicker();

        } catch (NullPointerException e) {
            new Alert(Alert.AlertType.WARNING, " No such a book", ButtonType.OK).show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnDetails (){
    }

    public void autosetDatePicker(){
        int noOdDays= (int) spnrNoOfDays.getValue();
        String currentDate;
        Calendar cal= Calendar.getInstance();
        int year =(cal.get(Calendar.YEAR));
        int month=cal.get(Calendar.MONTH)+1;
        int date=cal.get(Calendar.DATE)+noOdDays;
        Formatter fmt = new Formatter();

        dpicReturnDate.setValue(LocalDate.of(year, month, date));
    }

    public void spinnerOnAction(MouseEvent mouseEvent) {
        autosetDatePicker();
    }

    public void datePickerOnAction(ActionEvent actionEvent) {
        Date date= Date.valueOf(dpicReturnDate.getValue());
        java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
        int days=0;
        if (date.after(currentDate)){
            long difference = date.getTime() - currentDate.getTime();
            float daysBetween = (difference / (1000*60*60*24));
            days= (int) daysBetween;
        }
        spnrNoOfDays.getValueFactory().setValue(days+1);

        }

}

