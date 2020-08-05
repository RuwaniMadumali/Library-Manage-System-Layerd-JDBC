package util;

import java.sql.Date;

public class MemberTM {
    private String id;
    private String nic;
    private String name;
    private String gender;
    private String categoryId;
    private String address;
    private String email;
    private int contactNo;
    private Date addDate;
    private Date expDate;

    public MemberTM() {
    }

    public MemberTM(String id, String nic, String name, String gender, String categoryId, String address, String email, int contactNo, Date addDate, Date expDate) {
        this.id = id;
        this.nic = nic;
        this.name = name;
        this.gender = gender;
        this.categoryId = categoryId;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.addDate = addDate;
        this.expDate = expDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "MemberTM{" +
                "id='" + id + '\'' +
                ", nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contactNo=" + contactNo +
                ", addDate=" + addDate +
                ", expDate=" + expDate +
                '}';
    }
}
