package lk.ijse.olympusFitnessCenter.to;

public class Item {
    private String code;
    private String description;
    private double price;
    private int qty;

    public Item(String code, String description, double price, int qty) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.qty = qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
