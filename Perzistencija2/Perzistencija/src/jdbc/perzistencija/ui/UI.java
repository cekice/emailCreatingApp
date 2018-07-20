package jdbc.perzistencija.ui;

import java.util.Scanner;
import jdbc.perzistencija.db.Employee;


public class UI {
    
    public final static int InvalidOption    = 0;
    public final static int ShowEmployee     = 1;
    public final static int AddEmployee      = 2;
    public final static int UpdateEmployee   = 3;
    public final static int DeleteEmployee   = 4;
    public final static int ExitApp          = 5;
    
    public void updateEmployee(Employee employee){
        Scanner scanner = new Scanner (System.in);
        
             System.out.println("Enter Employee name : ");
             String name = scanner.nextLine();
             System.out.println("Enter Employee age : ");
             String age = scanner.nextLine();
             if(!name.isEmpty()&&!age.isEmpty()){
                employee.employee_name = name;
                employee.employee_age = age;
        }       
            System.out.println("Enter Employee address : ");
             String address = scanner.nextLine();
             if(!address.isEmpty()){
                employee.employee_address = address;}
             
             double salary;
            while(true){    
            System.out.println("Enter Employee salary : ");
            try{      salary = Double.parseDouble(scanner.nextLine());
            break;
            } catch(Exception ex){ 
                System.out.println("Must enter salary(0.0)!!!! \n ");
                  }
            }
            employee.employee_salary = salary;
            
        
    
    } 
        
    
    public Employee getEmployee(){
        Employee res = new Employee();
        Scanner scanner = new Scanner (System.in);
        while(res.employee_name==null){
             System.out.println("Enter Employee name: ");
             String name = scanner.nextLine();
             System.out.println("Enter Employee age: ");
             String age = scanner.nextLine();
             if(name.isEmpty()&& age.isEmpty()){
                System.out.println("Name and age can not be empty ");
                continue;
        }       
             res.employee_name = name;
             res.employee_age = age;
             System.out.println("Enter address: ");
             res.employee_address = scanner.nextLine();
             System.out.println("Enter salary: "); 
             res.employee_salary = scanner.nextDouble();
        }
        
        return res;
    }
    
    public String getEmployeeName(){
    
     Scanner scanner = new Scanner(System.in);
        
        String selectedName = null;
        while(true){
            System.out.println("Enter Employe name: ");
        try{
            selectedName = scanner.nextLine();
            break;
        } catch(Exception ex){
            System.out.println("Input must be string!!");
        }
        }
        
        return selectedName;
    
    }
    
    public int menu(){
        System.out.println(" "+ShowEmployee+". Show employee \n "+AddEmployee+". Add employee \n "+UpdateEmployee+". Update employee \n "+DeleteEmployee+". Delete employee \n "+ExitApp+". Exit app  ");
        
        Scanner scanner = new Scanner(System.in);
        
        int selectedOption = 0;
        while(true){
        try{
            selectedOption = Integer.parseInt(scanner.nextLine());
                 if(selectedOption<1||selectedOption>5){
                     System.out.println("Number option is form 1 to 5");
                     continue;
                 }
            break;
        } catch(Exception ex){
            System.out.println("Input must be number!!");
        }
        }
        return selectedOption;
        
    }
    
     public int getEmployeeId(){
    
     Scanner scanner = new Scanner(System.in);
        
        int selectedId = 0;
        while(true){
            System.out.println("Enter Employe id: ");
        try{
            selectedId = Integer.parseInt(scanner.nextLine());
            break;
        } catch(Exception ex){
            System.out.println("Input must be number!!");
        }
        }
        
        return selectedId;
    
    }
}
