package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();

    }

    //method


    //filter inventory list by price and return
    public ArrayList<Vehicle> getVehiclePrice(){
        return null;
    }

    //return the entire list
    public ArrayList<Vehicle> getAllVehicle(){
        return this.inventory;
    }


    //add vehicle created in the UI to the list
    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }

}
