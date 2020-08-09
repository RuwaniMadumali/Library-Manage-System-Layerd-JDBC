package util;

import java.sql.Date;

public class ReceiptTM {
    private String reciptNo;
    private String reason;
    private Date issuedDate;
    private String issuedStaffID;
    private String paymentmood;

    public ReceiptTM() {
    }

    public ReceiptTM(String reciptNo, String reason, Date issuedDate, String issuedStaffID, String paymentmood) {
        this.reciptNo = reciptNo;
        this.reason = reason;
        this.issuedDate = issuedDate;
        this.issuedStaffID = issuedStaffID;
        this.paymentmood = paymentmood;
    }

    public String getReciptNo() {
        return reciptNo;
    }

    public void setReciptNo(String reciptNo) {
        this.reciptNo = reciptNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getIssuedStaffID() {
        return issuedStaffID;
    }

    public void setIssuedStaffID(String issuedStaffID) {
        this.issuedStaffID = issuedStaffID;
    }

    public String getPaymentmood() {
        return paymentmood;
    }

    public void setPaymentmood(String paymentmood) {
        this.paymentmood = paymentmood;
    }

    @Override
    public String toString() {
        return "ReceiptTM{" +
                "reciptNo='" + reciptNo + '\'' +
                ", reason='" + reason + '\'' +
                ", issuedDate=" + issuedDate +
                ", issuedStaffID='" + issuedStaffID + '\'' +
                ", paymentmood='" + paymentmood + '\'' +
                '}';
    }
}
