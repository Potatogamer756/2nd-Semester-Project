import java.util.Scanner;

public class Client {
    int Client_ID;
    String name;
    Vehicle clientVehicle;

    static Scanner myScanner = new Scanner(System.in);
    static int client_count  = 0;
    static Client[] myClients;
    static boolean doesClientExists;

    Client(){
         myScanner.nextLine();
        System.out.println("----------------[ADD CLIENT]----------------");
        System.out.print("Enter Client Name: ");
        this.name = myScanner.nextLine();
       
         do{
             System.out.print("Enter Client ID: ");
             this.Client_ID = myScanner.nextInt();
        }while(!CheckID(this.Client_ID));
        
        this.clientVehicle =  Vehicle.CreateVehicle(Client_ID); //new Vehicle(Client_ID);
    }

    public void DisplayClient(){
        System.out.println("Client Name: " + this.name);
        System.out.println("Client ID: " + this.Client_ID);
        System.out.println("Vehicle Name: " + this.clientVehicle.vehicleName);
        System.out.println("Vehicle ID: " + this.clientVehicle.VehicleID);
        System.out.println("Vehicle Work: " + this.clientVehicle.VehicleJob);
    }

    public boolean CheckID(int id){
        boolean isValid = true;
        for(int i= 0; i<client_count; i++){
            if(myClients[i].Client_ID == id){
                 isValid = false;
                 System.out.println("ID Already taken!");
            }
        }

        return isValid;
    }

     public static void ConstructClient(){
        if(client_count >= myClients.length){
            System.out.println("Client list is completed!");
            return;
        }
        myClients[client_count] = new Client();
        System.out.println("Client Created! At Position " + (client_count + 1));
        client_count++;
        doesClientExists = true;
    }

    public static void GetClientByName(){
         if(!doesClientExists){
            System.out.println("No Client Exists!");
            return;
        }
         System.out.println("----------------[GET CLIENT]----------------");
         myScanner.nextLine();
         System.out.print("Enter Client Name: ");
         String name = myScanner.nextLine();
         for(int i=0; i<client_count;i++){
           if(myClients[i].name.equalsIgnoreCase(name)){ 
            System.out.println("----------------[DISPLAY CLIENT]----------------");
            myClients[i].DisplayClient();
            System.out.println("-------------------------------------------");
            }
         }
    }

    public static void GetClientByCarID(){
         if(!doesClientExists){
            System.out.println("No Client Exists!");
            return;
        }
        System.out.println("----------------[GET CLIENT]----------------");
         System.out.print("Enter Client's Vehicle ID: ");
         int id = myScanner.nextInt();
         for(int i=0; i<client_count;i++){
            if(myClients[i].clientVehicle.VehicleID == id){
                System.out.println("----------------[DISPLAY CLIENT]----------------");
                myClients[i].DisplayClient();
            }
         }
    }

    public static void DisplayAllClients(){
        if(!doesClientExists){
            System.out.println("No Client Exists!");
            return;
        }
         for(int i=0;i<client_count;i++){
            System.out.println("----------------[DISPLAYING CLIENT # " + (i+1) + "]----------------");
            myClients[i].DisplayClient();
        }
    }

    public static void GetChoice(int choice){
        switch (choice) {
            case 1:
                ConstructClient();
                break;
            case 2:
                RemoveClient();
                break;
            case 3:
                GetClientByCarID();
                break;
            case 4:
                GetClientByName();
                break;
            case 5:
                DisplayAllClients();
                break;
            case 6:
                break;
            default:
               System.out.println("Input: " + choice + " is In-Valid!");
                break;
        }
    }

     public static void RemoveClient() {
         if(!doesClientExists){
            System.out.println("No Client Exists!");
            return;
        }
        System.out.print("Client ID: ");
        int id = myScanner.nextInt();

        int index = -1;

        for (int i = 0; i < client_count; i++) {
            if (myClients[i].Client_ID == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Client does not exist!");
            return;
        }

        for (int i = index; i < client_count - 1; i++) {
            myClients[i] = myClients[i + 1];
        }

        myClients[client_count - 1] = null;

        client_count--;

        System.out.println("Client with ID " + id + " removed successfully!");
    }

    public static void GetClientSize(){
        doesClientExists = false;
        if (client_count > 0){
            for(int i=0; i<client_count;i++){
                 myClients[i] = null;
            }
        }

        System.out.println();
        System.out.print("How Many Clients Today: ");
        int size = myScanner.nextInt();
        myClients = new Client[size];
        client_count = 0;
        Vehicle.SetVehicleArraySize(size);
    }

}
