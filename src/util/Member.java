package util;

import com.jfoenix.controls.JFXButton;

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
    private JFXButton deleteButton;
    private JFXButton updateButton;
    private int count;

    public Member() {
    }

    public Member(String category, int count) {
        this.category = category;
        this.count = count;
    }

    public Member(String id, String nic, String name, String address, String email, String gender, String contactNo, String category, Date expDate) {
        this.id = id;
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.contactNo = contactNo;
        this.category = category;
        this.expDate = expDate;
    }

    public Member(String id, String nic, String name, String address, String email, String gender, String contactNo, String category, Date expDate, JFXButton deleteButton,JFXButton updateButton) {
        this.id = id;
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.contactNo = contactNo;
        this.category = category;
        this.expDate = expDate;
        this.deleteButton = deleteButton;
        this.updateButton=updateButton;
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

    public JFXButton getDeleteButton() { return deleteButton; }

    public void setDeleteButton(JFXButton deleteButton) { this.deleteButton = deleteButton; }

    public JFXButton getUpdateButton() { return updateButton; }

    public void setUpdateButton(JFXButton updateButton) { this.updateButton = updateButton; }

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
                ", count=" + count +
                '}';
    }
}
