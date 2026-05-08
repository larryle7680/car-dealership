package com.pluralsight;

import com.sun.security.jgss.GSSUtil;
import java.util.*;

import java.util.ArrayList;

public class UserInterface {
    static Scanner theScanner = new Scanner(System.in);
    //Object reference
    private Dealership dealership;

    //starts the menu
    public void display(){
        //creates the dealership for this class
        this.init();

        //do menu stuff
        boolean isRunning = false;
        while(!isRunning){
            System.out.println("===D N B Used Cards===");
            System.out.println();
            System.out.println("1. Vehicles within a Price Range");
            System.out.println("2. Vehicles by Make/Model");
            System.out.println("3. Find Vehicles by Year Range");
            System.out.println("4. Find Vehicle by Color");
            System.out.println("5. Find by Vehicle Mileage Range");
            System.out.println("6. Find by Vehicle Type");
            System.out.println("7. List All Vehicles");
            System.out.println("8. Add Vehicle");
            System.out.println("9. Remove Vehicle");
            System.out.println("99. Quit");
            System.out.println();
            System.out.println("Please Choose an option");
            //Store the users input into a variable
            int usersInput = theScanner.nextInt();

            switch(usersInput){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModel();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;


            }



        }
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
    private void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.toString());
        }
    }

    //Make a method to find price Range
    private void processGetByPriceRequest(){
        //Prompt user for min and max price and store their answer
        System.out.println("=== Search by Price Range ===");
        System.out.println();
        System.out.println("What is the Minimum Price");
        int minPrice = theScanner.nextInt();
        System.out.println("What is the Max Price");
        int maxPrice = theScanner.nextInt();
        System.out.println();
        ArrayList<Vehicle> matchingVehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(matchingVehicles);
    }

    private void processGetByYearRequest(){
        //Prompt user for a startYear and endYear and store it
        System.out.println("=== Search By Year ===");
        System.out.println();
        System.out.println("What is the start year? ");
        int startYear = theScanner.nextInt();
        System.out.println("What is the end year? ");
        int endYear = theScanner.nextInt();
        System.out.println();
       //Display the vehicles from the filter
        displayVehicles(dealership.getVehiclesByYear(startYear, endYear));
    }

    private void processGetByMakeModel(){
        //Eat a line?
        theScanner.nextLine();
        //Prompt user for a make/model and store it
        System.out.println("=== Search Make/Model ===");
        System.out.println();
        System.out.println("What is the Make of the Vehicle? ");
        String makeVehicle = theScanner.nextLine();
        System.out.println("What is the Model of the Vehicle? ");
        String modelVehicle = theScanner.nextLine();
        System.out.println();
        displayVehicles(dealership.getVehiclesByMakeModel(makeVehicle, modelVehicle));
    }
}
