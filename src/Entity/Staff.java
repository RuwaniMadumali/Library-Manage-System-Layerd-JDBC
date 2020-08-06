package Entity;

public class Staff implements SuperEntity{
    private String staffID;
    private String sName;
    private String sPosition;
    private String userName;
    private String passWord;

    public Staff() {
    }

    public Staff(String staffID, String sName, String sPosition, String userName, String passWord) {
        this.staffID = staffID;
        this.sName = sName;
        this.sPosition = sPosition;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPosition() {
        return sPosition;
    }

    public void setsPosition(String sPosition) {
        this.sPosition = sPosition;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffID='" + staffID + '\'' +
                ", sName='" + sName + '\'' +
                ", sPosition='" + sPosition + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
