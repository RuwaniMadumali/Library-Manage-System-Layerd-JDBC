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
