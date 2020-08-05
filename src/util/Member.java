package util;

import java.awt.*;
import java.sql.Date;

public class Member {
    private String id;
    private String nic;
    private String name;
    private String address;
    private String email;
    private String gender;
    private String contactNo;
    private String category;
    private Date expDate;
    private Button button;

    public Member() {
    }

    public Member(String id, String nic, String name, String address, String email, String gender, String contactNo, String category, Date expDate, Button button) {
        this.id = id;
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.contactNo = contactNo;
        this.category = category;
        this.expDate = expDate;
        this.button = button;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", category='" + category + '\'' +
                ", expDate=" + expDate +
                ", button=" + button +
                '}';
    }
}
