import java.util.Scanner;

public class Employee {
    int Employee_ID;
    String name;
    int age;
    double salary;
    boolean isWorking;

    static Employee[] myEmployees;
    static int employee_count  = 0;
    static Scanner myScanner = new Scanner(System.in);

    Employee(){
        myScanner.nextLine();
        System.out.println("----------------[ADD EMPLOYEE]----------------");
        System.out.print("Enter Employee Name: ");
        this.name = myScanner.nextLine();
        do{
        System.out.print("Enter Employee ID: ");
        this.Employee_ID = myScanner.nextInt();
        }while(!CheckID(this.Employee_ID));
        
        System.out.print("Enter Employee Age: ");
        this.age = myScanner.nextInt();
        System.out.print("Enter Employee Salary: ");
        this.salary = myScanner.nextDouble();
        System.out.print("Enter Employee Status(True/False): ");
        this.isWorking = myScanner.nextBoolean();
         System.out.println("----------------------------------------");
    }

    public void DisplayInfo(){
        System.out.println("Employee Name: " + this.name);
        System.out.println("Employee ID: " + this.Employee_ID);
        System.out.println("Employee Age: " + this.age);
        System.out.println("Employee Salary: " + this.salary);
        System.out.println("Employee Working Status(T/F): " + this.isWorking);
    }

    public static void RemoveEmployee() {
        System.out.print("Employee ID: ");
        int e_id = myScanner.nextInt();

        int index = -1;

        for (int i = 0; i < employee_count; i++) {
            if (myEmployees[i].Employee_ID == e_id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee does not exist!");
            return;
        }

        for (int i = index; i < employee_count - 1; i++) {
            myEmployees[i] = myEmployees[i + 1];
        }

        myEmployees[employee_count - 1] = null;

        employee_count--;

        System.out.println("Employee with ID " + e_id + " removed successfully!");
    }


    public static void ConstructEmployee(){
        if(employee_count >= myEmployees.length){
            System.out.println("Employee list is completed!");
            return;
        }
        myEmployees[employee_count] = new Employee();
        System.out.println("Employee Created! At Position " + (employee_count + 1));
        employee_count++;
    }

    public boolean CheckID(int id){
        boolean isValid = true;
        for(int i= 0; i<employee_count; i++){
            if(myEmployees[i].Employee_ID == id){
                 isValid = false;
                 System.out.println("ID Already taken!");
            }
        }

        return isValid;
    }

    public static void GetChoice(int choice){
        switch (choice) {
            case 1:
                ConstructEmployee();
                break;
            case 2:
                RemoveEmployee();
                break;
            case 3:
                ChangeSalary();
                break;
            case 4:
                DisplayEmployeeInfoByID();
                break;
            case 5:
                DisplayAllEmployess();
                break;
            case 6:
                AssignEmployeeToWork();
                break;
            case 7:
                break;
            default:
               System.out.println("Input: " + choice + " is In-Valid!");
                break;
        }
    }

    public static void AssignEmployeeToWork(){

        int id;
        boolean status;

        System.out.println("----------------[ASSIGN EMPLOYEE]----------------");

        System.out.print("Enter Employee ID: ");
        id = myScanner.nextInt();
        System.out.print("Enter Employee Status(true/false): ");
        status = myScanner.nextBoolean();

        for(int i=0; i< employee_count; i++){
            if (myEmployees[i].Employee_ID == id){
                if (myEmployees[i].isWorking == status){
                    if(status == true){
                        System.out.println("Employee already Working!");
                    }
                    else{
                        System.out.println("Employee is already Idle!");
                    }
                    
                }
                myEmployees[i].isWorking = status;
                System.out.println("Employee Assigned!");
                 return;
            }
        }
        System.out.println("Wrong ID!");
    }

    public static void ChangeSalary(){
        int id;
        double new_Salary;
        System.out.println("----------------[SALARY EMPLOYEE]----------------");
        System.out.print("Enter Employee ID: ");
        id = myScanner.nextInt();
        System.out.print("Enter Employee Salary: ");
        new_Salary = myScanner.nextDouble();
         for(int i=0; i< employee_count; i++){
            if (myEmployees[i].Employee_ID == id){
                myEmployees[i].salary = new_Salary;
                return;
            }
        }
         System.out.println("Wrong ID!");
    }

    public static void DisplayEmployeeInfoByID(){
        int id;
        System.out.println("----------------[DISPLAY EMPLOYEE]----------------");
        System.out.print("Enter Employee ID: ");
        id = myScanner.nextInt();
        
         for(int i=0; i< employee_count; i++){
            if (myEmployees[i].Employee_ID == id){
                System.out.println("----------------[DISPLAYING EMPLOYEE ID# " + (id) + "]----------------");
                myEmployees[i].DisplayInfo();
                 return;
            }
        }
         System.out.println("Wrong ID!");
    }

    public static void DisplayAllEmployess(){
        if(employee_count == 0){
            System.out.println("No Employees Exists!");
            return;
        }
        for(int i=0;i<employee_count;i++){
            System.out.println("----------------[DISPLAYING EMPLOYEE # " + (i+1) + "]----------------");
            myEmployees[i].DisplayInfo();
        }
    }

    public static void GetEmployeeSize(){
        System.out.println();
        System.out.print("How Many Employees in Your Company: ");
        myEmployees = new Employee[myScanner.nextInt()];
    }
}
