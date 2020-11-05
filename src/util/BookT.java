package util;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Button;

import java.awt.*;
import java.sql.Date;

public class BookT {
    private String bookID;
    private String bcategoryID;
    private String bname;
    private String bauthor;
    private String bedition;
    private double bprice;
    private int bnoofPages;
    private String bbscription;
    private JFXButton deleteBtn;
    private JFXButton updateBtn;

    public BookT() {
    }

    public BookT(String bookID, String bcategoryID, String bname, String bauthor, String bedition) {
        this.bookID = bookID;
        this.bcategoryID = bcategoryID;
        this.bname = bname;
        this.bauthor = bauthor;
        this.bedition = bedition;
    }

    public BookT(String bookID, String bcategoryID, String bname, String bauthor, String bedition, double bprice, int bnoofPages, String bbscription) {
        this.bookID = bookID;
        this.bcategoryID = bcategoryID;
        this.bname = bname;
        this.bauthor = bauthor;
        this.bedition = bedition;
        this.bprice = bprice;
        this.bnoofPages = bnoofPages;
        this.bbscription = bbscription;
    }

    public BookT(String bookID, String bcategoryID, String bname, String bauthor, String bedition, double bprice, int bnoofPages, String bbscription, JFXButton deleteBtn,JFXButton updateBtn) {
        this.bookID = bookID;
        this.bcategoryID = bcategoryID;
        this.bname = bname;
        this.bauthor = bauthor;
        this.bedition = bedition;
        this.bprice = bprice;
        this.bnoofPages = bnoofPages;
        this.bbscription = bbscription;
        this.deleteBtn = deleteBtn;
        this.updateBtn = updateBtn;
    }

    public JFXButton getUpdateBtn() {
        return updateBtn;
    }

    public void setUpdateBtn(JFXButton updateBtn) {
        this.updateBtn = updateBtn;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(JFXButton deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBcategoryID() {
        return bcategoryID;
    }

    public void setBcategoryID(String bcategoryID) {
        this.bcategoryID = bcategoryID;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getBedition() {
        return bedition;
    }

    public void setBedition(String bedition) {
        this.bedition = bedition;
    }

    public double getBprice() {
        return bprice;
    }

    public void setBprice(double bprice) {
        this.bprice = bprice;
    }

    public int getBnoofPages() {
        return bnoofPages;
    }

    public void setBnoofPages(int bnoofPages) {
        this.bnoofPages = bnoofPages;
    }

    public String getBbscription() {
        return bbscription;
    }

    public void setBbscription(String bbscription) {
        this.bbscription = bbscription;
    }

    @Override
    public String toString() {
        return "BookT{" +
                "bookID='" + bookID + '\'' +
                ", bcategoryID='" + bcategoryID + '\'' +
                ", bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", bedition='" + bedition + '\'' +
                ", bprice=" + bprice +
                ", bnoofPages=" + bnoofPages +
                ", bbscription='" + bbscription + '\'' +
                '}';
    }
}
