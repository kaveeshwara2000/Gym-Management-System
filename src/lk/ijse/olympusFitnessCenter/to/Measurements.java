package lk.ijse.olympusFitnessCenter.to;

public class Measurements {
    private String id;
    private double height;
    private double weight;
    private double chest;
    private double arm;
    private double waist;

    public Measurements() {
    }

    public Measurements(String id, double height, double weight, double chest, double arm, double waist) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.chest = chest;
        this.arm = arm;
        this.waist = waist;
    }

    public Measurements(double height, double weight, double chest, double arm, double waist) {
        this.height = height;
        this.weight = weight;
        this.chest = chest;
        this.arm = arm;
        this.waist = waist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getArm() {
        return arm;
    }

    public void setArm(double arm) {
        this.arm = arm;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }
}
