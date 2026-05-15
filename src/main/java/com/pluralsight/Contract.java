package com.pluralsight;

public abstract class Contract {
    //Attributes of the contract
    private String date;
    private String customerName;
    private String customerEmail;
    private boolean isSold;
    private double totalPrice;
    private double monthlyPayment;

    //Constructor
    public Contract(String date, String customerName, String customerEmail, boolean isSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.isSold = isSold;
    }

    //Created Abstract Methods
    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();





    //Setters/Getters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
