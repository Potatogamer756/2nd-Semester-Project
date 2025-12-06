import java.util.Scanner;

public class Main{
    static int outer_choice;
    static int inner_choice;

    static Scanner my_Scanner = new Scanner(System.in);
    
    static Client[] myClients = new Client[100];
    static Vehicle[] myVehicles = new Vehicle[100];
    public static void main(String[] args){

        Employee.GetEmployeeSize();
        Client.GetClientSize();
        OuterLoop();
        System.out.println("Please Visit Abdullah ki Mechanic dukan again, Bye! :DD");
    }

    public static void OuterLoop(){
    do{
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("----------------[MAIN MENU]----------------");
        System.out.println("1. Employee Options");
        System.out.println("2. Vehicle Options");
        System.out.println("3. Client Options");
        System.out.println("4. Reset Clients(For Daily Data)");
        System.out.println("5. EXIT");
        System.out.println("-------------------------------------------");
        System.out.print("CHOICE: ");
        outer_choice = my_Scanner.nextInt();
        GetOuterLoopChoice(outer_choice);
        }while(outer_choice != 5);
     }

     public static void GetOuterLoopChoice(int choice){
        switch (choice) {
            case 1:
                DisplayEmployeeOptions();
                break;

            case 2:
                DisplayVehicleOptions();
                break;
            case 3:
                DisplayClientOptions();
                break;
            case 4:
                Client.GetClientSize();
                break;
            case 5: //it is reserved for exiting
                break;
            default:
                System.out.println("Input: " + choice + " is In-Valid!");
                break;
        }
     }

    public static void DisplayEmployeeOptions(){
        do{
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println("--------------[EMPLOYEE MENU]--------------");
            System.out.println("1. ADD Employee");
            System.out.println("2. REMOVE Employee");
            System.out.println("3, Change Salary of Employee");
            System.out.println("4 Get Employee By ID");
            System.out.println("5. Display All Employees");
            System.out.println("6. Assign Employee to Work");
            System.out.println("7. Go Back");
            System.out.println("-------------------------------------------");
            System.out.print("CHOICE: ");
            inner_choice = my_Scanner.nextInt();
            Employee.GetChoice(inner_choice);
            //GetOuterLoopChoice(outer_choice);
        }while(inner_choice != 7);
    }


    public static void DisplayClientOptions(){
        do{
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println("---------------[CLIENT MENU]---------------");
            System.out.println("1. ADD Client");
            System.out.println("2. REMOVE Client");
            System.out.println("3. Get Client Info by Car ID");
            System.out.println("4. Get Client By NAME");
            System.out.println("5. Display All Clients");
            System.out.println("6. Go Back");
            System.out.println("-------------------------------------------");
            System.out.print("CHOICE: ");
            inner_choice = my_Scanner.nextInt();
            System.out.println("Your choice is: " + inner_choice);
            Client.GetChoice(inner_choice);
            //GetOuterLoopChoice(outer_choice);
        }while(inner_choice != 6);
    }

    public static void DisplayVehicleOptions(){
        do{
            System.out.println();
            System.out.println("--------------------------------------------");
            System.out.println("---------------[VEHICLE MENU]---------------");
            System.out.println("1. Get Vehicle by Client ID");
            System.out.println("2. Get Vehicle By ID");
            System.out.println("3. Get Job/Cost of Vehicle");
            System.out.println("4. Get Vehicles By Job"); //jobs are "Paint", "Repair"
            System.out.println("5. Display All vehicles");
            System.out.println("6. Randomly Choose a Vehicle For Work!");
            System.out.println("7. Go Back");
            System.out.println("--------------------------------------------");
            System.out.print("CHOICE: ");
            inner_choice = my_Scanner.nextInt();
            System.out.println("Your choice is: " + inner_choice);
            Vehicle.GetChoice(inner_choice);
            //GetOuterLoopChoice(outer_choice);
        }while(inner_choice != 7);
    }
}