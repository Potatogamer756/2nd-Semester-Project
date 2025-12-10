public interface InnerVehicleMethods {
    final double _VERSION = 3.72;
    void DisplayVehicle();
    void DisplayCostAndJob();
    void SetCost();

    default void Vehicle(){
        System.out.println("Your System has different vehicle methods!");
    }
}
