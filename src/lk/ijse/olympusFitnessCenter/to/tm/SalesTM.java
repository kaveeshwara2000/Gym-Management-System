package lk.ijse.olympusFitnessCenter.to.tm;
import javafx.scene.control.Button;

public class SalesTM {
    private String code;
    private String description;
    private double price;
    private int qty;
    private double total;
    private Button remove;


    public SalesTM() {
    }

    public SalesTM(String code, String description, double price, int qty, double total, Button remove) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.qty = qty;
        this.total = total;
        this.setRemove(remove);
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

    public Button getRemove() {
        return remove;
    }

    public void setRemove(Button remove) {
        this.remove = remove;
    }
}
