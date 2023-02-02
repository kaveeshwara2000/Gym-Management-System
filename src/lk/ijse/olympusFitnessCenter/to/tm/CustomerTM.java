package lk.ijse.olympusFitnessCenter.to.tm;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Button;

public class CustomerTM {
    private String Cus_Id;
    private String Name;
    private String Contact_No;
    private Button delete;

    public CustomerTM() {
    }

    public CustomerTM(String cus_Id, String name, String contact_No, Button delete) {
        Cus_Id = cus_Id;
        Name = name;
        Contact_No = contact_No;
        this.delete = delete;
    }

    public String getCus_Id() {
        return Cus_Id;
    }

    public void setCus_Id(String cus_Id) {
        Cus_Id = cus_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact_No() {
        return Contact_No;
    }

    public void setContact_No(String contact_No) {
        Contact_No = contact_No;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
}
