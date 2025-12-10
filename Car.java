public class Car extends Vehicle {

    public Car(int ownerID, String name, String job, int id, String type) {
        super(ownerID, name, job, id, type);
        SetCost();
    }

    
    public void SetCost() {
        if (VehicleJob.equalsIgnoreCase("Paint")){
             cost = 5000;
            }
        else if (VehicleJob.equalsIgnoreCase("Repair")){
             cost = 5500;
            }
        else {
            cost = 300;
        }
    }
}