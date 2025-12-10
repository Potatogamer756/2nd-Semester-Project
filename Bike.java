public class Bike extends Vehicle {

    public Bike(int ownerID, String name, String job, int id, String type) {
        super(ownerID, name, job, id, type);
        SetCost();
    }

    
    public void SetCost() {
        if (VehicleJob.equalsIgnoreCase("Paint")){
            cost = 3000;
        } 
        else if (VehicleJob.equalsIgnoreCase("Repair")){
            cost = 2000;

        } 
        else{cost = 0;

        } 
    }
}
