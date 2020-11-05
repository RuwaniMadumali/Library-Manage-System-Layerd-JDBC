package Entity;

import java.io.Serializable;

public class Issue_DetailPK implements SuperEntity {

    private String issueNo;
    private String bookID;

    public Issue_DetailPK() {
    }

    public Issue_DetailPK(String issueNo, String bookID) {
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
        return "Issue_DetailPK{" +
                "issueNo='" + issueNo + '\'' +
                ", bookID='" + bookID + '\'' +
                '}';
    }
}
