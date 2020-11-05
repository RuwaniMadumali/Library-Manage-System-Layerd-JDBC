package util;

import javafx.scene.control.Button;

import java.sql.Date;

public class CustomTM2 {
    private String issueNo;
    private String bookID;
    private String bookTitle;
    private String bookCategory;
    private String bookAuthoer;
    private String bookEdition;
    private Date returnDate;
    private String returnDay;
    private Button btndelete;

    public CustomTM2() {
    }

    public CustomTM2(String issueNo, String bookID, String bookTitle, String bookCategory, String bookAuthoer, String bookEdition, Date returnDate) {
        this.issueNo = issueNo;
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.bookAuthoer = bookAuthoer;
        this.bookEdition = bookEdition;
        this.returnDate = returnDate;
    }

    public CustomTM2(String issueNo, String bookID, String bookTitle, String bookCategory, String bookAuthoer, String bookEdition, Date returnDate, Button btndelete) {
        this.issueNo = issueNo;
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.bookAuthoer = bookAuthoer;
        this.bookEdition = bookEdition;
        this.returnDate = returnDate;
        this.btndelete = btndelete;
    }

    public String getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(String returnDay) {
        this.returnDay = returnDay;
    }

    public Button getBtndelete() {
        return btndelete;
    }

    public void setBtndelete(Button btndelete) {
        this.btndelete = btndelete;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "CustomTM2{" +
                "issueNo='" + issueNo + '\'' +
                ", bookID='" + bookID + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                ", bookAuthoer='" + bookAuthoer + '\'' +
                ", bookEdition='" + bookEdition + '\'' +
                ", returnDate=" + returnDate +
                '}';
    }
}
