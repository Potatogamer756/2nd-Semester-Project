
import java.util.Scanner;

public class Vehicle implements InnerVehicleMethods {
   public String vehicleName;
   public String VehicleJob;
   public int VehicleID;
   public int ownerID;
   public String vehicleType;
   public double cost = 0;

    static Scanner myScanner = new Scanner(System.in);
    static Vehicle[] myVehicles;
    static int Vehicle_count;
    static boolean doesVehicleExists;

    Vehicle(int ownerID, String name, String job, int id, String vtype) {
        this.ownerID = ownerID;
        this.vehicleName = name;
        this.VehicleJob = job;
        this.VehicleID = id;
        this.vehicleType = vtype;
    }
    
    public void SetCost(){
        if (this.vehicleType == "Car"){
            if(this.VehicleJob == "Paint"){
                this.cost = 5000;
            }
            else if(this.VehicleJob == "Repair"){
                this.cost = 5500;
            }
            else{
                this.cost = 300;
            }
        }
        else if(this.vehicleType == "Truck"){
            if(this.VehicleJob == "Paint"){
                this.cost = 7000;
            }
            else if(this.VehicleJob == "Repair"){
                this.cost = 10000;
            }
            else{
                this.cost = 3000;
            }
        }
        else if(this.vehicleType == "Bike"){
            if(this.VehicleJob == "Paint"){
                this.cost = 3000;
            }
            else if(this.VehicleJob == "Repair"){
                this.cost = 2000;
            }
        }
    }
     
    public void DisplayVehicle(){
        System.out.println("Vehicle Type: " + this.vehicleType);
        System.out.println("Vehicle Owner ID: " + this.ownerID);
        System.out.println("Vehicle ID: " + this.VehicleID);
        System.out.println("Vehicle Job: " +this.VehicleJob);
        System.out.println("Total Cost: " + this.cost + "pkr."); 
    }

    public void DisplayCostAndJob(){
        System.out.println("----------------[DISPLAY VEHICLE JOB/COST]----------------");
        System.out.println("Job: " + this.VehicleJob);
        System.out.println("Total Cost: " + this.cost + "pkr."); 
    }

    public static void GetChoice(int choice){
        switch (choice) {
            case 1:
                GetVehicleByClientID();
                break;
            case 2:
                GetVehicleByID();
                break;
            case 3:
                GetJobAndCost();
                break;
            case 4:
                GetVehiclessOfJob();
                break;
            case 5:
               
                break;
            case 6:
                 GetRandomVehicle();
            break;
            case 7:
                break;
            default:
               System.out.println("Input: " + choice + " is In-Valid!");
                break;
        }
    }

    public static void GetVehiclessOfJob(){
        if (Vehicle_count == 0) {
            System.out.println("No Vehicles exist!");
            return;
        }
        myScanner.nextLine();
        System.out.print("Enter Job name to retreieve Cars:");
        String job = myScanner.nextLine();
        Vehicle specificVehicles[];
        int index = 0;
        for(int i=0; i<Vehicle_count; i++){
            if(myVehicles[i].VehicleJob == job){
                index++;
            }
        }
        specificVehicles = new Vehicle[index];
        index = 0;
        for(int i=0; i<Vehicle_count;i++){
            if (myVehicles[i].VehicleJob == job){
                specificVehicles[index].ownerID =  myVehicles[i].ownerID;
                specificVehicles[index].vehicleType =  myVehicles[i].vehicleType;
                specificVehicles[index].VehicleJob =  myVehicles[i].VehicleJob;
                specificVehicles[index].VehicleID =  myVehicles[i].VehicleID;
                index++;
            }
        }
        System.out.println("----------------[" + job + " VEHICLE]----------------");
        for(int i=0; i<index; i++){
            System.out.println("----------------[DISPLAYING VEHICLE # " + (i+1) + "]----------------");
            System.out.println("OwnerID: " + specificVehicles[index].ownerID);
            System.out.println("Type: " + specificVehicles[index].vehicleType);
            System.out.println("ID: " + specificVehicles[index].VehicleID);
            System.out.println("Job: " + specificVehicles[index].VehicleJob);
        }
    }

