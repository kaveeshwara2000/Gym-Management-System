package lk.ijse.olympusFitnessCenter.to;

public class SaleDetails {
    private String code;
    private String description;
     private double price;
     private int qty;
     private double total;
    private String date;
    private String time;
    public SaleDetails() {
    }

    public SaleDetails(String code, String description, double price, int qty, double total) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.qty = qty;
        this.total = total;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
