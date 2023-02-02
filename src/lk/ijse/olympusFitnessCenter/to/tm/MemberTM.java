package lk.ijse.olympusFitnessCenter.to.tm;

import javafx.scene.control.Button;

public class MemberTM {
    private String id;
    private String name;
    private String contactNo;
    private String joinDate;
    private String NIC;
    private String DOB;
    private String address;
    private String gender;
    private Button deleteButton;
    private Button updateButton;

    public MemberTM() {
    }

    public MemberTM(String id, String name, String contactNo, String joinDate, String NIC, String DOB, String address, String gender, Button deleteButton, Button updateButton) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.joinDate = joinDate;
        this.NIC = NIC;
        this.DOB = DOB;
        this.address = address;
        this.gender = gender;
        this.deleteButton = deleteButton;
        this.updateButton = updateButton;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getDOB() {
        //genarate age
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public Button getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(Button updateButton) {
        this.updateButton = updateButton;
    }
}
