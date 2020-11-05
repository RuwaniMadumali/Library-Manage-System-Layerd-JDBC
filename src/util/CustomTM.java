package util;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.sql.Date;

public class CustomTM {
    private CheckBox checkBox;
    private String issueNo;
    private String bookID;
    private String memberID;
    private String memberName;
    private String memberType;
    private String bookTitle;
    private String bookCategory;
    private String bookAuthoer;
    private String bookEdition;
    private Date issueDate;
    private Date returnDate;
    private Date actualReturnDate;
    private double lateFee;
    private double charges;
    private Button btndelete;

    public CustomTM() {
    }

    public CustomTM(String issueNo) {
        this.issueNo = issueNo;
    }

    public CustomTM(String issueNo, double lateFee) {
        this.issueNo = issueNo;
        this.lateFee = lateFee;
    }

    public CustomTM(String memberID,String memberName, String memberType, String issueNo, String bookID, String bookTitle, double lateFee) {
        this.issueNo = issueNo;
        this.bookID = bookID;
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberType = memberType;
        this.bookTitle = bookTitle;
        this.lateFee = lateFee;
    }

    public CustomTM(CheckBox checkBox, String issueNo, String bookID, String bookTitle, double lateFee) {
        this.checkBox = checkBox;
        this.issueNo = issueNo;
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.lateFee = lateFee;
    }

    public CustomTM(String issueNo, String bookID, String bookTitle, String bookCategory, String bookAuthoer, String bookEdition, Date returnDate) {
        this.issueNo = issueNo;
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.bookAuthoer = bookAuthoer;
        this.bookEdition = bookEdition;
        this.returnDate = returnDate;
    }

    public CustomTM(String issueNo, String bookID,String bookTitle, String memberID, double charges,  Date issueDate, Date returnDate) {
        this.issueNo = issueNo;
        this.bookID = bookID;
        this.memberID = memberID;
        this.bookTitle = bookTitle;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.charges = charges;
    }

    public CustomTM(CheckBox checkBox, String issueNo, String bookID, String memberID, String bookTitle, String bookCategory, String bookAuthoer, String bookEdition, Date issueDate, Date returnDate, Date actualReturnDate, double lateFee, double charges, Button btndelete) {
        this.checkBox = checkBox;
        this.issueNo = issueNo;
        this.bookID = bookID;
        this.memberID = memberID;
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.bookAuthoer = bookAuthoer;
        this.bookEdition = bookEdition;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.actualReturnDate = actualReturnDate;
        this.lateFee = lateFee;
        this.charges = charges;
        this.btndelete = btndelete;
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

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() { return memberName; }

    public void setMemberName(String memberName) { this.memberName = memberName; }

    public String getMemberType() { return memberType; }

    public void setMemberType(String memberType) { this.memberType = memberType; }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookAuthoer() {
        return bookAuthoer;
    }

    public void setBookAuthoer(String bookAuthoer) {
        this.bookAuthoer = bookAuthoer;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public Button getBtndelete() {
        return btndelete;
    }

    public void setBtndelete(Button btndelete) {
        this.btndelete = btndelete;
    }

    @Override
    public String toString() {
        return "CustomTM{" +
                "issueNo='" + issueNo + '\'' +
                ", bookID='" + bookID + '\'' +
                ", memberID='" + memberID + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberType='" + memberType + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                ", bookAuthoer='" + bookAuthoer + '\'' +
                ", bookEdition='" + bookEdition + '\'' +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", actualReturnDate=" + actualReturnDate +
                ", lateFee=" + lateFee +
                ", charges=" + charges +
                '}';
    }
}
