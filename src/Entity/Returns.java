package Entity;

import java.sql.Date;

public class Returns implements SuperEntity{
    private String issueNo;
    private String bookID;
    private Date returnDate;
    private Date actualReturnDate;
    private String issueStaffID;

    public Returns() {
    }

    public Returns(String issueNo, String bookID, Date returnDate, Date actualReturnDate, String issueStaffID) {
        this.issueNo = issueNo;
        this.bookID = bookID;
        this.returnDate = returnDate;
        this.actualReturnDate = actualReturnDate;
        this.issueStaffID = issueStaffID;
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

    public String getIssueStaffID() {
        return issueStaffID;
    }

    public void setIssueStaffID(String issueStaffID) {
        this.issueStaffID = issueStaffID;
    }

    @Override
    public String toString() {
        return "Returns{" +
                "issueNo='" + issueNo + '\'' +
                ", bookID='" + bookID + '\'' +
                ", returnDate=" + returnDate +
                ", actualReturnDate=" + actualReturnDate +
                ", issueStaffID='" + issueStaffID + '\'' +
                '}';
    }
}
