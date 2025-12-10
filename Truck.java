public class Truck extends Vehicle {

    public Truck(int ownerID, String name, String job, int id, String type) {
        super(ownerID, name, job, id, type);
        SetCost();
    }

    public void SetCost() {
        if (VehicleJob.equalsIgnoreCase("Paint")){
             cost = 7000;
        }
        else if (VehicleJob.equalsIgnoreCase("Repair")){
             cost = 10000;
        }
        else {
            cost = 3000;
        }
    }
}