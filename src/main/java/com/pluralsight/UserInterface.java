package com.pluralsight;

import com.sun.security.jgss.GSSUtil;
import java.util.*;

import java.util.ArrayList;

public class UserInterface {
    static Scanner theScanner = new Scanner(System.in);
    //Object reference
    private Dealership dealership;
    private DealershipFileManager fileManager = new DealershipFileManager();

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
            System.out.println("10. Sell/Lease a Vehicle");
            System.out.println("99. Quit");
            System.out.println();
            System.out.println("Please Choose an option: ");
            //Store the users input into a variable
            int usersInput = theScanner.nextInt();

            switch(usersInput){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByTypeRequest();
                    break;
                case 7:
                    getAllVehicles();
                    break;
                case 8:
                    addVehicleRequest();
                    break;
                case 9:
                    removeVehicleRequest();
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

    private void processGetByMakeModelRequest(){
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

    private void processGetByColorRequest(){
        //Eat a line?
        theScanner.nextLine();
        System.out.println("=== Search By Color ===");
        System.out.println();
        System.out.println("What is the Color of the Vehicle? ");
        String colorVehicle = theScanner.nextLine();
        System.out.println();
        displayVehicles(dealership.getVehiclesByColor(colorVehicle));
    }

    private void processGetByMileageRequest(){
        System.out.println("=== Search by Mileage ===");
        System.out.println();
        System.out.println("What is the Minimum Mileage? ");
        int minMileage = theScanner.nextInt();
        System.out.println("What is the Maximum Mileage? ");
        int maxMileage = theScanner.nextInt();
        System.out.println();
        //Display the output with the filter
        displayVehicles(dealership.getVehiclesByMileage(minMileage, maxMileage));
    }

    private void processGetByTypeRequest(){
        //Eat the line
        theScanner.nextLine();
        System.out.println("=== Search By Type (SUV, Truck, Sedan) ===");
        System.out.println();
        System.out.println("What type of Vehicle is it? (SUV, Truck, Sedan)");
        String typeVehicle = theScanner.nextLine();
        System.out.println();
        displayVehicles(dealership.getVehicleByType(typeVehicle));

    }

    private void getAllVehicles(){
        System.out.println("=== All Vehicles in Inventory ===");
        displayVehicles(dealership.getAllVehicle());
    }

    private void addVehicleRequest(){
        //Eat the Line
        theScanner.nextLine();
        System.out.println("=== Adding a New Vehicle ===");
        System.out.println();
        System.out.println("What is the VIN of the Vehicle? ");
        int addVin = theScanner.nextInt();
        System.out.println("What is the Year of the Vehicle? ");
        int addYear = theScanner.nextInt();

        //Eat the line
        theScanner.nextLine();

        System.out.println("What is the Make of the Vehicle? ");
        String addMake = theScanner.nextLine();
        System.out.println("What is the Model of the Vehicle? ");
        String addModel = theScanner.nextLine();
        System.out.println("What is the Type of the Vehicle? ");
        String addType = theScanner.nextLine();
        System.out.println("What is the Color of the Vehicle? ");
        String addColor = theScanner.nextLine();
        System.out.println("What is the Mileage of the Vehicle? ");
        int addMileage = theScanner.nextInt();
        System.out.println("What is the Price of the Vehicle? ");
        double addPrice = theScanner.nextDouble();
        System.out.println();
        //Eat the Line
        theScanner.nextLine();
        System.out.println("Is this correct? (Y/N)");
        System.out.printf("""
                VIN: %d
                Year: %d
                Make: %s
                Model: %s
                Type: %s
                Color: %s
                Mileage: %d
                Price: $%.2f
                
                Press H: For Home Screen
                """, addVin, addYear, addMake, addModel, addType, addColor, addMileage, addPrice);

        String yesNo = theScanner.nextLine();

        if(yesNo.equalsIgnoreCase("Y")){
            Vehicle newVehicle = new Vehicle (addVin, addYear,addMake,addModel,addType,addColor,addMileage,addPrice);
            dealership.addVehicle(newVehicle);
            System.out.println();
            fileManager.saveDealership(newVehicle);
            System.out.println("Vehicle Saved!");
            System.out.println();
        }else if(yesNo.equalsIgnoreCase("H")){
            display();

        }else if(yesNo.equalsIgnoreCase("N")){
            System.out.println("Try Again!");
            System.out.println();
            addVehicleRequest();
        }
    }

    private void processGetByVinRequest(){
        System.out.println("=== Search by VIN ===");
        System.out.println();
        System.out.println("What is the VIN number?");
        System.out.println();
        int vinVehicle = theScanner.nextInt();
        displayVehicles(dealership.getVehicleByVin(vinVehicle));
    }

    private void processSellLeaseRequest(){

    }

    private void removeVehicleRequest(){
        //Make a menu that prompts questions to the user
        //Store their answer to use.
        boolean isRunning = false;
        while(!isRunning) {
            System.out.println("=== Remove Vehicle ===");
            System.out.println();
            System.out.println("1. To type in the VIn of vehicle to remove");
            System.out.println("2. Go back Home");
            int usersChoice = theScanner.nextInt();

            switch(usersChoice){
                case 1:
                    removeVehicle();
                    break;
                case 2:
                    display();
                    break;






            }
        }
    }

    private void removeVehicle(){
        System.out.println("Please type in the VIN number");
        int vinInput = theScanner.nextInt();
        System.out.println();
        System.out.println(vinInput);
        for (Vehicle vehicle : dealership.getAllVehicle()){
            if (vehicle.getVin() == vinInput){
                dealership.removeVehicle(vehicle);
                fileManager.saveDealership(dealership);
                break;

            }


        }


    }



}
