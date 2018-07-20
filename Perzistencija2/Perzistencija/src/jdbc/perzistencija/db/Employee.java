package jdbc.perzistencija.db;

public class Employee {
    public int employee_id;
    public String employee_name;
    public String employee_age;
    public String employee_address;
    public double employee_salary;
    
    @Override
    public String toString(){
    return employee_id + "\t" + employee_name + "\t" + employee_age + "\t" + employee_address + "\t" + employee_salary;
    }
}
