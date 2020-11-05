package Entity;

import java.io.Serializable;

public class Delay_PaymentPK implements SuperEntity {
    private String issueNo;
    private String bookID;

    public Delay_PaymentPK() {
    }

    public Delay_PaymentPK(String issueNo, String bookID) {
        this.issueNo = issueNo;
        this.bookID = bookID;
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

    @Override
    public String toString() {
        return "Delay_PaymentPK{" +
                "issueNo='" + issueNo + '\'' +
                ", bookID='" + bookID + '\'' +
                '}';
    }
}
