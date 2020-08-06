package Entity;

import java.sql.Date;

public class Member implements SuperEntity{
    private String memberID;
    private String mName;
    private String mType;
    private String mAddress;
    private String mEmail;
    private String gender;
    private String mPhoneNo;
    private Date mAddDate;
    private Date mExpDate;

    public Member() {
    }

    public Member(String memberID, String mName, String mType, String mAddress, String mEmail, String gender, String mPhoneNo, Date mAddDate, Date mExpDate) {
        this.memberID = memberID;
        this.mName = mName;
        this.mType = mType;
        this.mAddress = mAddress;
        this.mEmail = mEmail;
        this.gender = gender;
        this.mPhoneNo = mPhoneNo;
        this.mAddDate = mAddDate;
        this.mExpDate = mExpDate;
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

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getmPhoneNo() {
        return mPhoneNo;
    }

    public void setmPhoneNo(String mPhoneNo) {
        this.mPhoneNo = mPhoneNo;
    }

    public Date getmAddDate() {
        return mAddDate;
    }

    public void setmAddDate(Date mAddDate) {
        this.mAddDate = mAddDate;
    }

    public Date getmExpDate() {
        return mExpDate;
    }

    public void setmExpDate(Date mExpDate) {
        this.mExpDate = mExpDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID='" + memberID + '\'' +
                ", mName='" + mName + '\'' +
                ", mType='" + mType + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", gender='" + gender + '\'' +
                ", mPhoneNo='" + mPhoneNo + '\'' +
                ", mAddDate=" + mAddDate +
                ", mExpDate=" + mExpDate +
                '}';
    }
}
