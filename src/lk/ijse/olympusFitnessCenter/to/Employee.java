package lk.ijse.olympusFitnessCenter.to;

import java.sql.Date;

public class Employee {
    private String id;
    private String name;
    private String contactNo;
    private double salary;
    private Date joinDate;
    private String NIC;
    private String jobRole;
    private String address;

    public Employee(String id, String name, String contactNo, double salary, Date joinDate, String NIC, String jobRole, String address) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.salary = salary;
        this.joinDate = joinDate;
        this.NIC = NIC;
        this.jobRole = jobRole;
        this.address = address;
    }

    public Employee() {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
