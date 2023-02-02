package lk.ijse.olympusFitnessCenter.to;


public class Supplier {
    private String id;
    private String name;
    private String category;
    private String contactNo;

    public Supplier(String id, String name, String category, String contactNo) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.contactNo = contactNo;
    }

    public Supplier() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
