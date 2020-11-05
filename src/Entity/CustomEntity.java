package Entity;

import java.math.BigDecimal;
import java.sql.Date;

public class CustomEntity implements SuperEntity{

    private String memberID;
    private String mName;
    private String mType;
    private BigDecimal charges;
    private String issueNo;
    private String bookID;
    private String bName;
    private Date returnDate;

    public CustomEntity(String memberID, String mName, String mType, BigDecimal charges, String issueNo, String bookID, String bName, Date returnDate) {
        this.memberID = memberID;
        this.mName = mName;
        this.mType = mType;
        this.charges = charges;
        this.issueNo = issueNo;
        this.bookID = bookID;
        this.bName = bName;
        this.returnDate = returnDate;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
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

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "CustomEntity{" +
                "memberID='" + memberID + '\'' +
                ", mName='" + mName + '\'' +
                ", mType='" + mType + '\'' +
                ", charges=" + charges +
                ", issueNo='" + issueNo + '\'' +
                ", bookID='" + bookID + '\'' +
                ", bName='" + bName + '\'' +
                ", returnDate=" + returnDate +
                '}';
    }
}
