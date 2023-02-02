package lk.ijse.olympusFitnessCenter.to.tm;

import javafx.scene.control.Button;

public class TrainerTM extends MemberTM {
    private String id;
    private String name;
    private String contactNo;
    private String salary;
    private String joinDate;
    private String NIC;
    private String address;
    private Button deleteButton;
    private Button updateButton;

    public TrainerTM(String id, String name, String contactNo, String salary, String joinDate, String NIC, String address, Button deleteButton, Button updateButton) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.salary = salary;
        this.joinDate = joinDate;
        this.NIC = NIC;
        this.address = address;
        this.deleteButton = deleteButton;
        this.updateButton = updateButton;
    }

    public TrainerTM() {
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
