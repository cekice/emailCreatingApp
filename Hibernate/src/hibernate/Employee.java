
package hibernate;
    

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
   @Id @GeneratedValue
   @Column(name = "employee_id")
   private int employee_id;

   @Column(name = "employee_name")
    String employee_name;

   @Column(name = "employee_age")
    String employee_age;
   
   @Column(name = "employee_address")
    String employee_address;

   @Column(name = "employee_salary")
    int employee_salary;

    public Employee() {
    }
   
   
   public int getEmployee_Id() {
      return employee_id;
   }
   
   public void setEmployee_Id( int employee_id ) {
      this.employee_id = employee_id;
   }
   
   public String getEmployee_name() {
      return employee_name;
   }
   
   public void setEmployee_name( String employee_name ) {
      this.employee_name = employee_name;
   }
   
   public String getEmployee_age() {
      return employee_age;
   }
   
   public void setEmployee_age( String employee_age ) {
      this.employee_age = employee_age;
   }
   
   public String getEmployee_address() {
      return employee_address;
   }
   
   public void setEmployee_address( String employee_address ) {
      this.employee_address = employee_address;
   }   
   public double getEmployee_salary() {
      return employee_salary;
   }
   
   public void setEmployee_salary( int employee_salary ) {
      this.employee_salary = employee_salary;
   }
}
  