package Entity;

import java.math.BigDecimal;

public class Dalay_Payment implements SuperEntity{
    private String issueNo;
    private String bookID;
    private String memberID;
    private int lateDates;
    private BigDecimal appliedCharges;

    public Dalay_Payment() {

    }

    public Dalay_Payment(String issueNo, String bookID, String memberID, int lateDates, BigDecimal appliedCharges) {
        this.issueNo = issueNo;
        this.bookID = bookID;
        this.memberID = memberID;
        this.lateDates = lateDates;
        this.appliedCharges = appliedCharges;
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

    public int getLateDates() {
        return lateDates;
    }

    public void setLateDates(int lateDates) {
        this.lateDates = lateDates;
    }

    public BigDecimal getAppliedCharges() {
        return appliedCharges;
    }

    public void setAppliedCharges(BigDecimal appliedCharges) {
        this.appliedCharges = appliedCharges;
    }

    @Override
    public String toString() {
        return "Dalay_Payment{" +
                "issueNo='" + issueNo + '\'' +
                ", bookID='" + bookID + '\'' +
                ", memberID='" + memberID + '\'' +
                ", lateDates=" + lateDates +
                ", appliedCharges=" + appliedCharges +
                '}';
    }
}
