package com.pluralsight;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;

public class UserInterface {

    private Dealership dealership;

    //starts the menu
    public void display(){
        //creates the dealership for this class
        this.init();

        //do menu stuff

        //Have your switch that calls the method in the dealership to get the list.

        //imagine they selected getAll
        this.processGetAllVehicleRequest();
    }

    //Read the file to get the dealership information
    private void init(){
        DealershipFileManager fileManager = new DealershipFileManager();

        this.dealership = fileManager.getDealership();
    }

    //Process the information to get all the vehicle
    public void processGetAllVehicleRequest(){
        ArrayList<Vehicle> allTheCars = dealership.getAllVehicle();
        this.displayVehicles(allTheCars);
    }

    //This will display the vehicle
    private static void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.toString());
        }
    }
}