    public static void DisplayAllVehicles(){
         if (Vehicle_count == 0) {
            System.out.println("No Vehicles exist!");
            return;
        }
        for(int i=0;i<Vehicle_count;i++){
            System.out.println("----------------[DISPLAYING CLIENT # " + (i+1) + "]----------------");
            myVehicles[i].DisplayVehicle();
        }
    }

    public static void GetVehicleByClientID(){
        if (Vehicle_count == 0) {
            System.out.println("No Vehicles exist!");
            return;
        }
        System.out.print("Enter Car Owner's ID:");
        int id = myScanner.nextInt();
        for(int i=0; i<Vehicle_count;i++){
            if(id == myVehicles[i].ownerID){
                System.out.println("----------------[DISPLAY VEHICLE]----------------");
                myVehicles[i].DisplayVehicle();
            }
        }
    }

    static void GetRandomVehicle(){
        if (Vehicle_count == 0) {
            System.out.println("No Vehicles exist!");
            return;
        }

        int randomIndex = (int) (Math.random() * Vehicle_count);
        System.out.println("----------------[DISPLAY VEHICLE]----------------");
        myVehicles[randomIndex].DisplayVehicle();
    }

    public static Vehicle CreateVehicle(int clientID){
        myScanner.nextLine();

        System.out.println("----------------[ADD VEHICLE]----------------");
        System.out.print("Enter Vehicle Type (Car/Truck/Bike): ");
        String type = myScanner.nextLine();

        System.out.print("Enter Vehicle Name: ");
        String name = myScanner.nextLine();

        System.out.print("Enter Job (Paint/Repair/...): ");
        String job = myScanner.nextLine();

        System.out.print("Enter Vehicle ID: ");
        int id = myScanner.nextInt();

        Vehicle v;

        switch(type.toLowerCase()) {
            case "car":
                v = new Car(clientID, name, job, id, type);
                break;
            case "truck":
                v = new Truck(clientID, name, job, id, type);
                break;
            case "bike":
                v = new Bike(clientID, name, job, id, type);
                break;
            default:
                System.out.println("Unknown type! Defaulting to Car.");
                v = new Car(clientID, name, job, id, type);
        }

        myVehicles[Vehicle_count] = v;
        Vehicle_count++;

        return v;
    }


    public static void GetJobAndCost(){
        System.out.print("Enter Owner or Vehicle ID: ");
        int id = myScanner.nextInt();

        for(int i =0;i<Vehicle_count;i++){
            if(myVehicles[i].VehicleID == id){
                myVehicles[i].DisplayCostAndJob();
                return;
            }
        }

         for(int i = 0;i<Vehicle_count;i++){
            if(myVehicles[i].ownerID == id){
                myVehicles[i].DisplayCostAndJob();
                return;
            }
        }
       System.out.println("Input: " + id + " is In-Valid!");
    }

    public static void GetVehicleByID(){
        if (Vehicle_count == 0) {
            System.out.println("No Vehicles exist!");
            return;
        }
        System.out.print("Enter Vehicle ID: ");
        int id = myScanner.nextInt();
        for(int i=0; i< Vehicle_count;i++){
            if(id == myVehicles[i].VehicleID){
                System.out.println("----------------[DISPLAY VEHICLE]----------------");
                myVehicles[i].DisplayVehicle();
            }
        }
    }

    public static void SetVehicleArraySize(int size){
        doesVehicleExists = false;
        if (Vehicle_count > 0){
            for(int i=0; i<Vehicle_count;i++){
                 myVehicles[i] = null;
            }
        }
        
        myVehicles = new Vehicle[size];
        Vehicle_count = 0;
        myVehicles = new Vehicle[size];
    }

    
}
