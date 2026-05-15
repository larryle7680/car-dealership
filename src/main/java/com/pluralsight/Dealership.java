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
    //Returns an array list, trying to get the VIN number
    public ArrayList<Vehicle>getVehicleByVin(int vin){
        //Create a new ArrayList to store the results of the filter
        ArrayList<Vehicle> vinResults = new ArrayList<>();
        //For every Vehicle(Individual) that is inside inventory(the ArrayList inside Dealership)
        //We are looping through that ArrayList to find vehicles that matches the filter.
        for(Vehicle vehicle : inventory){
            if(vehicle.getVin() == vin){
                vinResults.add(vehicle);
            }
        }
        return vinResults;
    }

    //filter inventory list by price and return
    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice){
        //ArrayList variable name is results to hold the vehicles that matches the conditions in inventory
        ArrayList<Vehicle> results = new ArrayList<>();

        //This is looping through the inventory to find a match through the inventory
        for(Vehicle vehicle : inventory){
            //If vehicle price is greater or equal to the minPrice
            //And if vehicle price is less than or equal to the maxPrice
            //then it'll store it into results using hte .add method
            if(vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice){
                results.add(vehicle);

            }
        }

        //gives back the filtered list.
        return results;
    }

    //returns a array list of vehicle with the input of startYear and endYear
    public ArrayList<Vehicle> getVehiclesByYear(int startYear, int endYear){
        //Creating an instance for year results
        ArrayList<Vehicle> yearResults = new ArrayList<>();
        //loop through the vehicles in inventory
        for(Vehicle vehicle : inventory){
            if(vehicle.getYear() >= startYear && vehicle.getYear() <= endYear){
                //Add all the filtered vehicles into yearResults
                yearResults.add(vehicle);
            }
        }
        return yearResults;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        //Create an instance for makeModel
        ArrayList<Vehicle> makeModelResults = new ArrayList<>();
        //loop through the vehicles in inventory
        for(Vehicle vehicle : inventory){
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                makeModelResults.add(vehicle);
            }
        }
        return makeModelResults;
    }

    //this method returns a ArrayList of Vehicles
    public ArrayList<Vehicle> getVehiclesByColor(String color){
        //Create an instance for color
        ArrayList<Vehicle> colorVehiclesResults = new ArrayList<>();
        //loop through the vehicles in the inventory
        for(Vehicle vehicle : inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                colorVehiclesResults.add(vehicle);
            }
        }
        return colorVehiclesResults;
    }

    public ArrayList<Vehicle>getVehiclesByMileage(int minMileage, int maxMileage){
        //Create and instance for mileage
        ArrayList<Vehicle> mileageVehicleResults = new ArrayList<>();

        //loop through the array
        for(Vehicle vehicle : inventory){
            if(vehicle.getOdometer() >= minMileage && vehicle.getOdometer() <= maxMileage){
                mileageVehicleResults.add(vehicle);
            }
        }
        return mileageVehicleResults;
    }

    public ArrayList<Vehicle>getVehicleByType(String vehicleType){
        //Create an instance for type
        ArrayList<Vehicle> vehicleTypeResults = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                vehicleTypeResults.add(vehicle);
            }
        }
        return vehicleTypeResults;
    }

    //return the entire list
    public ArrayList<Vehicle> getAllVehicle(){
        return this.inventory;
    }


    //add vehicle created in the UI to the list
    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }

    //Remove vehicle method
    public void removeVehicle(Vehicle vehicle){
        this.inventory.remove(vehicle);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
