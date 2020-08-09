package util;

import java.math.BigDecimal;
import java.sql.Date;

public class Renewal_PaymentTM {
    private String renewalPaymentNo;
    private String memberID;
    private String oldMemberTypeID;
    private String newMemberTypeID;
    private BigDecimal fee;
    private Date renewDate;

    public Renewal_PaymentTM() {
    }

    public Renewal_PaymentTM(String renewalPaymentNo, String memberID, String oldMemberTypeID, String newMemberTypeID, BigDecimal fee, Date renewDate) {
        this.renewalPaymentNo = renewalPaymentNo;
        this.memberID = memberID;
        this.oldMemberTypeID = oldMemberTypeID;
        this.newMemberTypeID = newMemberTypeID;
        this.fee = fee;
        this.renewDate = renewDate;
    }

    public String getRenewalPaymentNo() {
        return renewalPaymentNo;
    }

    public void setRenewalPaymentNo(String renewalPaymentNo) {
        this.renewalPaymentNo = renewalPaymentNo;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getOldMemberTypeID() {
        return oldMemberTypeID;
    }

    public void setOldMemberTypeID(String oldMemberTypeID) {
        this.oldMemberTypeID = oldMemberTypeID;
    }

    public String getNewMemberTypeID() {
        return newMemberTypeID;
    }

    public void setNewMemberTypeID(String newMemberTypeID) {
        this.newMemberTypeID = newMemberTypeID;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Date getRenewDate() {
        return renewDate;
    }

    public void setRenewDate(Date renewDate) {
        this.renewDate = renewDate;
    }

    @Override
    public String toString() {
        return "Renewal_PaymentTM{" +
                "renewalPaymentNo='" + renewalPaymentNo + '\'' +
                ", memberID='" + memberID + '\'' +
                ", oldMemberTypeID='" + oldMemberTypeID + '\'' +
                ", newMemberTypeID='" + newMemberTypeID + '\'' +
                ", fee=" + fee +
                ", renewDate=" + renewDate +
                '}';
    }
}
