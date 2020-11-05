package util;

import javafx.scene.control.CheckBox;

import java.sql.Date;

public class ReturnsTM {
    private CheckBox checkBox;
    private String issueNo;
    private String bookID;
    private String bookTitle;
    private double lateFee;

    public ReturnsTM() {}

    public ReturnsTM(String issueNo) {
        this.issueNo = issueNo;
    }

    public ReturnsTM(String issueNo, String bookID) {
        this.issueNo = issueNo;
        this.bookID = bookID;
    }

    public ReturnsTM(CheckBox checkBox, String issueNo, String bookID, String bookTitle, double lateFee) {
        this.checkBox = checkBox;
        this.issueNo = issueNo;
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.lateFee = lateFee;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public String getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    @Override
    public String toString() {
        return "ReturnsTM{" +
                "issueNo='" + issueNo + '\'' +
                ", bookID='" + bookID + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", lateFee=" + lateFee +
                '}';
    }
}
