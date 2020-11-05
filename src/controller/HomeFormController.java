package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class HomeFormController {
    public AnchorPane root;
    public Button btnAddMember;
    public Button btnSearchMember;
    public Button btnAddBook;
    public Button btnSearchBook;
    public Button btnIssueAndReturn;
    public Tooltip ttAddNewMember;
    public Tooltip ttSearchMember;
    public Tooltip ttAddNewBook;
    public Tooltip ttSearchBook;
    public Tooltip ttIssueReturnBook;
    public Tooltip ttReport;
    public Tooltip ttSettings;
    public Tooltip ttMore;
    public Tooltip ttDashboard;
    public PieChart pieChartMembers;
    public BarChart barChart;
    public JFXButton btnClose;
    public Label lblIssueBooks;
    public Label lblReturnBooks;
    public Label lblDelayedReturns;
    public Button btnReports;
    public Button btnSettings;
    public Button btnInfor;

    public void initialize(){
        btnReports.setDisable(true);
        btnSettings.setDisable(true);


//setTooltip(new Tooltip("Tooltip for Button"));
        ObservableList<PieChart.Data> list= FXCollections.observableArrayList(
                new PieChart.Data("Browns",30),
                new PieChart.Data("Gold",10),
                new PieChart.Data("Free",50),
                new PieChart.Data("Platinum",20)
        );
        pieChartMembers.setData(list);

        XYChart.Series dataSeries1 = new XYChart.Series();


        dataSeries1.getData().add(new XYChart.Data("Adventure", 2));
        dataSeries1.getData().add(new XYChart.Data("Art"  , 3));
        dataSeries1.getData().add(new XYChart.Data("Cooking"  , 2));
        dataSeries1.getData().add(new XYChart.Data("Fantasy", 4));
        dataSeries1.getData().add(new XYChart.Data("Guide"  , 6));
        dataSeries1.getData().add(new XYChart.Data("Health"  , 2));
        dataSeries1.getData().add(new XYChart.Data("Historical"  , 2));
        dataSeries1.getData().add(new XYChart.Data("Novels"  , 5));
        dataSeries1.getData().add(new XYChart.Data("Romance"  , 2));
        dataSeries1.getData().add(new XYChart.Data("History", 8));
        dataSeries1.getData().add(new XYChart.Data("Horror"  , 5));
        dataSeries1.getData().add(new XYChart.Data("Science", 8));
        dataSeries1.getData().add(new XYChart.Data("Travel"  , 2));


        barChart.getData().add(dataSeries1);

        Node n = barChart.lookup(".data0.chart-bar");
        n.setStyle("-fx-bar-fill: #DE3F26");
        n = barChart.lookup(".data1.chart-bar");
        n.setStyle("-fx-bar-fill: #DE850B");
        n = barChart.lookup(".data2.chart-bar");
        n.setStyle("-fx-bar-fill: #487c2a");//
        n = barChart.lookup(".data3.chart-bar");
        n.setStyle("-fx-bar-fill: #144082");
        n = barChart.lookup(".data4.chart-bar");
        n.setStyle("-fx-bar-fill: #DE850B");
        n = barChart.lookup(".data5.chart-bar");
        n.setStyle("-fx-bar-fill: #487c2a");//
        n = barChart.lookup(".data6.chart-bar");
        n.setStyle("-fx-bar-fill: #144082");
        n = barChart.lookup(".data7.chart-bar");
        n.setStyle("-fx-bar-fill: #DE850B");
        n = barChart.lookup(".data8.chart-bar");
        n.setStyle("-fx-bar-fill: #487c2a");//
        n = barChart.lookup(".data9.chart-bar");
        n.setStyle("-fx-bar-fill: #144082");
        n = barChart.lookup(".data10.chart-bar");
        n.setStyle("-fx-bar-fill: #DE850B");
        n = barChart.lookup(".data11.chart-bar");
        n.setStyle("-fx-bar-fill: #487c2a");//
        n = barChart.lookup(".data12.chart-bar");
        n.setStyle("-fx-bar-fill: #144082");
        /*n = barChart.lookup(".data13.chart-bar");
        n.setStyle("-fx-bar-fill: #144082");*/


    }

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

    public void closeButtonAction(ActionEvent actionEvent) {

        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to exit from this program", yes, cancel);

        Optional<ButtonType> result = alert.showAndWait();
        System.out.println(result);
        if (result.orElse(yes) == yes) {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        }
    }

    public void btninforOnAction(ActionEvent actionEvent) {
    }

    public void getCountIssuedBooks(){

    }
    public void getCountReturnededBooks(){

    }
    public void getCountDelayedReturns(){

    }
    public void geCountMemberSumary(){

    }
    public void getCountBookSummary(){
        //"Adventure","Art","Cooking","Dystopian","Fantasy","Guide","Health","Historical","History","Horror","Humor","Memoir","Mystery","Novels","Paranormal","Romance","Science","Self-help","Thriller","Travel"
    }
}
