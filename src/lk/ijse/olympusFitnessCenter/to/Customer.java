package lk.ijse.olympusFitnessCenter.to;

public class Customer {
    private String Cus_Id;
    private String Name;
    private String Contact_No;

    public Customer() {
    }

    public Customer(String cus_Id, String name, String contact_No) {
        Cus_Id = cus_Id;
        Name = name;
        Contact_No = contact_No;
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
}
